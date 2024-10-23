package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBrandNotExists extends BaseApi{


    private   String id= "123";
    private String expectedError="Unable to fetch brand";


    @Test
    public void getBrandNotExists() {
        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response responce = httpRequest.get(BASE_URL+"/"+id);
        Assert.assertEquals(responce.getStatusCode(),422);
        JsonPath  jason = responce.jsonPath();
        String error = jason.get("error");
        Assert.assertEquals(error,expectedError);
        System.out.println(error);


    }


}
