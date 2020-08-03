package testRunner;

/*
 *Created by owel on 03/08/2020 9:14 AM
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions"
)
public class TestRunner {
}
