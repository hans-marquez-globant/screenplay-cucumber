Feature: LogIn
  Background: Test that every topic
    discussed in screenplay module
    can be applied in this example

  Scenario Outline: User can Log in correctly
    Given Automation open my store site
    When he go to my account section
    Then he waits for login form to be loaded

    When he logs in with user "<username>" and password "<password>"
    Then he should see log in status correctly

    Examples:
      | username             | password  |
      |uservisac91@gmail.com | D1$ne4    |
