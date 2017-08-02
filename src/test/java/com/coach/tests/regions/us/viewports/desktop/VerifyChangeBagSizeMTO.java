package com.coach.tests.regions.us.viewports.desktop;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerifyChangeBagSizeMTO extends CoachTest {

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication("http://onlinemto.coach.com");
		dsl.verifyUserOnMTOPage();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Select_bag_Size() {
		dsl.selectBagSize();
		dsl.verifyUserOnBagcustomizationPage();
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Change_bag_Size() {
		dsl.clickOnChangeBagSize();
		dsl.verifyUserOnMTOPage();
	}

}
