package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.otus.annotations.page.Path;

import java.util.List;
import java.util.Random;

@Path("/")
@Component
@Lazy
public class MainPage extends BasePage<MainPage>{
    @Autowired
    private WebDriver driver;
    @Autowired
    private CoursesPage coursesPage;

     private final String studyDropdownButtonLocator = "//span[@title='Обучение']";
     private final String allCoursesLocators = "//p[contains(text(),'Направления')]/following-sibling::*/a";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String openRandomStudy(){
        getElement(studyDropdownButtonLocator).click();
        List<WebElement> courses = getElements(allCoursesLocators);
        int rnd = new Random().nextInt(courses.size());
        String courseName = courses.get(rnd).getText();
        courses.get(rnd).click();
        return courseName;
    }
}
