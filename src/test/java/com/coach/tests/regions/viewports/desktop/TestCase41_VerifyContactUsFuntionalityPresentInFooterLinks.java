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
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class TestCase41_VerifyContactUsFuntionalityPresentInFooterLinks extends CoachTest{
	
	 Map<String,String> url;
	    Map<String, String> products;
	    Map<String, String> users;
	    Map<String, String> shipping;
	    Map<String, String> creditCards;
	    String country;
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
		 url = testData.get("BASE URL").get(0);
		 products = testData
		            .get("Products").get(0); 
		 shipping = testData
		            .get("GuestShippingDetails").get(0);
		 users = testData
		            .get("Users").get(0);
		
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 dsl.launchApplication(url.get("URL"));
	   Reporter.log("User Launches Coach Website");
	     
	}
	 
	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_UserUsesContactUsForm() {
		dsl.scrollDownToBottom();
		System.out.println("url"+url.get("URL"));
		if((url.get("URL").contains("@dwdevelopment.coach.com"))||(url.get("URL").contains("@dwdevelopment2.coach.com"))||(url.get("URL").contains("@dwstaging.coach.com"))||(url.get("URL").contains("@dwstaging2.coach.com"))||(url.get("URL").contains("http://www.coach.com/")) ){
			country = "US";
			
			
		}
		else
		{
			country = "Non US";
		}
		dsl.verifyContactUsFunctionality(country,shipping.get("FirstName"),shipping.get("LastName"),users.get("Username"));
		Reporter.log("User has verified the functionality of Contact Us form Present in Footer links");
	}
	 
	 
}
