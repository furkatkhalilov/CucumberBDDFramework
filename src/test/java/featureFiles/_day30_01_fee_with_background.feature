Feature: Full fee feature test

  Background:
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen

  Scenario: Successful fee creating in basqar
    And "Brazilia fee1" entity doesn't exist in table
    When I create table entity with following arbitrary fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | intCode  | code1         |
      | priority | 17            |
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee edit in basqar
    And "Alamania fee1" entity doesn't exist in table
    When I search table entity with following arbitrary fields
      | name | Brazilia fee1 |
    When I edit first table entity with following arbitrary fields
      | name | Alamania fee1 |
      | code | fee2          |
    Then "Fee Type" is successfully "updated"

  Scenario: Successful fee deletion in basqar
    When I search table entity with following arbitrary fields
      | name     | Alamania nationality1 |
    When I delete first table entity
    Then "Fee Type" is successfully "deleted"
    Then table doesn't contain the entity by name "Alamania fee1"