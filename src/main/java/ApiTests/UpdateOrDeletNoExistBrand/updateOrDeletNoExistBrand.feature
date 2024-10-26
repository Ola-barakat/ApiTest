Feature: update or delete

  Scenario:Validate that the API throws an error when attempting to  delete a non-existent brand.
    Given send delete request
    Then  check Status Code incase of delete non exists brand
    And Check that post API returns an appropriate error incase of delete non exists


  Scenario:Validate that the API throws an error when attempting to update a non-existent brand.
    Given send post request
    Then  check Status Code incase of update non exists brand
    And Check that post API returns an appropriate error incase of update non exists