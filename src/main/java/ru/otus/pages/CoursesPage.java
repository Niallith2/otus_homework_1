package ru.otus.pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.annotations.page.Path;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Component
@Path("/catalog/courses")
public class CoursesPage extends BasePage<CoursesPage>{
    @Autowired
    private WebDriver driver;

    @Autowired
    private CoursePage coursePage;

    private final String selectedStudyLocator = "//p[text()='Направление']/../following-sibling::*//input[@checked]/../../label";
    private final String searchInputLocator = "//input[@type = 'search']";
    private final String coursesNamesLocator = "//h6/div";
    private final String courseDatesLocator = "//h6/../descendant::*[contains(text(), 'месяц')]";

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public String getSelectedStudy(){
        return getElement(selectedStudyLocator).getText();
    }

    public CoursePage getCourseByName(String name){
        getElement(searchInputLocator).sendKeys(name);
        waitWhileElementIsPresent(String.format("//h6/div[contains(text(), '%s')]", name));
        List<WebElement> courses = getElements(coursesNamesLocator);
        WebElement course = courses.stream().filter(e-> e.getText().equals(name)).findFirst().get();
        course.click();
        return coursePage;
    }


    public void checkFirstAndLastCourses(){
        try {
            Document document = Jsoup.connect(driver.getCurrentUrl()).get();
            Elements elements = document.selectXpath(courseDatesLocator);
            HashMap<String, String> map = new HashMap<>();
            for (Element element: elements){
                String href = element.parent().parent().parent().attributes().get("href");

            }


            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
