package ru.otus;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ru.otus.steps"},
        plugin = {"progress", "summary"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
