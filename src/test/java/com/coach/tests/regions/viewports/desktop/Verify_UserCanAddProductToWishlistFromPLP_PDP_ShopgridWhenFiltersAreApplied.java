package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_UserCanAddProductToWishlistFromPLP_PDP_ShopgridWhenFiltersAreApplied extends CoachTest {

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
	public void TestStep02_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("Successfully login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User moves the product to wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		dsl.verifyProductOnWishlistPage();
		dsl.removeTheProductFromWishlist();
		Reporter.log("Verified product can be added to wishlist from PDP");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Name"));
		Reporter.log("Found Search Result");

	}
	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User moves the product to wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		dsl.verifyProductOnWishlistPage();
		dsl.removeTheProductFromWishlist();
		Reporter.log("Verified product can be added to wishlist from PLP");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Name"));
		Reporter.log("Found Search Result");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_Verify_UserCanAddProductToWishlistFromShopGridWhenFiltersAreApplied() throws InterruptedException {
		dsl.verify_FilterContainerIsDisplayed();
		dsl.addProductToWishList();
		dsl.clickOnWishListFromHeader();
		dsl.verifyProductOnWishlistPage();
		dsl.removeTheProductFromWishlist();
		Reporter.log("Verified user can add product from PDP,PLP & Shopping Grid when filters are applied");
	}
}
