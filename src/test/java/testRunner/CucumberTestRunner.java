package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "stepsDefinition",
        plugin = {
                "pretty",
                "html:/Users/fahiezah/Desktop/2024Projects/SeleniumOldProjects/report.html"
        }

)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
