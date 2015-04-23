/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Represents the table command from the database
 * @author rakotoarivony
 */
@Entity
@Table(name = "COMMAND")
@NamedQueries({
    @NamedQuery(name = "Command.findAll", query = "SELECT c FROM Command c"),
    @NamedQuery(name = "Command.findByCommandId", query = "SELECT c FROM Command c WHERE c.commandId = :commandId")})
public class Command implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMAND_ID")
    private Integer commandId;
    @ManyToMany(mappedBy = "commandCollection")
    private Collection<Book> bookCollection;
    @JoinColumn(name = "CLIENT_USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne
    private Client clientUsername;

    public Command() {
    }

    public Command(Integer commandId) {
        this.commandId = commandId;
    }

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }

    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public Client getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(Client clientUsername) {
        this.clientUsername = clientUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandId != null ? commandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Command)) {
            return false;
        }
        Command other = (Command) object;
        if ((this.commandId == null && other.commandId != null) || (this.commandId != null && !this.commandId.equals(other.commandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carJee.model.Command[ commandId=" + commandId + " ]";
    }
    
}
