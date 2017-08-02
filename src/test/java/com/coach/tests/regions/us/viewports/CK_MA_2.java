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


public class CK_MA_2 extends CoachTest  {
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;
	Map<String, String> NewcreditCards;


	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(4);
		shipping = testData.get("GuestShippingDetails").get(0);
		creditCards = testData.get("CardDetails").get(0);
		NewcreditCards = testData.get("CardDetails").get(3);


	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");
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
		Reporter.log("User navigated to Account page");
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
	public void TestStep09_ClickOnAddNewCreditCard(){
		dsl.addNewCreditCard();
	
	}	 


	@Test(groups={"desktop","mobile"})
	public void TestStep10_EnterNewCardDetailsAndSave(){
		dsl.saveNewCard(NewcreditCards.get("Number"), NewcreditCards.get("CVV"));
		Reporter.log("New Credit card is added");
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep11_EntersCvvAndEmail(){
		dsl.enterCvv(NewcreditCards.get("CVV"));
		dsl.enterEmailAndContinue(users.get("Username"));
		

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep12_PlacedOrder(){
		dsl.placedOrder();
		dsl.orderReview();
		Reporter.log("Order Placed");
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep13_Navigate_TO_AccountSettings(){
		dsl.userGoesToAccountSettingsPage();
		Reporter.log("User navigated to Account page");
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep14_Navigate_TO_SavedCreditCard(){
		dsl.userGoesTosavedcreditcard();
		Reporter.log("User navigated to Saved Credit Card");
	}



	@Test(groups={"desktop","mobile"})
	public void TestStep15_Delete_SavedCreditCards(){
		dsl.delete_SavedCreditCard();
		dsl.delete_SavedCreditCard();
		Reporter.log("Credits cards are deleted");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep16_LogOutSession(){
		dsl.logOutFromTheApplication();
		Reporter.log("User logs out from the application");
	}















}
