Feature: get brands by id

  Scenario:Validate that a brand is successfully returned by a specific ID.
    Given Send a get request with a specific brand.
    Then  check Status Code For Requested ID
    And check Brand Name For Specific ID


