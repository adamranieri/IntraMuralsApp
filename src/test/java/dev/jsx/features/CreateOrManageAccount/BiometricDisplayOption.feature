Feature: Display Biometric Information Data


  Background:
    Given The user is logged in as player
    Given The user is on the User Edit Page

  Scenario:The user toggles the Biometric Informartion Data to Display/Do Not Display

    When the user clicks on the Display Biometrics checkbox
    Then the user clicks on the Submit button
    Then there is an alert message that asks user to confirm
    Then the user clicks OK
    Then an alert message box appears that says update was successful
    Then click OK