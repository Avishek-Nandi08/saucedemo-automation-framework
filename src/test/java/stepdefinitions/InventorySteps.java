package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert; // Updated to TestNG Assert

import com.aventstack.extentreports.model.Test;

import actions.LoginActions;
import hooks.Hooks;
import actions.InventoryActions;
import utils.ConfigReader; // Imported your new utility

public class InventorySteps {
    
    LoginActions loginActions = new LoginActions(Hooks.driver);
    InventoryActions inventoryActions = new InventoryActions(Hooks.driver);

    @Given("the user is logged in and on the inventory page")
    public void the_user_is_logged_in_and_on_the_inventory_page() {
        loginActions.navigateToLogin();
        
        // Fetching credentials securely from config.properties!
        loginActions.enterUsername(ConfigReader.getProperty("valid_username"));
        loginActions.enterPassword(ConfigReader.getProperty("valid_password"));
        loginActions.clickLogin();
        
        
        System.out.println("User is inside inventory");
		/*
		 * System.out.println("Waiting for alert popup"); try {
		 * inventoryActions.acceptAlert(); }catch(Exception ex) {
		 * System.out.println(ex); return; }
		 */
    }

    @When("the user clicks the {string} button for the {string}")
    public void the_user_clicks_the_button_for_the(String buttonType, String product) {
    	
    	String[] products= product.split(", ");
    	for(String prod: products) {
    		inventoryActions.clickAddToCart(prod);
    	}
        System.out.println("Products added");
    }

    @Then("the {string} button text changes to {string}")
    public void the_button_text_changes_to(String product, String expectedText) {
        // Passing the 'product' variable so the dynamic locator finds "Sauce Labs Backpack"
        String actualText = inventoryActions.getTextOfRemoveButton(product);
        
        Assert.assertEquals(actualText, expectedText, "The button text did not change to Remove!");    
        System.out.println("Remove button found");
    }

    @Then("a cart badge appears in the top right corner displaying the number {string}")
    public void a_cart_badge_appears_in_the_top_right_corner_displaying_the_number(String expectedBadgeNumber) {
        String cartValue = inventoryActions.getValueOfCartBadge();
        
        Assert.assertEquals(cartValue, expectedBadgeNumber, "Cart badge number is incorrect!");
        System.out.println("The cart value is " + cartValue);
    }
    @Then("click on cart icon")
    public void click_on_cart_icon() {
        inventoryActions.clickCartIcon();
        String actualUrl = inventoryActions.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("cart"));
    }

}