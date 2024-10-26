Feature: get brands

  Scenario:send get request to /brands endpoint and Ensure the response status code is 200.
    Given send get request
    Then  validate Status Code is ok
    And check That List Of Brands HasMore Than One Entry
    And check That Each Brand Contains Id And Name


