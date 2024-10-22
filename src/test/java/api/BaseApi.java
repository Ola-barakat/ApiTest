package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import javax.json.*;
import java.io.IOException;

public class BaseApi {

    protected static final String BASE_URL = "https://practice-react.sdetunicorns.com/api/test/brands";

}
