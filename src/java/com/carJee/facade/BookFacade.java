/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.facade;

import com.carJee.model.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rakotoarivony
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {
    @PersistenceContext(unitName = "test1PU")
    private EntityManager em;
    
    private static final String GET_BOOK_BY_NAME = "SELECT b FROM Book b WHERE b.title like :bookname";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    @Override
    public List<Book> findByName(String name) {
        Query query = em.createQuery(GET_BOOK_BY_NAME);
        query.setParameter("bookname", "%"+name+"%");       
        return query.getResultList();        
    }
    
    
    
}
