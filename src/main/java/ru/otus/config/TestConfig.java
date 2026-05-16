package ru.otus.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "ru.otus.pages")
@Import(WebDriverConfig.class)
public class TestConfig {

}