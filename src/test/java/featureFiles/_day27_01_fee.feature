Feature: Full fee feature test

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I create fee with name "Brazilia fee", code "fee1", integration code "code1" and priority "17"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee edit in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And "Almania fee" entity doesn't exist in table
    When I edit  "Brazilia fee" to "Almania fee" fee
    Then "Fee Type" is successfully "updated"

#  Scenario: Successful fee deletion in basqar
#    Given I navigate to basqar
#    When I try to login using username and password
#    Then I am logged in
#    Given I navigate to "fee" screen
#    When I delete "Almania" fee
#    Then "Fee Type" is successfully "deleted"
#    #TODO: Then list doesn't contain the fee that we deleted