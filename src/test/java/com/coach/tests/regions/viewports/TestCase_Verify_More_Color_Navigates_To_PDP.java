package com.coach.tests.regions.viewports;

import com.coach.tests.CoachTest;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase_Verify_More_Color_Navigates_To_PDP extends CoachTest  {
	Map<String, String> url;
	Map<String, String> users;
	Map<String, String> products;


	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.landingPage.clickOnViewAllForSectionNew();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Verify_COACH_LogoRedirectsToHomepage(){
		dsl.verify_COACH_LogoRedirectsToHomepage();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SearchAProductFromLandingPage() {
		dsl.landingPage.clickOnViewAllForSectionNew();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_ClickOnMoreColors() {
		dsl.prodctresult.clickOnMoreColors();
		dsl.prodctdetails.verifyLablesInPDPPage();
		dsl.prodctdetails.verifyAllcolorsOfproductisdisplayed();
	}

}
