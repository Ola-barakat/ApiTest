Feature: brand not exists

Scenario:Validate that the API returns an appropriate error when attempting to retrieve a brand that does not exist
Given send get request
Then  check Status Code For Requested non exists ID that
And Check that API returns an appropriate error