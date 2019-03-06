package com.testng.topics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners(CustomizedListener.class)
public class TakeScreenshotForFailedTestcase {

	
	static WebDriver driver;
	
	@BeforeMethod
	@Parameters("browsername")
	public void setUp(String browsername)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\practice\\TestNGPractice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Automation\\practice\\TestNGPractice\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
	}
	
	@Test
	public void facebookLoginPage()
	{
		driver.get("http://www.facebook.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "facebook");
	
	}
	
	@Test
	public void fbLoginPage()
	{
		driver.get("http://www.facebook.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();		
	}
	
	public void screenShot(String testMethoName) throws FileNotFoundException
	{
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(image, new File("E:\\Automation\\practice\\TestNGPractice\\Screenshots\\"+testMethoName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
