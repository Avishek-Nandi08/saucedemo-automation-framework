@Login
Feature: User Login Functionality on SauceDemo

@PassLogin
  Scenario: Successful login with valid credentials
    Given the user is on the SauceDemo login page
    When the user enters username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the inventory page

@FailLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the SauceDemo login page
    When the user enters username "<username>" and password "<password>"
    And clicks the login button
    Then the user should see the error message "<expected_error>"

    Examples:
      | username        | password     | expected_error                                                            |
      | standard_user   | Avishek      | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      |                 | secret_sauce | Epic sadface: Username is required                                        |