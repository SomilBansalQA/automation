package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class Verify_PriceRangeForShopGrid extends CoachTest {

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
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_VerifyPriceForFullPricedProduct(){
		dsl.verify_PriceForFullPricedProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_VerifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel(){
		dsl.verifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifyPriceRangeIsInSaleWhenOneColorIsInSale(){
		dsl.verifyPriceRangeIsInSaleWhenOneColorIsInSale("BROOKLYN CARRYALL 34 IN PEBBLE LEATHER ");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_verifyQuickBuyPriceRange(){
		dsl.NavigateToquickShop();
		dsl.verifyQuickBuyPriceRange();
		dsl.verifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel();
		
		
	}
}
