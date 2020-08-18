Feature: discount fee feature test
  Scenario: Successful discount creating in basqar with data
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "discount" screen
    And search and delete "Brazilia discount1" entities by "description"
    When I validate discount fields from excel sheet "validation_scenario" as a "listMap"