Feature: Incorrect Log In
  Background: Go to Homepage

  Scenario Outline: User can Log in with errors
    Given Automation open Homepage
    When he click on login
    Then he wait for login form to be loaded

    When he logs in with user "<email>" and password "<password>"
    Then he should see incorrect email

    Examples:
      | email    | password  |
      | holaholahola@gmail.com | 123456789 |
