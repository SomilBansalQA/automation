package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuickBuyOptionForCrossSellersInShoppingBagPage extends CoachTest {

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

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launche the URL");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("User search a product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("user selects the first product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyYouMayAlsoLikeLabel() {
		dsl.verifyYouMayAlsoLike();
		Reporter.log("Verified You May Also Like label");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_HoverOnYouMayAlsoLikeProducts() {
		dsl.hoverOnYouMayAlsoLikeproducts();
		dsl.clickOnYouMayAlsoLikeproducts();
		Reporter.log("User Hover on You May Also Like products ");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_AddTheProductToShoppingBag() {
		dsl.addTheProductToBag();
		Reporter.log("User adds the product to shopping bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_selectViewShoppingBag() {
		dsl.selectViewShoppingBag();
		dsl.scrollDownToBottom();
		Reporter.log("user clicks on Select View Shopping Bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifyQuickBuyOptionForCrossSellersInShoppingBagPage() {
		dsl.verifyQuickBuyOptionForCrossSellersInShoppingBagPage();
		Reporter.log("Quick buy option is visible");

	}

}
