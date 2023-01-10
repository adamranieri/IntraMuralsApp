Feature: user can see details of games schedules
  Scenario Outline: user views games schedules
    Given the user logs in using "<username>" and "<password>"
    And   the user is on the homepage
    When  the user clicks on "Games"
    Then  the user should see details of game schedules

    Examples:
      | username    | password    |
      | gatorFan99  | chomp!!     |
      | mandy101    | pass123     |
      | Bobby202    | pass123     |
      | eegdell0    | DyAU3y5hLA  |