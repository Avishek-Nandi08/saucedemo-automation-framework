package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Hooks {
    
    // Static driver for simple sequential execution
    public static WebDriver driver;

    @Before
    public void setUp() {
        // Selenium 4 automatically handles ChromeDriver setup; no WebDriverManager needed!
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        // This block intercepts a failed test and captures the screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            
            // This attaches the image directly to the Extent Report via the adapter
            scenario.attach(screenshot, "image/png", "Failed_Screenshot_" + scenario.getName()); 
        }
        
        // Always quit the driver to prevent zombie processes
        if (driver != null) {
            driver.quit();
        }
    }
}