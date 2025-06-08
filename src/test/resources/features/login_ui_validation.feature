@smoke @ui
Feature: Login page UI elements

  Scenario: Check all login form elements are visible
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    Then the username field should be visible
    And the password field should be visible
    And the login button should be visible
