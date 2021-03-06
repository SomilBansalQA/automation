package com.coach.tests.regions.viewports.mobile;

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

import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class TestCase19Mobile_VerifyHeaderMenuLinksAndClickOnThem extends CoachTest {
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
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User launches the website");
		}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_GoToHeaderLinksAndVerify() {
		dsl.mobileVerifyBurgerLinks();
		Reporter.log("User verify the header links and categories");
	}

}
