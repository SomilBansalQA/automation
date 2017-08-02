package com.coach.tests.regions.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_LazyLoadingOnSearchResultPage extends CoachTest{
	Map<String, String> url;
	Map<String, String> categories;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Verify_LazyLoadingOnSearchResultPage() {
		dsl.verify_LazyLoadingOnSearchResultPage();
		Reporter.log("lazy loading completed");
	}
}

