Feature: view team captains
  Scenario Outline: the player views team captains
    Given the player is logged in
    And   the player is on the homepage
    When  the player clicks on the Team Applications link
    Then  the player is on the Team Application page
    When  the player clicks on the See The Captain button for the team "<team_name>"
    Then  a section should appear with information about the team captain for "<team_name>"
    And

    Examples:
    | team_name           |
    | Grand Dunk Railroad |
    | The Ballers         |
    | The Splash          |