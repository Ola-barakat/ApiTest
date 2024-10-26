Feature: get brands

  Scenario:send get request to /brands endpoint and Ensure the response status code is 200.
    Given send get request
    Then  validate Status Code is ok
    And check That List Of Brands HasMore Than One Entry
    And check That Each Brand Contains Id And Name


  Scenario:Validate that a brand is successfully returned by a specific ID.
    Given Send a get request with a specific brand.
    Then  check Status Code For Requested ID
    And check Brand Name For Specific ID


  Scenario:Validate that the API returns an appropriate error when attempting to retrieve a brand that does not exist
    Given send get request
    Then  check Status Code For Requested non exists ID that
    And Check that API returns an appropriate error


  Scenario:Validate that the API prevents the creation of duplicate brand entries via POST request.
    Given send post request
    Then  check Status Code For creation of duplicate brand
    And Check that post API returns an appropriate error


  Scenario:Validate that the API throws an error when attempting to  delete a non-existent brand.
    Given send delete request
    Then  check Status Code incase of delete non exists brand
    And Check that post API returns an appropriate error incase of delete non exists


  Scenario:Validate that the API throws an error when attempting to update a non-existent brand.
    Given send post request
    Then  check Status Code incase of update non exists brand
    And Check that post API returns an appropriate error incase of update non exists