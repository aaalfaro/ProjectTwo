Feature: Testing insertion of elements on the manage batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: inserting a new Trainee in a batch
    When user clicks "<button>"
    And user input "<name>" from "<nameLocation>"
    And user input "<email>" from "<emailLocation>"
    And user input "<skype>" from "<skypeLocation>"
    And user input "<phone>" from "<phoneLocation>"
    And user input "<college>" from "<collegeLocation>"
    And user input "<degree>" from "<degreeLocation>"
    And user input "<major>" from "<majorLocation>"
    And user input "<recruitName>" from "<recruitLocation>"
    And user input "<techScreenName>" from "<techScreenLocation>"
    And user input "<completion>" from "<completionLocation>"
    And user input "<URL>" from "<URLLocation>"
    And user selects "<status>" from "<statusTypes>"
    Then new trainee should be created

    Examples: 
      | button     | name        | nameLocation | email          | emailLocation | skype  | skypeLocation | phone      | phoneLocation | college | collegeLocation | degree       | degreeLocation | major   | majorLocation | recruitName | recruitLocation | techScreenName | techScreenLocation | completion | completionLocation | URL             | URLLocation | status  | statusTypes |
      | addTrainee | New Trainee | traineeName  | fake@gmail.com | email         | FakeId | skype         | 1238906483 | phone         | Fake U  | college         | Fake Science | degree         | Alchemy | major         | Bob Ross    | recruit         | Bill Williams  | screen             |         45 | completion         | www.notAURL.com | url         | Dropped | status      |
