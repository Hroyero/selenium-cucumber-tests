@cartBadge
Feature: Add multiple products and verify cart account

  Scenario: Add multiple products and verify cart count
  Given the user is logged in with valid credentials
  When the user adds the product "Sauce Labs Backpack" to the cart
  And the user adds the product "Sauce Labs Bike Light" to the cart
  And the cart should contain "Sauce Labs Backpack" and "Sauce Labs Bike Light"
  Then the cart badge should show "2"
