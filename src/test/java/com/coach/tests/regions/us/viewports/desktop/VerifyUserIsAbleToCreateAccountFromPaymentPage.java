package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class VerifyUserIsAbleToCreateAccountFromPaymentPage extends CoachTest{
	String username;
	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> payPal;

	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData
				.get("Products").get(0);		
		creditCards = testData.get("CardDetails").get(3);
		shipping = testData
				.get("GuestShippingDetails").get(0);
		users = testData
				.get("Users").get(0);
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){		 
		dsl.launchApplication(url.get("URL"));


	}

	@Test(groups={"desktop","mobile"})
	public void TestStep02_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Style Number"));


	}

	@Test(groups={"desktop","mobile"})
	public void TestStep03_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the firt product");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep04_AddTheProductToBag(){
		dsl.addTheProductToBag();

	}
	@Test(groups={"desktop","mobile"})
	public void TestStep05_SelectViewShoppingBag(){
		dsl.selectViewShoppingBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));

	}

	@Test(groups = {"desktop","mobile"})
	public void TestStep08_CreateAccountFromPaymentPage() {
		username=dsl.createAccountFromPaymentPage(creditCards.get("Number"), creditCards.get("CVV"), users.get("Password"));

	}


	@Test(groups={"desktop","mobile"})
	public void TestStep09_PlacedOrder(){
		dsl.placedOrder();

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep10_ReviewOrder(){
		dsl.orderReview();

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep11_Verify_User_Is_Created_From_Payment_Page(){
		dsl.userGoesToAccountSettingsPage();
		dsl.verifyUserOnAccountPage();
	}

	




}
