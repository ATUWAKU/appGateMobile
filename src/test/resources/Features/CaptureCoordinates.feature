Feature: As QA of the time zone mobile app I want to test the operation of the
        longitude and latitude data capture to guarantee the quality of the application

  @PermissionsGranted
  Scenario: Test that the capture of coordinates works when the access to the cell location has been granted
    When Request the coordinates
    Then The system displays latitude and longitude of the current location

#  @PermissionsNotGranted
#  Scenario: Test that the capture of coordinates does not work when the access to the cell location has not been granted
#    When Request the coordinates
#    Then The APP shows the error message "La APP no tiene permisos para acceder a la ubción del celuar"