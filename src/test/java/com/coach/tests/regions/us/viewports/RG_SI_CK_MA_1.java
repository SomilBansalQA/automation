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


public class RG_SI_CK_MA_1 extends CoachTest{

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
			users = testData
		            .get("Users").get(5);
			shipping = testData
		            .get("GuestShippingDetails").get(0);
			creditCards = testData.get("CardDetails").get(0);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 	dsl.launchApplication(url.get("URL"));
			Reporter.log("User Launched Coach Website");
	     
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
	 public void TestStep04_AddTheProductToShoppingBag(){
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}
	 
	 @Test(groups = { "desktop", "mobile" })
		public void TestStep05_Check_Out_the_product() {
	    	 dsl.checkoutTheProductFromBag();
			 Reporter.log("User checks out the product and proceed for purchase");
		}
	    
	    @Test(groups = { "desktop", "mobile" })
		public void TestStep06_Enter_Shipping_Details() {
	    	 dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
			Reporter.log("User enters shipping details");
		}
	    
	    @Test(groups = { "desktop", "mobile" })
		public void TestStep07_Enter_Payment_Details(){
	    	dsl.paymentpage.user_enter_card_number(creditCards.get("Number"));
			dsl.paymentpage.user_select_card_expiry_month_and_year_tier2();
			long Random = System.currentTimeMillis();
			String emailAddress = "A"+Random+"@qa.com";
			dsl.paymentpage.user_enter_securitycode_and_emailid(creditCards.get("CVV"), emailAddress);
			dsl.paymentpage.user_enter_password_for_new_registeration();
			dsl.paymentpage.user_submit_payment();
	    	Reporter.log("The credit card type is " +creditCards.get("Type"));
	    	Reporter.log("User enters payment details");
		}
	    
	    @Test(groups = { "desktop", "mobile" })
		public void TestStep07_Place_Order(){
	    	dsl.placedOrder();
			Reporter.log("User places the order");
		}
	    
	    @Test(groups={"desktop","mobile"})
		 public void TestStep08_ReviewOrder(){
			dsl.orderReview();
			Reporter.log("User reviews order");
		}
	    
	    @Test(groups={"desktop","mobile"})
		 public void TestStep09_UserGoToAccountSettings(){
	    	 dsl.userGoesToAccountSettingsPage();
	    	 dsl.accountPage.goToSavedCreditCardsPage();
	    	 dsl.accountPage.verifyPrimaryCard();
			Reporter.log("User account settings");
		}
	    
	    @Test(groups={"desktop","mobile"})
		 public void TestStep10_SearchAProductFromLandingPage(){
			 dsl.searchProduct(products.get("Style Number"));
			 Reporter.log("Found Search Result");
		     
		}
		 
		 @Test(groups={"desktop","mobile"})
		 public void TestStep11_SelectTheFirstProduct(){
			 dsl.selectFirstProduct(); 
			Reporter.log("User selects the firt product");
		}
		 
		 @Test(groups={"desktop","mobile"})
		 public void TestStep12_AddTheProductToShoppingBag(){
			dsl.addTheProductToBag();
			Reporter.log("User adds the product to Shopping Bag");
		}
		 
		 @Test(groups = { "desktop", "mobile" })
			public void TestStep13_Check_Out_the_product() {
		    	 dsl.checkoutTheProductFromBag();
				 Reporter.log("User checks out the product and proceed for purchase");
			}
		 
		 @Test(groups = { "desktop", "mobile" })
			public void TestStep13_EnterCVV() {
		    	 dsl.enterCvv(creditCards.get("CVV"));
				 Reporter.log("User checks out the product and proceed for purchase");
			}
	    
		 @Test(groups = { "desktop", "mobile" })
			public void TestStep14_Place_Order(){
		    	dsl.placedOrder();
				Reporter.log("User places the order");
			}
		    
		    @Test(groups={"desktop","mobile"})
			 public void TestStep15_ReviewOrder(){
				dsl.orderReview();
				Reporter.log("User reviews order");
			}
		    
		    @Test(groups={"desktop","mobile"})
			 public void TestStep16_UserGoToAccountSettings(){
		    	 dsl.userGoesToAccountSettingsPage();
		    	 dsl.accountPage.goToSavedCreditCardsPage();
		    	 dsl.accountPage.verifyPrimaryCard();
				Reporter.log("User account settings");
			}
		    
		    @Test(groups={"desktop","mobile"})
			 public void TestStep17_UserMakesTheSavedCardSecondry(){
		    	  dsl.accountPage.makeTheCreditCardSecondory();
				Reporter.log("User account settings");
			}
		    
}
