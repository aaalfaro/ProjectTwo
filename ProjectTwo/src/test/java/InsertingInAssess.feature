Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: adding a new assessment
    When user clicks "<button>"
    And user selects "<category>" from "<categories>"
    And user input "<point>" from "<points>"
    And user selects "<type>" from "<types>"
    And user clicks "<submit>"
    Then new assessment should be created

    Examples: 
      | button       | category | categories | point | points | type    | types | submit    |
      | createAssess | Java     | categories |    21 | point  | Project | type  | subAssess |

  Scenario Outline: adding a new week
    When user clicks "<button>"
    And user clicks "<submit>"
    Then new week should be created

    Examples: 
      | button     | submit  |
      | createWeek | subWeek |
