package com.coach.tests.regions.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Verify_404_Page extends CoachTest{
	
	 Map<String,String> url;
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 dsl.launchApplication(url.get("URL")+"/404");
	    Reporter.log("Successfully Launched Coach Website");
	 }

	   @Test(groups = { "desktop","mobile" })
	public void TestStep02_Verify_404_Page(){
		dsl.verify_404_page();
		Reporter.log("Verification of 404 page is completed");
	}
	
	
	
}
