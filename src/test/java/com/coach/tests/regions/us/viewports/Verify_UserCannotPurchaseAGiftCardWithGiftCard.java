package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_UserCannotPurchaseAGiftCardWithGiftCard extends CoachTest {

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
		giftCards = testData.get("Gift Cards").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnGiftCard() {
		dsl.clickOnGiftCard();
		Reporter.log("User clicks on Gift Card");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_EnterGiftCardAmount() {
		dsl.enterGiftCardAmount();
		Reporter.log("User enters Gift Card Amount");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddTheProductToBag() {
		dsl.addTheGiftCardToBag();
		Reporter.log("User adds the Gift Card to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_CheckoutTheProductFromBag() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Verify_ErrorMessage() {
		dsl.makePaymentUsingCoachGiftCard(giftCards.get("Number"), giftCards.get("Pin"), users.get("Username"));
		dsl.verifyGifCardErrorMessage();
		Reporter.log("Verified Coach gift Card cannot be purchased from Gift Card");
	}

}
