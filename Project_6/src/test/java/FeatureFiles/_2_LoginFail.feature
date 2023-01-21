Feature:

  Scenario Outline: Login unsuccessful

    Given Navigate to Luna

    And Click on the sigin Button

    When User enters email as "<email>" password as "<password>"

    And Click on the login button

    Examples:
      | email           | password |
      | grup4@gmail.com | Grup4444 |
      | grup4@gmail.com | Grup3333 |
      | grup3@gmail.com | Grup4444 |

