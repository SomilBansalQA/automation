package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import java.util.Random;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class VerifyallusVerifyAllUserEnteredDataOnTheShippingPagePersistIfUserDoesNotHaveShippingAddressStored extends CoachTest {
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(1);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(10) ;
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Selects_First_Product() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Sign_In_From_Shipping_page() {
		dsl.clickOnShippingTab();
		dsl.signInFromShippingpage(users.get("Username"), users.get("Password"));
		dsl.verifyUserIsAbleToSignIn();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_Verify_Entered_data_is_shown_for_user_having_no_address_saved() {
		dsl.verifyEnteredDataIsShownForUserHavingNoAddresSaved(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"));
	}

}
