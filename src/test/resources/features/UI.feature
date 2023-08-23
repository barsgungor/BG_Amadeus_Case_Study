Feature: UI Testing

  Scenario: Ensure "From" and "To" input fields do not accept the same value
    Given user is on the flights app
    When user enters "Istanbul" in the From input field
    And user enters "Istanbul" in the To input field
    Then the selected departure country should not be the same as the selected arrival country

  Scenario Outline: Ensure the displayed flight count matches the "Found X items" count
    Given user is on the flights app
    When user enters "<departureCountry>" in the From input field
    And user enters "<arrivalCountry>" in the To input field
    Then the available flight count should match the displayed number

    Examples:
      | departureCountry | arrivalCountry |
      | Istanbul         | Los Angeles    |
      | London           | Rome           |
      | Paris            | Dubai          |