package com.coach.tests.regions.viewports.mobile;

import java.util.Map;

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

import com.coach.tests.CoachTest;

public class Verify_MoreButtonIsPresentAtTheEndOfPage extends CoachTest {

	 String[] browserSizes = {"1366x768"}; 
	 String [] layoutTags = {"all"};
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

		 shipping = testData
		            .get("GuestShippingDetails").get(0);
		 users = testData
		            .get("Users").get(0);

		 creditCards = testData
		            .get("CardDetails").get(4);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){		 
	  dsl.launchApplication(url.get("URL"));
	   Reporter.log("Successfully Launched Coach Website");
	     
	}

	    @Test(groups = { "desktop", "mobile" })
		public void TestStep02_ClickOnBurgerButtonForMenu() {
			dsl.clickOnBurgerButtonForMenu();
			Reporter.log("User clicks on burger icon");
		}
	 
	    @Test(groups = { "desktop", "mobile" })
        public void TestStep03_ClickOnWomenTabAndSelectBag(){
	    	dsl.clickOnWomenTab();
	    	Reporter.log("User clicks on Women tab and selects Bag");
	    }
	    
	    @Test(groups = { "desktop", "mobile" })
	    public void TestStep04_VerifyMoreButton() throws InterruptedException{
	    	dsl.verifyMoreButton();
	    }
	    
}
