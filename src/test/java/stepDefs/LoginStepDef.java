package stepDefs;

import org.openqa.selenium.WebDriver;

import configuration.DriverSingleton;
import cucumber.api.java.en.Given;

public class LoginStepDef extends DriverSingleton{
	
	private WebDriver driver;
	private DriverSingleton driverSingleton;
	
	@Given("I access the site")
	public LoginStepDef accessTheSite() {
		driverSingleton = new DriverSingleton();
		this.driver = driverSingleton.getWebDriver();
		driver.get("https://www.google.com");
		return this;
	}

}
