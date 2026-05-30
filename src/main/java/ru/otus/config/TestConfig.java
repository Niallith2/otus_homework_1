package ru.otus.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "ru.otus")
@PropertySource("classpath:application.properties")
@CucumberContextConfiguration
public class TestConfig {
    @Bean
    public TestContext testContext() {
        return new TestContext();
    }
}