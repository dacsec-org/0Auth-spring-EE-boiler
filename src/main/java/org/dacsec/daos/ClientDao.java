package org.dacsec.daos;

import org.dacsec.domains.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientDao extends JpaRepository<Clients, Long> {
    
    @Query("SELECT f FROM Clients f WHERE LOWER(f.name) = LOWER(:name)")
    Clients retrieveByName(@Param("name") String name);
}
