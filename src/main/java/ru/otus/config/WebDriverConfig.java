package ru.otus.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.otus.listeners.HighlightListener;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Bean
    @Scope("singleton")
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.setPageLoadTimeout(Duration.ofSeconds(30));
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        options.setScriptTimeout(Duration.ofSeconds(20));

        WebDriver driver = new ChromeDriver(options);

        HighlightListener highlightListener = new HighlightListener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(highlightListener);
        driver = decorator.decorate(driver);
        return driver;
    }
}