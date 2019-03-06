package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportGeneration {
	
	@Test
	public void test()
	{
		System.out.println("login test");
		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:\\Automation\\practice\\TestNGPractice\\Reports\\extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("test");
		logger.log(Status.INFO, "login test");
		extent.flush();		
	}

}
