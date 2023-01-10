Feature: referee can choose an upcoming game to officiate
  Scenario: referee chooses upcoming game to officiate
    Given the referee is logged in
    And   the referee is on the home page
    When  the referee clicks on the Edit Officiating Choice link
    Then  the referee should be on the Officiating Choice page
    When  the referee enters an existing game ID into the Game ID input
    And   the referee clicks on the Submit button
    Then  an alert should appear saying "Application Successful!"