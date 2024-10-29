package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/reports/cucumber-report.html",
                "json:target/reports/cucumber-report.json"
        },
        monochrome = true,
        tags = "@AllTests"
)
public class TestRunner {
}
