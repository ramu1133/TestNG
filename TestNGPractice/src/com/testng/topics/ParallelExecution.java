package com.testng.topics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("set up");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test----1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test----2");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("close");
	}
	

}
