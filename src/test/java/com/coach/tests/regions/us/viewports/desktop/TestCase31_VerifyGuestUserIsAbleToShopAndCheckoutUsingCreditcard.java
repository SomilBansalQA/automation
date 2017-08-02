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

public class TestCase31_VerifyGuestUserIsAbleToShopAndCheckoutUsingCreditcard extends CoachTest{

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
		creditCards = testData.get("CardDetails").get(5);
		shipping = testData
				.get("GuestShippingDetails").get(0);
		users = testData
				.get("Users").get(0);
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){		 
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep02_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Name"));
		Reporter.log("Found Search Result");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep03_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the first product");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep04_AddTheProductToBag(){
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}
	@Test(groups={"desktop","mobile"})
	public void TestStep05_SelectViewShoppingBag(){
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
		//		dsl.verifylayout();
		Reporter.log("User checks out the product and proceed for purchase");
	}

//	@Test(groups = { "desktop", "mobile" })
//	public void TestStep07_VerifyRegisteredSectionFromShippingPage() {
//		dsl.VerifyForgotPasswordLinkFromSignInpage();
//		dsl.signInFromShippingpage("abs1234567@qa.com",users.get("Password"));
//		dsl.verifyUserCannotSignFromInValidUsername();
//	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
	}


	@Test(groups = {"desktop","mobile"})
	public void TestStep09_Verify_EasyTrackOrdersUnderCreateAnAccount() throws InterruptedException {
		dsl.verify_EasyTrackOrdersUnderCreateAnAccount();
		Reporter.log("verified Easy Track Orders Under Create An Account");
		dsl.verify_ThisIsTheBillingInformationStatementIsRemovedBelowBillingAddress();
		Reporter.log("This is the billing information exactly as it appears on your credit card statement is REMOVED");
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_Enter_Payment_Details(){
		dsl.verify_InvalidCVV(creditCards.get("Number"),creditCards.get("CVV"),users.get("Username"));
		Reporter.log("INVALID SECURITY CODE is verified");
		dsl.makePaymentUsingcards(creditCards.get("Number"),creditCards.get("CVV"),users.get("Username"));
		Reporter.log("The credit card type is " +creditCards.get("Type"));
		Reporter.log("User enters payment details");
	}	


	@Test(groups={"desktop","mobile"})
	public void TestStep11_PlacedOrder(){
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}



	@Test(groups={"desktop","mobile"})
	public void TestStep12_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("User reviews order");
	}

}
