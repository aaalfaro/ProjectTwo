Feature: Testing various features of the report page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: testing the select boxes on report page
    When user input "<search>" from "<searchBox>"
    Then the "<element>" should displayed

    Examples: 
      | search | searchBox   | element |
      | search | searchTextBox| search  |

  Scenario: testing all pdf buttons on report page
  	When user clicks a pdf button
  	Then a pdf should download