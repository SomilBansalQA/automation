package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerifyRegisterUserIsAbleToShopAndCheckoutUsingPaypal extends CoachTest {

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
		products = testData.get("Products").get(0);
		giftCards = testData.get("Gift Cards").get(0);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		payPal = testData.get("Pay Pal").get(0);
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

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_CheckoutTheProductFromBag() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Click_On_Cancel_link_And_Verify_Billing_page_Is_Dispalyed() {
		dsl.selectPaymentMethodAsPaypala(payPal.get("Email"));
		dsl.clickOnCancelLinkOnPayPalWindowAndverifyClickingCancelOfPaypalWindowUserIsNavigatedBackToBillingPage();

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_MakePaymentUsingPayPal() {
		dsl.selectPaymentMethodAsPaypala(payPal.get("Email"));
		dsl.makePaymentUsingPayPal(payPal.get("Email"), payPal.get("Password"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_PlacedOrder() {
		dsl.placedOrder();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_ReviewOrder() {
		dsl.orderReview();

	}

}
