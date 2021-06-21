package com.mitigram.resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static int screenShotCount = 1;
	public static String projectPath=System.getProperty("user.dir");
	public static String screenshotLoc = projectPath+"/Screenshots";
	public static String screenshotTCLoc = "";
	
	
	public static WebDriver webDriverIntialization() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void getScreenshot(String testmethodName) throws IOException {

		Path path = Paths.get(screenshotLoc);
		boolean isDirExists = Files.isDirectory(path);

		if (!isDirExists) {
			File file = new File(projectPath+"/Screenshots");

		}

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm ss");
		String time = dateFormat.format(now);
		screenshotTCLoc = screenshotLoc + "/" + testmethodName + "_" + time;
		Path path2 = Paths.get(screenshotTCLoc);
		boolean isDirTCExists = Files.isDirectory(path2);

		if (!isDirTCExists) {
			File file = new File(screenshotTCLoc);
			screenShotCount = 1;

		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotTCLoc + "/" + screenShotCount + ".png"));

	}

}
