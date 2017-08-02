package com.coach.tests.regions.viewports.mobile;

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
import com.qait.automation.utils.YamlReader;

public class TestCase52_53_54_VerifyUserCanAddEditMonogram extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> payPal;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_sestorefrontssion() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(4);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
		creditCards = testData.get("CardDetails").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");

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
	public void TestStep04_VerifyMonoGramLinkOnPDP() {
		dsl.verifyAndNavigateToLinkAddAMonogram();
		Reporter.log("User Navigated to Add A Monogram Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddMonoGram() {
		dsl.addAMonogramPage();
		Reporter.log("User Adds A Monogram Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ProceedToCheckOut() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User proceeds to checkout the product from Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_ShipingTheProduct() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User Shipped Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_MakePaymentUsingCoachCreditCard() {
		dsl.makePaymentUsingcards(creditCards.get("Number"), creditCards.get("CVV"), users.get("Username"));
		Reporter.log("Payment sucessfully");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_PlacedOrder() {
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_ReviewOrder() {
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

}
