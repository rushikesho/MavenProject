package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory 
	//object repository
	//page Library



	@FindBy(xpath ="//input[@type='text']") private WebElement username ;
	@FindBy(xpath ="//input[@type='password']") private WebElement password ;
	@FindBy(xpath="//input[@type='submit']") private WebElement loginButton ;
	@FindBy(xpath="//a[contains(@class,'navbar')]") private WebElement logo ;
	@FindBy(xpath="//a[text()='Sign Up']") private WebElement signUp;

	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String getTitleOfPage() {
		return driver.getTitle(); 
	}
	public HomePage loginPage(String userName ,String pass) {

		username.sendKeys(userName);
		password.sendKeys(pass);
		loginButton.click();
		return  new HomePage();
	}

	public boolean logoPageClick() {
		logo.click();
		return logo.isDisplayed() ;
	}
	public void signUpPageClick() {
		signUp.click();
	}
}