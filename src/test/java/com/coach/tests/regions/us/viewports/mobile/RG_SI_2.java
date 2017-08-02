package com.coach.tests.regions.us.viewports.mobile;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RG_SI_2 extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(0);
		shipping = testData.get("GuestShippingDetails").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		dsl.closeCrossCookieIcon();
		Reporter.log("Successfully Launched Coach Website");

	}

//	@Test(groups = { "desktop", "mobile" })
//	public void TestStep02_ClickOnBurgerButtonForMenu() {
//		dsl.clickOnBurgerButtonForMenu();
//		Reporter.log("User clicks on burger icon");
//	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButtonForMobile();
		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOnRegisterANewUserForMobile() {
		dsl.clickOnRegisterANewUserForMobile(shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User clicks on Registraion button to register");
		dsl.topBanner.goToAccountSettingsPage();
		Reporter.log("User clicks on account setting page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Log_Out_From_The_App() {
		dsl.logOutFromTheApplication();
		Reporter.log("User logs out from the application");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_ClickOnBurgerButtonForMenu() {
		dsl.clickOnBurgerButtonForMenu();
		Reporter.log("User clicks on burger icon");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_Mobile_Login_With_User_Credentials() {
		dsl.mobile_loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("User login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_VerifyForgotPasswordFunctionality() {
		dsl.accountPage.clickForgotPassword();
		dsl.accountPage.assertLabelPasswordRequest();
		dsl.accountPage.enterEmailForForgotPasswordAndNavigateBackToAccountPage("anmolbagga5@gmail.com");
		Reporter.log("User verifies the Forgot Password Link and Functionality");
	}

}
