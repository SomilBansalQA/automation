package com.coach.tests.regions.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_MonogrammingPageAndShoppingBagForMonogramming extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	static String color;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(4);

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
	public void TestStep03_VerifyAddAMonogramIsUpdatedToComplimentaryMonogram() {
		dsl.verifyAddAMonogramIsUpdatedToComplimentaryMonogram();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyMonoGramLinkOnPDP() {
		dsl.verifyAndNavigateToLinkAddAMonogram();
		Reporter.log("User Navigated to Add A Monogram Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyMonogrammingPage() throws InterruptedException {
		dsl.verifyMonogrammingPage();
		dsl.verify_MultipleColorVarientsAreNotPresentInAddAMonogramWindow(color);
		dsl.verifyStampsAreWorking();
		Reporter.log("User verifies monogramming page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_AddMonogramProductToShoppingBag() {
		dsl.AddMonogramProductToShoppingBag();
		Reporter.log("Monogram product is added to Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifyUserIsNotAbleToIncreaseQuantityOfMonogrammingProduct() {
		dsl.verifyUserIsNotAbleToIncreaseQuantityOfMonogrammingProduct();
		Reporter.log("User Is  Not Able To Increase Quantity of Monogramming Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_AddGiftMessage() {
		dsl.verifyAddAGiftMessage();
		Reporter.log("Gift Message is added");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_VerifyPriview() {
		dsl.verifyPriview();
		Reporter.log("verified preview");

	}

}
