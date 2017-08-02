package com.coach.tests.regions.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Verify_GiftMessage_And_ComplimentaryGiftBox extends CoachTest {

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
		products = testData.get("Products").get(2);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("User searches a product by it's style number");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Selects_First_Product() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the first product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product into the bag");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
		Reporter.log("User clicks on view shopping bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_VerifyGiftMessageErrorMessage() {
		dsl.verifyGiftMessageErrorMessage();
		Reporter.log("Verified GiftMessage Error Message");
	}

}
