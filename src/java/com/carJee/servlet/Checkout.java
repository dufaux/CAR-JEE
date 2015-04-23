/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.servlet;

import com.carJee.bean.CartBeanLocal;
import com.carJee.facade.ClientFacadeLocal;
import com.carJee.facade.CommandFacadeLocal;
import com.carJee.model.Book;
import com.carJee.model.Client;
import com.carJee.model.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dufaux
 */
@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class Checkout extends HttpServlet {

    @EJB(name="CartBean")
    CartBeanLocal cartejb;
    
    @EJB(name="ClientFacade")
    ClientFacadeLocal clientfacade;
        
    @EJB(name="CommandFacade")
    CommandFacadeLocal commandfacade;
    
    EntityManager em;
    
    private static final String SHOPPING_CART_BEAN_SESION_KEY = "shoppingCart";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String VUE = "/WEB-INF/checkout.jsp";
        
        CartBeanLocal cart = (CartBeanLocal) request.getSession().getAttribute(SHOPPING_CART_BEAN_SESION_KEY);
        String identifiant = (String) request.getSession().getAttribute("idcli");
        
        boolean connected = true;
        boolean emptycart = false;
        List<Book> books = new ArrayList<>();
        
        if(identifiant == null){
            connected = false;
        }
        else if(cart == null){
            emptycart = true;
            cart = cartejb;
            
            // put EJB in HTTP session for future servlet calls
            request.getSession().setAttribute(
              SHOPPING_CART_BEAN_SESION_KEY, 
              cart);
        }
        else{      
            Command c = new Command();
            books =  new ArrayList(cart.getAll());          
            Client client = clientfacade.find(identifiant);
            
            //bi-directionnel
            for(Book b : books){
                Collection<Command> coms = b.getCommandCollection();
                coms.add(c);
                b.setCommandCollection(coms);
            }
            
            c.setBookCollection(books);
            c.setClientUsername(client);
            
            commandfacade.create(c);
                        
            cart.confirmOrder();
        }
        
        request.setAttribute("emptycart", emptycart);
        request.setAttribute("connected", connected);
        request.setAttribute("books", books);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
