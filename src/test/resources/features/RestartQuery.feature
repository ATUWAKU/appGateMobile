Feature: As WHAT I want to test the restart of the APP to verify its functionality is correctly built

  Scenario: Validate time zone query reset
    Given Request the coordinates
    And Consult the time zone information
    When Reboot the system
    Then The system returns and changes its state to consult coordinates