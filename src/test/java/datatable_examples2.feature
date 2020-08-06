Feature: This is datatable feature in automationpractice

  Scenario: Lists Scenario for automationpractice
    Given I navigate to "http://automationpractice.com"
    When I Search for products I expect number of results to be:
      | product  | results |
      | dress    | 7       |
      | blouse   | 1       |
      | t-shirts | 1       |