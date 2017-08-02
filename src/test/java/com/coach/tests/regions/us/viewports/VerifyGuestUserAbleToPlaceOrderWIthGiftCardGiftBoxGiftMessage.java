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

public class VerifyGuestUserAbleToPlaceOrderWIthGiftCardGiftBoxGiftMessage extends CoachTest  {

	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> products1;
	Map<String, String> products2;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		products1 = testData.get("Products").get(1);
		products2 = testData.get("Products").get(2);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);
		creditCards = testData.get("CardDetails").get(0);
		giftCards = testData.get("Gift Cards").get(5);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
		dsl.searchProduct(products1.get("Style Number"));
		dsl.selectFirstProduct();
		dsl.addTheProductToBag();
	}
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
		dsl.searchProduct(products2.get("Style Number"));
		dsl.selectFirstProduct();
		dsl.addTheProductToBag();
	}

	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_AddGiftBoxForProduct1AndGiftMessageForProduct2() {
		dsl.addGiftBoxForProduct1AndGiftMessageForProduct2();
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep10_CheckoutTheProductFromBag(){
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}
	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"), shipping.get("LastName"), shipping.get("StreetAddress"),
				shipping.get("Country"), shipping.get("Zip"), shipping.get("City"), shipping.get("PhoneNumber"));
	}




	@Test(groups={"desktop","mobile"})
	public void TestStep12_MakePaymentUsingCoachGifts(){
		dsl.makePaymentUsingCoachGifts(giftCards.get("Number"),
				giftCards.get("Pin"), users.get("Username"));
		Reporter.log("Payment sucessfully");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep13_PlacedOrder(){
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep14_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

}
