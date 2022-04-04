@test
@taskEight
Feature: Payment by card

  Scenario: Pay with valid card
    Given User is on Task Eight page
    When User selects "Visa" as card type
    And User types "Tom Smith" as full name
    And User types "4111111111111111" as card No
    And User types "123" as CVV code
    And User selects "April" as month
    And User selects "2024" as year
    And User clicks on 'Pay' button
    Then A message about successful payment is displayed

  Scenario: Pay with expired card
    Given User is on Task Eight page
    When User selects "MasterCard" as card type
    And User types "Tom Black" as full name
    And User types "5105105105105100" as card No
    And User types "321" as CVV code
    And User clicks on 'Pay' button
    Then A message about card expiration is displayed

  Scenario: Check CVV information is displayed
    Given User is on Task Eight page
    When User hovers over info sign
    Then CVV information is displayed

  Scenario: Pay with not matching card No
    Given User is on Task Eight page
    When User selects "MasterCard" as card type
    And User types "Tom Black" as full name
    And User types "51051" as card No
    And User types "456" as CVV code
    And User clicks on 'Pay' button
    Then A message with "Please match the requested format." text, about not matching card No is displayed

  Scenario: Pay with invalid CVV code
    Given User is on Task Eight page
    When User selects "Switch/Solo (Paymentech)" as card type
    And User types "Tom Black" as full name
    And User types "6331101999990016" as card No
    And User types "1234" as CVV code
    And User clicks on 'Pay' button
    Then A message about invalid CVV code is displayed

