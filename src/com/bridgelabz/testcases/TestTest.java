package com.bridgelabz.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTest
{
	@Test
	public void testAdd()
	{
		com.bridgelabz.oops.Test test=new com.bridgelabz.oops.Test();
		int res=test.add(41, 87);
		assertEquals(res,128);
	}

}
