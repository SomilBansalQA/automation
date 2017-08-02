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
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;

public class TestCase33_VerifyStoreLocatorAndSetAsFavouriteStore extends CoachTest{
	
	Map<String,String> url;
    Map<String, String> products;
    Map<String, String> users;
    Map<String, String> shipping;
    Map<String, String> creditCards;
    String country="UNITED KINGDOM";
    
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		 products = testData
		            .get("Products").get(0);
		 shipping = testData
		            .get("GuestShippingDetails").get(0);
		 users = testData
		            .get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_GoToStoreLocatorFromFooterLinks() {
		dsl.scrollDownToBottom();
		dsl.goToStoreLocatorPageFromFooter();
		//dsl.searchStoreUsingZipCode(shipping.get("Zip"));
		dsl.verifyStorePage();
		Reporter.log("User searches a store from store locator");
	}

}
