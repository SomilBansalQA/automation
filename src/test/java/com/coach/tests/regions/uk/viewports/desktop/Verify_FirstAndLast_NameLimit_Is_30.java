package com.coach.tests.regions.uk.viewports.desktop;

import java.util.Map;

import com.coach.qa.automation.dsl.api.ProductSearch;
import com.coach.tests.CoachTest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verify_FirstAndLast_NameLimit_Is_30 extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	String country;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);

		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		dsl.closeCrossCookieIcon();
		Reporter.log("Successfully Launched Coach STAGING2 Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnRegisterButton() {
		dsl.accountPage.clickOnRegisterButton();
		Reporter.log("User clicks on Register Button");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Verify_First_LastNameLimit_Is_30() {
		dsl.verify_First_LastNameLimit_Is_30();
		Reporter.log("Verified REGISTRATION form FIRST & LAST name limit is 30");
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Selects_First_Product() {
    	dsl.selectFirstProduct(); 
		 Reporter.log("User selects the first Product");
	}
    
    @Test(groups = { "desktop", "mobile" })
	public void TestStep07_Add_The_Product_To_Bag() {
    	dsl.addTheProductToBag();
		 Reporter.log("User add the product to shopping bag");
	}
    
    @Test(groups = { "desktop", "mobile" })
	public void TestStep08_Check_Out_the_product() {
    	 dsl.checkoutTheProductFromBag();
    	 dsl.shipngpage.verify_First_LastNameLimit_Is_30();
		 Reporter.log("User checks out the product and proceed for purchase");
	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ClickOn_ContactUS(){
		dsl.scrollDownToBottom();
		System.out.println("url"+url.get("URL"));
		if((url.get("URL").contains("@dwdevelopment.coach.com"))||(url.get("URL").contains("@dwdevelopment2.coach.com"))||(url.get("URL").contains("@dwstaging.coach.com"))||(url.get("URL").contains("http://www.coach.com/")) ){
			country = "US";
		}
		else
		{
			country = "Non US";
		}
		dsl.footer.clickOnContactUsLink(country);
		dsl.customerCarePage.verify_First_LastNameLimit_Is_30();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_RegisterNewUserIntoCoach() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		dsl.registerANewUser(shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
		dsl.topBanner.goToAccountSettingsPage();
		dsl.verify_First_LastNameLimit_Is_30();
		Reporter.log("User registeres into Coach Application");
		
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep11_SearchAProductFromLandingPage(){
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep12_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep13_AddProductToMoveToWishList(){
		dsl.addProductToWishList();
		
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep14_ClickOnWishListFromHeader(){
		dsl.clickOnWishListFromHeader();
		dsl.clickOnEmailLink();
		dsl.wishlistpage.verify_First_LastNameLimit_Is_30();
		
	}
	
	
    
}
