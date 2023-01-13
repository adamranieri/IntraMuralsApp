Feature: player can view team captains
  Scenario Outline: player views each team captain
    Given the player is logged in
    And   the player is on the home page
    When  the player clicks on the Team Applications link
    Then  the player should be on the Team Application page
    When  the player clicks on the See The Captain button for the team "<team name>"
    Then  a section should appear with information about the captain "<captain username>"

    Examples:
      | team name           | captain username  |
      | Grand Dunk Railroad | Bobby202          |
      | The Ballers         | Candice202        |
      | The Splash          | Jessika202        |