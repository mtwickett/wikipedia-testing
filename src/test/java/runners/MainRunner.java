package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
                 tags="@correct-url", monochrome = false, dryRun = false)
public class MainRunner extends AbstractTestNGCucumberTests {
}
