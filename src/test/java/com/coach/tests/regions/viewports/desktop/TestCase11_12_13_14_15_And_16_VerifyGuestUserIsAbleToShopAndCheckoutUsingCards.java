package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import java.util.Random;
import com.coach.tests.CoachTest;

import org.testng.Reporter;
import org.testng.annotations.*;

public class TestCase11_12_13_14_15_And_16_VerifyGuestUserIsAbleToShopAndCheckoutUsingCards extends CoachTest {

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
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		Random r = new Random();
		int low = 0;
		int high = 5;
		int credit = r.nextInt(high - low) + low;
		creditCards = testData.get("CardDetails").get(credit);
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
	public void TestStep03_Selects_First_Product() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Verify_ValidEmailOnShippingPage() {
		dsl.shipngpage.clickOnForgotPasswordLink();
		dsl.verify_ValidEmailOnShippingPage();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Verify_InvalidEmailOnShippingPage() {
		dsl.shipngpage.clickOnForgotPasswordLink();
		dsl.verify_InvalidEmailOnShippingPage();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_VerifyLoginFromShippingPageDoesnotHaveRememberMeCheckbox() {
		dsl.verifyLoginFromShippingPageDoesnotHaveRememberMeCheckbox();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_Enter_Payment_Details() {
		dsl.makePaymentUsingcards(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
		Reporter.log("The credit card type is " + creditCards.get("Type"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_Place_Order() {
		dsl.placedOrder();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_ReviewOrder() {
		dsl.orderReview();

	}

}
