package com.mitigram.testFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mitigram.pageObjects.MitigramHomePage;
import com.mitigram.pageObjects.MitigramLoginPage;
import com.mitigram.resources.Base;
import com.mitigram.resources.PropertiesFile;


public class LoginTest extends Base {


	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
	MitigramHomePage mitigramHomePagePO;
	MitigramLoginPage mitigramLoginPagePO;
	PropertiesFile prop=new PropertiesFile();



	@BeforeTest
	public void startUp() throws IOException, InterruptedException {
		driver = webDriverIntialization();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Launched Mitigram URL!!");

	}


	@Test(priority = 0)
	public void tc01VerifyThePresenceOfLoginBtnInHomePage() throws IOException, InterruptedException {

		mitigramHomePagePO = new MitigramHomePage(driver);	
		mitigramHomePagePO.clickLoginHomepage();
		log.info("Login button clicked successfully!!");

	}


	@Test(priority = 1) 
	public void tc02VerifyThePresenceOfLoginPageFields() throws IOException, InterruptedException {

		mitigramLoginPagePO = new MitigramLoginPage(driver);
		mitigramLoginPagePO.verifyLoginPageElementsDisplayed();
		log.info("Login page elements verified successfully!!");

	}


	@Test(priority = 2)
	public void tc03VerifyInvalidLogin() throws IOException, InterruptedException {

		mitigramLoginPagePO.verifyInvalidLogin(prop.getProperty("email"),prop.getProperty("password"));
		log.info("Invalid login verified successfully!!");

	}


	@Test(priority = 3)
	public void tc04VerifyLoginErrorWhenNoCredentialsProvided() throws IOException, InterruptedException {

		mitigramLoginPagePO.verifyblankLogin();
		log.info("Error message verified successfully!!");
	}



	@Test(priority = 4)
	public void tc05VerifyInvalidLoginWithoutPassword() throws IOException, InterruptedException {

		mitigramLoginPagePO.verifyInvalidLoginWithoutPassword(prop.getProperty("email"));
		log.info("Invalid login without providing password verified successfully!!");

	}

	@Test(priority = 5) 
	public void tc06VerifyInvalidLoginWithoutEmail() throws IOException, InterruptedException {

		mitigramLoginPagePO.verifyInvalidLoginWithoutEmail(prop.getProperty("password"));
		log.info("Invalid login without providing email verified successfully!!");

	}


	@Test(priority = 6)
	public void tc07VerifyInvalidEmailFormat() throws IOException, InterruptedException {

		mitigramLoginPagePO.verifyInvalidEmailFormat(prop.getProperty("invaildEmail"),prop.getProperty("password"));
		log.info("Invalid Email Format verified successfully!!");


	}
	
	@Test(priority = 7)
	public void tc01VerifyThePresenceOfCareerBtnInHomePage() throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("URL"));
		mitigramHomePagePO = new MitigramHomePage(driver);	
		mitigramHomePagePO.clickCareersHomepage();
		log.info("Careers button clicked successfully!!");

	}


	@AfterTest
	public void tearDown()
	{
		driver.close(); 
		driver.quit();
		log.info("Web browser closed successfully!!");

	}




}
