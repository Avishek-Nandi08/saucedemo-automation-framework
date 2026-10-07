package actions;

import org.openqa.selenium.WebDriver;
import java.util.*;
import utils.ActionHelper;
import locators.InventoryLocators;

public class InventoryActions {
	
	
	private InventoryLocators inventoryLocators;
	private ActionHelper actionHelper;
	
	public InventoryActions(WebDriver driver) {
		this.inventoryLocators= new InventoryLocators();
		this.actionHelper = new ActionHelper(driver);
	}
	
	public void acceptAlert() {
		actionHelper.safeAcceptAlert();
	}
	
	public void clickAddToCart(String product) {
		actionHelper.safeClick(inventoryLocators.getAddToCartDynamicButton(product));
	}
	
	public String getTextOfRemoveButton(String product) {
		String value =actionHelper.safeGetText(inventoryLocators.getRemoveDynamicButton());
		return value;
	}
	
	public String getValueOfCartBadge() {
		String value = actionHelper.safeGetText(inventoryLocators.getCartBadge());
		return value;
	}
	
	public void clickCartIcon() {
		actionHelper.safeClick(inventoryLocators.getCartIcon());
	}
	public String getCurrentUrl() {
		return actionHelper.safeGetCurrentUrl();
	}
}
