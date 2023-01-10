package org.dacsec.implementations;

import org.dacsec.daos.ClientDao;
import org.dacsec.domains.Clients;
import org.dacsec.services.ThatService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link TheService} implementation.
 */
@Service
@Transactional
public class TheService extends AbstractService<Clients> implements ThatService {
    @Autowired
    private ClientDao dao;
    
    public TheService() {
        super();
    }
    
    // API
    @Override
    protected PagingAndSortingRepository<Clients, Long> getDao() {
        return dao;
    }
    
    // custom methods
    @Override
    public Clients retrieveByName(final String name) {
        return dao.retrieveByName(name);
    }
    
    // overridden to be secured
    @Override
    @Transactional(readOnly = true)
    public List<Clients> findAll() {
        return Lists.newArrayList(getDao().findAll());
        //FIXME:
    }
    
    @Override
    public Page<Clients> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
