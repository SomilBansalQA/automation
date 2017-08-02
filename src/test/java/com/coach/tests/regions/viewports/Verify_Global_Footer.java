package com.coach.tests.regions.viewports;

import java.util.Map;

import com.coach.tests.CoachTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verify_Global_Footer extends CoachTest {
	
	Map<String, String> url;
	Map<String, String> users;
	
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		users = testData
	            .get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}
   
	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Verify_Footer_Sections() {
		dsl.homeheader.verifyFooterSections();
		dsl.verifyConnectWithCoachFunctionality(users.get("Username"));
	}
	
}
