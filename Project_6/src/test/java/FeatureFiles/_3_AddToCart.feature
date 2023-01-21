Feature: Item add to cart

  Background:
    Given Navigate to Luna
    When Enter username and password click login button
    Then User should login successfuly

  Scenario: Click cannot add to item on the cart
    When User clicks women button

    And  User selects sizes

    Then User clicks add to cart button


  Scenario: User cannot add to cart a item
    When User clicks women button

    And  User selects color

    Then User clicks add to cart button

  Scenario: User can add to cart a item
    When User clicks women button

    And  User selects size

    And  User selects color

    Then User clicks add to cart button


