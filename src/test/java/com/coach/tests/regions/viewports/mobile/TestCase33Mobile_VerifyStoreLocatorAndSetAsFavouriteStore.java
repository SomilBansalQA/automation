package com.coach.tests.regions.viewports.mobile;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;
import com.coach.tests.CoachTest;

public class TestCase33Mobile_VerifyStoreLocatorAndSetAsFavouriteStore extends CoachTest {
	String[] browserSizes = { "1366x768" };
	String[] layoutTags = { "all" };
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> payPal;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);

		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ScrollDownAndClickOnStoresAndSites() {
		dsl.scrollDownToBottom();
		dsl.mobile_clickOnStoresAndSites();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_GoToStoreLocatorFromFooterLinks() {
		dsl.goToStoreLocatorPageFromFooter();
		dsl.verifyMobileStorePage();

	}
}
