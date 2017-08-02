package com.coach.tests.regions.uk.viewports;

import java.util.Map;
import java.util.Random;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.coach.qa.automation.dsl.api.ProductSearch;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qait.automation.DSL;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

/**
 *
 * @author Anmol <anmolbagga@qainfotech.com>
 */

public class TestCase11_12_13_14_15_And_16_VerifyGuestUserIsAbleToShopAndCheckoutUsingMaestro16Card extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> products1;
	Map<String, String> products2;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		products1 = testData.get("Products").get(1);
		products2 = testData.get("Products").get(2);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		Random r = new Random();
		int low = 0;
		int high = 11;
		int credit = r.nextInt(high - low) + low;
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
	public void TestStep05_SearchAProductFromLandingPage() {
		dsl.searchProduct(products1.get("Style Number"));
		Reporter.log("Found Search Result");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_SearchAProductFromLandingPage() {
		dsl.searchProduct(products2.get("Style Number"));
		Reporter.log("Found Search Result");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_VerifyProductsAddedInCart(){
		dsl.verifyProductsAddedInCart();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checks out the product and proceed for purchase");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep14_VerifyRegisteredSectionFromShippingPage() {
		dsl.VerifyForgotPasswordLinkFromSignInpage();
		dsl.signInFromShippingpage("abs1234567@qa.com", users.get("Password"));
		dsl.verifyUserCannotSignFromInValidUsername();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep15_Enter_Shipping_Details() {
		dsl.giftCardNotDisplayedOnShippingPageForEU();
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User enters shipping details");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep16_Enter_Payment_Details() {
		dsl.makePaymentFromCreditCardUK(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
		dsl.linkGiftCardNotDisplayedOnOrderReviewPage();
		Reporter.log("The credit card type is " + creditCards.get("Type"));
		Reporter.log("User enters payment details");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep17_Place_Order() {
		dsl.placedOrder();
		Reporter.log("User places the order");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep18_ReviewOrder() {
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

}

