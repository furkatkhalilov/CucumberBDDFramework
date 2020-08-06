Feature: This is datatable feature
  Scenario: Lists Scenario
    Given I printout to console using datable
    | data11 |  data12 | data13 |
    | data21 |  data22 | data23 |

  Scenario: Maps Scenario
    Given I printout to console using datable list of maps
      | field1 |  field1 | field1 |
      | data11 |  data12 | data13 |
      | data21 |  data22 | data23 |

  Scenario: Map Scenario
    Given I printout to console using datable map only
      | field1 |  data11 |
      | field2 |  data12 |
      | field3 |  data13 |