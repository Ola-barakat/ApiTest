package ApiTests.postDuplicateBrands;

import Api.BaseApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;


public class PostDuplicateBrands extends BaseApi {

    private   String brandName= "My New brand";
    private   String description= "";
    private String expectedError="already exists";
    private  BaseApi baseApi=new BaseApi();


    @Given("send post request")
    public void sendPostRequest() {
       baseApi.postData(brandName,description);
    }

    @Then("check Status Code For creation of duplicate brand")
    public void checkStatusCodeForCreationOfDuplicateBrand() {
        Response responce =baseApi.postData(brandName,description);
        Assert.assertEquals(responce.getStatusCode(), 422);

    }

    @And("Check that post API returns an appropriate error")
    public void checkThatPostAPIReturnsAnAppropriateError() {
        Response responce =baseApi.postData(brandName,description);
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,brandName+" "+expectedError);
        System.out.println(error);
    }


}

