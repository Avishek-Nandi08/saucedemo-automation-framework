package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // Tells Cucumber where your feature files are located
        features = "src/test/resources/features",
        
        // Tells Cucumber where your step definitions and hooks are located
        glue = {"stepdefinitions", "hooks"},
        //tags = "@TC_INV_001",
        // The ExtentReports plugin requires this exact string (the colon at the end is mandatory)
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        
        // Makes the console output more readable
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class can be left empty. 
    // Extending AbstractTestNGCucumberTests allows it to run via TestNG.
}