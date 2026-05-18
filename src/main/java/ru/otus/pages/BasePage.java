package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.annotations.page.Path;
import ru.otus.config.TestContext;

import java.time.Duration;
import java.util.List;

@Component
public abstract class BasePage<T> {
    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
    }

    private String getPath() {
        Class<T> clazz = (Class<T>) getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            return clazz.getAnnotation(Path.class).value();
        }
        return "";
    }

    public void open() {
        context.getDriver().get(baseUrl + getPath());

    }

    protected WebElement getElement(String xPath) {
        waitWhileElementIsPresent(xPath);
        return context.getDriver().findElement(By.xpath(xPath));
    }

    protected List<WebElement> getElements(String xPath) {
        waitWhileElementIsPresent(xPath);
        return context.getDriver().findElements(By.xpath(xPath));
    }

    public void waitWhileElementIsPresent(String xPath) {
        PageFactory.initElements(context.getDriver(), this);
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}