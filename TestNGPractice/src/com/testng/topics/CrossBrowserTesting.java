package com.testng.topics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void loginFB(String browser) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Automation\\practice\\TestNGPractice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Automation\\practice\\TestNGPractice\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "E:\\Automation\\practice\\SeleniumPractice\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("http://www.facebook.com");
	}

}
