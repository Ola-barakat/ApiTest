package ApiTests.getBrandNotExists;

import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests/getBrandNotExists/getBrandNotExists.feature"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Report2.html"},
        monochrome = true
)
public class GetBrandNotExixtsRunner extends AbstractTestNGCucumberTests {
}
