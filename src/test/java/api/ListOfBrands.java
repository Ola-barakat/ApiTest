package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class ListOfBrands extends BaseApi {



    private Response getRequest() {
        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response responce = httpRequest.get(BASE_URL);
        return responce;
    }

    @Test
    public void validateStatusCode(){
        Assert.assertEquals(getRequest().statusCode(),200);
    }

    @Test
    public void  checkThatListOfBrandsHasMoreThanOneEntry(){
        Response response=getRequest();
        List<Integer> brandIds = response.jsonPath().getList("_id");
        Assert.assertTrue(brandIds.size() > 0);
        System.out.println("Number of Brands IDs: " + brandIds.size());
    }

    @Test
    public void checkThatEachBrandContainsIdAndName(){
        Response response=getRequest();
       List<BrandsClass> allBrands = response.jsonPath().getList("$", BrandsClass.class);
       for(BrandsClass brand : allBrands)
       {
           Assert.assertTrue(brand._id !=null && brand.name !=null);
           System.out.println("brand: " + brand.name);
        }

    }
}
