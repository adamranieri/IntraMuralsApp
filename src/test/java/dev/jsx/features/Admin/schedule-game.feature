Feature: Admin schedules a game series

  Background:
    Given The user is logged in as admin
    Given The user is on homepage

    Scenario: Admin schedules a game for basketball
      When The user clicks on Schedule game
      Then The user is on Game Scheduling Form
      When User selects a venue
      When User selects a time and date
      When User selects a season basketball
      When User selects Sport as "basketball"
      When User selects a Home Team
      When User selects an Away Team
      And User clicks schedule button
      Then The admin has scheduled a game

