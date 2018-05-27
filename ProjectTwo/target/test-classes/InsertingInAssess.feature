Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user clicks "<button>"
    And user input "<points>"
    And user selects "<type>" from "<types>"
    And user clicks "<submit>"
    Then new assessment should be created

    Examples: 
      | button       | points | type    | submit    | types |
      | createAssess |     21 | Project | subAssess | type  |
