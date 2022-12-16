Feature: Log In with non-existent data
  Background: Test that every topic
    discussed in screenplay module
    can be applied in this example

  Scenario Outline: User can't Log in with wrong data
    Given Automation open my store site
    When he go to my account section
    Then he waits for login form to be loaded

    When he logs in with user "<username>" and password "<password>"
    And he can see the title Login to your account
    Then he can see the error called Your email or password is incorrect!


    Examples:
      | username             | password  |
      | uservisac91@gmail.com | D1$ne4ABC |
