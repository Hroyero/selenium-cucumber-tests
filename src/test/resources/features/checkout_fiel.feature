@CheckoutFiel
Feature: Add multiple products and verify cart account

Scenario: Checkout fails with missing first name
Given the user is logged in with valid credentials
When the user adds the product "Sauce Labs Backpack" to the cart
And proceeds to checkout
And fills in personal information with "", "Doe", "12345"
Then the checkout error message should be "Error: First Name is required"