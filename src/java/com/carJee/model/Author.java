/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carJee.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rakotoarivony
 */
@Entity
@Table(name = "AUTHOR")
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.authorPK.name = :name"),
    @NamedQuery(name = "Author.findByFirstname", query = "SELECT a FROM Author a WHERE a.authorPK.firstname = :firstname")})
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AuthorPK authorPK;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Collection<Book> bookCollection;

    public Author() {
    }

    public Author(AuthorPK authorPK) {
        this.authorPK = authorPK;
    }

    public Author(String name, String firstname) {
        this.authorPK = new AuthorPK(name, firstname);
    }

    public AuthorPK getAuthorPK() {
        return authorPK;
    }

    public void setAuthorPK(AuthorPK authorPK) {
        this.authorPK = authorPK;
    }

    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorPK != null ? authorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorPK == null && other.authorPK != null) || (this.authorPK != null && !this.authorPK.equals(other.authorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carJee.model.Author[ authorPK=" + authorPK + " ]";
    }
    
}
