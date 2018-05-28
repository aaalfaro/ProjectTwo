Feature: Testing the drop down setting through out caliber

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: adding a new assessment
    When user clicks "<button>"
    And user selects "<choice>" from "<dropDown>"
    Then "<option>" should be displayed

    Examples: 
      | button | choice                 | dropDown      | option        |
      | manage |                   2016 | manageYear    | manageYear    |
      | assess |                   2016 | assessYear    | assessYear    |
      | assess | Patrick Walsh - 9/8/18 | assessTrainer | assessTrainer |
      |	assess | Week 2									|	weekTab				|	weekTab				|
      | report |                   2016 | reportYear    | reportYear    |
      | report | Patrick Walsh - 9/8/18 | reportTrainer | reportTrainer |
      | report | Week 2                 | reportWeek    | reportWeek    |
      | report | All                    | reportTrainee | reportTrainee |
      | report | Charts                 | reportPdf     | reportPdf     |
      
