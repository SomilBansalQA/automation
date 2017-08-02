package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_GuestUserCanCheckoutWith_2giftCards_1CreditCardHavingOnePreorderProduct extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> product1;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCard1;
	Map<String, String> giftCard2;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(2);
		product1 = testData.get("Products").get(8);
		creditCards = testData.get("CardDetails").get(4);
		giftCard1 = testData.get("Gift Cards").get(1);
		giftCard2 = testData.get("Gift Cards").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_SearchAProductFromLandingPage() {
		dsl.searchProduct(product1.get("Style Number"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_AddTheProductToBag() {
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_CheckoutTheProductFromBag() throws InterruptedException {
		dsl.selectViewShoppingBag();
		dsl.increaseQuantityOfProduct();
		dsl.verifyPreOrderBagInCartPage();
		dsl.verifyPriceChange();
		dsl.checkOutAndProceed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User enters shipping details");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_MakePaymentUsingGiftCardAndCreditCard() {
		dsl.makePaymentUsingGiftCard(giftCard1.get("Number"), giftCard1.get("Pin"), users.get("Username"));
		dsl.addAnotherCard();
		dsl.makePaymentUsingGiftCard(giftCard2.get("Number"), giftCard2.get("Pin"), users.get("Username"));
		dsl.makePaymentUsingcards(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_PlacedOrder() {
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_ReviewOrder() {
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
		Reporter.log("User Logs Out From The Application");
	}

}
