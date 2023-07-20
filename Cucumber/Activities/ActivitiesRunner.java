package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Activity1.feature",

        //glue = {"stepDefinitions"},
        //glue ="src/test/java/stepDefinition/GoogleSearchSteps.java"
        tags = "src/test/java/stepDefinition/GoogleSearchSteps.java"
        //tags = "@activity2"
)

public class ActivitiesRunner {
}
