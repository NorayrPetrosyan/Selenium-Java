@test
@taskNine
Feature: Folders tree
  Background:
    When I click on Task nine button

  Scenario: Check all nodes have the same names and titles
    Given Task nine page is opened
    When I open all nodes
    Then All nodes have the same names and titles