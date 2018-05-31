Feature: Testing deletion of elements

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user deletes batch "<pk>"
    Then batch should be delete "<pk>"

    Examples: 
      | pk  |
      | 182 |
