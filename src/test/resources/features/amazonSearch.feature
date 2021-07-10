Feature: Amazon Search and Cart feature
  @wip
  Scenario: Amazon search and cart functionality
    Given  User is on the Amazon Home Page
    When User search for hats for men
    And User ads the first hat appearing to the cart with quantity two
    Then the total price and quantiy should be correct
    When user reduce the quantity from two to one
    Then total price and quantity has been correctly changed
