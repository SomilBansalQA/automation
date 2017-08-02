package com.coach.tests.regions.uk.viewports;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Italy_Verify_OptIn_CheckboxesIsDisplayed extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> products1;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
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
	public void TestStep02_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButton();
		Reporter.log("User clicks on Register Button");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Italy_VerifyObtinCheckboxMessage() throws InterruptedException {
		dsl.italy_verifyObtinCheckboxMessage();
		Reporter.log("ObtIn Checkbox message is displayed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Login_With_User_Credentials() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("Successfully login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		dsl.verifyPriceFromat("IT");
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		Reporter.log("User moves the product to wishlist");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ClickOnWishListFromHeader() throws InterruptedException {
		dsl.clickOnWishListFromHeader();
		dsl.clickOnEmailLink();
		dsl.wishlistpage.italy_verifyObtinCheckboxMessage();
		Reporter.log("ObtIn Checkbox message is displayed");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_SearchAProductFromLandingPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		dsl.searchProduct(products1.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_ClickOnNotifyMe() throws InterruptedException {
		dsl.clickOnNotifyMe();
		dsl.prodctdetails.italy_verifyObtinCheckboxMessage();
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("Verified ObtIn Checkbox message is displayed");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep14_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep15_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep16_CheckoutTheProductFromBag() throws InterruptedException {
		dsl.checkoutTheProductFromBag();
		dsl.paymentpage.italy_verifyObtinCheckboxMessage();
		Reporter.log("Verified ObtIn Checkbox message is displayed");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep17_Italy_VerifyObtInMessageAtFooter() throws InterruptedException{
		dsl.italy_VerifyObtInMessageAtFooter();
	}
}

