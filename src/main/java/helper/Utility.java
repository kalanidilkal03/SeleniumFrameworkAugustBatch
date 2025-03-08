package helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{
    /*Select
     * Wait
     * Actions
     * Screenshots
     * Scroll
     * JSExecutor
     */
	public void waitForSecond(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
		}
	}
	
	public static String getCurrentDateTime()
	{
		Date currentDate=new Date();
		SimpleDateFormat customFormat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String newDate=customFormat.format(currentDate);
		return newDate;
	}
	
	public static WebElement findElement(WebDriver driver,By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static WebElement findElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static void clickElement(WebDriver driver,By locator, int time)
	{
		WebElement element=null;
		try
		{
			element=findElement(driver,locator,time);
			element.click();
		}
		catch(Exception e)
		{
			System.out.println("LOG:INFO - Normal click failed - Tyring for actions class click");
			Actions act=new Actions(driver);
			try
			{
				act.moveToElement(element).click().build().perform();
			}
			catch(Exception e1)
			{
				System.out.println("LOG:INFO - Actions click failed - Tyring with JS click");
				JavascriptExecutor js=(JavaScriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
			
		}
	}
	
	public static void clickElement(WebDriver driver,By locator)
	{
		WebElement element=null;
		try
		{
			element=findElement(driver,locator);
			element.click();
		}
		catch(Exception e)
		{
			System.out.println("LOG:INFO - Normal click failed - Tyring for actions class click");
			Actions act=new Actions(driver);
			try
			{
				act.moveToElement(element).click().build().perform();
			}
			catch(Exception e1)
			{
				System.out.println("LOG:INFO - Actions click failed - Tyring with JS click");
				JavascriptExecutor js=(JavaScriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
			
		}
	}
}
