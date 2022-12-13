Feature: LogIn - Edge
  Background: Test that every topic
    discussed in screenplay module
    can be applied in this example

  Scenario Outline: User can Log in with errors
    Given Automation open my store site
    When he go to my account section
    Then he wait for login form to be loaded

    When he logs in with user "<username>" and password "<password>"
    Then he should see log in error message

    Examples:
      | username             | password  |
      |wronguser@gmail.com   | wrongpass |
