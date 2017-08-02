package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class TestCase19_VerifyHeaderMenuLinksAndHoverOnThem extends CoachTest{
	
	 	Map<String,String> url;
	    
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
	 }
	 
	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}
	 	 	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_GoToHeaderLinksAndVerify(){		 
		 dsl.hoverAtHeaderLinks();
	}
	 

}
