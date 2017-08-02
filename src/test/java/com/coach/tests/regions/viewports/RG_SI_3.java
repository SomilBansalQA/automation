package com.coach.tests.regions.viewports;

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
import com.qait.automation.utils.YamlReader;


public class RG_SI_3 extends CoachTest{

	 Map<String,String> url;
	    Map<String, String> products;
	    Map<String, String> users;
	    Map<String, String> shipping;
	    Map<String, String> creditCards;
	    Map<String, String> giftCards;
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 public void start_test_session() {
			url = testData.get("BASE URL").get(0);
			products = testData
		            .get("Products").get(0);
			users = testData
		            .get("Users").get(0);
			shipping = testData
		            .get("GuestShippingDetails").get(0);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 	dsl.launchApplication(url.get("URL"));
			Reporter.log("User Launched Coach Website");
	     
	}
	 
	 @Test(groups = { "desktop", "mobile" })
		public void TestStep02_ClickOnSignInAndNavigateToAccountsPage() {
			dsl.navigate_To_Registeration_Page_From_Landing_Page();
			Reporter.log("User Navigates to Account Page From Landing Page");
		}
	 
	
	 @Test(groups = { "desktop", "mobile" })
		public void TestStep03_ClickOnRegisterButton() {
			dsl.accountPage.clickOnRegisterButton();
			Reporter.log("User clicks on Register Button");
		}
	 	
	@Test(groups = { "desktop", "mobile" })
		public void TestStep04_EnterWrongInformationInRegisterationForm() {
			dsl.accountPage.enterExistingUserInformation("111111","2222222", "abcdef@yahoo.com","altavista@yahoo.com","1234","4321");
			dsl.accountPage.clickOnSignUpButton();
			Reporter.log("User enters wrong information and clicks on Sign Up Button");
		}
		
		@Test(groups = { "desktop", "mobile" })
		public void TestStep05_AssertErrorMessageForWrongValuesInRegistrationForm() {
			dsl.accountPage.verifyErrorMessageForWrongValuesInRegistrationForm();
			Reporter.log("User verifies error message for incorrect values registeration with an existing email");
		}
		
		


}
