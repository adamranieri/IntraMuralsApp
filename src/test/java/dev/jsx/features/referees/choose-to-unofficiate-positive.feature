Feature: referee can choose an upcoming game to unofficiate
  Scenario: referee chooses upcoming game to unofficiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters an existing game ID into the Game ID input to remove themself from a game
    And   the referee clicks on the Submit button to remove themself from a game
    Then  the referee should see an alert appear saying "Removal Successful!"
    When  the referee clicks on the Back link from the Officiating Choice page
    Then  the referee should be on the home page
    When  the referee clicks on the Officiate Games link
    Then  the referee should be on the Officiate Games page
    And   the referee should not see the game ID of the game they removed