Feature: Testing the updating and edit options of Caliber



  Background: 
    Given a user opens a webbrowser
    And navigates to caliber
    
Scenario Outline: updating a batch
When a user updates batch "<oldPk>" with "<newPk>"
Then then batch"<oldPk>" should be changed
Examples:
|oldPk|newPk|
|	182 | 189 |

