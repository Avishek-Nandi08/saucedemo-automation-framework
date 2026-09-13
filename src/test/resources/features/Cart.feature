@Cart
Feature: Cart Operations on SauceDemo

  @TC_INV_001 @smoke
  Scenario Outline: Add a specific product to the cart
    Given the user is logged in and on the inventory page
    When the user clicks the "Add to cart" button for the "<product>"
    Then the "Add to cart" button text changes to "Remove"
    And a cart badge appears in the top right corner displaying the number "1"

    Examples: 
      | product             |
      | Sauce Labs Backpack |