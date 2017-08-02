package com.coach.tests.regions.viewports;

import com.coach.tests.CoachTest;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyOnPageRefreshAppliedFilterRemains extends CoachTest  {
	
	Map<String,String> url;
	String color;
	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
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
	public void TestStep03_Apply_Filter_And_Verify_Filter_Applied() {
		color=dsl.prodctresult.selectColourFilter();
		dsl.prodctresult.verifyShopGridDisplayedAccordingToAppliedFilter(color);
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Refresh_Page_And_Verify_Filter_Remains() {
		dsl.prodctresult.verifyAfterRefreshFilterRemains();
		
	}

}
