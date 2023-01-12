Feature: Captain can filter which player will make it onto their team

  Background:
  Given The player logged in is a captain
  Given The player is on home page

  Scenario: View list of players requesting to join team
    Given The player is on Approve or Deny Team Requests Page
    When The player can click on See The Player
    Then The player can view details on a player
    When The player clicks on close button
    Then The details of player disappears
    When The player clicks back
    Then The player is back on the homepage

  Scenario: The Captain can approve of player
    Given The player is on Approve or Deny Team Requests Page
    When The player clicks on approve
    Then An alert appears saying it has been approve button
    When The player clicks on alert
    Then The alert confirmation disappears and the captain sees the request status

