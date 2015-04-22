/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.servlet;

import com.carJee.facade.ClientFacadeLocal;
import com.carJee.model.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dufaux
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class Index extends HttpServlet {

    
    @EJB(name="ClientFacade")
    ClientFacadeLocal clientfacade;
       
    /**
     * 
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
        
        boolean connected = false;
        boolean wrongconnec = false;
        
        // gestion de la connexion.
        String ident = (String) request.getParameter("ident");
        String password = (String) request.getParameter("password");
        
        if(ident != null && password != null){
            Client cli = clientfacade.find(ident);
            
            
            if(cli != null && password.equals(cli.getPassword())){
                request.getSession().setAttribute("idcli",ident);
                connected = true;
            }
            else{
                wrongconnec = true;
            }
        }
        
        String identifiant = (String) request.getSession().getAttribute("idcli");
        if(identifiant == null){
            connected = false;
        }
        request.setAttribute("connected", connected);
        request.setAttribute("wrongconnec", wrongconnec);
        request.setAttribute("identifiant", identifiant);
        String VUE = "/WEB-INF/index.jsp";
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
