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

public class WL_2 extends CoachTest {

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

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_ClickOnBurgerButtonForMenu() {
		dsl.clickOnBurgerButtonForMenu();
		Reporter.log("User clicks on burger icon");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnSignInAndNavigateToAccountsPage() {
		dsl.navigate_To_Registeration_Page_From_Landing_Page();
		Reporter.log("User is navigated to Accounts Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Mobile_Login_With_User_Credentials() {
		dsl.mobile_loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("User login using valid credentials");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOn_WishList_AccountPage() {
		dsl.clickonwishlist();
		dsl.verifyWishListdisplayed();
		Reporter.log("User Wishlist is displayed");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ClickOnFindFriendWishlist() {
		dsl.clickOnFindFriendWishListButton();
		dsl.verifyFindWishListPageDisplayed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SearchFriendWishList() {
		dsl.enterFriendEmailAndSearch();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifyPrivateListNotDisplayed() {
		dsl.verifyPrivateListNotDisplayed();
		Reporter.log("Private WishList Is Not Accessible");

	}

}
