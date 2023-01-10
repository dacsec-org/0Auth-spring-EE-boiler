package org.dacsec.configs;

import org.dacsec.services.ThisService;
import org.dacsec.implementations.ThisSpringDataJpaService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * {@link PersistenceConfiguration} is a Spring {@link Configuration} class that
 * provides the necessary beans to configure the persistence layer.
 */
@Configuration
@Profile("!tc")
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {
    
    @Bean
    public ThisService barSpringDataJpaService() {
        return new ThisSpringDataJpaService();
    }
}
