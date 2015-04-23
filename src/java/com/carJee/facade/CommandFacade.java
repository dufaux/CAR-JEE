package com.carJee.facade;

import com.carJee.model.Command;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Is a facade implementation to make persistence for commands
 * @author rakotoarivony
 */
@Stateless
public class CommandFacade extends AbstractFacade<Command> implements CommandFacadeLocal {
    @PersistenceContext(unitName = "test1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandFacade() {
        super(Command.class);
    }
    
}
