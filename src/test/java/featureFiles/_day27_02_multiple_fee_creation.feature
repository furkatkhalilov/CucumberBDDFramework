Feature: Full fee feature test

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I create fee with name "Brazilia fee1", code "fee1", integration code "code1" and priority "11"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I create fee with name "Brazilia fee2", code "fee2", integration code "code2" and priority "12"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I create fee with name "Brazilia fee3", code "fee3", integration code "code3" and priority "13"
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    When I create fee with name "Brazilia fee4", code "fee4", integration code "code4" and priority "14"
    Then "Fee Type" is successfully "created"