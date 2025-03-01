package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import dataprovider.ConfigReader;
import factory.BrowserFactory;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void setupBrowser()
	{
		System.out.println("LOG:INFO - Setting up browser");
		String browser=ConfigReader.getValue("browser");
		String appurl=ConfigReader.getValue("qaenv");
		driver=BrowserFactory.getDriver(browser, appurl);
	    System.out.println("LOG:INFO - Application is up and running");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO - Closing browser");
		driver.quit();
		System.out.println("LOG:INFO - Application and browser closed");
	}
}
