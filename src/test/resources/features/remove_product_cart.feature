
  Feature: remove products from cart

    Scenario: Remove product from cart
      Given the user is logged in with valid credentials
      When the user adds the product "Sauce Labs Backpack" to the cart
      And proceeds to checkout
      And removes the product "Sauce Labs Backpack"
      Then the cart should be empty

