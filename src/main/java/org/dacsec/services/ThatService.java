package org.dacsec.services;

import org.dacsec.domains.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * {@link ThatService} is a service interface for {@link Clients} domain.
 */
public interface ThatService extends IOperations<Clients> {
    
    Clients retrieveByName(String name);
    //FIXME: raw use of parameterized class
    
    Page<Clients> findPaginated(Pageable pageable);
}
