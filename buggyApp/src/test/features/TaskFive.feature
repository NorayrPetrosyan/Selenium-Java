@test
@taskFive
Feature: Uploading data to the application

  Scenario: Upload a properly formatted file
    Given User is on Task Five page
    When User uploads "properFile.csv" file
    Then "properFile.csv" file is uploaded

  Scenario: Upload an improperly formatted file
    Given User is on Task Five page
    When User uploads "wrongFileFormat.xlsx" file
    Then Alert with "Zły format pliku" text is displayed
    And "wrongFileFormat.xlsx" file is not uploaded

  Scenario: Upload a wrong formatted file
    Given User is on Task Five page
    When User uploads "wrongFormattedFile.csv" file
    Then Alert with "Źle sformatowany plik." text is displayed
    And "wrongFormattedFile.csv" file is not uploaded

  Scenario: Upload a file with wrong formatted tel. numbers
    Given User is on Task Five page
    When User uploads "wrongTelNumber.txt" file
    Then Alert with "Numer telefonu może zawierać tylko znaki numeryczne, musi mieć 9 znaków." text is displayed
    And "wrongTelNumber.txt" file is not uploaded

  Scenario: Upload a file that contains more than 20 lines
    Given User is on Task Five page
    When User uploads "moreThan20Lines.txt" file
    Then Alert with "Maksymalnie wprowadzić można 20 wierszy." text is displayed
    And "moreThan20Lines.txt" file is not uploaded
