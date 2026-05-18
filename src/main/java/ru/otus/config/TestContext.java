package ru.otus.config;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import ru.otus.factory.WebDriverFactory;

@Configuration
public class TestContext {
    @Value("${browser.type}")
    private String browser;

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(new WebDriverFactory().getDriver(browser));
        }
        return webDriver.get();
    }

    public void quit() {
        if (webDriver != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
