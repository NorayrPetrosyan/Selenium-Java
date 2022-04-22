@test
@taskThree
Feature: Editing the form
  Background:
    When I click on Task three button

  Scenario: Make form editable
    Given Task three page is opened
    When I make the form editable
    Then The form input fields are enabled

  Scenario: Upload a new photo
    Given Task three page is opened
    When I make the form editable
    And I upload image.png from upload button in Task three page
    Then The photo is updated

  Scenario: Upload a wrong formatted file
    Given Task three page is opened
    When I make the form editable
    And I upload wrongFileFormat.xlsx from upload button in Task three page
    Then Alert with Zły format pliku! text is displayed
    And The photo is not changed

  Scenario: Fill form with valid data
    Given Task three page is opened
    When I make the form editable
    And I type name in first name field
    And I type surname in surname field
    And I type something in notes field
    And I type phone number in phone number field
    And I upload image.png from upload button in Task three page
    And I click on save button
    Then successful registration message is visible
    And The form input fields are disabled

  Scenario: Fill form with no data
    Given Task three page is opened
    When I make the form editable
    And I fill the form with no data
    And I click on save button
    Then Save button is disabled