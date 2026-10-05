@HomePage
Feature: Add to Cart Operations on SauceDemo

  @TC_INV_001 @smoke
  Scenario Outline: Add a specific product to the cart
    Given the user is logged in and on the inventory page
    When the user clicks the "Add to cart" button for the "<product>"
    Then the "Add to cart" button text changes to "Remove"
    And a cart badge appears in the top right corner displaying the number "1"

    Examples: 
      | product                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |

  @TC_INV_002 @smoke
  Scenario Outline: Add multiple product to the cart
    Given the user is logged in and on the inventory page
    When the user clicks the "Add to cart" button for the "<products>"
    Then a cart badge appears in the top right corner displaying the number "<Expected Number>"
    And click on cart icon
    Then cart to contain all "<products>"

    Examples: 
      | products                                     | Expected Number |
      | Sauce Labs Backpack, Sauce Labs Bolt T-Shirt |              2 |
