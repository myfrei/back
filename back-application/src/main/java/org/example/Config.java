package org.example;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("org.example.domain")
@EnableJpaRepositories("org.example.adapter.persistens")
public class Config {
}
