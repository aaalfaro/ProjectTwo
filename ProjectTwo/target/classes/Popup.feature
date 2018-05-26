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
      | updateBatch   | updateBatch   |
      | deleteBatch   | deleteBatch   |
      | addTrainee    | addTrainee    |
      | updateTrainee | updateTrainee |
      | importBatch   | importBatch   |
      | createAssess  | createAssess  |
      | createWeek    | createWeek    |
      | updateTrainee | updateTrainee |
      | updateAssess  | updateAssess  |
      | save          | save          |


