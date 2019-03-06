package com.testng.topics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsExample {
	
	@BeforeSuite
	public void SetUp(){
		System.out.println("set up chrome");
	}
	@BeforeTest
	public void LaunchBrowser(){
		System.out.println("Launch the Browser");
	}
	@BeforeClass
	public void EnterURL(){
		System.out.println("Enter url");
	}
	@BeforeMethod
	public void LogIn(){
		System.out.println("log in ");
	}
	
	@Test
	public void TitleTest(){
		System.out.println("Title test");
	}
	@Test
	public void LogoTest(){
		System.out.println("Logo test");
	}
	@Test
	public void Test(){
		System.out.println("test");
	}
	
	
	@AfterMethod
	public void LogOut(){
		System.out.println("log out ");
	}
	@AfterClass
	public void DeleteAllCookies(){
		System.out.println("delete all cookies");
	}
	@AfterTest
	public void CloseBrowser(){
		System.out.println("close browser");
	}
	@AfterSuite
	public void GenerateReport(){
		System.out.println("generate the report");
	}

}
