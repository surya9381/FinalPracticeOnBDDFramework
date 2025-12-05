package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features={".//Features/Login.feature"},
		         glue="stepDefinitions",
		         dryRun = true,
		         monochrome = true,
		         plugin = {"pretty","html:target/htmlreport.html"},
		         tags = "@feature"
		        )

public class TestRunner extends AbstractTestNGCucumberTests {

}
