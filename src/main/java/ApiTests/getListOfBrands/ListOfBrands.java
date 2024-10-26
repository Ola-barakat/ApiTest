package ApiTests.getListOfBrands;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;


import Api.BaseApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class ListOfBrands extends BaseApi {

    @Given("send get request")
    public void sendGetRequest() {
        BaseApi baseApi=new BaseApi();
        baseApi.getRequest();
  //      System.out.println(baseApi.getRequest().jsonPath().getList("name"));
    }

    @Then("validate Status Code is ok")
    public void validateStatusCodeIsOk() {
        Assert.assertEquals(getRequest().statusCode(),200);
    }

    @And("check That List Of Brands HasMore Than One Entry")
    public void checkThatListOfBrandsHasMoreThanOneEntry() {
        Response response=getRequest();
        List<Integer> brandIds = response.jsonPath().getList("_id");
        Assert.assertTrue(brandIds.size() > 0);
        System.out.println("Number of Brands IDs: " + brandIds.size());
    }

    @And("check That Each Brand Contains Id And Name")
    public void checkThatEachBrandContainsIdAndName() {
        Response response=getRequest();
        List<BrandsClass> allBrands = response.jsonPath().getList("$", BrandsClass.class);
        for(BrandsClass brand : allBrands)
        {
            Assert.assertTrue(brand._id !=null && brand.name !=null);
            System.out.println("brand: " + brand.name);
        }
    }

}
