package com.coach.tests.regions.us.viewports;

import com.coach.tests.CoachTest;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verify_Registered_User_Can_Recover_Password extends CoachTest {
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

	@Test(groups={"desktop","mobile"})
	public void TestStep02_Click_On_Sign_In_Button_On_Account_Page(){
		dsl.topBanner.clickOnSignINRegister();
		dsl.accountPage.clickOnSignInButton();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_Click_On_ForgotPasswordLink(){
		dsl.landingPage.clickOnForgotPasswordLink();
		dsl.landingPage.verifyPasswordRequestPopupIsOpen();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep04_Change_Password(){
		dsl.landingPage.enterEmailAddressForPasswordRecovery(users.get("Username"));
		dsl.landingPage.verifyEmailIsSendToUser();
	}


}
