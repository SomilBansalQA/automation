package com.coach.tests.regions.us.viewports.desktop;

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


public class RG_SI_2_Favourite_Store extends CoachTest{

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
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_Go_To_Store_Locator_Page_From_Footers(){
		 	dsl.scrollDownToBottom();
		 	dsl.goToStoreLocatorPageFromFooter();
			Reporter.log("User goes to Store Locator Page");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep03_Search_Store_Using_Zip_Code(){
		 	dsl.searchStoreUsingZipCode(shipping.get("Zip"));
			Reporter.log("User Search Store Using Zip Code");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep04_click_On_First_Store_Star_Icon(){
		 	dsl.storeLocator.clickOnFirstStoreStaricon();
			Reporter.log("User clicks on the Star Icon of the First Store");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep05_verify_Account_Page(){
		 	dsl.accountPage.verifyLabelCreateAnAccount();
			Reporter.log("User lands on Account Page");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep06_click_On_Register_Button(){
		 	dsl.accountPage.clickOnRegisterButton();
			Reporter.log("User clicks on Register Button");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep07_enter_Register_Information(){
		 	dsl.accountPage.enterRegisterInformation();
			Reporter.log("User enters Registration Information");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep08_Assert_Label_Fevorite_Store(){
		 	dsl.storeLocator.assertLabelFavoriteStore();
			Reporter.log("User verifies the Label for Favorite Store");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep09_Log_Out_From_The_App(){
		 	dsl.logOutFromTheApplication();
			Reporter.log("User logs out from the application");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep10_VerifyForgotPasswordFunctionality(){
		 dsl.accountPage.clickOnSignInButton();
			dsl.accountPage.clickForgotPassword();
			dsl.accountPage.assertLabelPasswordRequest();
			dsl.accountPage.enterEmailForForgotPasswordAndNavigateBackToAccountPage("anmolbagga5@gmail.com");
			Reporter.log("User verifies the Forgot Password Link and Functionality");
	}

}
