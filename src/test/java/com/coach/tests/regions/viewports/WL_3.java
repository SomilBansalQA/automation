package com.coach.tests.regions.viewports;
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

public class WL_3 extends CoachTest  {
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");
	}
	
	@Test(groups={"desktop","mobile"})
	 public void TestStep02_Login_With_User_Credentials(){
		 dsl.loginAsRegisteredUser(users.get("Username"),users.get("Password"));
		 Reporter.log("User login using valid credentials");
	     
	}
     

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep04_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the firt product");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep05_AddTheProductToShoppingBag(){
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep06_SelectViewShoppingBag(){
		dsl.selectViewShoppingBag();
		Reporter.log("User clicked on View Shopping Bag");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep07_ClickOnButtonMoveToWishList(){
		dsl.clickandVerifyMoveToWishList();
		Reporter.log("User verifies the product is moved to wishlist");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep08_CloseWishListModalAndVerifyShoppingBagIsEmpty(){
		dsl.closeWishListModal();
		Reporter.log("User closes the wishlist and verifies the shopping bag is empty");

	}
}
