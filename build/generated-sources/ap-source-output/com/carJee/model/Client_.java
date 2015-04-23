package com.carJee.model;

import com.carJee.model.Command;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-23T11:31:03")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, String> username;
    public static volatile CollectionAttribute<Client, Command> commandCollection;
    public static volatile SingularAttribute<Client, String> password;

}