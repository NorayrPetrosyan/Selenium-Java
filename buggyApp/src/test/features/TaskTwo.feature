@test
@taskTwo
Feature: Filtering products by category
  Background:
    When I click on Task two button

  Scenario Outline: Filter products
    Given Task two page is opened
    When I set <filter> as filter
    Then Products are filtered by <filter>

    Examples:
      | filter         |
      | Sport          |
      | Elektronika    |
      | Firma i usługi |

  Scenario Outline: Search for an existing filter
    Given Task two page is opened
    When I click on filter container
    And I type <filter> in filter search field
    Then <filter> is in search results

    Examples:
      | filter         |
      | Sport          |
      | Elektronika    |
      | Firma i usługi |

  Scenario: Check the search field is case-sensitive
    Given Task two page is opened
    When I click on filter container
    And I type sport in filter search field
    Then Sport is in search results

  Scenario: Search an invalid filter
    Given Task two page is opened
    When I click on filter container
    And I type dance in filter search field
    Then No results found