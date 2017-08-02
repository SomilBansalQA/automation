package com.coach.tests.regions.viewports;

import java.util.Map;
import java.util.Random;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class TestCase24_25_26_27_28_29VerifyRegisterUserIsAbleToShopAndCheckOutUsingCreditCards extends CoachTest{

	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData
				.get("Products").get(1);
		shipping = testData
				.get("GuestShippingDetails").get(0);
		users = testData
				.get("Users").get(0);
		Random r = new Random();
		int low = 0;
		int high = 5;
		int credit = r.nextInt(high-low) + low;
		creditCards = testData
				.get("CardDetails").get(credit);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User opens Coach Website");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep02_Login_With_User_Credentials(){
		dsl.loginAsRegisteredUser(users.get("Username"),users.get("Password"));
		Reporter.log("User login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("User searches the Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Selects_First_Product() {
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the first Product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();
		Reporter.log("User add the product to shopping bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checks out the product and proceed for purchase");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Enter_Payment_Details(){
		dsl.makePaymentUsingcards(creditCards.get("Number"),creditCards.get("CVV"),users.get("Username"));
		Reporter.log("The credit card type is " +creditCards.get("Type"));
		Reporter.log("User enters payment details");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Place_Order(){
		dsl.placedOrder();
		Reporter.log("User places the order");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep09_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

//	@Test(groups = { "desktop", "mobile" })
//	public void TestStep10_Delete_CreditCard() {
//		dsl.userGoesToAccountSettingsPage();
//		dsl.deleteSavedCard();
//		Reporter.log("User places the order");
//	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_Logout_From_The_Application(){
		dsl.logOutFromTheApplication();
		Reporter.log("User places the order");
	}
}

