package hooks;

import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Hooks {
    
    // Static driver for simple sequential execution
    public static WebDriver driver;

    @Before
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
    	
    	String isHeadless = System.getProperty("headless", "false"); 
        if (isHeadless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }
    	// 1. Disable the specific password leak detection feature
        options.addArguments("--disable-features=PasswordLeakDetection");

        // 2. Disable standard password saving prompts
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 3. Initialize driver with the configured options
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        
        // Removed: Do not mix Implicit Waits with your new ActionHelper's Explicit Waits!
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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