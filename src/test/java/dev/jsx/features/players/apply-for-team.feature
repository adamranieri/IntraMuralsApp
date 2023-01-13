Feature: players can apply to a team
  Scenario: a player applies to a team
    Given the player is logged in
    And   the player is on the home page
    When  the player clicks on the Team Applications link
    Then  the player should be on the Team Application page
    When  the player selects the team "The Ballers" from the dropdown menu
    And   the player clicks on the Submit button
    Then  an alert should appear saying "Team Application Successful"
    When  the player accepts the alert
    Then  the application status for the team "The Ballers" should say "pending"