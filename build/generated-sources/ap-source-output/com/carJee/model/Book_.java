package com.carJee.model;

import com.carJee.model.Author;
import com.carJee.model.Command;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-22T20:19:12")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Author> author;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile CollectionAttribute<Book, Command> commandCollection;
    public static volatile SingularAttribute<Book, Integer> parutionYear;

}