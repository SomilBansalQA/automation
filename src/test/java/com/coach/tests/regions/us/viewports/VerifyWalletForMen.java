package com.coach.tests.regions.us.viewports;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class VerifyWalletForMen extends CoachTest {
	Map<String,String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){
		dsl.launchApplication(url.get("URL"));
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Verify_Wallet_Guide_Under_Men_Section(){
		dsl.verifyWalletGuideForMen();
	}
	

	@Test(groups={"desktop","mobile"})
	public void TestStep03_Click_On_Wallet_Guide_For_men(){
		dsl.clickOnWalletGuideFormen();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep04_Verify_Wallet_Categories_Under_Men_Section(){
		dsl.verifyWalletcategories();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_Verify_Shop_Grid_For_Category_Selected(){
		dsl.verifyShopGridForCategorySelected();
	}
	
	
	@Test(groups={"desktop","mobile"})
	public void TestStep06_Verify_Shop_Grid_After_Category_is_DeSelected(){
		dsl.verifyShopGridForCategoryIsDeSelected();
	}

}
