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
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class TestCase50_RegisterUserExpressCheckoutUsingSavedCardDetails extends CoachTest{
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
		 giftCards = testData
		            .get("Gift Cards").get(0);
		 shipping = testData
		            .get("GuestShippingDetails").get(0);
		 users = testData
		            .get("Users").get(1);
		 payPal = testData
		            .get("Pay Pal").get(0);
		 creditCards = testData
		            .get("CardDetails").get(1);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 
	  dsl.launchApplication(url.get("URL"));
	   Reporter.log("Successfully Launched Coach Website");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_Login_With_User_Credentials(){
		 dsl.loginAsRegisteredUser(users.get("Username"),
				 				   users.get("Password"));
		 Reporter.log("Successfully login using valid credentials");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep03_Navigate_TO_AccountSettings(){
		dsl.userGoesToAccountSettingsPage();	     
	}
	 
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep04_NavigatedToSavedCardsPageAndAddcard(){
		dsl.saveCard(creditCards.get("Number"), creditCards.get("CVV"));
	}
	 	 
	 	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep05_SearchAProductFromLandingPage(){
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

	 @Test(groups={"desktop","mobile"})
	 public void TestStep09_EnteredCvv(){
		 dsl.enterCvv(creditCards.get("CVV"));
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep10_PlacedOrder(){
		dsl.placedOrder();
		Reporter.log("Order Placed");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep11_ReviewOrder(){
		dsl.orderReview();
		Reporter.log("User reviews order");
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep12_DeleteSaveCard(){
		 dsl.userGoesToAccountSettingsPage();	
		dsl.deleteSavedCard();
		Reporter.log("Delete Saved card");
	}
	 @Test(groups={"desktop","mobile"})
	 public void TestStep13_LogOutFromApplication(){
		 dsl.logOutFromTheApplication();
		 Reporter.log("User Logs Out From The Application");
	}
}
