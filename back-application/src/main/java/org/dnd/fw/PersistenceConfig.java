package org.dnd.fw;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("org.dnd.domain")
@EnableJpaRepositories("org.dnd.adapter.persistence")
public class PersistenceConfig {
}
