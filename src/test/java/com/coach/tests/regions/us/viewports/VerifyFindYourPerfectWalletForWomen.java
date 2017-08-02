package com.coach.tests.regions.us.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class VerifyFindYourPerfectWalletForWomen extends CoachTest {
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
	public void TestStep02_Verify_Wallet_Guide_Under_Women_Section() {
		dsl.verifyWalletGuideForWomen();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Click_On_Wallet_Guide_For_Women() {
		dsl.clickOnWalletGuideForWomen();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Click_On_Find_Your_Perfect_Wallet() {
		dsl.clickOnFindYourPerfectWallet();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Verify_Find_Your_Perfect_Wallet() {
		dsl.verifyFindYourPerfectWallet();
	}

	 @Test(groups={"desktop","mobile"})
	 public void TestStep06_Click_On_Find_Your_Perfect_Wallet(){
	 dsl.clickOnFindYourPerfectWallet();
	 }
	
	 @Test(groups={"desktop","mobile"})
	 public void
	 TestStep07_Click_On_Clear_All_On_Find_Your_perfect_wallet_Section(){
	 dsl.clickOnClearAllOnFindYourperfectwalletSection();
	 }
	
	 @Test(groups={"desktop","mobile"})
	 public void TestStep08_Close_Perfect_Wallet_Section(){
	 dsl.clickOnFindYourPerfectWallet();
	 dsl.closePerfectWalletSection();
	 }

}
