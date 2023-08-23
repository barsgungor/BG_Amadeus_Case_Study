Feature: API testing

  Scenario: Validate API Response Status Code
    When user sends a GET request to the endpoint
    Then the response status code should be 200

  Scenario: Validate JSON Body of API Response
    When user sends a GET request to the endpoint
    Then the response status code should be 200
    And the response body should match the json schema

  Scenario: Validate the Content-Type header in the response of a GET request
    When user sends a GET request to the endpoint
    Then the response status code should be 200
    And the response should contain the "Content-Type" header
    And the Content-Type header should have the value "application/json"