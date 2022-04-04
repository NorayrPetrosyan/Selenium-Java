@test
@taskFour
Feature: Completing the form in a separate window

  Scenario: Open application form
    Given User is on Task Four page
    When User clicks on 'Apply' button
    Then The application form is opened

  Scenario: Fill form with valid data
    Given User is on Task Four page
    When User clicks on 'Apply' button
    And User types 'Alan' as name
    And User types 'test2022@gmail.com' as email
    And User types '123-456-789' as tel. number
    And User clicks 'Save' button
    Then A message about successful application is displayed

  Scenario: Type an invalid name
    Given User is on Task Four page
    When User clicks on 'Apply' button
    And User types ' ' as name
    And User types 'test2022@gmail.com' as email
    And User types '123-456-789' as tel. number
    And User clicks 'Save' button
    Then A message with 'Brak imienia i nazwiska' text, about invalid name is displayed

  Scenario Outline: Type an invalid email
    Given User is on Task Four page
    When User clicks on 'Apply' button
    And User types 'Alan' as name
    And User types '<emails>' as email
    And User types '123-456-789' as tel. number
    And User clicks 'Save' button
    Then A message with 'Nieprawidłowy email' text, about invalid email is displayed

    Examples:
      | emails              |
      | test2022@gmailcom   |
      | test2022@gmail.     |
      | test2022gmail.com   |
      | test2022@gmail..com |
      | test2022@           |
      | test2022            |

  Scenario Outline: Type an invalid tel. number
    Given User is on Task Four page
    When User clicks on 'Apply' button
    And User types 'Alan' as name
    And User types 'test2022@gmail.com' as email
    And User types '<telNumbers>' as tel. number
    And User clicks 'Save' button
    Then A message with 'Zły format telefonu - prawidłowy: 600-100-200' text, about invalid tel. number is displayed

    Examples:
      | telNumbers      |
      | 123456789       |
      | 123-456789      |
      | 123456-789      |
      | 123-456-789-101 |
      | test2022        |

