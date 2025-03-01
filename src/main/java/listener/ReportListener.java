package listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportListener implements ITestListener
{
	ExtentReports extent=ExtentManager.getInstance();
	ExtentTest extentTest;
	public void OnTestSuccess(ITestResult result)
	{
		  extentTest.pass("Test executed successfully");
	}
	
	public void OnTestStart(ITestResult result)
    {
	  extentTest=extent.createTest(result.getMethod().getMethodName());
    }
   
   public void OnTestFailure(ITestResult result)
   {
	  extentTest.fail("Test failed "+result.getThrowable().getMessage());
   }
   
   public void OnTestSkipped(ITestResult result)
   {
	  extentTest.skip("Test skipped "+result.getThrowable().getMessage());
   }
   
   
   public void OnTestFinish(ITestContext context)
   {
	  extent.flush();
   }
}
