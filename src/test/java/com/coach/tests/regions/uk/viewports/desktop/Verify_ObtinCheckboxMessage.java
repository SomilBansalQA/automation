package com.coach.tests.regions.uk.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_ObtinCheckboxMessage extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> products1;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(4);
		products1 = testData.get("Products").get(7);
		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Verify_Connect_With_Coach_For_UK() {
		dsl.verifyConnectWithCoachFunctionalityUK(users.get("Username"));
		Reporter.log("Successfully Launched Coach Website");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButton();
		Reporter.log("User clicks on Register Button");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyObtinCheckboxMessage() throws InterruptedException {
		dsl.verifyObtinCheckboxMessage();
		Reporter.log("ObtIn Checkbox message is displayed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("Successfully login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User moves the product to wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_ClickOnWishListFromHeader() throws InterruptedException {
		dsl.clickOnWishListFromHeader();
		dsl.clickOnEmailLink();
		dsl.wishlistpage.verifyObtinCheckboxMessage();
		Reporter.log("Verified ObtIn Checkbox message is displayed");
	}
	
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_SearchAProductFromLandingPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		dsl.searchProduct(products1.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_ClickOnNotifyMe() throws InterruptedException {
		dsl.clickOnNotifyMe();
		dsl.prodctdetails.verifyObtinCheckboxMessage();
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("Verified ObtIn Checkbox message is displayed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep14_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep15_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep16_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep17_CheckoutTheProductFromBag() throws InterruptedException {
		dsl.checkoutTheProductFromBag();
		dsl.paymentpage.verifyObtinCheckboxMessage();
		Reporter.log("Verified ObtIn Checkbox message is displayed");
	}

}