package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="srs/test/resources/Features",
                  glue="stepdefinition",
                  plugin={"pretty", "html:target/cucumber-report/cucumber.html"},
                  tags="Nothing"
                    )
	public class TestRunners {

	}


