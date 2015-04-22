/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.bean;

import com.carJee.model.Book;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author dufaux
 */
@Local
public interface CartBeanLocal {
    
    public void addBook(Book b);
    
    public void removeBook(Book b);
    
    public List<Book> getAll();
    
    public void confimOrder();
}
