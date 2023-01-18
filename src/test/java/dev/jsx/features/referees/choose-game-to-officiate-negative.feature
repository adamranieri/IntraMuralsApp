Feature: referee can choose an upcoming game to officiate
  Scenario: referee chooses an invalid id for an upcoming game to officiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters a non-existing game ID into the Game ID input to register for a a game
    And   the referee clicks on the Submit button to register for a game
    Then  the referee should see an alert appear saying "Application Unsuccessful"

  Scenario: referee enters a floating point number as a game id for an upcoming game to officiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters a floating point number into the Game ID input to register for a game
    And   the referee clicks on the Submit button to register for a game
    Then  the referee should not see an alert

  Scenario: referee enters nothing as a game id for an upcoming game to officiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters nothing into the Game ID input to register for a game
    And   the referee clicks on the Submit button to register for a game
    Then  the referee should not see an alert
