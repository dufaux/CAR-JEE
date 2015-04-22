/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.servlet;

import com.carJee.facade.AuthorFacadeLocal;
import com.carJee.facade.BookFacadeLocal;
import com.carJee.model.Author;
import com.carJee.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rakotoarivony
 */
public class AdministrationServlet extends HttpServlet {
    @EJB(name="AuthorFacade")
    private AuthorFacadeLocal authorFacade;
    
    @EJB(name="BookFacade")
    private BookFacadeLocal bookFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Collection authors = authorFacade.findAll();
        request.setAttribute("authorsList", authors);
        this.getServletContext().getRequestDispatcher("/WEB-INF/administration.jsp").forward(request, response);
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
        request.setAttribute("book_added", false);
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
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        Author author = authorFacade.find(Integer.parseInt(request.getParameter("author")));
        Book newBook = new Book(title, year);
        newBook.setAuthorId(author);
        
        bookFacade.create(newBook);
        
        request.setAttribute("chosen_author",author);
        request.setAttribute("book_added", true);
        
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
