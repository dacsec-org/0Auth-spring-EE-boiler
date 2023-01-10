package org.dacsec.services;

import org.dacsec.domains.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThatService extends IOperations<Clients> {
    
    Clients retrieveByName(String name);
    
    Page<Clients> findPaginated(Pageable pageable);
}
