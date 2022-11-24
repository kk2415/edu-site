package com.onoffmix.yonsei.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EntityScan("com.onoffmix.yonsei")
@EnableJpaRepositories("com.onoffmix.yonsei")
@Configuration
public class JpaConfig {
}
