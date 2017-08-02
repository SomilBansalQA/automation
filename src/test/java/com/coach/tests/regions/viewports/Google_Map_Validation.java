package com.coach.tests.regions.viewports;

import com.coach.tests.CoachTest;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google_Map_Validation extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(0);
		shipping = testData.get("GuestShippingDetails").get(1);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Go_To_Store_Locator_Page_From_Footers() {
		dsl.scrollDownToBottom();
		dsl.goToStoreLocatorPageFromFooter();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Search_Store_Using_Zip_Code() {
		dsl.searchStoreUsingZipCode("10003");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Click_And_Verify_View_Map() {
		dsl.storeLocator.verifyAddressAndTelephoneOnstorePage();
		dsl.storeLocator.clickOnViewMap();
		dsl.storeLocator.verifyUserClickedOnViewMap();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Close_And_Verify_View_Map_Is_Closed() {
		dsl.storeLocator.clickOnCloseButtonForGoogleMap();
		dsl.storeLocator.verifyUserClosedViewMap();
	}

}
