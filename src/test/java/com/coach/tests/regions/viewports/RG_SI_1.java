package com.coach.tests.regions.viewports;

import java.lang.reflect.Method;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class RG_SI_1 extends CoachTest {

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
	public void TestStep03_AsertLabelsOnAccountPage() {
		dsl.accountPage.verifyLabelCreateAnAccount();
		dsl.accountPage.verifyLabelRegisterNow();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButton();
		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AssertLabelsForPasswordAndSignUp() {
		dsl.accountPage.verifyLabelPasswordMustBe();
		dsl.accountPage.verifyCheckBoxSignUpAndLabelYouAreSigningUp();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ClickSignUpWithOutFillingAnyData() {
		dsl.accountPage.clickOnSignUpButton();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_AssertErrorMessagesWhenUserClicksOnSignUpButtonWithoutEnteringAnyInformation() {
		dsl.accountPage.verifyErrorMessagesWhenUserClicksSignUpButtonWithoutEnteringAnyInformation();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_RegisterAnExistingUser() {
		dsl.accountPage.enterExistingUserInformation(shipping.get("FirstName"), shipping.get("LastName"),
				users.get("Username"), users.get("Username"), users.get("Password"), users.get("Password"));
		dsl.accountPage.clickOnSignUpButton();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_AssertErrorMessageForExistingUser() {
		dsl.accountPage.verifyErrorMessageForExistingUser();

	}

}
