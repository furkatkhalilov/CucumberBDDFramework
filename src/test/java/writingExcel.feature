Feature: This is excel feature reading from data.xlsx
  Scenario: List Scenario
    Given I write to excel following data
      |  data11 |
      |  data12 |
      |  data13 |
      |  data13 |

  Scenario: Map Scenario
    Given I printout to console from excel using map only
#      | field1 |  data11 |
#      | field2 |  data12 |
#      | field3 |  data13 |
#      | field4 |  data13 |

  Scenario: Lists Scenario
    Given I printout to console from excel using list of lists
#      | data11 |  data12 | data13 |   data11 |
#      | data21 |  data22 | data23 |  data11 |
#      | data21 |  data22 | data23 |  data11 |

  Scenario: Maps Scenario
    Given I printout to console from excel using list of maps
#      | field1 |  field2 | field3 | field4 |
#      | data11 |  data12 | data13 | data11 |
#      | data21 |  data22 | data23 | data11 |
