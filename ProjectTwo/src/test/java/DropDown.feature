Feature: Testing the drop down setting through out caliber

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: adding a new assessment
    When user clicks "<button>"
    And user selects "<choice>" from "<dropDown>"
    Then "<option>" should be displayed

    Examples: 
      | button | choice              | dropDown      | option        |
      | manage |                2016 | manageYear    | manageYear    |
      | assess |                2016 | assessYear    | assessYear    |
      | assess | Ankit Garg - 6/9/21 | assessTrainer | assessTrainer |
      | report |                2016 | reportYear    | reportYear    |
      | report | Ankit Garg - 6/9/21 | reportTrainer | reportTrainer |
      | report | Week 1              | reportWeek    | reportWeek    |
      | report | All                 | reportTrainee | reportTrainee |
      | report | Charts              | reportPdf     | reportPdf     |
