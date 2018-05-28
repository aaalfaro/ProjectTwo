Feature: Testing the updating and edit options of Caliber



  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

Scenario Outline: adding a new assessment
    When user selects "<button>" from "<buttons>"
    And user selects "<category>" from "<categories>"
    And user input "<point>" from "<points>"
    And user selects "<type>" from "<types>"
    And user clicks "<submit>"
    Then new assessment should be created

    Examples: 
      | button | buttons      | category | categories | point | points | type    | types | submit   |
      |      3 | updateAssess | CSS      | updateCategory |    21 | updatePoint  | Project | updateType  | upAssess |

Scenario Outline: inserting a new  batch
    When user selects "<button>" from "<buttonType>"
    And user input "<name>" from "<nameLocation>"
    And user selects "<training>" from "<trainingType>"
    And user selects "<skill>" from "<skillType>"
    And user selects "<location>" from "<locationType>"
    And user selects "<trainer>" from "<trainerType>"
    And user input "<startDate>" from "<startDateLocation>"
    And user input "<endDate>" from "<endDateLocation>"
    And user input "<goodGrade>" from "<goodGradeLocation>"
    And user input "<passingGrade>" from "<passingGradeLocation>"
    And user clicks "<subBatch>"
    Then new trainee should be created

    Examples: 
      | button | buttonType  | name | nameLocation | training | trainingType | skill | skillType | location                                                           | locationType | trainer | trainerType | startDate | startDateLocation | endDate  | endDateLocation | goodGrade | goodGradeLocation | passingGrade | passingGradeLocation | subBatch |
      |      0 | updateBatch | Name | name         | Other    | training     | JTA   | skill     | Revature LLC, 11730 Plaza America Drive, 2nd Floor Reston VA 20190 | VA           | Name    | trainer     |  04202016 | startDate         | 05272016 | endDate         |        90 | goodGrade         |           45 | passingGrade         | subBatch |


  Scenario Outline: updating a new Trainee in a batch
    When user selects "<viewButton>" from "<viewButtonType>"
    When user selects "<button>" from "<buttonType>"
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
      | viewButton | viewButtonType | button | buttonType | name        | nameLocation | email          | emailLocation | skype  | skypeLocation | phone      | phoneLocation | college | collegeLocation | degree       | degreeLocation | major   | majorLocation | recruitName | recruitLocation | techScreenName | techScreenLocation | completion | completionLocation | URL             | URLLocation | status  | statusTypes |
      |          2 | viewBatch      |      1 | upTrainee  | New Trainee | traineeName  | fake@gmail.com | email         | FakeId | skype         | 1238906483 | phone         | Fake U  | college         | Fake Science | degree         | Alchemy | major         | Bob Ross    | recruit         | Bill Williams  | screen             |         45 | completion         | www.notAURL.com | url         | Dropped | status      |
