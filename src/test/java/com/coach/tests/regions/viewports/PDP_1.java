package com.coach.tests.regions.viewports;

import java.lang.reflect.Method;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PDP_1 extends CoachTest {

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
		products = testData.get("Products").get(1);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User launches the website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("User search a product from landing page");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the first product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyYouMayAlsoLikeLabel() {
		dsl.verifyYouMayAlsoLike();
		Reporter.log("User verifies the You May Also Like label");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_HoverOnYouMayAlsoLikeProducts() {
		dsl.hoverOnYouMayAlsoLikeproducts();
		Reporter.log("User Hovers on You May Also Like product");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_ClickOnYouMayAlsoLikeProducts() {
		dsl.clickOnYouMayAlsoLikeproducts();
		Reporter.log("User clicks on You May Also Like product");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_VerifyProductIsDisplayedInPDP() {
		dsl.verifyProductIsDisplayedInPDP();
		Reporter.log("You May Also Like product is displayed ON Product Display Page");

	}

}
