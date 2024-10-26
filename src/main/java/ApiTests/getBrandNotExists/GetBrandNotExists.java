package ApiTests.getBrandNotExists;

import Api.BaseApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBrandNotExists extends BaseApi {

    private   String id= "123";
    private  String expectedError="Unable to fetch brand";
    private  BaseApi baseApi=new BaseApi();


    @Then("check Status Code For Requested non exists ID that")
    public void checkStatusCodeForRequestedNonExistsIDThat() {
        Response responce =baseApi.getRequestByID(id);
        Assert.assertEquals(responce.getStatusCode(),422);
    }

    @And("Check that API returns an appropriate error")
    public void checkThatAPIReturnsAnAppropriateError() {
        Response responce =baseApi.getRequestByID(id);
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError);
        System.out.println(error);
    }
}
