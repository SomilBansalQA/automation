package com.coach.tests.regions.viewports;

import java.util.Map;
import java.util.Random;

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

public class Verify_OrderTotalUpdatationOnChangingShippingMethod extends CoachTest {

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
	public void TestStep06_Change_Shipping_Method() {
		dsl.change_Shipping_Method(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));

	}

}
