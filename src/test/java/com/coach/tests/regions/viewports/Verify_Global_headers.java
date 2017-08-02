package com.coach.tests.regions.viewports;

import java.util.Map;

import com.coach.tests.CoachTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verify_Global_headers extends CoachTest {

	Map<String, String> url;
	Map<String, String> users;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Verify_Header_Icons() {
		dsl.landingPage.verifyHeaderIcons();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Verify_Categories_On_Header() {
		dsl.homeheader.verifyCategoriesOnHeader();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Verify_Utility_Navigation_Dropdown() {
		dsl.verifyUtilityNavigationDropdown();
	}

}
