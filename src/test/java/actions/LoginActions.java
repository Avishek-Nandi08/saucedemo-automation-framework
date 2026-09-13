package actions;

import locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader; // Imported your new utility

public class LoginActions {
	
	private WebDriver driver;
	private LoginLocators loginLocators;
	
	public LoginActions(WebDriver driver) {
		this.driver = driver;
		this.loginLocators = new LoginLocators();
	}
	
	public void navigateToLogin() {
        // Fetches the URL directly from the properties file!
        driver.get(ConfigReader.getProperty("url"));
    }

    public void enterUsername(String username) {
        driver.findElement(loginLocators.getUsernameField()).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(loginLocators.getPasswordField()).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginLocators.getLoginButton()).click();
    }

    public String getErrorMessage() {
        return driver.findElement(loginLocators.getErrorMessage()).getText();
    }
}