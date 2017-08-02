package com.coach.tests.regions.uk.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class FR_IT_ES_DE_Verify_UserIsAbleToChangeTheLanguageFromFooter extends CoachTest{
	    
	    Map<String,String> url;
	    
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
		 
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){		 
	  dsl.launchApplication(url.get("URL"));
	  dsl.closeCrossCookieIcon();
	   Reporter.log("Successfully Launched Coach Website");
	     
	}
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_Verify_UserIsAbleToChangeTheLanguageFromFooter(){
		 dsl.verify_UserIsAbleToChangeTheLanguageFromFooter();
		 Reporter.log("Verified languages");
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep03_VerifyCountryDropdown(){
		 dsl.verifyCountryDropdown();
	 }
}
