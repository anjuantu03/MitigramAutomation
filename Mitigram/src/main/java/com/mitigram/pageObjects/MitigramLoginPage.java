package com.mitigram.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mitigram.resources.Base;


public class MitigramLoginPage extends Base{
	
	
public WebDriver driver;
public static Logger log = LogManager.getLogger(MitigramLoginPage.class.getName());

	
	public MitigramLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="Email")
	WebElement txtbox_email;
	
	@FindBy(id="Password")
	WebElement txtbox_password;
	
	@FindBy(id="loginBtn")
	WebElement btn_login;
	
	@FindBy(xpath=".//div[@class='error']/div/div[contains(text(),'Invalid login attempt')]")
	WebElement txt_InvalidLoginAttempt;
	
	@FindBy(xpath=".//div[@class='error']/div/div[contains(text(),'Email is required')]")
	WebElement txt_EmailRequired;
	
	@FindBy(xpath=".//div[@class='error']/div/div[contains(text(),'Password is required')]")
	WebElement txt_PasswordRequired;
	
	@FindBy(xpath=".//div[@class='error']/div/div[contains(text(),'The Email field is not a valid e-mail address.')]")
	WebElement txt_InvalidEmailFormat;
	
	
	public void clearEmailAndPassword()
	{
		txtbox_email.clear();
		txtbox_password.clear();
	}
	
	
	public void verifyLoginPageElementsDisplayed() throws InterruptedException
	{
		try {
			txtbox_email.isDisplayed();
			txtbox_password.isDisplayed();
			btn_login.isDisplayed();
		}
		catch (Exception e) {
			log.info("verifyLoginPageElementsDisplayed function failed");
			Assert.fail("Login page elements not displayed-FAILED");
		}
		

	}
	
	
	public void verifyInvalidLogin(String email,String password) throws InterruptedException
	{
		try {
			clearEmailAndPassword();
			txtbox_email.sendKeys(email);
			txtbox_password.sendKeys(password);
			btn_login.click();
			txt_InvalidLoginAttempt.isDisplayed();
			log.info("Invalid login attempt error message is displayed");
			
		
		}
		catch (Exception e) {
			log.info("verifyInvalidLogin function failed");
			Assert.fail("Invalid login attempt error message is  not displayed-FAILED");
		}
	
		

	}
	

	public void verifyblankLogin() throws InterruptedException
	{
		try {
			
			clearEmailAndPassword();
			btn_login.click();
			txt_EmailRequired.isDisplayed();
			log.info("Email is required error message is displayed");
			
		
		}
		catch (Exception e) {
			log.info("verifyblankLogin function failed");
			Assert.fail("Email is required  error message is  not displayed-FAILED");
		}
	
		

	}
	
	
	public void verifyInvalidLoginWithoutPassword(String email) throws InterruptedException
	{
		try {
			
			clearEmailAndPassword();
			txtbox_email.sendKeys(email);
			btn_login.click();
			txt_PasswordRequired.isDisplayed();
			log.info("Password is required error message is displayed");
			
		
		}
		catch (Exception e) {
			log.info("verifyInvalidLoginWithoutPassword function failed");
			Assert.fail("Password is required error message is  not displayed-FAILED");
		}
	
	}

	
	public void verifyInvalidLoginWithoutEmail(String password) throws InterruptedException
	{
		try {
			
			clearEmailAndPassword();
			txtbox_password.sendKeys(password);;
			btn_login.click();
			txt_EmailRequired.isDisplayed();
			log.info("Email is required error message is displayed");
			
		
		}
		catch (Exception e) {
			log.info("verifyInvalidLoginWithoutEmail function failed");
			Assert.fail("Email is required error message is  not displayed-FAILED");
		}
	
		

	}
	
	public void verifyInvalidEmailFormat(String email,String password) throws InterruptedException
	{
		try {
			
			clearEmailAndPassword();
			txtbox_email.sendKeys(email);
			txtbox_password.sendKeys(password);
			btn_login.click();
			txt_InvalidEmailFormat.isDisplayed();
			log.info("The Email field is not a valid e-mail address error message is displayed");
			
		
		}
		catch (Exception e) {
			log.info("verifyInvalidEmailFormat function failed");
			Assert.fail("The Email field is not a valid e-mail address error message is  not displayed-FAILED");
		}
	
		

	}
	



}
