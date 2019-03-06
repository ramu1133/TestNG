package com.testng.topics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTesting {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAMU\\git\\TestNG\\TestNGPractice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		String propfile = "C:\\Users\\RAMU\\git\\TestNG\\TestNGPractice\\InputTestData\\config.properties";
		File file1 = new File(propfile);
		FileInputStream fip = new FileInputStream(file1);
			
		Properties prop = new Properties();
		prop.load(fip);
		
		driver.get(prop.getProperty("url"));
	}
	
	@DataProvider(name = "fbLoginDetails")
	public Iterator<Object[]> testData() throws IOException
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		
		String ext = "C:\\Users\\RAMU\\git\\TestNG\\TestNGPractice\\InputTestData\\inputdata.xlsx";
		File f = new File(ext);
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet2");
				
		for (int rowNumber = 0; rowNumber <= sh.getLastRowNum(); rowNumber++) 
		{
			String username = sh.getRow(rowNumber).getCell(0).getStringCellValue();
			String password = sh.getRow(rowNumber).getCell(1).getStringCellValue();
			Object ob[] = {username,password};
			data.add(ob);
		}
		return data.iterator();
		
	}
	
	@Test(dataProvider ="fbLoginDetails" )
	public void fbLogin(String username, String password) throws IOException
	{

		String propfile = "C:\\Users\\RAMU\\git\\TestNG\\TestNGPractice\\InputTestData\\config.properties";
		File file1 = new File(propfile);
		FileInputStream fip = new FileInputStream(file1);
			
		Properties prop = new Properties();
		prop.load(fip);
		
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(password);

		driver.findElement(By.xpath(prop.getProperty("loginbtn_xpath"))).click();
		
		File FBLoginDetailsImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(FBLoginDetailsImage, new File("C:\\Users\\RAMU\\git\\TestNG\\TestNGPractice\\FBLoginDetailsImages\\image.png"));

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
