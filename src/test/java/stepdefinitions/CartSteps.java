package stepdefinitions;

import org.testng.Assert;

import actions.CartActions;
import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	
	CartActions cartActions = new CartActions(Hooks.driver);
	
	@Then("cart to contain all {string}")
    public void cart_to_contain_all(String product) {
        String[] products = product.split(", ");
        String[] actualProducts = cartActions.getProductNames();
        if(products.length!=actualProducts.length) {
        	Assert.fail("Products number mismatched");
        }else {
        	for(int i=0;i<products.length;i++) {
        		Assert.assertEquals(products[i], actualProducts[i]);
        	}
        	System.out.println("Expected and actual product matched");
        }
    }
    @When("user clicks on the remove button for {string}")
    public void user_clicks_on_the_remove_button_for(String product) {
        String[] products = product.split(", ");
        for(int i=0;i<products.length;i++) {
        	cartActions.clickRemoveBtn(products[i]);
        	System.out.println("Remove Button clicked for the product "+products[i]);
        }
    }
    @Then("cart should be empty")
    public void cart_should_be_empty() {
    	String[] actualProducts = cartActions.getProductNames();
    	Assert.assertEquals(actualProducts.length, 0);
    	System.out.println("Product list is empty");
    }
}
