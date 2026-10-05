package actions;

import locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;
import utils.ConfigReader; 

public class LoginActions {
	
	private LoginLocators loginLocators;
	private ActionHelper actionHelper;
	
	public LoginActions(WebDriver driver) {
		this.loginLocators = new LoginLocators();
		this.actionHelper = new ActionHelper(driver);
	}
	
	public void navigateToLogin() {
		actionHelper.navigateTo(ConfigReader.getProperty("url"));
	}

	public void enterUsername(String username) {
		actionHelper.safeSendKeys(loginLocators.getUsernameField(), username);
	}

	public void enterPassword(String password) {
		actionHelper.safeSendKeys(loginLocators.getPasswordField(), password);
	}

	public void clickLogin() {
		actionHelper.safeClick(loginLocators.getLoginButton());
	}

	public String getErrorMessage() {
		return actionHelper.safeGetText(loginLocators.getErrorMessage());
	}
}