@Checkout
Feature: Product Purchase Flow

  Scenario: User logs in, adds a product to the cart and completes the purchase
    Given the user is logged in with valid credentials
    When the user adds the product "Sauce Labs Backpack" to the cart
    And proceeds to checkout
    And fills in personal information with "John", "Doe", "12345"
    And completes the purchase
    Then the user should see a confirmation message "Thank you for your order!"
