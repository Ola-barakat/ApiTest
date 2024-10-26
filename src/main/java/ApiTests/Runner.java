package ApiTests;
import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/ApiTests"},
        glue = {"ApiTests"},
        plugin = {"html:reports/Api_Report.html"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests{
}
