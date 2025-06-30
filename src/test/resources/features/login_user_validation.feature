@Login
Feature: Login validation with multiple user types

  Scenario Outline: Login attempt with different users
    Given the user opens the browser
    When they navigate to the SauceDemo login page
    And they enter username "<username>" and password "<password>"
    Then The user should see the result "<expectedResult>"

    Examples:
      | username              | password     | expectedResult                         |
      | standard_user         | secret_sauce | dashboard                              |
      | locked_out_user       | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
      | problem_user          | secret_sauce | dashboard                              |
      | performance_glitch_user | secret_sauce | dashboard                            |
