Feature: Search and place the order for Products
  Scenario: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched for shortname "Tom" and extracted actual name  of product
    Then user searched for "Tom" shortname in offers page
    And validate product name in offers page matches with Landing Page