package com.rest.api.polyclinic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application configuration class.
 */
@EnableJpaRepositories("com.rest.api.polyclinic.repository")
@ComponentScan("com.rest.api.polyclinic")
@EnableTransactionManagement
@Configuration
public class ApplicationConfiguration {

}
