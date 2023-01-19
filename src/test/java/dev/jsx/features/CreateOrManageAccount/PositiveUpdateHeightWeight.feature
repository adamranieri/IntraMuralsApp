Feature: Positive Update Height & Weight

Given The user is logged in

  Scenario:The user wants to update their height
    Given The user is logged in as player
    Given The user is on the User Edit Page
    When the user types a new height seventy five inches in the height input
    When the user clicks on the Submit button
    Then there is an alert message that says Are you sure you want to edit your user profile?
    Then the user clicks OK
    Then an alert message box appears that says Update successful!
    Then click OK
    Then the input for height remains seventy five inches


  Scenario:The user wants to update their weight
    Given The user is logged in as player
    Given The user is on the User Edit Page
    When the user types a new weight one hundred eighty into the weight input
    When the user clicks on the Submit button
    Then there is an alert message that says Are you sure you want to edit your user profile?
    Then the user clicks OK
    Then an alert message box appears that says Update successful!
    Then click OK
    Then the input for weight remains one hundred eighty inches
