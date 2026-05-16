package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    @Autowired
    private WebDriver driver;

    public void open() {
        driver.get("https://otus.ru");
    }
}