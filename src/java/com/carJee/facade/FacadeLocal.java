/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.facade;

import java.util.List;

/**
 * Is a facade for the generic type T
 * @author rakotoarivony
 * @param <T> the type of entity that this facade supports.
 */
public interface FacadeLocal<T> {

    /**
     * Returns the number of elements in the table associated to T
     * @return 
     */
    int count();

    /**
     * Creates a new entity in the table associated to T
     * 
     * @param entity the entity to be added to table
     */
    void create(T entity);

    /**
     * Updates the given entity in database.
     * 
     * @param entity the new data of the entity
     */
    void edit(T entity);

    /**
     * Returns an entity in the base which primary key is equivalent to the given id
     * @param id the primary key of the entity to be retrieved
     * @return an entity which parimary key is id
     */
    T find(Object id);

    /**
     * Returns all elements in the table associated to T
     * @return all elements in the table associated to T
     */
    List<T> findAll();

    /**
     * Returns all elements in the table associated to T between range[0] and range[1]
     * @param range a table of two integer representing the range
     * @return all elements in the table associated to T
     */
    List<T> findRange(int[] range);

    /**
     * Delete the given entity from database
     * @param entity the entity to be deleted
     */
    void remove(T entity);
    
}
