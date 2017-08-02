package com.coach.tests.regions.viewports.desktop;

import java.util.Map;
import java.util.Random;

import com.coach.tests.CoachTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerificationOfQuickBuyInShopGridAndProductNameVerificationOnShopGridPDPQuickBuyMiniCart extends CoachTest {

	Map<String, String> url;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SelectViewAllForBagsForWomen() {
		dsl.selectViewAllForBagsForWomen();
		dsl.verifyShopGridPage();
		dsl.verifyWishlistIcon();
		dsl.verifyProductNameInShopGrid();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_VerifyShopGridPageNameAndCategory() {
		dsl.checkShopGridCategory("COACH Sale: Women's Bags", "All Women’s Bags", "Bags");
		Reporter.log("Shopgrid name verified");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyShopGridFilters() {
		dsl.verifyShopGridFilter();
		Reporter.log("Shopgrid Filter verified");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyQuickShopWindow() {
		dsl.NavigateToquickShop();
		dsl.verifyProductNameInQuickBuy();
		dsl.verifyQuickShopPageAndAddToBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_VerifyProductNameIsDisplayedInPDPAndMiniCart() {
		dsl.prodctdetails.verifyProductName();
		dsl.verifyProductNameIsDisplayedInPDPAndMiniCart();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_ValidateProductName() {
		dsl.validateProductName();
	}

}
