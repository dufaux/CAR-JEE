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
 * Represents a cart during one user session.
 * When a user adds a book for first time, a cartBean is created and will not be destroyed until user's session expires
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
    
    @Override
    public void addBook(Book b) {
        books.add(b);
    }

    @Override
    public void removeBook(Book b) {
        books.remove(b);
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

//    @Remove
    @Override
    public void confirmOrder() {
        this.books.clear();
    }
}
