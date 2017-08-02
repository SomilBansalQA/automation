package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerifyGuestUserCanCheckoutWithCCandGCForMonogrammedMonoWithGiftBoxMessage extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> products1;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(2);
		products1 = testData.get("Products").get(8);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);
		creditCards = testData.get("CardDetails").get(0);
		giftCards = testData.get("Gift Cards").get(2);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddMonoGram() {
		dsl.verifyAndNavigateToLinkAddAMonogram();
		dsl.addAMonogramPage();
		Reporter.log("User Adds A Monogram Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
		dsl.searchProduct("54052");
		dsl.selectFirstProduct();
		dsl.verifyAndNavigateToLinkAddAMonogram();
		dsl.addAMonogramPage();
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
		dsl.searchProduct(products1.get("Style Number"));
		dsl.selectFirstProduct();
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_AddGiftBoxAndGiftMessageOnProduct2() {
		dsl.addGiftBoxAndGiftMessageOnProduct2();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_CheckoutTheProductFromBag() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User Shipped Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_MakePaymentUsingGiftCardAndCreditCard() {
		dsl.makePaymentUsingGiftCard(giftCards.get("Number"), giftCards.get("Pin"), users.get("Username"));
		dsl.makePaymentUsingcards(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep14_PlacedOrder() {
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep15_ReviewOrder() {
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep16_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
		Reporter.log("User Logs Out From The Application");
	}
}
