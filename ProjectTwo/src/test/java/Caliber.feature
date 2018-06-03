Feature: Testing the hyperlinks for revature

  Background: 
    Given a user opens a webbrowser
    And navigates to caliber

  Scenario Outline: 
    When user arrives at "<startPage>"
    And user clicks "<hyperlink>"
    Then user should be at "<endPage>"

    Examples: 
      | startPage | hyperlink | endPage |
      | home      | manage    | manage  |
      | home      | home      | home    |
      | home      | report    | report  |
      | home      | assess    | assess  |
   #   | manage    | manage    | manage  |
   #   | manage    | home      | home    |
   #   | manage    | report    | report  |
   #   | manage    | assess    | assess  |
   #   | home      | manage    | manage  |
    #  | assess    | home      | home    |
   #   | assess    | report    | report  |
    #  | assess    | assess    | assess  |
    #  | home      | manage    | manage  |
    # | report    | home      | home    |
    #  | report    | report    | report  |
    #  | report    | assess    | assess  |

  
