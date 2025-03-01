package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport 
{
	 @Test
     public void sampleReport()
     {
    	 ExtentSparkReporter sparkReporter=new ExtentSparkReporter("./Sample.html");
    	 sparkReporter.config().setDocumentTitle("Sample Automation Report");
    	 sparkReporter.config().setReportName("Sprint 1 Report");
    	 //by default white theme
    	 sparkReporter.config().setTheme(Theme.DARK);
    	 ExtentReports report=new ExtentReports();
    	 report.attachReporter(sparkReporter);
    	 ExtentTest test1=report.createTest("Test1");
    	 test1.pass("Test 1 passed");
    	 ExtentTest test2=report.createTest("Test2");
    	 test2.fail("Test 2 failed ",MediaEntityBuilder.createScreenCaptureFromPath("/Users/dilan/Downloads/Tracing In Playwright.png").build());
         ExtentTest test3=report.createTest("Test3");
         test3.skip("Test 3 skipped");
         report.flush();
     
     }
}
