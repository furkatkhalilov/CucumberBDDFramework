Feature: Full nationality feature test

  Background:
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "nationality" screen

  Scenario: Successful nationality creating in basqar
    And "Brazilia nationality1" entity doesn't exist in table
    When I create table entity with following arbitrary fields
      | name     | Brazilia nationality1 |
    Then "Nationality" is successfully "created"

  Scenario: Successful nationality edit in basqar
    And "Alamania nationality1" entity doesn't exist in table
    When I search table entity with following arbitrary fields
      | name     | Brazilia nationality1 |
    When I edit first table entity with following arbitrary fields
      | name     | Alamania nationality1 |
    Then "Nationality" is successfully "updated"

  Scenario: Successful nationality deletion in basqar
    When I search table entity with following arbitrary fields
      | name     | Alamania nationality1 |
    When I delete first table entity
    Then "Nationality" is successfully "deleted"
    Then table doesn't contain the entity by name "Alamania nationality1"