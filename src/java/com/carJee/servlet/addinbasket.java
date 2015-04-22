/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.servlet;

import com.carJee.bean.CartBeanLocal;
import com.carJee.facade.BookFacadeLocal;
import com.carJee.model.Book;
import java.io.IOException;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dufaux
 */
@WebServlet(name = "addinbasket", urlPatterns = {"/addinbasket"})
public class addinbasket extends HttpServlet {

    @EJB(name="CartBean")
    CartBeanLocal cartejb;
    
    @EJB(name="BookFacade")
    BookFacadeLocal bookfacade;
    
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
        CartBeanLocal cart = (CartBeanLocal) request.getSession().getAttribute(SHOPPING_CART_BEAN_SESION_KEY);
    
        if(cart == null){
          // EJB is not present in the HTTP session
          // so let's fetch a new one from the container
          /*try {
            InitialContext ic = new InitialContext();*/
            //cart = (CartBeanLocal) ic.lookup("java:global/com-byteslounge/com"); ??
            cart = cartejb;
            
            // put EJB in HTTP session for future servlet calls
            request.getSession().setAttribute(
              SHOPPING_CART_BEAN_SESION_KEY, 
              cart);

          /*} catch (NamingException e) {
            throw new ServletException(e);
          }*/
        }
        
        String bookname = request.getParameter("book");
        Book thebook = bookfacade.find(bookname);
        cart.addBook(thebook);
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
