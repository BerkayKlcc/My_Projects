Feature: Completed Order

  Background:
    Given Navigate to Luna
    When Enter username and password click login button
    Then User should login successfuly
    When User clicks women button
    And  User selects size
    And  User selects color
    Then User clicks add to cart button

  Scenario: User enter shipment address and clicks next button

    When User click to shopping cart button
      | clickCart |

    And User click to Checkout button
      | checkout |

    And User fills the address form
      | streetAddress | grup3      |
      | city          | Istanbul   |
      | zipCode       | 34000      |
      | phoneNumber   | 5128569845 |

    Then User clicks next button
      | country         |
      | radioBttn       |
      | addressNextBttn |
      | placeOrderBttn  |

  Scenario: User logouts successfully
    When User click to account Click
      | accountClick |

    Then User can logout
      | signoutButton |