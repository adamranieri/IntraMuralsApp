Feature: Captain can view the players on team

  Background:
    Given The player logged in is a captain
    Given The player is on home page

  Scenario: The Captain views the players on their team
  Given The player is on View Your Team page
  When The player clicks on see the player
  Then The player can view details on a player
  When The player clicks on close button
  Then The details of the player disappears
  When The player clicks back
  Then The player is back on the homepage







