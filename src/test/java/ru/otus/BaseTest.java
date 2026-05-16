package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.otus.config.TestConfig;
import ru.otus.config.WebDriverConfig;
import ru.otus.pages.MainPage;

@ContextConfiguration(classes = {WebDriverConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {
}
