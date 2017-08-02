package com.coach.tests.region.uk.viewports.mobile;

import java.util.Map;

import com.coach.qa.automation.dsl.api.ProductSearch;
import com.coach.tests.CoachTest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstName_LastName_LimitIs30_Mobile extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	String country;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);

		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		dsl.closeCrossCookieIcon();
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnBurgerButtonForMenu() {
		dsl.clickOnBurgerButtonForMenu();
		Reporter.log("User clicks on burger icon");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButtonForMobile();
		dsl.verify_First_LastNameLimit_Is_30();
		Reporter.log("Verifying first and last name character limit 30 is succesful");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOnRegisterANewUserForMobile() {
		dsl.clickOnRegisterANewUserForMobile(shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
		Reporter.log("User clicks on Registraion button to register");
		dsl.topBanner.goToAccountSettingsPage();
		Reporter.log("User clicks on account setting page");
		dsl.verify_First_LastNameLimit_Is_30();
		Reporter.log("Verifying first and last name character limit 30 is succesful");

	}
	

	@Test(groups={"desktop","mobile"})
	public void TestStep06_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Selects_First_Product() {
    	dsl.selectFirstProduct(); 
		 Reporter.log("User selects the first Product");
	}
    
    @Test(groups = { "desktop", "mobile" })
	public void TestStep08_Add_The_Product_To_Bag() {
    	dsl.addTheProductToBag();
		 Reporter.log("User add the product to shopping bag");
	}
    
    @Test(groups = { "desktop", "mobile" })
	public void TestStep09_Check_Out_the_product() {
    	 dsl.checkoutTheProductFromBag();
    	 dsl.shipngpage.verify_First_LastNameLimit_Is_30();
		 Reporter.log("Verifying first and last name character limit 30 is succesful");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects first product the first product");

	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User moves the product to wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		dsl.clickOnEmailLink();
		dsl.wishlistpage.verify_First_LastNameLimit_Is_30();
		Reporter.log("Verifying first and last name character limit 30 is succesful");

	}
	
	
}
