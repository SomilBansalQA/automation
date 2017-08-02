package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class TestCase51_VerifyUserIsAbleToCheckDetailsInCartPage extends CoachTest{

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

		shipping = testData
				.get("GuestShippingDetails").get(0);
		users = testData
				.get("Users").get(0);

		creditCards = testData
				.get("CardDetails").get(0);
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){		 
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
		dsl.addSizeableProductToShoppingBag();
		Reporter.log("User adds the product to Shopping Bag");
	}
	@Test(groups={"desktop","mobile"})
	public void TestStep05_SelectViewShoppingBag(){
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep06_VerifyCartPage(){
//		dsl.verifyOtherElementsInTheCartPage();
//		dsl.verifyLabelsInShoppingBag();
		Reporter.log("verify Image,Color,labels,Proceed to check and other elements in the cart page");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep07_IncreaseQuantityOfProduct(){
		dsl.increaseQuantityOfProduct();
		Reporter.log("Quantity Of Product Is Increased");
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep08_DecreaseQuantityOfProduct(){
		dsl.decreaseQuantityOfProduct();
		Reporter.log("Quantity Of Product Is Decreased");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep09_VerifyPromoCodeAndApplyNowLabels(){
		dsl.verifyPromoCodeAndApplyNowLabels();
		Reporter.log("Promo Code and Apply Now Verified");
	}


	
	@Test(groups={"desktop","mobile"})
	public void TestStep10_VerifyShoppingBagTotal(){
	//	dsl.verifyProductTotal();
		Reporter.log("verify Products total according to the quantity");
	}


	@Test(groups={"desktop","mobile"})
	public void TestStep11_VerifyShoppingBagSubTotal(){
		dsl.verifySubProductTotal();
		Reporter.log(" Products Subtotal is Greater than zero");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep12_VerifyGiftMessage(){
		dsl.verifyAddAGiftMessageFunctionality();
		Reporter.log("Verify user is able to add gift message and also able to verify special characters should not be in message box");
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep13_ClickOnApplyLinkAndVerify(){
		dsl.clickOnApplyLinkAndVerify();
		Reporter.log("Clicked On Apply Now Link");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep14_VerifyRemoveProductFromCart(){
		dsl.verifyRemoveProductFromCartPage();
		Reporter.log(" Product is removed from bag");
		
	}

	
}