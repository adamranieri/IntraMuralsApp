Feature: Login Positive

  Scenario Outline: Login with correct credentials
    Given The user is on the login page
    When  The user types "<username>" into username input
    When The user types "<password>" into password input
    When The user clicks on the login button
    Then the user should be on the User Page
    Then The user should see their role "<role>" on the home page
    Then The user should see their name "<username>" on the home page

    Examples:
      | username   | password | role    |
      | gatorFan99 | chomp!!  | Admin   |
      | cindy101   | pass123  | Referee |
      | Bobby202   | pass123  | Player  |
      | margo23    | eCItXyih | Player  |



