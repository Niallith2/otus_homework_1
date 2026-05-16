package ru.otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.otus.config.TestConfig;
import ru.otus.config.WebDriverConfig;
import ru.otus.listeners.HighlightListener;


@ContextConfiguration(classes = {WebDriverConfig.class, TestConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebDriver webDriver;

    @AfterMethod
    public void shutdown() {
        if (webDriver != null)
            webDriver.quit();
    }

}
