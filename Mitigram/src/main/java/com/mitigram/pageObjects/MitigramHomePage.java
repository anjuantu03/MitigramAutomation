package com.mitigram.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mitigram.resources.Base;


public class MitigramHomePage extends Base{
		
public WebDriver driver;
public static Logger log = LogManager.getLogger(MitigramHomePage.class.getName());
	
	public MitigramHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=".//header/nav/ul/li/a[text()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath=".//header/nav/ul/li/a[text()='Careers']")
	WebElement btn_careers;
	
	
	
	public void clickLoginHomepage() throws InterruptedException
	{
		try {
			btn_login.click();
		}
		catch (Exception e) {
			log.info("Login button in home page is not available");
			Assert.fail("Login button in home page is not available-FAILED");
		}
		

	}
	
	public void clickCareersHomepage() throws InterruptedException
	{
		try {
			btn_careers.click();
		}
		catch (Exception e) {
			log.info("Careers button in home page is not available");
			Assert.fail("Careers button in home page is not available-FAILED");
		}
		

	}


}
