package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoursePage extends BasePage<CoursePage>{

    @Autowired
    WebDriver driver;

    private final String headerLocator = "//h1";

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public String getHeader(){
        return getElement(headerLocator).getText();
    }




}
