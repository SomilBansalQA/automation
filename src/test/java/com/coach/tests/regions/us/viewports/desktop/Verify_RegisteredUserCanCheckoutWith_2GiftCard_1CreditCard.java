package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_RegisteredUserCanCheckoutWith_2GiftCard_1CreditCard extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCard1;
	Map<String, String> giftCard2;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(4);
		creditCards = testData.get("CardDetails").get(4);
		giftCard1 = testData.get("Gift Cards").get(1);
		giftCard2 = testData.get("Gift Cards").get(2);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddTheProductToBag() {
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_CheckoutTheProductFromBag() {
		dsl.selectViewShoppingBag();
		dsl.increaseQuantityOfProduct();
		dsl.verifyPriceChange();
		dsl.checkOutAndProceed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_MakePaymentUsingGiftCardAndCreditCard() {
		dsl.makePaymentUsingGiftCard(giftCard1.get("Number"), giftCard1.get("Pin"), users.get("Username"));
		dsl.addAnotherCard();
		dsl.makePaymentUsingGiftCard(giftCard2.get("Number"), giftCard2.get("Pin"), users.get("Username"));
		dsl.makePaymentUsingcards(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_PlacedOrder() {
		dsl.placedOrder();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ReviewOrder() {
		dsl.orderReview();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
	}

}
