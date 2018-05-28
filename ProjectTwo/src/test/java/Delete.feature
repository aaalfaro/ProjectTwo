Feature: Testing deletion of elements

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user selects "<deleteButton>" from "<deleteButtonLocation>"
    Then the "<element>" should be gone

    Examples: 
      | deleteButton | deleteButtonLocation | element |
      | 1					   | deleteBatch          | batch   |
