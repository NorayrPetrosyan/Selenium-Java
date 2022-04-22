#@test
#@taskOne
Feature: Adding a product to the cart
  Background:
    When I click on Task one button

  Scenario: Add products to the basket
    Given Task one page is opened
    When I add products to the basket
    Then Products with appropriate names are added to the basket

  Scenario: Check the quantities of the products added to the basket
    Given Task one page is opened
    When I add products to the basket
    Then Products with appropriate quantities are added to the basket

  Scenario: Delete all products from the basket
    Given Task one page is opened
    When I add products to the basket
    And I remove products from the basket
    Then Total number of products in basket is equal to 0

  Scenario: Check total number of products added to the basket
    Given Task one page is opened
    When I add products to the basket
    Then Total number of products added to the basket is equal to the sum of products quantities

  Scenario: Check total price of products added to the basket
    Given Task one page is opened
    When I add products to the basket
    Then Total price of products is equal to the sum of products prices added to the basket

  Scenario: Check the limit of total number of products added to the basket
    Given Task one page is opened
    When I add more than 100 products to the basket
    Then Alert with "Łączna ilość produktów w koszyku nie może przekroczyć 100." text is displayed
    And The products are not added to the basket



