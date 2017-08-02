package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_MultipleProductCheckoutsAlongWithOnePreorderUsingDinersCard extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> product1;
	Map<String, String> product2;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> shipping1;
	Map<String, String> creditCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(1);
		product1 = testData.get("Products").get(2);
		product2 = testData.get("Products").get(8);
		creditCards = testData.get("CardDetails").get(2);

		shipping = testData.get("GuestShippingDetails").get(0);
		shipping1 = testData.get("GuestShippingDetails").get(1);
		users = testData.get("Users").get(0);
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
		dsl.verifyPreOrderBagInCartPage();
		dsl.increaseQuantityOfProduct();
		dsl.checkOutAndProceed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_MakePaymentUsingGiftCardAndCreditCard() {
		dsl.makePaymentUsingcardsForPayment(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep14_ChangeTheBillingAddress() throws InterruptedException {
		dsl.clickOnBillingAddressCheckbox();
		dsl.changeTheBillingAddress(shipping1.get("FirstName"), shipping1.get("LastName"), shipping1.get("StreetAddress"),
				shipping1.get("Country"), shipping1.get("Zip"), shipping1.get("City"), shipping1.get("PhoneNumber"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep15_PlacedOrder() {
		dsl.verifyShippingAddressAndBillingAddressAreDifferent();
		dsl.placedOrder();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep16_ReviewOrder() {
		dsl.orderReview();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep17_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
	}

}
