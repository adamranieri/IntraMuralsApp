Feature: referee can choose an upcoming game to unofficiate
  Scenario: referee chooses an invalid upcoming game to unofficiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters an invalid game ID into the Game ID input to remove themself from a game
    And   the referee clicks on the Submit button to remove themself from a game
    Then  the referee should see an alert appear saying "Removal Unsuccessful"

  Scenario: referee enters a floating point number as a game id for an upcoming game to unofficiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters a floating point number into the Game ID input to remove themself from a game
    And   the referee clicks on the Submit button to remove themself from a game
    Then  the referee should not see an alert

  Scenario: referee enters nothing as a game id for an upcoming game to unofficiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters nothing into the Game ID input to to remove themself from a game
    And   the referee clicks on the Submit button to remove themself from a game
    Then  the referee should not see an alert