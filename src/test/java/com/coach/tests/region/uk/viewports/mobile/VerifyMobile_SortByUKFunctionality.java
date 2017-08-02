package com.coach.tests.region.uk.viewports.mobile;

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

public class VerifyMobile_SortByUKFunctionality extends CoachTest {
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(1);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchProductfromHeader() {
		dsl.searchProductfromHeader();
		Reporter.log("Clicked on Bag under women");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickandVerifySortByForPriceLowToHigh() {
		dsl.clickandVerifySortByForPriceLowToHigh();
		Reporter.log("Sort By for price low to high is working");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ClickandVerifySortByForPriceHighToLow() {
		dsl.clickandVerifySortByForPriceHighToLow();
		Reporter.log("Sort By for price high to low is working");

	}
	
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Verify_FilterContainerIsDisplayed() throws InterruptedException{
		dsl.verifyMobile_FilterContainerIsDisplayed();
	}

}
