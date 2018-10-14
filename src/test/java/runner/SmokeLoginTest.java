package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "classpath:stepDefs", features = "classpath:", tags = "@SmokeLoginTest")
public class SmokeLoginTest {

}
