package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage 
{
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    private By welcomeMsg=By.className("welcomeMessage");
    private By manage=By.xpath("//span[normalize-space()='Manage']");
    private By manageCourses=By.xpath("//span[normalize-space()='Manage Courses']");
    private By manageCategory=By.xpath("//span[normalize-space()='Manage Categories']");
    
    public String getWelcomeMsg()
    {
    	String welcomeMessage=driver.findElement(welcomeMsg).getText();
    	return welcomeMessage;
    }
    
    public Courses clickOnManageCourses()
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(driver.findElement(manage)).perform();
    	driver.findElement(manageCourses).click();
    	Courses course=new Courses(driver);
    	return course;
    }
    
    public Category clickOnManageCategory()
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(driver.findElement(manage)).perform();
    	driver.findElement(manageCategory).click();
    	Category category=new Category(driver);
    	return category;
    }
}
