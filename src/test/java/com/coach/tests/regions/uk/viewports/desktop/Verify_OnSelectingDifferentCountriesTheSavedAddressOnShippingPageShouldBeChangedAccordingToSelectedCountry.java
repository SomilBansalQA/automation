package com.coach.tests.regions.uk.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_OnSelectingDifferentCountriesTheSavedAddressOnShippingPageShouldBeChangedAccordingToSelectedCountry extends CoachTest {
	
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
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("Successfully login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}
	
	@Test(groups={"desktop","mobile"})
	 public void TestStep06_SelectViewShoppingBag(){
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep07_ChangeTheCountryFromFooter(){
		dsl.changeTheCountryFromFooter();
		dsl.clickOnShoppingBagIcon();
		dsl.verifyShippingAddressIsOfChangedCountry();
		Reporter.log("Verified that on selecting different countries the saved address on shipping page should be changed according to selected country");
	}
	
}
