Feature: Negative Update Profile Picture

  Scenario:The user updates their profile picture with an invalid url (url does not end with extension .jpg, .jpeg, .gif, .png)
    Given The user is on the User Edit Page
    When the user selects the profile picture text input
    Then the user pastes the url for an image "https://s-i.huffpost.com/gen/2223300/images/o-SCARY"
    Then the user clicks on the Submit button
    Then there is an alert message that says "Are you sure you want to edit your user profile?"
    Then the user clicks OK
    Then an alert message box appears that says "Update successful!"
    Then click OK

