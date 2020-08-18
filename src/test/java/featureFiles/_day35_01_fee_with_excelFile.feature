Feature: Full fee feature test

  Scenario: Successful fee creating in basqar using arbitrary fields with intCode
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I create fee with fields from excel sheet "scenario1" as a "map"
    Then "Fee Type" is successfully "created"


  Scenario: Successful fee creating in basqar using arbitrary fields without intCode
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I create fee with fields from excel sheet "scenario2" as a "map"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar with data
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I try to fill in fee with data from excel sheet "scenario3" as a "listMap"

