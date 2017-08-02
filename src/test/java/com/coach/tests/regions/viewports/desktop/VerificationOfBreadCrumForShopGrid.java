package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import java.util.Random;

import com.coach.tests.CoachTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerificationOfBreadCrumForShopGrid extends CoachTest {


	Map<String, String> url;
	
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
	public void TestStep02_SelectViewAllForBagsForWomen() {
		dsl.selectViewAllForBagsForWomen();
		dsl.verifyShopGridPage();
		Reporter.log("User selects View All from Women Section");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_verifySelectedBreadCrumb() {
		dsl.verifyBreadCrumAndViewAllHeader("Bags");
		dsl.verifyViewAllBreadCrumDropDown();
		Reporter.log("Verify the selected breadcrumb");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyBreadcrumbCountAfterApplyingFilters() {
		dsl.VerifyBreadcrumbCountAfterApplyingFilters();
		Reporter.log("Verify landing page product count after apply filter");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	

