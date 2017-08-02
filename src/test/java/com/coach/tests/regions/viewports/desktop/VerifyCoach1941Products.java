package com.coach.tests.regions.viewports.desktop;
import java.util.Map;

import com.coach.tests.CoachTest;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyCoach1941Products extends CoachTest{
	
	Map<String, String> url;
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){
		dsl.launchApplication(url.get("URL"));
	}
	

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SelectAny1941ShopsForWomen() {
		dsl.selectAny1941ShopsForWomen();
		Reporter.log("User selects any 1941 shop for women");

	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_VerifyCoach1941ProductOnShopGrid(){
		dsl.verifyCoach1941TextOnAllProduct("COACH 1941");
	}
	
	
	

}
