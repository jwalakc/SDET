package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    //tags = "@SimpleAlert or @ConfirmAlert",
    //tags = "@PromptAlert",
    strict = true,
    plugin = {"html:test-reports"},
    //plugin = {"json:test-reports/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}