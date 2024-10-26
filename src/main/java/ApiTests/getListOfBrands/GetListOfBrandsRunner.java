package ApiTests.getListOfBrands;

import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests/getListOfBrands/getListOfBrands.feature"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Report.html"},
        monochrome = true
)

public class GetListOfBrandsRunner extends AbstractTestNGCucumberTests{
}
