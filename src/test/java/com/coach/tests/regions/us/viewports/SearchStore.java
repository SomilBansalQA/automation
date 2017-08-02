package com.coach.tests.regions.us.viewports;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class SearchStore extends CoachTest{

	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> shipping;
	String country="ARGENTINA";
	String address = "randomAdress";
	String city = "random city";
	String PostalCode = "10000";
	String state = "ARUBA";

	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData
				.get("Products").get(0);
		shipping = testData
	            .get("GuestShippingDetails").get(0);
	}
	
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Go_To_Store_Locator_Page_From_Footers(){
		dsl.scrollDownToBottom();
		dsl.goToStoreLocatorPageFromFooter();
	}
	
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_Verify_Store_Results_Page_US(){
		dsl.searchStoreUsingZipCode(shipping.get("Zip"));
		dsl.verifyStorePage();
	}
	
	
	@Test(groups={"desktop","mobile"})
	public void TestStep04_Click_On_International_Tab(){
		dsl.storeLocator.clickOnRedoSearch();
		
		dsl.storeLocator.clickOnInternationalTab();
		dsl.storeLocator.verifyUserClickedOnInternationalTab();
	}
	
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_Select_Country_Having_Store(){
		dsl.storeLocator.selectCountryAndSearchStore(country);
		dsl.storeLocator.verifyCountryIsSelected(country);
	}
	
//	@Test(groups = {"desktop","mobile"})
//	public void TestStep06_Click_On_Directions_Link(){
//		dsl.storeLocator.cLickOnDirectionsLink();
//		dsl.storeLocator.EnterWrongAdressForError(address,city,state,PostalCode);
//	}
	

}
