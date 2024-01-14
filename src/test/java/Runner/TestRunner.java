package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import static Pages.WebPages.LoginPage.driver;

@CucumberOptions(
        features = "src/test/java/Features", // path to your feature files
        glue = "StepDefinitions",       // package where your step definitions are located
        plugin = {"pretty",
                  "html:test-output/cucumber-reports/cucumber.html",
                  "rerun:target/failedrerun.txt"
                  }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class will run your Cucumber tests with TestNG



    @BeforeClass
    public void BeforeClassmethod(){
        System.out.println("Control is in before class");
    }

    @AfterSuite
    public void AfterSuiteMethod(){
        System.out.println("Test Suite ran successfully");
        driver.quit();
    }
}
