Feature: User login on SauceDemo

  Scenario: Successful login with valid credentials
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they should see the page title "Swag Labs"
    And they enter username "standard_user" and password "secret_sauce"
    Then they should see the text "Products"