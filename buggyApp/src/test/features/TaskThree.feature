@test
@taskThree
Feature: Editing the form

  Scenario: Make form editable
    Given User is on Task Three page
    When User makes form editable
    Then The form input fields are enabled

  Scenario: Upload a new photo
    Given User is on Task Three page
    When User makes form editable
    And User uploads a photo
    Then The photo is updated

  Scenario: Upload a wrong formatted file
    Given User is on Task Three page
    When User makes form editable
    And User uploads a wrong formatted file
    Then Alert with 'Zły format pliku!' text is displayed
    And The photo is not changed

  Scenario: Fill form with valid data
    Given User is on Task Three page
    When User makes form editable
    And User fills form with valid data
    And User uploads a photo
    And User clicks on 'Save' button
    Then A message about successful registration is displayed
    And The form input fields are disabled

  Scenario: Fill form with no data
    Given User is on Task Three page
    When User makes form editable
    And User fills form with no data
    And User clicks on 'Save' button
    Then 'Save' button is disabled