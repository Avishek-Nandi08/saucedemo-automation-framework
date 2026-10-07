package locators;
import org.openqa.selenium.By;

public class CartLocators {
	
	private By productNames= By.xpath("//div[@class='inventory_item_name']");
	private By continueShoppingBtn = By.id("continue-shopping");
	private final String dynamicProductRemoveBtnTemplate = "//button[contains(@id,'remove-%s')]";
	
	
	public By  getProductNames() {
		return productNames;
	}
	public By getContinueShoppingBtn() {
		return continueShoppingBtn;
	}
	
	public By getDynamicProductRemoveBtn(String product) {
		String formattedProduct = product.toLowerCase().replace(" ", "-");
        String completeXpath = String.format(dynamicProductRemoveBtnTemplate, formattedProduct);
        return By.xpath(completeXpath);
	}
	
}
