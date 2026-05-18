package ru.otus.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.otus.config.TestContext;

@Component
@Lazy
public class CoursePage extends BasePage<CoursePage> {
    @Autowired
    TestContext context;
    private final String headerLocator = "//h1";

    public CoursePage(TestContext context) {
        super(context);
    }

    public String getHeader() {
        return getElement(headerLocator).getText();
    }


}
