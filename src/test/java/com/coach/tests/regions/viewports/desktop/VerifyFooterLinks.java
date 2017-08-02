package com.coach.tests.regions.viewports.desktop;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerifyFooterLinks extends CoachTest {
	
	Map<String, String> url;
	
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session(){
		url = testData.get("BASE URL").get(0);
	}
	
	@Test(groups = {"desktop" , "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}
	
	@Test(groups = {"desktop", "mobile"})
	public void TestStep02_VerifyAllFooterLinksAreNavigatingToRightPage(){
		dsl.VerifyFooterLinks();
	}

}
