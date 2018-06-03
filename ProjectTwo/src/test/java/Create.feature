Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario: inserting a new week
    When a user clicks the add week button
    Then a week should be added

  Scenario Outline: inserting a new batch
    When a user inserts a batch "<pk>"
    Then a new batch "<pk>" should be made

    Examples: 
      | pk  |
      | 182 |

  Scenario Outline: inserting a new trainee
    When a user inserts a trainee "<pk>"
    Then a new trainee "<pk>" should be made

    Examples: 
      | pk  |
      | 129 |

  Scenario Outline: inserting a new Assessment
    When a user inserts an assessment "<pk>"
    Then a new assessment "<pk>" should be made

    Examples: 
      | pk  |
      | 181 |
      | 141 |
      | 142 |
      #| 143 |
      #| 144 |
      #| 145 |
      #| 146 |
      #| 147 |
      #| 148 |
      #| 149 |
      #| 150 |
