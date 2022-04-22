@test
@taskFour
Feature: Completing the form in a separate window
  Background:
    When I click on Task four button

  Scenario: Open application form
    Given Task four page is opened
    When I scroll down
    And I click on apply button
    And I switch to the opened form
    Then The application form is  opened

  Scenario: Fill form with valid data
    Given Task four page is opened
    When I scroll down
    And I click on apply button
    And I switch to the opened form
    And I type name in name field
    And I type valid email in email field
    And I type valid tel. number in tel. number field
    And I click on save button
    Then A message about successful application is displayed

  Scenario: Type an invalid name
    Given Task four page is opened
    When I scroll down
    And I click on apply button
    And I switch to the opened form
    And I type  in name field
    And I type valid email in email field
    And I type valid tel. number in tel. number field
    And I click on save button
    Then A message with Brak imienia i nazwiska text is displayed

  Scenario Outline: Type an invalid email
    Given Task four page is opened
    When I scroll down
    And I click on apply button
    And I switch to the opened form
    And I type name in name field
    And I type <invalid email> in email field
    And I type valid tel. number in tel. number field
    And I click on save button
    Then A message with Nieprawidłowy email text is displayed

    Examples:
      | invalid email       |
      | test2022@gmailcom   |
      | test2022@gmail.     |
      | test2022gmail.com   |
      | test2022@gmail..com |
      | test2022@           |
      | test2022            |

  Scenario Outline: Type an invalid tel. number
    Given Task four page is opened
    When I scroll down
    And I click on apply button
    And I switch to the opened form
    And I type name in name field
    And I type valid email in email field
    And I type <invalid telNumber> in tel. number field
    And I click on save button
    Then A message with Zły format telefonu - prawidłowy: 600-100-200 text is displayed

    Examples:
      | invalid telNumber |
      | 123456789         |
      | 123-456789        |
      | 123456-789        |
      | 123-456-789-101   |
      | test2022          |

