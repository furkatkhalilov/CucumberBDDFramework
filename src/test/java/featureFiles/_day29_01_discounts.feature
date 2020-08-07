Feature: Full discount feature test

  Scenario: Successful discount creating in basqar and delete it
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "discount" screen
    And search and delete "Brazilia discount1" entities by "description"
    When I create discount following arbitrary fields
      | description | Brazilia discount1 |
      | intCode     | discount Int code1 |
      | priority    | 17                 |
    Then "Discount" is successfully "created"
    And search and delete "Brazilia discount1" entities by "description"
    Then "Discount" is successfully "deleted" message is present

  Scenario Outline: Successful discount creating in basqar and deleting using scenario outline
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "discount" screen
    And search and delete "<description>" entities by "description"
    When I create discount following arbitrary fields
      | description | <description> |
      | intCode     | <intCode>     |
      | priority    | <priority>    |
    Then "Discount" is successfully "created"
    And search and delete "<description>" entities by "description"

    Examples:
      | description   | intCode | priority |
      | Brazilia fee1 | code1   | 11       |
      | Brazilia fee2 | code2   | 12       |
      | Brazilia fee3 | code3   | 13       |
      | Brazilia fee4 | code4   | 14       |

#  Scenario: Successful discount creating, editing and deleting in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to "discount" screen
#    And search and delete "Brazilia discount1" entities by "description"
#    When I create discount following arbitrary fields
#      | description | Brazilia discount1 |
#      | intCode     | discount Int code1 |
#      | priority    | 17                 |
#    Then "Discount" is successfully "created"
#    And "Alamania discount1" entity doesn't exist in table
#    When I edit  "Brazilia discount1" to "Alamania discount1" discount by "description"
#    Then "Discount" is successfully "updated"
#    And search and delete "Brazilia discount1" entities by "description"
#    Then "Discount" is successfully "deleted" message is present
