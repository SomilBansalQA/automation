package com.coach.tests.regions.viewports.mobile;


import java.util.Map;

import com.coach.tests.CoachTest;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class TestCase01_02_03_04_05_07_18_39And40Mobile_VerifyUserIsAbleToRegisterAndLoginIntoCoach extends CoachTest{

	 String[] browserSizes = {"1366x768"}; 
	 String [] layoutTags = {"all"};
	 	Map<String,String> url;
	    Map<String, String> products;
	    Map<String, String> users;
	    Map<String, String> shipping;
	    Map<String, String> creditCards;
	    Map<String, String> giftCards;
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void initializeTestData() {
			url = testData.get("BASE URL").get(0);
			shipping = testData
		            .get("GuestShippingDetails").get(0);
			users = testData
		            .get("Users").get(0);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 dsl.launchApplication(url.get("URL"));
		 Reporter.log("User Launched Coach Website");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_VerifyLandingPage() throws InterruptedException{
		 
		 dsl.verifyLandingPage();
		 dsl.verifySearchDisplayed();
		 dsl.mobile_verifyFooterSection();
		 dsl.mobile_verifyConnectWithCoachFunctionality(users.get("Username"));
//		 dsl.handleDontMissoutWindow();
		 Reporter.log("Landing page verifications done");
	}
	 

		@Test(groups = { "desktop", "mobile" })
		public void TestStep03_ClickOnBurgerButtonForMenu() {
			dsl.clickOnBurgerButtonForMenu();
			Reporter.log("User clicks on burger icon");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep04_ClickOnSignInAndNavigateToAccountsPage() {
			dsl.navigate_To_Registeration_Page_From_Landing_Page();
			Reporter.log("User is navigated to Accounts Page");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep05_ClickOnRegisterButton() {
			dsl.accountPage.clickOnRegisterButtonForMobile();
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep06_ClickOnRegisterANewUserForMobile() {
			dsl.clickOnRegisterANewUserForMobile(shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
			Reporter.log("User clicks on Registraion button to register");

		}
		

		@Test(groups = { "desktop", "mobile" })
		public void TestStep07_LogOutFromApplication() {
			dsl.logOutFromTheApplication();
			Reporter.log("User Logs Out From The Application");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep08_VerifyRegisteredUserIsAbleToLoginIntoCoach() throws InterruptedException {
			dsl.loginAsRegisteredUser(PropFileHandler.readProperty("emailAddress"), PropFileHandler.readProperty("password"));
			Reporter.log("Registered User login into the application");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep09_VerifyRegisteredUserIsAbleToSeeAccountMenuTabOptions(){
			dsl.verifyUserAccountMenuTabOptions();
			Reporter.log("Registered User Sees the different Account options in the top navigation bar");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep10_VerifyUserIsAbleToEditAccountSettings(){
			dsl.userGoesToAccountSettingsPage();
			dsl.editNameinAccountSetting(PropFileHandler.readProperty("password"));
			dsl.editAddressInAccountSettings();
			Reporter.log("Registered User edits Account Settings");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep11_LogOutFromApplication() {
			dsl.logOutFromTheApplication();
			Reporter.log("Registered User Logs Out From The Application");
		}
}
