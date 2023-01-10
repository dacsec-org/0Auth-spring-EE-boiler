package org.dacsec.implementations;

import org.dacsec.daos.ThisCrudRepository;
import org.dacsec.domains.Logger;
import org.dacsec.services.ThisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * {@link ThisService} implementation.
 */
public class ThisSpringDataJpaService extends AbstractSpringDataJpaService<Logger> implements ThisService {
    
    @Autowired
    private ThisCrudRepository dao;
    
    public ThisSpringDataJpaService() {
        super();
    }
    
    @Override
    protected CrudRepository<Logger, Serializable> getDao() {
        return dao;
    }
    
    @Override
    public Page<Logger> findPaginated(int page, int size) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
