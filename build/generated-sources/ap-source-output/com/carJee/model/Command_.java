package com.carJee.model;

import com.carJee.model.Book;
import com.carJee.model.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-23T11:31:03")
@StaticMetamodel(Command.class)
public class Command_ { 

    public static volatile CollectionAttribute<Command, Book> bookCollection;
    public static volatile SingularAttribute<Command, Client> clientUsername;
    public static volatile SingularAttribute<Command, Integer> commandId;

}