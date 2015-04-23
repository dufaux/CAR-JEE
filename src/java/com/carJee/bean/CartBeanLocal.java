/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.bean;

import com.carJee.model.Book;
import java.util.List;
import javax.ejb.Local;

/**
 * Represents the cart to temporary store books until they are checked out
 * @author dufaux
 */
@Local
public interface CartBeanLocal {
    /**
     * Adds a book to this cart
     * @param b tje book to be added
     */
    public void addBook(Book b);
    
    /**
     * Removes a book from this cart
     * @param b the book to be removed
     */
    public void removeBook(Book b);
    
    /**
     * Returns the list of all book in this cart
     * @return the list of all book in this cart
     */
    public List<Book> getAll();
    
    /**
     * Checks out all books in this cart.
     * It removes all books from this cart.
     */
    public void confirmOrder();
}
