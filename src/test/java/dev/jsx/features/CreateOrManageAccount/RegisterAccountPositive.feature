Feature: Register New User

  Scenario: Register with full name and password
    Given The user is on the register page
    When  The user types Testuser111 into username input
    When The user types password111 into password input
    When The user clicks on the register button
    Then the user gets an alert message Registration Successful
    Then user clicks accept button on the alert message
    Then the user should be on the User Page
    Then The user should see their name Testuser111 on the home page



