Feature: Login

  Scenario Outline: Login with correct credentials
    Given The user is on the login page
    When  The user types "<username>" into username input
    When The user types "<password>" into password input
    When The user clicks on the login button
    Then the user should be on the "User Page"
    Then The user should see their name "<role>" on the home page
    Then The user should see their name "<username>" on the home page

    Examples:
      | username   | password | role    |
      | g8torFan99 | chomp!!  | admin   |
      | cindy101   | pass123  | referee |
      | Bobby202   | pass123  | player  |
      | margo23    | eCItXyih | player  |


