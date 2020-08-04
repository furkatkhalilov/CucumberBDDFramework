Feature: Full fee feature test

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Brazilia fee1" entity doesn't exist in table
    When I create fee with name "Brazilia fee1", code "fee1", integration code "code1" and priority "17"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee edit in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Alamania fee1" entity doesn't exist in table
    When I edit  "Brazilia fee1" to "Alamania fee1" fee
    Then "Fee Type" is successfully "updated"

  Scenario: Successful fee deletion in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I delete "Alamania fee1" fee
    Then "Fee Type" is successfully "deleted"
    #TODO: Then list doesn't contain the fee that we deleted