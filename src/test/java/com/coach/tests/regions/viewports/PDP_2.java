package com.coach.tests.regions.viewports;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PDP_2 extends CoachTest {

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

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Name"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_SelectTheFirstProduct() {
		dsl.selectFirstProduct();

	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_VerifyAddBagCharmLabel() {
		dsl.verifyaddbagcharm();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_HoverOnAddBagCharmProducts() {
		dsl.addbagCharmProductsDisplayed();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_AddBagCharmToBag() {
		dsl.addbagCharmProductToBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_VerifyBagCharmIsAddedToBag() {
		dsl.verifybagcharmisadded();

	}

}
