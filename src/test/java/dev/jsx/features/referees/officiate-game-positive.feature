Feature: referee can officiate games
  Scenario: referee enters scores for a game they have chosen to officiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Officiate Games link
    Then  the referee should be on the Officiate Games page
    When  the referee selects the Update Scores button for the first game in the list
    Then  the referee should see a section appear with inputs for the points and fouls in a game
    When  the referee clicks on each of the Add point buttons for the home team
    Then  the referee should see the home team's score to be six
    When  the referee clicks on each of the Add point buttons for the away team
    Then  the referee should see the away team's score to be six
    When  the referee clicks on the Add button to add a foul to the home team
    Then  the referee should see one foul in the home team input
    When  the referee clicks on the Add button to add a foul to the away team
    Then  the referee should see one foul in the away team input
    When  the referee clicks on the Save button
    Then  the referee should see an alert appear saying "Score update success!"
    When  the referee clicks on the Back Link from the Officiate Game page
    And   the referee clicks on the Games link
    Then  the referee should be on the Game Schedules page
    And   the user should see the new scores reflected for the edited game
