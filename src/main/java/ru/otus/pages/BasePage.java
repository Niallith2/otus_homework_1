package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.otus.annotations.page.Path;

import java.util.List;

import static java.lang.Thread.sleep;

@Component
@Lazy
public abstract class BasePage<T> {
    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private String getPath() {
        Class<T> clazz = (Class<T>) getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            return clazz.getAnnotation(Path.class).value();
        }
        return "";
    }

    public void open() {
        driver.get(baseUrl + getPath());
        PageFactory.initElements(driver, this);
    }

    protected WebElement getElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    protected List<WebElement> getElements(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public void waitWhileElementIsPresent(String xPath) {
        boolean success = false;
        int tryCount = 0;

        try {
            while (!success) {
                success = getElement(xPath).isDisplayed();
                sleep(1000);
                if (tryCount >= 10)
                    throw new RuntimeException("Элемент не найден за 10 сек");
                tryCount++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}