package ru.otus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.otus.pages.CoursesPage;
import ru.otus.pages.MainPage;

public class CatalogTests extends BaseTest {
    @Autowired
    MainPage mainPage;

    @Autowired
    CoursesPage coursesPage;

    @DataProvider(name = "dataProvider")
    public static Object[][] provideData() {
        return new Object[][]{
                {"SRE практики и инструменты"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void scenario1(String courseName) {
        coursesPage.open();
        String header = coursesPage
                .getCourseByName(courseName)
                .getHeader();
        Assert.assertEquals(header, courseName);
    }


    @Test
    @Ignore
    public void scenario2() {
        //TODO
    }

    @Test
    public void scenario3() {
        mainPage.open();
        String rndCourseName = mainPage.openRandomStudy();
        String selectedStudy = coursesPage.getSelectedStudy();
        Assert.assertTrue(rndCourseName.contains(selectedStudy));
    }

}