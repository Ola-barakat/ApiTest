package ApiTests.postDuplicateBrands;
import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests/postDuplicateBrands/postDuplicateBrands.feature"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Report.html"},
        monochrome = true
)
public class PostDuplicateBrandsRunner extends AbstractTestNGCucumberTests{
}
