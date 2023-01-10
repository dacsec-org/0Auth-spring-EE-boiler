package org.dacsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.dacsec.daos")
@EntityScan("org.dacsec.domains")
public class EEBoilerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(EEBoilerApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
