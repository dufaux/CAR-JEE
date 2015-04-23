package com.carJee.facade;

import com.carJee.model.Command;
import javax.ejb.Local;

/**
 * Is a facade interface to handle persistence for authors
 * @author rakotoarivony
 */
@Local
public interface CommandFacadeLocal extends FacadeLocal<Command>{
    
}
