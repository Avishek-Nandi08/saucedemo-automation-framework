package stepdefinitions;

import actions.LoginActions;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.ConfigReader; // Imported your config reader

public class LoginSteps {
    
    // Instantiate your Actions class, passing the driver from Hooks
    LoginActions loginActions = new LoginActions(Hooks.driver);

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_saucedemo_login_page() {
        // Note: Make sure navigateToLogin() in LoginActions uses ConfigReader.getProperty("url")!
        loginActions.navigateToLogin();
    }

    // --- NEW SECURE STEP FOR VALID LOGINS ---
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginActions.enterUsername(ConfigReader.getProperty("valid_username"));
        loginActions.enterPassword(ConfigReader.getProperty("valid_password"));
    }

    // --- KEPT FOR NEGATIVE TESTING (e.g., testing fake or locked-out users) ---
    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginActions.enterUsername(username);
        loginActions.enterPassword(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginActions.clickLogin();
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed: User is not on the inventory page.");
    }
    
    @Then("the user should be given error message")
    public void the_user_should_be_given_error_message() {
        // Fetch the actual error text from the UI
        String actualError = loginActions.getErrorMessage();
        
        // Assert that the text matches the expected SauceDemo error
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualError, expectedError, "The error message did not match!");
    }
    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String expectedError) {
        // Fetch the actual error text from the UI
        String actualError = loginActions.getErrorMessage();
        
        // Assert that the UI text matches the expected string passed from your Feature file!
        Assert.assertEquals(actualError, expectedError, "The error message did not match!");
    }
}