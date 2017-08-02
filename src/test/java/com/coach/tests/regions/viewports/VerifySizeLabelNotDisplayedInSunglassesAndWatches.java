package com.coach.tests.regions.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VerifySizeLabelNotDisplayedInSunglassesAndWatches extends CoachTest{
	Map<String, String> url;
	Map<String, String> products;
    Map<String, String> products1;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(5);
		products1 = testData.get("Products").get(6);
		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_VerifySizeDropDwonIsNotDisplayed() {
		dsl.verifySizeDropDwonIsNotDisplayed();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SearchAProductFromLandingPage() {
		dsl.searchProduct(products1.get("Style Number"));
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_VerifySizeDropDwonIsNotDisplayed() {
		dsl.verifySizeDropDwonIsNotDisplayed();
	}
	
}

