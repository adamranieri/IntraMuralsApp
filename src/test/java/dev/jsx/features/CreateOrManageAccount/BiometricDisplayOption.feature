Feature: Display Biometric Information Data

  Scenario:The user toggles the Biometric Informartion Data to Display/Do Not Display
    Given The user is on the User Edit Page
    When the user clicks on the Display Biometrics checkbox
    Then the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that says "Update successful!"
    Then click OK