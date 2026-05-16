package ru.otus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "ru.otus.pages")
@PropertySource("classpath:application.properties")
@Import(WebDriverConfig.class)
public class TestConfig {

}