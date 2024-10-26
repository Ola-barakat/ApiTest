package ApiTests.getBrandById;

import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests/getBrandById/getBrandById.feature"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Report2.html"},
        monochrome = true
)

public class GetBrandRunner extends AbstractTestNGCucumberTests{
}
