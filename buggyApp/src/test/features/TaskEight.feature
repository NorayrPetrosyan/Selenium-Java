@test
@taskEight
Feature: Payment by card
  Background:
    When I click on Task eight button

  Scenario: Pay with valid card
    Given Task eight page is opened
    When I select Visa from card type container
    And I type full name in full name field
    And I type valid card No in card No field
    And I type valid cvv code in cvv code field
    And I select April from month container
    And I select 2024 from year container
    And I scroll down
    And I click on pay button
    Then successful payment message is visible

  Scenario: Pay with expired card
    Given Task eight page is opened
    When I select MasterCard from card type container
    And I type full name in full name field
    And I type valid card No in card No field
    And I type valid cvv code in cvv code field
    And I scroll down
    And I click on pay button
    Then card expiration message is visible

  Scenario: Check CVV information is displayed
    Given Task eight page is opened
    When I hover over info sign
    Then CVV information is visible

  Scenario: Pay with not matching card No
    Given Task eight page is opened
    When I select MasterCard from card type container
    And I type full name in full name field
    And I type 51051 in card No field
    And I type valid cvv code in cvv code field
    And I scroll down
    And I click on pay button
    Then A message with Please match the requested format. text about not matching card No is displayed

  Scenario: Pay with invalid CVV code
    Given Task eight page is opened
    When I select Switch/Solo (Paymentech) from card type container
    And I type full name in full name field
    And I type valid card No in card No field
    And I type 1234 in cvv code field
    And I scroll down
    And I click on pay button
    Then invalid CVV code message is visible

