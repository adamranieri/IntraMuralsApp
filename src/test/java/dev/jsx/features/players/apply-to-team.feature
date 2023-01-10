Feature: apply to team
  Scenario: the player applies to a specific team
    Given the player is logged in
    And   the player is on the homepage
    When  the player clicks on the Team Applications link
    Then  the player is on the Team Application page
    When  the player selects "The Ballers" from the dropdown
    And   the player clicks the Apply button
    Then  a dialog should appear saying "Team Application Successful"
    Then  the application status for "The Ballers" should say "pending"
