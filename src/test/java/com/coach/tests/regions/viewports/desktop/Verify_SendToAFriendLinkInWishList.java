package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Verify_SendToAFriendLinkInWishList extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;

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
		dsl.clickOnEmailLink();
		dsl.enterEmailAFriendInformation();
		dsl.removeTheProductFromWishlist();

	}
	
}
