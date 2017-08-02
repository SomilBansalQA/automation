package com.coach.tests.regions.viewports;

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
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButtonForMobile();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_EnterInformationForNewUserAndSkipAddressPart() {
		dsl.accountPage.enterRegisterInformation();
		dsl.accountPage.clickOnSkip();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_Click_On_Account_Setting(){
		dsl.ClickOnAccountSetting();
		dsl.VerifyUserOnAccountEditPage();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep06_Verify_Gender_Field_On_Account_Page(){
		dsl.verifyGenderFieldOnAccountPage();
		
	}
	
	

	
	
	
	
	
	
		

	
}
