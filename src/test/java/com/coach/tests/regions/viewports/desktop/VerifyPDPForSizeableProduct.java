package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyPDPForSizeableProduct extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> payPal;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(3);

		shipping = testData.get("GuestShippingDetails").get(0);
		users = testData.get("Users").get(0);

		creditCards = testData.get("CardDetails").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
		Reporter.log("Found Search Result");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
		Reporter.log("User selects the firt product");
	}

	// @Test(groups={"desktop","mobile"})
	// public void TestStep04_VerifyPriceGreaterThanZero(){
	// dsl.verifyPriceGreaterThanZero();
	// Reporter.log("Product Price is Greater than zero");
	// }

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyPrimaryImageOnPDPAndProductName() {
		dsl.verifyInnerImageAndCurrentImageOfTheProductWithName();
		Reporter.log("Verified View Screen Link");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_VerifyLablesInPDPPage() {
		dsl.verifyLablesInPDPPage();
		Reporter.log("Verified all the lables in PDP");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_VerifyBradCrumsAndSwiperContainer() {
		dsl.verifyBradCrumAndSwiperContainer();
		Reporter.log("Primary Image is verified On PDP");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifyIconsAndSizeChart() {
		dsl.verifyIconsAndSizeChart();
		Reporter.log("Icons and Size chart is  displayed");
	}

}
