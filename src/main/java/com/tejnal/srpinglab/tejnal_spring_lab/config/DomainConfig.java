package com.tejnal.srpinglab.tejnal_spring_lab.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.tejnal.srpinglab.tejnal_spring_lab.domain")
@EnableJpaRepositories("com.tejnal.srpinglab.tejnal_spring_lab.repos")
@EnableTransactionManagement
public class DomainConfig {
}
