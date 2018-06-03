Feature: Testing deletion of elements

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user deletes trainee "<pk>"
    Then trainee "<pk>" should be gone

    Examples: 
      | pk  |
      | 129 |
      | 201 |
      | 183 |

  Scenario Outline: 
    When user deletes batch "<pk>"
    Then batch should be delete "<pk>"

    Examples: 
      | pk  |
      | 182 |
