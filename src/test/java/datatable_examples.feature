Feature: This is datatable feature
  @RegressionTest
  Scenario: Lists Scenario
    Given I printout to console using datable
    | data11 |  data12 | data13 |   data11 |
    | data21 |  data22 | data23 |  data11 |
    | data21 |  data22 | data23 |  data11 |
    | data21 |  data22 | data23 |  data11 |
    | data21 |  data22 | data23 |  data11 |
  @RegressionTest
  Scenario: Maps Scenario
    Given I printout to console using datable list of maps
      | field1 |  field2 | field3 | field4 |
      | data11 |  data12 | data13 | data11 |
      | data21 |  data22 | data23 | data11 |
  @SmokeTest
  Scenario: Map Scenario
    Given I printout to console using datable map only
      | field1 |  data11 |
      | field2 |  data12 |
      | field3 |  data13 |
      | field4 |  data13 |
      | field5 |  data13 |
      | field6 |  data13 |
      | field7 |  data13 |