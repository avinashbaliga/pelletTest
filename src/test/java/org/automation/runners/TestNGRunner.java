package org.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/main/java/org/automation/features/leads.feature",
        glue = {"org/automation/stepdef", "org/automation/utilities/hooks"},
        plugin = {"pretty", "html:target/report.html"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
