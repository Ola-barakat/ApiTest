package ApiTests.getBrandById;

import Api.BaseApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBrandById extends BaseApi {

  private  String id= "6716c306986188d4dce4fd35";
  private  String expectedName="My New brand";
  private  BaseApi baseApi=new BaseApi();


    @Given("Send a get request with a specific brand.")
    public void sendAGetRequestWithASpecificBrand() {
      baseApi.getRequestByID(id);
    }

    @Then("check Status Code For Requested ID")
    public void checkStatusCodeForRequestedID() {
        Response responce =baseApi.getRequestByID(id);
        Assert.assertEquals(responce.getStatusCode(),200);
    }

    @And("check Brand Name For Specific ID")
    public void checkBrandNameForSpecificID() {
        Response responce =baseApi.getRequestByID(id);
        JsonPath  jason = responce.jsonPath();
        String name = jason.get("name");
        Assert.assertEquals(name,expectedName);
        System.out.println(name);
        String response=responce.getBody().asString();
        System.out.println(response);
    }


}
