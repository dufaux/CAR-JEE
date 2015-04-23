package com.carJee.facade;

import com.carJee.model.Author;
import javax.ejb.Local;

/**
 * Is a facade interface to handle persistence for authors
 * @author rakotoarivony
 */
@Local
public interface AuthorFacadeLocal extends FacadeLocal<Author>{
    
}
