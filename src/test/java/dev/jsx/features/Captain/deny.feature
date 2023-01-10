Feature: The Captain can deny player request to join team

  Background:
    Given The player logged in is a captain
    Given The player is on home page

  Scenario: The Captain can deny a player
    Given The player is on Approve/Deny Team Requests Page
    When The player clicks on deny button
    Then An alert appears saying the player has been denied
    When The player clicks on alert
    Then The alert confirmation disappears and the captain sees the request status
