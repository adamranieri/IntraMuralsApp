Feature: Admin attempts to add a season

  Background:
    Given The user is logged in as admin
    Given The user is on homepage

  Scenario: The admin tries to add season without typing anything
    When The user clicks on Add Season
    Then The user is on Season Scheduler
    When User clicks on submit button
    Then User gets a popup of empty field in season name

