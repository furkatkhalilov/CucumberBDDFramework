Feature: Full country feature test

  Scenario: Successful country creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    And "Brazilia" entity doesn't exist in table
    When I create "Brazilia" country
    Then "Country" is successfully "created"

  Scenario: Successful country edit in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    And "Almania" entity doesn't exist in table
    When I edit  "Brazilia" to "Almania" country
    Then "Country" is successfully "updated"

  Scenario: Successful country deletion in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "country" screen
    When I delete "Almania" country
    Then "Country" is successfully "deleted"
    #TODO: Then list doesn't contain the country that we deleted