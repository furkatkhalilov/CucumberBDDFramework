Feature: Full fee feature test

 Scenario Outline: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "<screenName>" screen
    When I create fee with name "<name>", code "<code>", integration code "<intCode>" and priority "<priority>"
    Then "<entityName>" is successfully "<outcome>"

    Examples:
       | screenName | name | code | intCode | priority | entityName | outcome |
       | fee | Brazilia fee1 | fee1 | code1 | 11 | Fee Type | created |
       | fee | Brazilia fee2 | fee2 | code2 | 12 | Fee Type | created |
       | fee | Brazilia fee3 | fee3 | code3 | 13 | Fee Type | created |
       | fee | Brazilia fee4 | fee4 | code4 | 14 | Fee Type | created |