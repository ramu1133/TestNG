package com.testng.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	SoftAssert soft = new SoftAssert();
	
	@Test(priority = 1)
	public void test1()
	{
		Assert.assertEquals(true, false);
		System.out.println("gfhgfh");
	}

	@Test(priority = 2)
	public void test2()
	{
		Assert.assertEquals(true, true);
		System.out.println("chgch");
	}

	@Test(priority = 3)
	public void test3()
	{
		soft.assertEquals(true, false);
		System.out.println("soft fail");
		soft.assertAll();
	}

	@Test(priority = 4)
	public void test4()
	{
		soft.assertEquals(true, true);
		System.out.println("soft pass");
	
	}

}
