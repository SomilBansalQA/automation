package com.coach.tests.regions.viewports;

import com.coach.tests.CoachTest;
import com.coach.tests.CoachTest;
import java.util.Map;
import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verfify_Viewed_Items_On_PDP  extends CoachTest{

	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> products1;


	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData
				.get("Products").get(0);
		products1 = testData
				.get("Products").get(4);
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
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
		dsl.searchProduct(products1.get("Style Number"));
		dsl.selectFirstProduct();
		dsl.addTheProductToBag();
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyArrowsForScrollFunctionalityForMiniCart() {
		dsl.verifyArrowsForScrollFunctionalityForMiniCart();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Search_A_Product_And_Verify_Recently_Viewed_Items_Are_Displayed() {
		dsl.prodctdetails.verifyRecentlyViewedItemsAredisplayed();
	}









}
