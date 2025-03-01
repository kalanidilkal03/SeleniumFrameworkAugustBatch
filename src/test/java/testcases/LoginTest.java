package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.LoginPage;


public class LoginTest extends BaseClass
{
    //txt,properties - no dependancy
	//xml,json,excel,opencsv,yml - dependancy
	
	@Test(description="This test will verify valid login scenario",groups={"Smoke","Regression"},dataProvider="login",dataProviderClass=CustomDataProvider.class)
	public void validLoginTest(String username,String password)
	{
	     
	     LoginPage login=new LoginPage(driver);
	     login.LoginToApp("admin@email.com", "admin@123");
	     Assert.assertTrue(driver.findElement(By.className("welcomeMessage")).isDisplayed());
	}
}
