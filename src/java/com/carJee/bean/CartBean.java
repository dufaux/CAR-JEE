/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.bean;

import com.carJee.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;

/**
 *
 * @author dufaux
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class CartBean implements CartBeanLocal {

    private List<Book> books;
    
    @PostConstruct
    public void initCartBean(){
        books = new ArrayList<Book>();
    }
    
    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(Book b) {
        books.remove(b);
    }

    public List<Book> getAll() {
        return this.books;
    }

//    @Remove
    public void confirmOrder() {
        this.books.clear();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
