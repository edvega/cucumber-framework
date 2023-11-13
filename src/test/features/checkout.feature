Feature: Search and place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched for shortname <name> and extracted actual name  of product
    And added "3" items of the selected product to cart
    Then user proceeds to checkout and validate the <name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | name |  |
      | tom  |  |
