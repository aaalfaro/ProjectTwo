Feature: Testing insertion of elements on the manage batch page

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: inserting new batch
    When user clicks "<button>"
    And user input "<name>" from "<nameLocation>"
    And user selects "<Trainingtype>" from "<Trainingtypes>"
    And user selects "<Skilltype>" from "<Skilltypes>"
    And user selects "<Location>" from "<Locations>"
    And user selects "<Trainer>" from "<Trainers>"
    And user input "<startDate>" from "<startDateLocation>"
    And user input "<EndDate>" from "<endDateLocation>"
    And user input "<GoodGrade>" from "<goodGradeLocation>"
    And user input "<PassingGrade>" from "<passingGradeLocation>"
    And user clicks "<submit>"
    Then new assessment should be created

    Examples: 
      | button      | name | nameLocation | Trainingtype | Trainingtypes | Skilltype | Skilltypes | Location                                                           | Locations | Trainer | Trainers | startDate | startDateLocation | EndDate  | endDateLocation | GoodGrade | goodGradeLocation | PassingGrade | passingGradeLocation | submit         |
      | createBatch | Name | name         | Revature     | training      | J2EE      | skill      | Revature LLC, 11730 Plaza America Drive, 2nd Floor Reston VA 20190 | VA        | Name    | trainer  |  05272017 | startDate         | 07272017 | endDate         |        62 | goodGrade         |           55 | passingGrade         | subCreateBatch |
