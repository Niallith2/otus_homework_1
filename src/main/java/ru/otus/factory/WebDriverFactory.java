package ru.otus.factory;

import org.openqa.selenium.WebDriver;
import ru.otus.config.WebDriverConfig;

public class WebDriverFactory {

    public WebDriver getDriver(String browserType) {
        return switch (browserType) {
            case "chrome" -> new WebDriverConfig().chromeDriver();
            default -> throw new IllegalStateException("Unexpected value: " + browserType.toLowerCase());
        };
    }
}
