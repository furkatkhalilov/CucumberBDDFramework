Feature: Full Document Types feature test

  Scenario: Successful Document Type creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "document types" screen