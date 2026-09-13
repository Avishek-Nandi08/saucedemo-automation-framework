package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert; // Updated to TestNG Assert
import actions.LoginActions;
import hooks.Hooks;
import actions.CartActions;
import utils.ConfigReader; // Imported your new utility

public class CartSteps {
    
    LoginActions loginActions = new LoginActions(Hooks.driver);
    CartActions cartActions = new CartActions(Hooks.driver);

    @Given("the user is logged in and on the inventory page")
    public void the_user_is_logged_in_and_on_the_inventory_page() {
        loginActions.navigateToLogin();
        
        // Fetching credentials securely from config.properties!
        loginActions.enterUsername(ConfigReader.getProperty("valid_username"));
        loginActions.enterPassword(ConfigReader.getProperty("valid_password"));
        loginActions.clickLogin();
        
        System.out.println("User is inside inventory");
    }

    @When("the user clicks the {string} button for the {string}")
    public void the_user_clicks_the_button_for_the(String buttonType, String product) {
        cartActions.clickAddToCart(product);
        System.out.println("Product added");
    }

    @Then("the {string} button text changes to {string}")
    public void the_button_text_changes_to(String product, String expectedText) {
        // Passing the 'product' variable so the dynamic locator finds "Sauce Labs Backpack"
        String actualText = cartActions.getTextOfRemoveButton(product);
        
        Assert.assertEquals(actualText, expectedText, "The button text did not change to Remove!");    
        System.out.println("Remove button found");
    }

    @Then("a cart badge appears in the top right corner displaying the number {string}")
    public void a_cart_badge_appears_in_the_top_right_corner_displaying_the_number(String expectedBadgeNumber) {
        String cartValue = cartActions.getValueOfCartBadge();
        
        Assert.assertEquals(cartValue, expectedBadgeNumber, "Cart badge number is incorrect!");
        System.out.println("The cart value is " + cartValue);
    }
}