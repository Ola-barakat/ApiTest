package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BaseApi {

    protected static final String BASE_URL = "https://practice-react.sdetunicorns.com/api/test/brands";
    JSONObject requestParams = new JSONObject();


    public Response getRequest() {
        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response responce = httpRequest.get(BASE_URL);
        return responce;
    }

    public Response getRequestByID(String id) {
        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response responce = httpRequest.get(BASE_URL + "/" + id);
        return responce;
    }


    public Response postData(String name, String description) {
        requestParams.put("name", name);
        requestParams.put("description", description);
        // Prepare request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType("application/json")
                .body(requestParams.toString())
                .log().all();
        // Post request
        Response response = request.post();
        response.then().log().all();
        return response;
    }

    public Response deleteBrandByID(String id) {
        RequestSpecification httpRequest = RestAssured.given();
        Response responce = httpRequest.delete(BASE_URL+"/"+id);
        return responce;
    }

    public Response updateBrandByID(String id,String name, String description) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("description", description);
        // Prepare request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType("application/json")
                .body(requestParams.toString())
                .log().all();

        // Post request
        Response response = request.put("/"+id);
        response.then().log().all();

        return response;
    }


}