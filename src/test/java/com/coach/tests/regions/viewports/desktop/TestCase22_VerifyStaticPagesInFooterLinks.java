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

public class TestCase22_VerifyStaticPagesInFooterLinks extends CoachTest{

    Map<String,String> url;
	    Map<String, String> products;
	    Map<String, String> users;
	    Map<String, String> shipping;
	    Map<String, String> creditCards;
	    Map<String, String> giftCards;
	    Map<String, String> payPal;
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
			products = testData
		            .get("Products").get(2);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
	   dsl.launchApplication(url.get("URL"));
	   Reporter.log("Successfully Launched Coach Website");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_ScrollDownToBottom(){
	   dsl.scrollDownToBottom();
	   Reporter.log("User scrolls down");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep03_VerifyCorporateResponsibilityLinkPageInFooter(){
		 dsl.verifyCorporateResponsibilityLinkPage();
	   Reporter.log("Successfully Corporate Responsibility link Page");
	     
	}
	 
}
