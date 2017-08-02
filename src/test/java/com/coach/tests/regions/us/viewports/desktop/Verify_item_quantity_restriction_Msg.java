package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_item_quantity_restriction_Msg extends CoachTest{
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	String quantity="5";

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(3);

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
	public void TestStep03_Verify_Error_msg_displayed_after_item_exceeds_quantity_restriction() {
		//dsl.increaseQuantityOfProductPDPpage(quantity);
		dsl.addTheProductToBag();
		//dsl.prodctdetails.verifyErrorMsgDisplayedAfterItemExceedsQuantityRestriction();
	}
	
}
