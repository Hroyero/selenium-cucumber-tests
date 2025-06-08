Feature: Login error validation

  Scenario: Empty username
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they enter username "" and password "secret_sauce"
    Then they should see the error message "Epic sadface: Username is required"

  Scenario: Empty password
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they enter username "standard_user" and password ""
    Then they should see the error message "Epic sadface: Password is required"

  Scenario: Invalid username
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they enter username "fake_user" and password "secret_sauce"
    Then they should see the error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Incorrect password
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they enter username "standard_user" and password "wrongpass"
    Then they should see the error message "Epic sadface: Username and password do not match any user in this service"
