# Mitigram Automation

This project is Selenium Java implementation for automating regression test cases for Login to Mitigram portal flow and for Careers page

# Pre requisites

1.Java and Maven should be installed and paths should be set in environment variable

# Building and Running

Maven is used to build this project.

Execution starts from testng.xml file hence please use from command line after navigating to testng.xml file

$ mvn clean test -DsuiteXmlFile=testng.xml


# Project Structure

1)Mitigram -> src -> main -> java -> com.mitigram.pageObjects ->This package contains 2 class files

		1.MitigramHomePage.java: This contains the Web Elements and associated functions in the home page
		2.MitigramLoginPage.java: This contains the Web Elements and associated functions in the Login page
		
2)Mitigram -> src -> test -> java -> com.mitigram.resources ->This package contains the base class, ExtentReporterNG and Properties files

3)Mitigram -> src -> test -> resources -> This contains the Test file and Listeners

4) Reports -> Reports can be viewed under test-output->ExtentReportsTestNG.html





