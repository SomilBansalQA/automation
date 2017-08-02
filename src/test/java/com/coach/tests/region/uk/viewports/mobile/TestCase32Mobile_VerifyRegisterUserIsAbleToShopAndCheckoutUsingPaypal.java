package com.coach.tests.region.uk.viewports.mobile;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.qa.automation.dsl.api.ProductSearch;
import com.coach.tests.CoachTest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestCase32Mobile_VerifyRegisterUserIsAbleToShopAndCheckoutUsingPaypal extends CoachTest {
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
	public void TestStep04_Mobile_Login_With_User_Credentials() {
		dsl.mobile_loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("User login using valid credentials");

	}
	@Test(groups={"desktop","mobile"})
	 public void TestStep05_SearchAProductFromLandingPage() throws UnirestException{
		 ProductSearch ps = new ProductSearch(dsl);
//		 dsl.searchProduct(ps.findProductByAvailable().name);
		 dsl.searchProduct(products.get("Style Number"));
		 Reporter.log("Found Search Result");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep06_SelectTheFirstProduct(){
		 dsl.selectFirstProduct(); 
		Reporter.log("User selects the firt product");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep07_AddTheProductToBag(){
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}
	 	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep08_CheckoutTheProductFromBag(){
		 dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}
//	 
//	 @Test(groups={"desktop","mobile"})
//	 public void TestStep06_select_chekout_as_guest_button(){
//		dsl.selectchekoutasguestbutton();
//		Reporter.log("User checkout the product from Shopping Bag");
//	}
	 
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep09_ShipingTheProduct(){
		 dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
		Reporter.log("User provides Shipping Information");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep10_MakePaymentUsingPayPal(){
		 dsl.selectPaymentMethodAsPayPalUK();
		 dsl.enterEmailAndClickedOnContinue(users.get("Username"));
		Reporter.log("User provides payment information");
	}
	 
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep11_PlacedOrder(){
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep12_ContinuePaypal(){
		dsl.continuePaypal();
		Reporter.log("Order Placed");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep13_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("Order Placed");
	}
}



