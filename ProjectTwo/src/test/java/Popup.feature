Feature: Testing the buttons that bring up menus

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user clicks "<button>"
    Then the "<popUp>" should occur

    Examples: 
      | button        | popUp         |
      | viewTrainees  | viewTrainees  |
      | deleteBatch   | deleteBatch   |
      | addTrainee    | addTrainee    |
      | importBatch   | importBatch   |
      | createAssess  | createAssess  |
      | createWeek    | createWeek    |
      | save          | save          |


