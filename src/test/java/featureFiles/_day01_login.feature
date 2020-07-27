Feature: Login feature test
  Scenario: Login in to basqar
    Given I navigate to basqar
    When I enter username and password
    When I click on login
    Then I am logged in
