package org.maven.in;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartMobilepurchase {

	static WebDriver driver;
	static String txt,text;
	@BeforeClass
	public static void browserLanuch()
	{
		System.out.println("BrowserLanuch");
		System.setProperty("webdriver.chrome.driver", "F:\\MS-Office 2007\\Private\\Junit\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void browserQuit()
	{
		driver.quit();
		System.out.println("BrowserQuit");
	}
	@Test
	public void method1()
	{
		System.out.println("Login");
		WebElement cancel = driver.findElement(By.xpath("//button[text()='✕']"));
		cancel.click();
	}
	@Test
	public void method2() throws Throwable
	{
		System.out.println("Search");
		WebElement searchtxt = driver.findElement(By.xpath("//input[@type='text']"));
		searchtxt.sendKeys("Samsung Mobiles");
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();
		Thread.sleep(4000);
		
	}
	@Test
	public void method3() throws Throwable
	{
		System.out.println("Mobiles Choose");
		WebElement a = driver.findElement(By.xpath("(//div[contains(@class,'_4rR01T')])[1]"));
		a.click();
		Thread.sleep(5000);
		txt=a.getText();
		System.out.println("Mobiles Choose is :" + txt);
		
	}
	
	@Test
	public void method4() throws InterruptedException, IOException
	{
		System.out.println("Windows Handling");
		String parwin = driver.getWindowHandle();
		Set<String> chwin=driver.getWindowHandles();
		for(String x : chwin)
		{
			if (!x.equals(parwin))
			{
		driver.switchTo().window(x);
			}
			Thread.sleep(4000);
			}
		WebElement b=driver.findElement(By.xpath("//span[contains(@class,'B_NuCI')]"));
	    text= b.getText();
	    System.out.println("The child window text is :" +text);
	    File file = new File ("F:\\MS-Office 2007\\Private\\Junit\\target\\ExcelTV.xlsx");
	    FileOutputStream f = new FileOutputStream(file);
	    HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Junit");
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(txt);
		HSSFRow row1=sheet.createRow(1);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue(text);
	    workbook.write(f);
	    workbook.close();
	    
	}
	@Test
	public void method5() throws IOException
	{
		
		if(txt.equals(text))
		{
			System.out.println("The parent and child window text are same");
		}
		else
		{
			System.out.println("The parent and child name are not same");
			System.out.println("The parent window name :" +txt);
			System.out.println("The Child window name :"+ text);
		}
		
		System.out.println("Screenshot");
		TakesScreenshot tk= (TakesScreenshot)driver;
		File source=tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\MS-Office 2007\\Private\\Junit\\target\\flipkart.png");
		FileUtils.copyFile(source, dest);
		
        Assert.assertEquals(text, "SAMSUNG Galaxy F12 (Sky Blue, 64 GB)  (4 GB RAM)\r\n");
		Assert.assertTrue(txt.equalsIgnoreCase(text));
	}
}

