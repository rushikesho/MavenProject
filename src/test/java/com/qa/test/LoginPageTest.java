package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage login ;
	HomePage homePage ;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void lunchBrowser() {
		intilization();
		login = new LoginPage();
	}

	@Test(priority=1)
	public void gestTitleOfPageTest() {
		String title =login.getTitleOfPage();
		Assert.assertEquals(title, "title") ;
	}
	@Test(priority=2)
	public void loginPageTest() {
		homePage =login.loginPage(prop.getProperty("username"),prop.getProperty("password") );

	}
	@Test(priority=3)
	public void logoTest() {
		boolean logoDisplyed=login.logoPageClick();
		Assert.assertTrue(logoDisplyed);
	}
    
	@Test
	public void signupPageTast() {
		login.signUpPageClick();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
