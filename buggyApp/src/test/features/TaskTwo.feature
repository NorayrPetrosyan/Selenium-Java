@test
@taskTwo
Feature: Filtering products by category

  Scenario Outline: Filter products
    Given User is on Task Two page
    When User selects "<filter>" as filter
    Then Products are filtered by "<filter>"

    Examples:
      | filter         |
      | Sport          |
      | Elektronika    |
      | Firma i usługi |

  Scenario Outline: Search for an existing filter
    Given User is on Task Two page
    When User types "<filter>" as filter name in filter search field
    Then Searched "<filter>" name is in search results

    Examples:
      | filter         |
      | Sport          |
      | Elektronika    |
      | Firma i usługi |

  Scenario: Check the search field is case-sensitive
    Given User is on Task Two page
    When User types "sport" as filter name in filter search field
    Then "Sport" is in search results

  Scenario: Search an invalid filter
    Given User is on Task Two page
    When User types "Dance" as filter name in filter search field
    Then No results found