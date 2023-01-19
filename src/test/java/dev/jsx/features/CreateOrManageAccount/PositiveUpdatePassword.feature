Feature: Positive Update Password



  Scenario:The user wants to update their password
    Given The user is logged in as player
    Given The user is on the User Edit Page
    When the user types a new password newpass123 into the password input
    When the user clicks on the Submit button
    Then there is an alert message that says Are you sure you want to edit your user profile?
    Then the user clicks OK
    Then an alert message box appears that says Update successful!
    Then click OK
