package com.sgtesting.testscripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestScript1 {
	static WebDriver driver;
	
	@Test(priority=1)
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	private static void navigate()
	{
		try
		{
			driver.get("http://desktop-qmj8cn1/login.do");
			
			String title=driver.getTitle();
			
			System.out.println(title);
			Assert.assertEquals(title,"actiTIME -  Login");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	private static void login()
	{
		try
		{
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.name("pwd")).sendKeys("manager");
			driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
			String logoutTitle=driver.getTitle();
			Assert.assertEquals(logoutTitle,"actiTIME -  Enter Time-Track");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	private static void logout()
	{
		try
		{
			driver.findElement(By.id("logoutLink")).click();
			String title=driver.getTitle();
			Assert.assertEquals(title,"actiTIME -  Login");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority=5)
	private static void closeApp()
	{
		try
		{
			driver.quit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
