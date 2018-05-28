Feature: Testing insertion of elements on the assess batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: inserting a new assessment
    When a user inserts an assessment "<pk>"
    Then a new assessment should be made

    Examples: 
      | pk  |
      | 141 |
      | 142 |
      | 143 |
      | 144 |
      | 145 |
      | 146 |
      | 147 |
      | 148 |
      | 149 |
      | 150 |
      | 151 |
      | 152 |
      | 153 |
      | 154 |
      | 155 |
      | 156 |
      | 157 |
      | 158 |
      | 159 |
      | 160 |
      | 161 |
      | 162 |
      | 163 |
      | 164 |
      | 165 |
      | 166 |
      | 167 |
      | 168 |
