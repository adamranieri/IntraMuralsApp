Feature: Positive Update Height & Weight

Given The user is logged in

  Scenario:The user wants to update their height
    Given The user is on the User Edit Page
    When the user types a new height "75" inches in the height input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that says "Update successful!"
    Then click OK
    Then the input for height remains "75" inches


  Scenario:The user wants to update their weight
    Given The user is on the User Edit Page
    When the user types a new weight "180" into the weight input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that says "Update successful!"
    Then click OK
    Then the input for weight remains "180" inches
