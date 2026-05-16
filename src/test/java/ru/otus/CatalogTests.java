package ru.otus;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import ru.otus.pages.MainPage;

public class CatalogTests extends BaseTest {
    @Autowired
    MainPage mainPage;

    @Test
    public void testEarliestAndLatestCourses() {
        mainPage.open();
    }

}