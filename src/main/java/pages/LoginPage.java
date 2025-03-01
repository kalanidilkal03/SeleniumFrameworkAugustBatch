package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
     WebDriver driver;
     public LoginPage(WebDriver driver)
     {
    	 this.driver=driver;
     }
     
    @FindBy(id="email1") WebElement username;
    @FindBy(id="password1") WebElement password;
    @FindBy(className="submit-btn") WebElement loginButton;
     
     public HomePage LoginToApp(String uname,String pass)
     {
    	username.sendKeys(uname); 
    	password.sendKeys(pass);
    	loginButton.click();
    	HomePage home=PageFactory.initElements(driver, HomePage.class);
    	return home;
     }

}
