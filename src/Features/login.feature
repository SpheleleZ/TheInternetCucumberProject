Feature: Test login functionality

  Scenario Outline: Successfully login with valid credentials
    Given user on the login page
    When user enters <username> and <password>
    And user click login button
    Then logged in successfully
    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |