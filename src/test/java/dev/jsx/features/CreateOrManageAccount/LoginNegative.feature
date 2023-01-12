Feature: Login

  Scenario: Login with incorrect username and password
    Given The user is on the login page
    When  The user types asdfasdf into username input
    When The user types asdfadsf into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page

  Scenario: Login with correct username and correct password
    Given The user is on the login page
    When  The user types TopDawg into username input
    When The user types asdfadsf into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page

  Scenario: Login with correct username and correct password
    Given The user is on the login page
    When  The user types asdfasdf into username input
    When The user types pass123 into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page

  Scenario: Login with empty username and empty password
    Given The user is on the login page
    When  The user types "" into username input
    When The user types "" into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page

  Scenario: Login with empty username and correct password
    Given The user is on the login page
    When  The user types blank into username input
    When The user types pass123 into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page


  Scenario: Login with correct username and empty password
    Given The user is on the login page
    When  The user types TopDawg into username input
    When The user types blank into password input
    When The user clicks on the login button
    Then the user should get an alert message indicating incorrect credentials
    Then the user should stay on the login page
