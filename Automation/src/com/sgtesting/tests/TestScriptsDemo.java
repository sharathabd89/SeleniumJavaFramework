package com.sgtesting.tests;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScriptsDemo {
	public static String filename="C:\\Users\\HP\\eclipse-workspace\\Automation\\DataFiles\\TestData.xlsx";
	@Test
	public void login()
	{
		try
		{
			String username=getData(filename, "Sheet1", 2, 0);
			String password=getData(filename, "Sheet1", 2, 1);
			System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(5000);
			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getData(String filename, String sheetname,int rownum,int cellno)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		String data=null;
		try
		{
			fin=new FileInputStream(filename);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet("Sheet1");
			row=sh.getRow(rownum-1);
			cell=row.getCell(cellno);
			data=cell.getStringCellValue();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return data;
	}
	

}
