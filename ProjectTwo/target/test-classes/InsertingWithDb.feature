Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber


Scenario Outline: inserting a new Trainee
    When a user inserts a trainee "<pk>"
    Then a new trainee should be made

    Examples: 
      | pk  |
      | 183 |

 