package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSingleton {

	private static WebDriver driver = null;
	private String browser;

	File configFile;
	FileInputStream fileStream;
	static Properties rProperties = new Properties();

	public DriverSingleton initDriver() {

		configFile = new File(
				System.getProperty("user.dir") + "/src/main/resource/configurationData/runConfiguration.properties");

		try {
			fileStream = new FileInputStream(configFile);
			rProperties.load(fileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(System.getProperty("runOn.local") == null) {
			browser = rProperties.getProperty("runOn.browser");
		}else {
			browser = System.getProperty("runOn.browser");
		}
		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resource\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resource\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().fullscreen();
		} else {
			System.out.println("Browser not Supported");
		}
		return this;
	}

	public WebDriver getWebDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}
}
