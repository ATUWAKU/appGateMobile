Feature: As a software quality manager
          I want to test the time zone APP data query module
          to ensure the quality of the application


  Scenario: Consult the information of the time zone with the current coordinates of the cell phone
    Given Request the coordinates
    When Consult the time zone information
    Then The APP displays the information