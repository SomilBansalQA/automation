package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class Verify_GuestUserCanCheckoutUsingGiftCardAndPayPal extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> payPal;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(1);
		giftCards = testData.get("Gift Cards").get(1);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		payPal = testData.get("Pay Pal").get(0);
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
		dsl.selectViewShoppingBag();
		dsl.increaseQuantityOfProduct();
		dsl.verifyPriceChange();
		dsl.checkOutAndProceed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifySaveThisCC_BelowCreateAnAccount() throws InterruptedException {
		dsl.verifySaveThisCC_BelowCreateAnAccount();
		dsl.verify_WhatIsThisIconInPaymentPage();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_MakePaymentUsingGiftCardAndPayPal() {
		dsl.makePaymentUsingGiftCard(giftCards.get("Number"), giftCards.get("Pin"), users.get("Username"));
		dsl.selectPaymentMethodAsPaypala(payPal.get("Email"));
		dsl.makePaymentUsingPayPal(payPal.get("Email"), payPal.get("Password"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_PlacedOrder() {
		dsl.placedOrder();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_ReviewOrder() {
		dsl.orderReview();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
	}
}
