package com.coach.tests.regions.uk.viewports;

import java.util.Map;
import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.qa.automation.dsl.api.ProductSearch;
import com.coach.tests.CoachTest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DE_VerifyGuestUserCanMakePaymentThroughSOFORT extends CoachTest {

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
		creditCards = testData.get("CardDetails").get(1);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		dsl.closeCrossCookieIcon();
		Reporter.log("User opens Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Search_A_Product() throws UnirestException {
		ProductSearch ps = new ProductSearch(dsl);
		// dsl.searchProduct(ps.findProductByAvailable().name);
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("User searches the Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Selects_First_Product() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the first Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();
		Reporter.log("User add the product to shopping bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checks out the product and proceed for purchase");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_VerifyRegisteredSectionFromShippingPage() {
		dsl.VerifyForgotPasswordLinkFromSignInpage();
		dsl.signInFromShippingpage("abs1234567@qa.com", users.get("Password"));
		dsl.verifyUserCannotSignFromInValidUsername();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Enter_Shipping_Details() {
		dsl.giftCardNotDisplayedOnShippingPageForEU();
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User enters shipping details");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Verify_SofortIconIsDisplayed() {
		dsl.verify_SofortIconIsDisplayed();
		dsl.enterEmailAndClickedOnContinue(users.get("Username"));
		Reporter.log("Verified SOFORT icon is displayed at payment page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_PlacedOrder() {
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_ContinueSofort() {
		dsl.continueSofort();
		Reporter.log("User clicks on continue button");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_ReviewOrder() {
		dsl.orderReview();
		Reporter.log("User Reviews the order");
	}

}
