Feature: Testing the updating and edit options of Caliber

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: updating a batch
    When a user updates batch "<oldPk>" with "<newPk>"
    Then then batch"<oldPk>" should be changed

    Examples: 
      | oldPk | newPk |
      |   182 |   189 |

  Scenario Outline: updating a trainee
    When a user updates trainee "<oldPk>" with "<newPk>"
    Then then trainee"<oldPk>" should be changed

    Examples: 
      | oldPk | newPk |
      |   183 |   129 |

  Scenario Outline: updating an Assessment
    When a user updates assessment"<oldPk>" with "<newPk>"
    Then then assessment "<oldPk>" should be changed

    Examples: 
      | oldPk | newPk |
      |   181 |   144 |
