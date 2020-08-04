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


   # Task 4: use outline to delete several fee types
   Scenario Outline: Successful citizenship deletion in basqar
      Given I navigate to basqar
      When I try to login using username and password
      Then I am logged in
      Given I navigate to "fee" screen
      When I delete "<Name>" citizenship
      Then "Fee Type" is successfully "deleted"
    #TODO: Then list doesn't contain the citizenship that we deleted

      Examples:
         | Name |
         | Alamania fee1 |
         | Alamania fee2 |
