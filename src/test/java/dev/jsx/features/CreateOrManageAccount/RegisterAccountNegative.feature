Feature: Negative Register New User


  Scenario: Register with username that already exists and password
    Given The user is on the register page
    When  The user types TopDawg into username input
    When The user types password111 into password input
    When The user clicks on the register button
    Then the user should get an alert message that this username is already registered
    Then the user should remain on the register page

  Scenario: Register with a blank username password
    Given The user is on the register page
    When  The user types blank into username input
    When The user types password111 into password input
    When The user clicks on the register button
    Then the user should get an alert message that this username is already registered
    Then the user should remain on the register page

  Scenario: Register with username and a blank password
    Given The user is on the register page
    When  The user types Testuser9009 into username input
    When The user types blank into password input
    When The user clicks on the register button
    Then the user should get an alert message that this username is already registered
    Then the user should remain on the register page

  Scenario: Register with a blank username and a blank password
    Given The user is on the register page
    When  The user types blank into username input
    When The user types blank into password input
    When The user clicks on the register button
    Then the user should get an alert message that this username is already registered
    Then the user should remain on the register page

