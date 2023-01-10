package org.dacsec.daos;

import org.dacsec.domains.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * {@link ClientDao} is a DAO interface for {@link Clients} entity.
 */
@SuppressWarnings("RawUseOfParameterizedClass")
public interface ClientDao extends JpaRepository<Clients, Long> {
    
    @Query("SELECT f FROM Clients f WHERE LOWER(f.name) = LOWER(:name)")
    Clients retrieveByName(@Param("name") String name);
    
    @Query("SELECT f FROM Clients f WHERE LOWER(f.email) = LOWER(:email)")
    Clients retrieveByEmail(@Param("email") String email);
    
    @Query("SELECT f FROM Clients f WHERE LOWER(f.phone) = LOWER(:phone)")
    Clients retrieveByPhone(@Param("phone") String phone);
    
    
}
