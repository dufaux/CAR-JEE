/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.facade;

import com.carJee.model.Book;
import java.util.List;
import javax.ejb.Local;

/**
 * Is a facade interface to handle persistence for authors
 * @author rakotoarivony
 */
@Local
public interface BookFacadeLocal extends FacadeLocal<Book>{
   
    /**
     * Finds a book by its name.
     * The name can be just a little part of the real title of the book
     * @param name a part of the book title
     * @return list of all books containing the name
     */
    List<Book> findByName(String name);    
}
