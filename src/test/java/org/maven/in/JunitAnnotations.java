package org.maven.in;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotations {
	@BeforeClass
	public static void browserLanuch()
	{
		System.out.println("BrowserLanuch");
	}
	@AfterClass
	public static void browserQuit()
	{
		System.out.println("BrowserQuit");
	}
	static long start;
	@Before
	public void starttime()
	{
		System.out.println("Before");
		start = System.currentTimeMillis();
	}

	@After
	public void endtime()
	{
		System.out.println("After");
		long end = System.currentTimeMillis();
		System.out.println("Time taken is "+ (end-start));
	}

	@Test
	public void method1()
	{
		System.out.println("method1");
	}
	@Test
	public void method2()
	{
		System.out.println("method2");
	}
	@Ignore
	@Test
	public void method3()
	{
		System.out.println("method3");
	}
	@Test
	public void method4()
	{
		System.out.println("method4");
	}
	@Test
	public void method5()
	{
		System.out.println("method5");
	}
	
}
