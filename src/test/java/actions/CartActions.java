package actions;

import org.openqa.selenium.WebDriver;
import locators.CartLocators;

public class CartActions {
	
	private WebDriver driver;
	
	private CartLocators cartLocators;
	
	public CartActions(WebDriver driver) {
		this.driver = driver;
		this.cartLocators= new CartLocators();
	}
	
	public void clickAddToCart(String product) {
		driver.findElement(cartLocators.getAddToCartDynamicButton(product)).click();
	}
	
	public String getTextOfRemoveButton(String product) {
		String value = driver.findElement(cartLocators.getRemoveDynamicButton()).getText();
		return value;
	}
	
	public String getValueOfCartBadge() {
		String value = driver.findElement(cartLocators.getCartBadge()).getText();
		return value;
	}
}
