Feature: Full Document Types feature test

  Background:
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "document types" screen

  Scenario: Successful Document Type creating in basqar
    Given I click on following elements
      | createButton           |
      | attachmentStagesSelect |
      | Option2                |
    And I press TAB Key
    Given I click on following elements
      | useCameraToggle |
    Given I enter text to following elements
      | name        | Brazilia document1      |
      | description | Brazilia document1 desc |
    Given I click on following elements
      | saveButton |
    Then "Document Type" is successfully "created"

  Scenario: Successful Document Type editing in basqar
    When I search table entity with following arbitrary fields
      | name     | Brazilia document1 |
    Given I click on following elements
      | editButton           |
      | attachmentStagesSelect |
      | Option1                |
    And I press TAB Key
    Given I click on following elements
      | useCameraToggle |
    Given I enter text to following elements
      | name        | Almania document1      |
      | description | Almania document1 desc |
    Given I click on following elements
      | saveButton |
    Then "Document Type" is successfully "updated"
