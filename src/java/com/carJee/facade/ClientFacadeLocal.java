package com.carJee.facade;

import com.carJee.model.Client;
import javax.ejb.Local;

/**
 * Is a facade interface to handle persistence for authors
 * @author rakotoarivony
 */
@Local
public interface ClientFacadeLocal extends FacadeLocal<Client>{
    
}
