package com.stackroute.Music.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")

public class DatabaseConfig {

    @Profile("dev")
    @Bean
    public void devDataBaseConnection(){
    }

    @Profile("prod")
    @Bean
    public void prodDataBaseConnection(){
    }

}
