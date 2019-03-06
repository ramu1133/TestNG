package com.testng.topics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglePageTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\TestNGPractice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");

	}
	
	@Test
	public void titleTest(){
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void gmailLink(){
		driver.findElement(By.xpath("//a[@class='gb_P']")).click();
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}

}
