package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerificationOfClearAllFilterForShopGrid extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;
	
	String breadCrumeValue="Bags";
	String filter="Red";
	String filter2="Beige";
	String clearButton="CLEAR X";

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(1);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");

	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SelectViewAllForBagsForWomen() {
		dsl.selectViewAllForBagsForWomen();
		dsl.verifyShopGridPage();
		Reporter.log("User selects View All from Women Section");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_VerifyAllTheShopGridFilters() {
		dsl.verifyShopGridFilter();
		dsl.verifyBreadCrumAndViewAllHeader(breadCrumeValue);
		
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ApplyColorFromColorFilterAndVerifySubFilter() {
		dsl.applyColorFromColorFilterForProductAndVerifySubFilter(filter,clearButton);
		Reporter.log("User selects View All from Women Section");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_verifySelectedfiltersShouldCleared() {
		dsl.verifySelectedfiltersShouldCleared();
		Reporter.log("User clicks on clear button and selected filter  cleared");
	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SelectFilterAndValidateFilterCount() {
		dsl.SelectFilterAndValidateFilterHeadercount(filter,filter2);
		
	}
	
	
	

}
