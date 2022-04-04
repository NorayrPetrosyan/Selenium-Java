@test
@taskNine
Feature: Folders tree

  Scenario: Check all nodes have the same names and titles
    Given User is on Task Nine page
    When User opens all nodes
    Then All nodes have the same names and titles