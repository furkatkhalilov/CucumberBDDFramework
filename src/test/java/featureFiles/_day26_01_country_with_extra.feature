Feature: Full country feature test

  Scenario: Successful country creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    And "Brazilia" country doesn't exist
    When I create "Brazilia" country
    Then country is successfully created

  Scenario: Successful country edit in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    And "Almania" country doesn't exist
    When I edit  "Brazilia" to "Almania" country
    Then country is successfully edited

  Scenario: Successful country deletion in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    When I delete "Almania" country
    Then country is successfully deleted