package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "ru.otus.pages")
@PropertySource("classpath:application.properties")
public class TestConfig {
    @Bean
    public TestContext testContext() {
        return new TestContext();
    }
}