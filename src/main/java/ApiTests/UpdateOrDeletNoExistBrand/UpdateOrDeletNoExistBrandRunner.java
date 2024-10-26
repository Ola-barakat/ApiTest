package ApiTests.UpdateOrDeletNoExistBrand;
import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests/UpdateOrDeletNoExistBrand/updateOrDeletNoExistBrand.feature"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Report.html"},
        monochrome = true
)

public class UpdateOrDeletNoExistBrandRunner extends AbstractTestNGCucumberTests {
}
