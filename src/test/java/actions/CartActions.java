package actions;

import org.openqa.selenium.WebDriver;

import locators.CartLocators;
import utils.ActionHelper;

public class CartActions {
	
	private CartLocators cartLocators;
	private ActionHelper actionHelper;
	
	public CartActions(WebDriver driver) {
		this.actionHelper = new ActionHelper(driver);
		this.cartLocators = new CartLocators();
	}
	
	public String[] getProductNames(){
		return actionHelper.getMultipleTexts(cartLocators.getProductNames());
	}
	public String getCurrentUrl() {
		return actionHelper.safeGetCurrentUrl();
	}
	public void clickRemoveBtn(String productName) {
		actionHelper.safeClick(cartLocators.getDynamicProductRemoveBtn(productName));
	}
}
