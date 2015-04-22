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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rakotoarivony
 */
@Entity
@Table(name = "BOOK")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByParutionYear", query = "SELECT b FROM Book b WHERE b.parutionYear = :parutionYear")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARUTION_YEAR")
    private int parutionYear;
    @JoinTable(name = "BOOK_JOIN_COMMAND", joinColumns = {
        @JoinColumn(name = "TITLE", referencedColumnName = "TITLE")}, inverseJoinColumns = {
        @JoinColumn(name = "COMMAND_NUMBER", referencedColumnName = "COMMAND_ID")})
    @ManyToMany
    private Collection<Command> commandCollection;
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Author authorId;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, int parutionYear) {
        this.title = title;
        this.parutionYear = parutionYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParutionYear() {
        return parutionYear;
    }

    public void setParutionYear(int parutionYear) {
        this.parutionYear = parutionYear;
    }

    public Collection<Command> getCommandCollection() {
        return commandCollection;
    }

    public void setCommandCollection(Collection<Command> commandCollection) {
        this.commandCollection = commandCollection;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carJee.model.Book[ title=" + title + " ]";
    }
    
}
