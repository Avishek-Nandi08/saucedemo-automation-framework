package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import org.openqa.selenium.Alert;

public class ActionHelper {
    private WaitHelper waitHelper;
    private WebDriver driver;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    // Waits for the element to be clickable, then clicks it
    public void safeClick(By locator) {
        waitHelper.waitForClickability(locator).click();
    }

    // Waits for the element to be visible, clears it, then types
    public void safeSendKeys(By locator, String text) {
        waitHelper.waitForVisibility(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    
    // Waits for the element to be visible, then returns its text
    public String safeGetText(By locator) {
        return waitHelper.waitForVisibility(locator).getText();
    }
    
    //wait for password reset alert and click ok
    public void safeAcceptAlert() {
    	Alert alert = waitHelper.waitForAlert();
        
        // 2. Accept it on the next line
        alert.accept();
    }
 // Navigates to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }	
    
    public  String[] getMultipleTexts(By locator) {
    	List<WebElement> elements = driver.findElements(locator);
    	String[] texts = new String[elements.size()];
    	for (int i = 0; i < elements.size(); i++) {
            texts[i] = elements.get(i).getText();
        }
    	return texts;
    }

	public String safeGetCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
}