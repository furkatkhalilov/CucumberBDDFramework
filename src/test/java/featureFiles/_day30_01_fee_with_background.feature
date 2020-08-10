Feature: Full fee feature test

  Background:
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen

  Scenario: Successful fee creating in basqar
    And "Brazilia fee1" entity doesn't exist in table
    When I create fee with name "Brazilia fee1", code "fee1", integration code "code1" and priority "17"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee edit in basqar
    And "Alamania fee1" entity doesn't exist in table
    When I edit  "Brazilia fee1" to "Alamania fee1" fee
    Then "Fee Type" is successfully "updated"

  Scenario: Successful fee deletion in basqar
    When I delete "Alamania fee1" fee
    Then "Fee Type" is successfully "deleted"
    Then table doesn't contain the entity by name "Alamania fee1"