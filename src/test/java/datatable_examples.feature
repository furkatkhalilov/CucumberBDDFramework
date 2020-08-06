Feature: This is datatable feature
  Scenario: Lists Scenario
    Given I printout to console using datable
    | data11 |  data12 | data13 |
    | data21 |  data22 | data23 |
  Scenario: Maps Scenario
    Given I printout to console using datable map
      | column1 |  column2 | column3 |
      | data11 |  data12 | data13 |
      | data21 |  data22 | data23 |