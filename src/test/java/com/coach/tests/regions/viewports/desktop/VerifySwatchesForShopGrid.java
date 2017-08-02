package com.coach.tests.regions.viewports.desktop;
import java.util.Map;

import com.coach.tests.CoachTest;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifySwatchesForShopGrid extends CoachTest{
	
	Map<String, String> url;
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){
		dsl.launchApplication("http://dwdevelopment2.coach.com/shop/women-wallets?viewAll=true");
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Verify_color_swatches_for_less_than_8_color_swatches(){
		dsl.selectAndVerifyProductWithLessThan8ColorSwatches("ACCORDION ZIP WALLET IN POLISHED PEBBLE LEATHER");
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_Verify_color_swatches_for_more_than_8_color_swatches(){
		dsl.selectAndVerifyProductWithMoreThan8ColorSwatches("ACCORDION ZIP WALLET IN GLOVETANNED LEATHER");
	}
		

}
