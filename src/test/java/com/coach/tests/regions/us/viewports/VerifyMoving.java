package com.coach.tests.regions.us.viewports;

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

public class VerifyMoving extends CoachTest{

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
				.get("Products").get(0);
		giftCards = testData
				.get("Gift Cards").get(2);
		shipping = testData
				.get("GuestShippingDetails").get(0);
		users = testData
				.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {

		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep02_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep03_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the firt product");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep04_AddTheProductToBag(){
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep05_CheckoutTheProductFromBag(){
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}

	//	 @Test(groups={"desktop","mobile"})
	//	 public void TestStep06_select_chekout_as_guest_button(){
	//		dsl.selectchekoutasguestbutton();
	//		Reporter.log("User checkout the product from Shopping Bag");
	//	}


	@Test(groups={"desktop","mobile"})
	public void TestStep07_ShipingTheProduct(){
		dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
		Reporter.log("User Shipped Product");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep08_MakePaymentUsingCoachGifts(){
		dsl.makePaymentUsingCoachGifts(giftCards.get("Number"),
				giftCards.get("Pin"), users.get("Username"));
		Reporter.log("Payment sucessfully");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep09_PlacedOrder(){
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep10_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("User reviews order");
	}


}
