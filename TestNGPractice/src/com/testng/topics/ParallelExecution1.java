package com.testng.topics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution1 {

	@BeforeMethod
	public void setUp()
	{
		System.out.println("set up");
	}
	
	@Test
	public void test3()
	{
		System.out.println("test----3");
	}
	
	@Test
	public void test4()
	{
		System.out.println("test----4");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("close");
	}
	
}
