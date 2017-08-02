package com.coach.tests.regions.viewports.mobile;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase37Mobile_VerifyUserCanMoveProductToWishlist extends CoachTest {

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
		Reporter.log("User selects the first product");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User adds the product into wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOnWishListFromHeader() {
		dsl.clickOnWishListFromHeader();
		Reporter.log("User clicks on wishlist link from header");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_NavigateToAccountPageFromWishListPage() {
		dsl.navigateToAccountPageFromWishListPage();
		Reporter.log("User navigates to Accounts page from wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_ClickOnBurgerButtonForMenu() {
		dsl.clickOnBurgerButtonForMenu();
		Reporter.log("User clicks on burger icon");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_Mobile_Login_With_User_Credentials() {
		dsl.mobile_loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("User login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_GoToWishListInAccountSettings() {
		dsl.navigateToWishList();
		Reporter.log("User navigates to wishlist page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_DeleteProductFromWishList() {
		dsl.deleteProductFromWishList();
		Reporter.log("User removes the product from wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_LogOutFromApplication() {
		dsl.logOutFromTheApplication();
		Reporter.log("User logs out from the application");

	}

}
