Feature: Error Validation

@errorValidation
  Scenario Outline: Error Validation
    Given I landed on Ecommerce Page
    When  Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    
    Examples:
      | name                 | password        |  
      | test13oup1@gmail.com  | Admin@12345    | 