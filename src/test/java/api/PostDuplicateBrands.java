package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class PostDuplicateBrands extends BaseApi {

    private   String id= "123";
    private   String brandName= "My New brand";
    private String expectedError="already exists";

    @Test
    public void checkNoDuplicateDataCreation() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", brandName);
        requestParams.put("description", " ");
        // Prepare request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType("application/json")
                .body(requestParams.toString())
                .log().all();

        // Post request
        Response response = request.post();
        response.then().log().all();

        // Validate response status code (422 )
        Assert.assertEquals(response.getStatusCode(), 422);
        JsonPath  jason = response.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,brandName+" "+expectedError);
        System.out.println(error);


    }
}

