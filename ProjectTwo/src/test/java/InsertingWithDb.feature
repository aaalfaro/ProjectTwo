Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: inserting a new Assessment
    When a user inserts an assessment "<pk>"
    Then a new assessment should be made

    Examples: 
      | pk  |
      | 181 |

  Scenario Outline: inserting a new Batch
    When a user inserts a batch "<pk>"
    Then a new batch should be made

    Examples: 
      | pk  |
      | 182 |

  Scenario Outline: inserting a new Trainee
    When a user inserts a trainee "<pk>"
    Then a new trainee should be made

    Examples: 
      | pk  |
      | 183 |

  Scenario: inserting a new week
    When a user clicks the add week button
    Then a week should be added
