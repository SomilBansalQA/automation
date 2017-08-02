package com.coach.tests.regions.uk.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_CityIsMappedWithZipCodeAndShowsNoErrorOnAccountPage extends CoachTest{

	Map<String,String> url;
	Map<String, String> shipping;
	Map<String, String> users;
	
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
		Reporter.log("Successfully Launched Coach Website");

	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Login_With_User_Credentials(){
		dsl.loginAsRegisteredUser(users.get("Username"),users.get("Password"));
		Reporter.log("Successfully login using valid credentials");

	}	
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_Verify_CityIsMappedWithZipCodeAndShowsNoErrorOnAccountPage(){
		dsl.userGoesToAccountSettingsPage();
		dsl.goToAddressBook();
		dsl.clickOnAddANewAddress();
		dsl.enterShippingAddress(shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
	}
	
}
