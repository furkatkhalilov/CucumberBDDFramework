Feature: Full citizenship feature test

  Scenario: Successful citizenship creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "citizenship" screen
    And "Brazilia" entity doesn't exist in table
    When I create "Brazilia" citizenship
    Then "Citizenship" is successfully "created"

  Scenario: Successful citizenship edit in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "citizenship" screen
    And "Almania" entity doesn't exist in table
    When I edit  "Brazilia" to "Almania" citizenship
    Then "Citizenship" is successfully "updated"

  Scenario: Successful citizenship deletion in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "citizenship" screen
    When I delete "Almania" citizenship
    Then "Citizenship" is successfully "deleted"
    Then table doesn't contain the entity by name "Almania"