package com.coach.tests.regions.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase37_VerifyUserCanMoveProductToWishlist extends CoachTest {

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
		products = testData.get("Products").get(0);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("Add the product to bag");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		Reporter.log("Click on wishlist from header");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_NavigateToAccountPageFromWishListPage() {
		dsl.navigateToAccountPageFromWishListPage();
		Reporter.log("Navigate to account page from wishlist page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_LoginWithRegisteredUser() {
		dsl.accountPage.loginWithRegisteredUser(users.get("Username"), users.get("Password"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		dsl.clickOnEmailLink();
		dsl.enterEmailAFriendInformation();
		Reporter.log("Verified Send to a friend link");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_DeleteProductFromWishList() {
		dsl.deleteProductFromWishList();
		Reporter.log("Delete the product from wishlist");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
		Reporter.log("Log out");

	}

}
