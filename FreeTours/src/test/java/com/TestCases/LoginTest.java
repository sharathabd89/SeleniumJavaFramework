package com.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import co.free.tour.pages.HomePage;
import co.free.tour.pages.LoginPage;
import mainPacakge.BaseTestClass;
public class LoginTest extends BaseTestClass{
	public LoginPage log=new LoginPage();
	public HomePage page;
	public LoginTest()
	{
		super();
	}
	@Test(priority=1)
	public void verifyingTitle()
	{
		String title=log.validateLoginPageTitle();
		Assert.assertEquals("OrangeHRM",title);
		
	}
	@Test(priority=2)
	public void logocheck() {
		boolean flag=log.validateLogoImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginCredentials() {
	
	page=log.loginCheck("Admin","admin123");
	}
	@Test(priority=4)
	public void CheckLogSucessOrNot()
	{
		String actual=log.VerifySuccesfullLogin();
		Assert.assertEquals("welcome",actual);
	}
	@Test(priority=5)
	public void closeB() {
		driver.quit();
	}
	
	}
	


