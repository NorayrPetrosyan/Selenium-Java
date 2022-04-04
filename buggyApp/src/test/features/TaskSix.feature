@test
@taskSix
Feature: Loging in and downloading the file

  Scenario: Login with valid data
    Given User is on Task Six page
    When User types "tester" as login
    And User types "123-xyz" as password
    And User clicks 'Login' button
    Then User logs in

  Scenario: Log out
    Given User is on Task Six page
    And User is logged in
    When User logs out
    Then User is logged out

  Scenario: Login with invalid data
    Given User is on Task Six page
    When User types "login" as login
    And User types "password" as password
    And User clicks 'Login' button
    Then Error message is displayed
    And User is not logged in

  Scenario: Login with no data
    Given User is on Task Six page
    When User clicks 'Login' button
    Then User is not logged in

  Scenario: Download the file
    Given User is on Task Six page
    And User is logged in
    When User downloads the file
    Then The file is downloaded