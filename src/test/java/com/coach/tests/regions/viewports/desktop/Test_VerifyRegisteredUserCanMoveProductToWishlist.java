package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Test_VerifyRegisteredUserCanMoveProductToWishlist extends CoachTest {
	
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(0);
	}
	
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		
	}

	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Login_With_User_Credentials(){
		dsl.loginAsRegisteredUser(users.get("Username"),users.get("Password"));
	}
	
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep04_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
	}
	
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_AddProductToMoveToWishList() {
		dsl.addProductToWishList();
		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Verify_Product_Added_To_WishList_Is_Added_Wishlist() {
		dsl.clickOnAccountIconFromHeader();
		dsl.verifyUserOnAccountPage();
		dsl.clickonwishlistIconFromAccountPage();
		dsl.verifyProductOnWishlistPage();
		dsl.deleteProductFromWishList();
	}

}
