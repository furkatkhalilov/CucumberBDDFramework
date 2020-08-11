Feature: Full Document Types feature test

  Scenario: Successful Document Type creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "document types" screen
    Given I click on following elements
      | createButton     |
#      | stageButton      |
#      | dialogBoxHeader  |
#      | requiredCheckbox |
#    Given I enter text to following elements
#      | name | Brazilia document1      |
#      | desc | Brazilia document1 desc |
#    Given I click on following elements
#      | saveButton |