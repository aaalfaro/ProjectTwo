Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber



  Scenario: a user adds a week
  	When a user clicks the add week button
  	Then a week should be added