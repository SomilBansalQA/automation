package com.coach.tests.regions.viewports.desktop;

import com.coach.tests.CoachTest;
import java.util.List;
import java.util.Map;

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

public class TestCase01_02_03_04_05_07_18_39And40_VerifyUserIsAbleToRegisterAndLoginIntoCoach extends CoachTest{

            Map<String,String> url;
	    Map<String, String> products;
	    Map<String, String> users;
	    Map<String, String> shipping;
	    Map<String, String> creditCards;
	    Map<String, String> giftCards;
	    
	    
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
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
	 public void TestStep02_VerifyLandingPage(){
		 dsl.closeCrossCookieIcon();
		 dsl.verifyLandingPage();
		 //dsl.verifylayout();
		 dsl.verifyTopNavigationBar();
		 dsl.verifySearchDisplayed();
		 dsl.verifyFooterSection();
		 dsl.scrollDownToBottom();
		 //dsl.verifyConnectWithCoachFunctionality(users.get("Username"));
		 Reporter.log("Landing page verifications done");
	}
	 
	 @Test(groups = { "desktop", "mobile" })
		public void TestStep03_NavigateToRegisterationPage() throws InterruptedException {
			
			dsl.navigate_To_Registeration_Page_From_Landing_Page();
			Reporter.log("User Navigates to Registeration Page From Landing Page");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep04_RegisterNewUserIntoCoach() {
			dsl.registerANewUser(shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
			Reporter.log("User registeres into Coach Application");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep05_LogOutFromApplication() {
			dsl.logOutFromTheApplication();
			Reporter.log("User Logs Out From The Application");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep06_VerifyRegisteredUserIsAbleToLoginIntoCoach() throws InterruptedException {
			dsl.loginAsRegisteredUser(PropFileHandler.readProperty("emailAddress"), PropFileHandler.readProperty("password"));
			Reporter.log("Registered User login into the application");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep07_VerifyRegisteredUserIsAbleToSeeAccountMenuTabOptions(){
			dsl.verifyUserAccountMenuTabOptions();
			Reporter.log("Registered User Sees the different Account options in the top navigation bar");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep08_VerifyUserIsAbleToEditAccountSettings(){
			dsl.userGoesToAccountSettingsPage();
			dsl.editNameinAccountSetting(PropFileHandler.readProperty("password"));
			dsl.editAddressInAccountSettings();
			Reporter.log("Registered User edits Account Settings");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep09_LogOutFromApplication() {
			dsl.logOutFromTheApplication();
			Reporter.log("Registered User Logs Out From The Application");
		}	 
}
