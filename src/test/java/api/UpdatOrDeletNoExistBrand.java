package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.json.Json;

import java.util.HashMap;
import java.util.Map;


public class UpdatOrDeletNoExistBrand extends BaseApi{

    private   String id= "123";
    private   String brandName= "not exists";
    private String expectedError1="Unable to delete brand";
    private String expectedError2="Unable to update brands";
    private int statusCode= 422;
    JSONObject requestParams = new JSONObject();



    @Test
    public void deleteBrandNotExistsID() {
        RequestSpecification httpRequest = RestAssured.given();
        Response responce = httpRequest.delete(BASE_URL+"/"+id);
        Assert.assertEquals(responce.getStatusCode(),statusCode);
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError1);
        System.out.println(error);
    }

    @Test
    public void updateBrandNotExistsID() {

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
        Response response = request.put("/"+id);
        response.then().log().all();
        // Validate response status code (422 )
        Assert.assertEquals(response.getStatusCode(), 422);
        JsonPath  jason = response.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError2);
        System.out.println(error);
    }


}
