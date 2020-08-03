Feature: Full citizenship feature test

  Scenario: Successful citizenship creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to citizenship screen
    And "Brazilia" citizenship doesn't exist
    When I create "Brazilia" citizenship
    Then citizenship is successfully created

#  Scenario: Successful citizenship edit in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to citizenship screen
#    And "Almania" citizenship doesn't exist
#    When I edit  "Brazilia" to "Almania" citizenship
#    Then citizenship is successfully edited
#
#  Scenario: Successful citizenship deletion in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to citizenship screen
#    When I delete "Almania" citizenship
#    Then citizenship is successfully deleted