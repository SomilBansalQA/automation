package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_CheckoutsUsing3GC_PaypalAlongWithBackorderProduct extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> product1;
	Map<String, String> product2;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> payPal;
	Map<String, String> giftCard1;
	Map<String, String> giftCard2;
	Map<String, String> giftCard3;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(2);
		product1 = testData.get("Products").get(4);
		product2 = testData.get("Products").get(7);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		payPal = testData.get("Pay Pal").get(0);
		giftCard1 = testData.get("Gift Cards").get(1);
		giftCard2 = testData.get("Gift Cards").get(3);
		giftCard3 = testData.get("Gift Cards").get(5);
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
	public void TestStep08_SearchAProductFromLandingPage() {
		dsl.searchProduct(product2.get("Style Number"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_AddTheProductToBag() {
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_CheckoutTheProductFromBag() throws InterruptedException {
		dsl.selectViewShoppingBag();
		dsl.verifyBackOrderBagInCartPage();
		dsl.increaseQuantityOfProduct();
		dsl.verifyPriceChange();
		dsl.checkOutAndProceed();
		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_MakePaymentUsingGiftCardAndCreditCard() {
		dsl.makePaymentUsingGiftCard(giftCard1.get("Number"), giftCard1.get("Pin"), users.get("Username"));
		dsl.addAnotherCard();
		dsl.makePaymentUsingGiftCard(giftCard2.get("Number"), giftCard2.get("Pin"), users.get("Username"));
		dsl.makePaymentUsingGiftCard(giftCard3.get("Number"), giftCard3.get("Pin"), users.get("Username"));
		dsl.makePaymentUsingPayPal(payPal.get("Email"), payPal.get("Password"));
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
