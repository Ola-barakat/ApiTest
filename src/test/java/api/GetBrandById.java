package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class GetBrandById extends BaseApi {

  private  String id= "6716c306986188d4dce4fd35";
  private  String expectedName="My New brand";

    private Response getRequestByID() {
        RequestSpecification httpRequest = RestAssured.given();
        Response responce = httpRequest.get(BASE_URL+"/"+id);
        return responce;
    }

  @Test
   public void checkStatusCodeForReqID() {
        Response responce = getRequestByID();
        Assert.assertEquals(responce.getStatusCode(),200);
    }

    @Test
    public void checkBrandNameForSpecificID() {
        Response responce = getRequestByID();
        JsonPath  jason = responce.jsonPath();
        String name = jason.get("name");
        Assert.assertEquals(name,expectedName);
        System.out.println(name);
        String response=responce.getBody().asString();
        System.out.println(response);
    }
}
