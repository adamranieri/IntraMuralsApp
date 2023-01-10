Feature: Logout

  Scenario: A logged in 'player' logs out
    Given the user has a role of 'player'
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page
    Then the user should not be logged in

  Scenario: A logged in 'captain' logs out
    # Given the user has a role of 'player' 
    Given the user is a 'captain'
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page
    Then the user should not be logged in

  Scenario: A logged in 'admin' logs out
    Given the user has a role of 'admin'
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page
    Then the user should not be logged in

  Scenario: A logged in 'referee' logs out
    Given the user has a role of 'referee'
    Given The user is on the home page
    When  The user clicks on the logout button
    Then the user should return to the login page
    Then the user should not be logged in