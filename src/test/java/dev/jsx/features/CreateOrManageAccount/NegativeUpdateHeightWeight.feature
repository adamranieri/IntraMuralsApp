Feature: Negative Update Height & Weight

Given The user is logged in

  Scenario:The user wants to update their height with non-possible values
    Given The user is on the User Edit Page
    When the user types a new height "10" inches in the height input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"

  Scenario:The user wants to update their height with non-possible values
    Given The user is on the User Edit Page
    When the user types a new height "0" inches in the height input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"

  Scenario:The user wants to update their height with non-possible values
    Given The user is on the User Edit Page
    When the user types a new height "-10" inches in the height input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"


  Scenario:The user wants to update their weight with non-possible values
    Given The user is on the User Edit Page
    When the user types a new weight "10" pounds in the weight input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"

  Scenario:The user wants to update their weight with non-possible values
    Given The user is on the User Edit Page
    When the user types a new weight "0" pounds in the weight input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"

  Scenario:The user wants to update their weight with non-possible values
    Given The user is on the User Edit Page
    When the user types a new weight "-10" pounds in the weight input
    When the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that gives a warning "Invalid input"
