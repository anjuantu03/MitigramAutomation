package com.mitigram.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

public class PropertiesFile {
	
	public String getProperty(String key) throws IOException {
		
		Properties prop= new Properties();
		String projectPath=System.getProperty("user.dir");
		InputStream input= new FileInputStream(projectPath+"/src/main/java/com/mitigram/resources/Testdata.properties");
		prop.load(input);
		
		String value = "";
		if (key == "" || key == null || key.equals("")) {
			Assert.fail(key + " is not availble ");
		} else {
			value = prop.getProperty(key);
		}
		return value;
	}

}
