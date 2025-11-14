Feature: Purchase the order from Ecommerce Website

	Background:
	Given I landed on Ecommerce Page

@submitOrder
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from cart
    And Checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | name                 | password        | productName |
      | test13oup@gmail.com  | Admin@12345    | ZARA COAT 3 |
