package ru.otus.pages;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.otus.annotations.page.Path;
import ru.otus.config.TestContext;

import java.util.List;
import java.util.Random;

@Path("/")
@Component
@Lazy
public class MainPage extends BasePage<MainPage> {

    @Autowired
    TestContext context;

    @Autowired
    private CoursesPage coursesPage;

    private final String studyDropdownButtonLocator = "//span[@title='Обучение']";
    private final String allCoursesLocators = "//p[contains(text(),'Направления')]/following-sibling::*/a";

    public MainPage(TestContext context) {
        super(context);
    }

    public String openRandomStudy() {
        getElement(studyDropdownButtonLocator).click();
        List<WebElement> courses = getElements(allCoursesLocators);
        int rnd = new Random().nextInt(courses.size());
        String courseName = courses.get(rnd).getText();
        courses.get(rnd).click();
        return courseName;
    }
}
