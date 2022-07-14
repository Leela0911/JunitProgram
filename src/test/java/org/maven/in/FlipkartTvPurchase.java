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
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTvPurchase {
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
	public void method2() throws InterruptedException
	{
		System.out.println("Search");
		WebElement searchtxt = driver.findElement(By.xpath("//input[@type='text']"));
		searchtxt.sendKeys("Samsung TV");
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();
		Thread.sleep(4000);
	}
	@Test
	public void method3() throws Throwable
	{
		System.out.println("TV Choose");
		WebElement a = driver.findElement(By.xpath("(//div[contains(@class,'_4rR01T')])[1]"));
		a.click();
		Thread.sleep(5000);
		txt=a.getText();
		System.out.println("Mobiles Choose is :" + txt);
		File file = new File ("F:\\MS-Office 2007\\Private\\Junit\\target\\Excel.xlsx");
	    FileOutputStream f = new FileOutputStream(file);
	    HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Junit1");
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(txt);
		workbook.write(f);
		workbook.close();
	}
	@Test
	public void method4() throws InterruptedException, FileNotFoundException
	{
		System.out.println("Windows Handling");
		String pwin=driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		for(String x:allwin)
		{
			if(!x.equals(pwin))
			{
				driver.switchTo().window(x);
			}
		}
		Thread.sleep(4000);
		WebElement bt=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
		bt.click();
	
		//get text store in excel
	}
	@Test
	public void method5() throws IOException
	{
		System.out.println("Screenshot");
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source=tk.getScreenshotAs(OutputType.FILE);
	    File des= new File("F:\\MS-Office 2007\\Private\\Junit\\target\\flipkartTV.png");
		FileUtils.copyFile(source, des);
	    
	}
	



}
