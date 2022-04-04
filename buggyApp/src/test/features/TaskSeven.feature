@test
@taskSeven
Feature: Adding a product to the cart via drag and drop

  Scenario: Add products to the basket via drag and drop
    Given User is on Task Seven page
    When User adds products to the basket via drag and drop
    Then Products with appropriate names are added to the basket

  Scenario: Check the quantities of the products added to the basket
    Given User is on Task Seven page
    When User adds products to the basket via drag and drop
    Then Products with appropriate quantities are added to the basket

  Scenario: Delete all products from the basket
    Given User is on Task Seven page
    When User adds products to the basket via drag and drop
    And User removes products from the basket
    Then Total number of products in basket is equal to 0

  Scenario: Check total number of products added to the basket
    Given User is on Task Seven page
    When User adds products to the basket via drag and drop
    Then Total number of products added to the basket is equal to the sum of products quantities

  Scenario: Check total price of products added to the basket
    Given User is on Task Seven page
    When User adds products to the basket via drag and drop
    Then Total price of products is equal to the sum of products prices added to the basket

  Scenario: Check the limit of total number of products added to the basket
    Given User is on Task Seven page
    When User adds 101 products to the basket via drag and drop
    Then Alert with "Łączna ilość produktów w koszyku nie może przekroczyć 100." text is displayed
    And The products are not added to the basket