package com.coach.tests.regions.uk.viewports.desktop;

import com.coach.tests.CoachTest;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyAlternateParametersPresentInTheURL extends CoachTest{
	
	 Map<String,String> url;
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL_with_InvalidParameter(){		 
	   dsl.launchApplication(url.get("URL")+"/abc");
	   dsl.closeCrossCookieIcon();
	   Reporter.log("Coach website with passed parameter is launched");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_Verify_InvalidParameterPassedInURLPage(){
			dsl.verify_InvalidParameterPassedInURLPage();
			Reporter.log("Verification of invalid parameter in url is completed");
		}
}

