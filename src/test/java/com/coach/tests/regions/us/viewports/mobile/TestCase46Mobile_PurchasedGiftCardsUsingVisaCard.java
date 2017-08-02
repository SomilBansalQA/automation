package com.coach.tests.regions.us.viewports.mobile;

import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

import com.coach.tests.CoachTest;

public class TestCase46Mobile_PurchasedGiftCardsUsingVisaCard extends CoachTest{
	Map<String,String> url;
    Map<String, String> products;
    Map<String, String> users;
    Map<String, String> shipping;
    Map<String, String> visacards;
    Map<String, String> giftCards;
    Map<String, String> payPal;

	String[] browserSizes = { "1366x768" };
	String[] layoutTags = { "all" };

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		 products = testData
		            .get("Products").get(2);
		 giftCards = testData
		            .get("Gift Cards").get(0);
		 shipping = testData
		            .get("GuestShippingDetails").get(0);
		 users = testData
		            .get("Users").get(0);
		 payPal = testData
		            .get("Pay Pal").get(0);
		 visacards = testData
		            .get("CardDetails").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_NavigateToFooterGiftCardsLinkAndPurchaseGiftCard(){
		dsl.scrollDownToBottom();
		dsl.mobile_clickOnProductInformation();
		dsl.navigateToFooterGiftCardsLink();
		Reporter.log("Successfully Coach foundation link Page");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_PurchaseGiftCard(){
		dsl.purchaseGiftCard();
		Reporter.log("Successfully Coach foundation link Page");

	}
		
	 @Test(groups={"desktop","mobile"})
	 public void TestStep04_CheckoutTheProductFromBag(){
		 dsl.checkoutTheProductFromBag();
		Reporter.log("User checkout the product from Shopping Bag");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep07_ShipingTheProduct(){
		 dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
		Reporter.log("User Shipped Product");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep08_MakePaymentUsingVisaCard(){
		 dsl.makePaymentUsingcards(visacards.get("Number"),visacards.get("CVV"),users.get("Username"));
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
