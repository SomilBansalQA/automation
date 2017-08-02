package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerificationOfOnlineExclusiveForShopGrid extends CoachTest {
	
	Map<String, String> url;
	String item="ONLINE EXCLUSIVE";
	
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
	public void TestStep03_VerifyOnlineExclusiveItems() {
		dsl.checkOnlineExclusiveItem(item);
		Reporter.log("Verification of online exclusive item sucessfully");
	}
	

}
