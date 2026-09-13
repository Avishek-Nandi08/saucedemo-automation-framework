package locators;

import org.openqa.selenium.By;

public class LoginLocators {
	 	private By usernameField = By.id("user-name");
	    private By passwordField = By.id("password");
	    private By loginButton = By.id("login-button");
	    private By errorMessage = By.xpath("//h3[@data-test='error']");
	    	
	 // Public getters to safely expose them
	    public By getUsernameField() {
	        return usernameField;
	    }

	    public By getPasswordField() {
	        return passwordField;
	    }

	    public By getLoginButton() {
	        return loginButton;
	    }

	    public By getErrorMessage() {
	        return errorMessage;
	    }
}
