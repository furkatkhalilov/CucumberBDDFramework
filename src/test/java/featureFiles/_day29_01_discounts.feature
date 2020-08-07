Feature: Full discount feature test

  Scenario: Successful discount creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "discount" screen
    And "Brazilia discount1" entity doesn't exist in table by "description"
#    When I create discount following fields
#      | name     | Brazilia discount1 |
#      | code     | discount1          |
#      | intCode  | code1         |
#      | priority | 17            |
#    Then "Discount" is successfully "created"