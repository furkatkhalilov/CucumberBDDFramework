Feature: Full fee feature test

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Brazilia fee1" entity doesn't exist in table
    When I create fee following fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | intCode  | code1         |
      | priority | 17            |
    Then "Fee Type" is successfully "created"


  Scenario: Successful fee creating in basqar using arbitrary fields
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Brazilia fee1" entity doesn't exist in table
    When I create fee following arbitrary fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | priority | 17            |
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar with data
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Brazilia fee1" entity doesn't exist in table
    When I try to fill in fee with following data
      | name          | code | intCode | priority | errorIn   |
      |               | fee1 | code1   | 17       | name     |
      | Brazilia fee2 |      | code2   | 18       | code     |
      | Brazilia fee3 | fee3 |         | 19       |          |
      | Brazilia fee4 | fee4 | code4   |          | priority |
#    Then "Fee Type" is successfully "created"


#  Scenario: Successful fee edit in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to "fee" screen
#    And "Alamania fee1" entity doesn't exist in table
#    When I edit  "Brazilia fee1" to "Alamania fee1" fee
#    Then "Fee Type" is successfully "updated"
#
#  Scenario: Successful fee deletion in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to "fee" screen
#    When I delete "Alamania fee1" fee
#    Then "Fee Type" is successfully "deleted"
#    Then table doesn't contain the entity by name "Alamania fee1"