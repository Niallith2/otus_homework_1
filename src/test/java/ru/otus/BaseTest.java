package ru.otus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import ru.otus.config.TestConfig;
import ru.otus.config.TestContext;


@ContextConfiguration(classes = {TestConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TestContext context;

    @AfterMethod
    public void shutdown() {
        context.quit();
    }

}
