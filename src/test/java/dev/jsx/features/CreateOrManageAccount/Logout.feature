Feature: Logout

  Scenario: A logged in 'player' logs out
    Given the user is logged in as a player
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page

  Scenario: A logged in 'captain' logs out
    Given the user is logged in as a captain
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page

  Scenario: A logged in 'admin' logs out
    Given the user is logged in as an admin
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page


  Scenario: A logged in 'referee' logs out
    Given the user is logged in as a referee
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page


