Feature: Admin can demote a referee or admin as a player

  Background:
    Given The user is logged in as admin
    Given The user is on homepage

  Scenario: Admin demotes a player
    When User clicks on Manage User Roles
    Then User is on Manager View page
    When User clicks on Demote to Player
    Then The page updates and the player role is updated



