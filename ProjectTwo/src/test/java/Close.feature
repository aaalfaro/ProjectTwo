Feature: Testing the buttons that close menus

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber
  Scenario Outline: 
    When user clicks "<button>"
    And user closes "<closeButton>"
    Then the "<window>" should be close

    Examples: 
      | button        | closeButton   | window        |
      | viewTrainees  | active        | active        |
      | viewTrainees  | viewTrainees  | viewTrainees  |
      | importBatch   | importBatch   | importBatch   |
      | updateBatch   | updateBatch   | updateBatch   |
      | updateTrainee | updateTrainee | updateTrainee |
      | deleteBatch   | deleteBatch   | deleteBatch   |
      | createBatch   | createBatch   | createBatch   |
      | createAssess  | createAssess  | createAssess  |
      | createWeek    | createWeek    | createWeek    |
      | techSkills    | techSkills    | techSkills    |