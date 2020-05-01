package com.nopaldev.artesanos.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.nopaldev.artesanos.core.respositories")
@EnableTransactionManagement
public class AppLevelConfig {
}
