package com.coach.tests.regions.uk.viewports;

import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		creditCards = testData.get("CardDetails").get(2);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {

		dsl.launchApplication(url.get("URL"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddTheProductToBag() {
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_CheckoutTheProductFromBag() {
		dsl.checkoutTheProductFromBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ShipingTheProductAndAddressVerification() {
		dsl.enterNewShipingDetails();
		dsl.verifyCurrentEnteredAddress();
		dsl.clickOnShippingTab();
		dsl.loginFromShippingPage(users.get("Username"),users.get("Password"));
        dsl.verifyAddressAfterAndBeforeLoginAreSame();
        dsl.verify_COACH_LogoRedirectsToHomepage();
        
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_VerifyAddressIsNotSavedMarked(){
		dsl.verifyAddressIsNotMarkedPrimary();
	}
	  
	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary(){
		dsl.verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary();
	}

}
