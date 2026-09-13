package locators;

import org.openqa.selenium.By;

public class CartLocators {
    
    // String Templates waiting for the product name
    private final String ADD_TO_CART_BTN_TEMPLATE = "//button[contains(@id,'add-to-cart-%s')]";
    //private final String REMOVE_BTN_TEMPLATE = "//button[contains(@id,'remove-')]";
    
    private By removeBtn = By.xpath("//button[contains(@id,'remove-')]");
    // Static locator for the cart badge
    private By cartBadge = By.className("shopping_cart_badge");

    // Getter for Add to Cart
    public By getAddToCartDynamicButton(String product) {
        String formattedProduct = product.toLowerCase().replace(" ", "-");
        String completeXpath = String.format(ADD_TO_CART_BTN_TEMPLATE, formattedProduct);
        return By.xpath(completeXpath);
    }

    // Getter for Remove Button
    public By getRemoveDynamicButton() {
        return removeBtn;
    }

    // Getter for Cart Badge
    public By getCartBadge() {
        return cartBadge;
    }
}