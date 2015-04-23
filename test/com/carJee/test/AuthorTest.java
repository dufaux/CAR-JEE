/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.test;

import com.carJee.model.Author;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rakotoarivony
 */
public class AuthorTest {
    
    public AuthorTest() {
    }

    /**
     * Test of getId method, of class Author.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expResult = 3;
        Author instance = new Author(expResult);
        
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Author.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 45;
        Author instance = new Author();
        instance.setId(id);
        assertEquals(id,instance.getId());
    }

    /**
     * Test of getName method, of class Author.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Nom bidon";
        Author instance = new Author(0,expResult,"");
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Author.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Setted name";
        Author instance = new Author();
        instance.setName(name);
        assertEquals(name,instance.getName());
    }

    /**
     * Test of getFirstname method, of class Author.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        String expResult = "Firstname";
        
        Author instance = new Author(0,"",expResult);
        
        String result = instance.getFirstname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstname method, of class Author.
     */
    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "Set firstname";
        Author instance = new Author();
        instance.setFirstname(firstname);
        assertEquals(firstname, instance.getFirstname());
    }

    

    /**
     * Test of equals method, of class Author.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Author instance = new Author(1,"Jean-Baptiste","De la Salle");
        Author instance2 = new Author(3,"Jean-Baptiste","De la Salle");
        
        assertEquals(instance, instance2);
    }

  
    
}
