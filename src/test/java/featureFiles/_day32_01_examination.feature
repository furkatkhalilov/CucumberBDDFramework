@AllDocumentTypeScenarios
Feature: Full Exam feature test

  Background:
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to
      | Entrance Exams 1 | Setup 2 | Entrance Exams 2 |

  Scenario: Successful Exam creating in basqar
    Given I click on following elements
      | createButton |
    Given I enter text to following elements
      | name | Brazilia document1 |
    Given I click on following elements
      | academicPeriodSelect |
      | Option1              |
      | gradeLevelSelect     |
      | Option2              |
    Given I click on following elements
      | saveButton |
    Then "Exam" is successfully "created"

#  @EditAndDelete
#  Scenario: Successful Exam editing in basqar
#    When I search table entity with following arbitrary fields
#      | name | Brazilia document1 |
#    Given I click on following elements
#      | editButton             |
#      | attachmentStagesSelect |
#      | Option1                |
#    And I press TAB Key
#    Given I click on following elements
#      | useCameraToggle |
#    Given I enter text to following elements
#      | name        | Almania document1      |
#      | description | Almania document1 desc |
#    Given I click on following elements
#      | saveButton |
#    Then "Document" is successfully "updated"
#
#  @EditAndDelete
#  Scenario: Successful Exam deletion in basqar
#    When I search table entity with following arbitrary fields
#      | name | Almania document1 |
#    When I delete first table entity
#    Then "Document" is successfully "deleted"
#    Then table doesn't contain the entity by name "Almania document1"