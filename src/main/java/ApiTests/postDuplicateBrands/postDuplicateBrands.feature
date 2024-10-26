Feature: duplicate data

Scenario:Validate that the API prevents the creation of duplicate brand entries via POST request.
Given send post request
Then  check Status Code For creation of duplicate brand
And Check that post API returns an appropriate error