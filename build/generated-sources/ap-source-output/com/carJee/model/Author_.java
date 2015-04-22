package com.carJee.model;

import com.carJee.model.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-22T19:11:24")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, Integer> id;
    public static volatile CollectionAttribute<Author, Book> bookCollection;
    public static volatile SingularAttribute<Author, String> name;
    public static volatile SingularAttribute<Author, String> firstname;

}