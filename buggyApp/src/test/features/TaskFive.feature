@test
@taskFive
Feature: Uploading data to the application
  Background:
    When I click on Task five button

  Scenario: Upload a properly formatted file
    Given Task five page is opened
    When I upload properFile.csv from upload button in Task five page
    Then properFile.csv file is uploaded

  Scenario: Upload an improperly formatted file
    Given Task five page is opened
    When I upload wrongFileFormat.xlsx from upload button in Task five page
    Then Alert with Zły format pliku text is displayed
    And wrongFileFormat.xlsx file is not uploaded

  Scenario: Upload a wrong formatted file
    Given Task five page is opened
    When I upload wrongFormattedFile.csv from upload button in Task five page
    Then Alert with Źle sformatowany plik. text is displayed
    And wrongFormattedFile.csv file is not uploaded

  Scenario: Upload a file with wrong formatted tel. numbers
    Given Task five page is opened
    When I upload wrongTelNumber.txt from upload button in Task five page
    Then Alert with Numer telefonu może zawierać tylko znaki numeryczne, musi mieć 9 znaków. text is displayed
    And wrongTelNumber.txt file is not uploaded

  Scenario: Upload a file that contains more than 20 lines
    Given Task five page is opened
    When I upload moreThan20Lines.txt from upload button in Task five page
    Then Alert with Maksymalnie wprowadzić można 20 wierszy. text is displayed
    And moreThan20Lines.txt file is not uploaded
