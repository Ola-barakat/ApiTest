package ApiTests.UpdateOrDeletNoExistBrand;

import Api.BaseApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UpdatOrDeletNoExistBrand extends BaseApi {

    private   String id= "123";
    private   String brandName= "non hhhhhexists";
    private String expectedError1="Unable to delete brand";
    private String expectedError2="Unable to update brands";
    private int statusCode= 422;
    private BaseApi baseApi=new BaseApi();


 @Given("send delete request")
    public void sendDeleteRequest() {
        baseApi.deleteBrandByID(id);
    }

    @Then("check Status Code incase of delete non exists brand")
    public void checkStatusCodeIncaseOfDeleteNonExistsBrand() {
        Response responce = baseApi.deleteBrandByID(id);
        Assert.assertEquals(responce.getStatusCode(),statusCode);
    }

    @And("Check that post API returns an appropriate error incase of delete non exists")
    public void checkThatPostAPIReturnsAnAppropriateErrorIncaseOfDeleteNonExists() {
        Response responce = baseApi.deleteBrandByID(id);
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError1);
        System.out.println(error);
    }


    @Then("check Status Code incase of update non exists brand")
    public void checkStatusCodeIncaseOfUpdateNonExistsBrand() {
        Response responce = baseApi.updateBrandByID(id,brandName,"");
        Assert.assertEquals(responce.getStatusCode(), 422);
    }

    @And("Check that post API returns an appropriate error incase of update non exists")
    public void checkThatPostAPIReturnsAnAppropriateErrorIncaseOfUpdateNonExists() {
        Response responce = baseApi.updateBrandByID(id,brandName,"");
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError2);
        System.out.println(error);
    }
}
