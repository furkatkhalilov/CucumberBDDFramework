Feature: Login feature test
  @SmokeTest
  Scenario: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
