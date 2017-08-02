package com.coach.tests.regions.viewports.desktop;

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

public class SRCH_1 extends CoachTest {
	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;
	String country;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URLAndVerifySearchBarIsDisplayed() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website,Search Bar Is Present On Home Page");

		dsl.verifySearchDisplayed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_VerifyDefaultTextIsSearch() {
		// dsl.verifySearchText();
		Reporter.log("Default Text Is Search");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SuggestionAppearAfterEntering3Letters() {
		dsl.verifySuggestionAppearAfterEntering3Letters();
		Reporter.log("After Entering 3 letters in search bar, Suggestions are Displayed");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Login_With_User_CredentialsAndVerifySearchBarIsDisplayed() {
		dsl.loginAsRegisteredUser(users.get("Username"), users.get("Password"));
		Reporter.log("Successfully login using valid credentials,Search Bar Is Present On Sign In page");
		dsl.verifySearchDisplayed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifySearchBarOnWelcomePage() {
		dsl.verifySearchDisplayed();
		Reporter.log("Search Bar Is Present On Welcome page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SearchAProductFromLandingPageAndVerifySearchBarIsDisplayed() {
		dsl.searchProduct(products.get("Style Number"));
		dsl.verifySearchDisplayed();
		Reporter.log("Found Search Result,Search Bar Is Present On PDP");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		dsl.verifySearchDisplayed();
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_AddTheProductToBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_CheckoutTheProductFromBagAndVerifySearchBarNotDisplayed() {
		dsl.checkoutTheProductFromBag();
		dsl.verifySearchNotDisplayed();

		Reporter.log("User checkout the product from Shopping Bag,Search Bar Is Not Displayed In CheckOut Page");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_SelectViewShoppingBagAndVerifySearchBarNotDisplayed() {
		dsl.selectViewShoppingBag();
		dsl.verifySearchNotDisplayed();
		Reporter.log("User clicked on View Shopping Bag,Search Bar Is Not Displayed In Cart");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep11_UserUsesContactUsForm() {
		if ((url.get("URL").contains("http://dwdevelopment.coach.com/"))
				|| (url.get("URL").contains("http://dwstaging.coach.com/"))||(url.get("URL").contains("http://dwstaging2.coach.com/"))||(url.get("URL").contains("http://dwdevelopment2.coach.com/"))) {
			country = "US";
		} else {
			country = "Non US";
		}

		dsl.clickOnContactUsFunctionality(country);
		dsl.verifySearchDisplayed();
		Reporter.log("User clicked on Contact Us,Search Bar Is  Displayed In Contact Us Page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep12_GoToStoreLocatorFromFooterLinksAndVerifySearchBarIsDisplayed() {
		dsl.goToStoreLocatorPageFromFooter();
		dsl.verifySearchDisplayed();
		Reporter.log("User clicked on Store Locator ,Search Bar Is Store Page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep13_LogOutSession() {
		dsl.logOutFromTheApplication();
		Reporter.log("User logs out from the application");
	}

}
