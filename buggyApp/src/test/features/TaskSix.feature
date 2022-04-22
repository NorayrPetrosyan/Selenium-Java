@test
@taskSix
Feature: Loging in and downloading the file
  Background:
    When I click on Task six button

  Scenario: Login with valid data
    Given Task six page is opened
    When I type tester in login field
    And I type 123-xyz in password field
    And I click on login button
    Then I am logged in

  Scenario: Log out
    Given Task six page is opened
    When I type tester in login field
    And I type 123-xyz in password field
    And I click on login button
    And I click on logout button
    Then I am logged out

  Scenario: Login with invalid data
    Given Task six page is opened
    When I type login in login field
    And I type password in password field
    And I click on login button
    Then invalid login message is visible
    And I am not logged in

  Scenario: Login with no data
    Given Task six page is opened
    When I click on login button
    Then I am not logged in

  Scenario: Download the file
    Given Task six page is opened
    When I type tester in login field
    And I type 123-xyz in password field
    And I click on login button
    And I click on download button
    Then The file is downloaded