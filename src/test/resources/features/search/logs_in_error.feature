Feature:Unsuccessful login
  Background: Test that every topic
    discussed in screenplay module
    can be applied in this example

  Scenario Outline: User can not Log in with errors
    Given Automation open my store site
    When he go to my account section
    And he wait for login form to be loaded
    Then he should see the login form title

    When he logs in with user "<username>" and password "<password>"
    Then he should see a warning message for wrong credentials

    Examples:
      | username             | password  |
      |uservisac91@gmail.com | D1$ne4ABC    |
