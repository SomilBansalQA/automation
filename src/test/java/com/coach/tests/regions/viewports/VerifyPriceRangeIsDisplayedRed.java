package com.coach.tests.regions.viewports;

import java.lang.reflect.Method;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyPriceRangeIsDisplayedRed extends CoachTest {

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
		products = testData.get("Products").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launche the URL");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnBagsFromCoach1941() {
		dsl.clickOnBagsFromCoach1941();
		dsl.clickandVerifySortByForPriceLowToHigh();
		Reporter.log("User sorts the price from low to high");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_PriceRangeIsDisplayedRed() {
		dsl.verifyPriceRangeIsDisplayedRed();
		Reporter.log("Verify Price range is red");
	}
}
