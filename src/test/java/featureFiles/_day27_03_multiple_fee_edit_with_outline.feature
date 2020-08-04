Feature: Full fee feature test

 Scenario Outline: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "<screenName>" screen
    And "<name>" entity doesn't exist in table
    When I create fee with name "<name>", code "<code>", integration code "<intCode>" and priority "<priority>"
    Then "<entityName>" is successfully "<outcome>"

    Examples:
       | screenName | name | code | intCode | priority | entityName | outcome |
       | fee | Brazilia fee1 | fee1 | code1 | 11 | Fee Type | created |
       | fee | Brazilia fee2 | fee2 | code2 | 12 | Fee Type | created |
       | fee | Brazilia fee3 | fee3 | code3 | 13 | Fee Type | created |
       | fee | Brazilia fee4 | fee4 | code4 | 14 | Fee Type | created |

    # Task 2: use outline to edit several fee types
   Scenario Outline: Successful fee edit in basqar
      Given I navigate to basqar
      When I try to login using username and password
      Then I am logged in
      Given I navigate to "fee" screen
      And "<newName>" entity doesn't exist in table
      When I edit  "<oldName>" to "<newName>" fee
      Then "Fee Type" is successfully "updated"
      Examples:
         | newName | oldName  |
         | Alamania fee1 | Brazilia fee1|
         | Alamania fee2 | Brazilia fee2|
         | Alamania fee3 | Brazilia fee3|
         | Alamania fee4 | Brazilia fee4|