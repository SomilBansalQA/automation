package com.coach.tests.regions.viewports.desktop;

import java.lang.reflect.Method;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class VerifyFindAStoreLinkIsPresentAtHomePage extends CoachTest {

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		shipping = testData
				.get("GuestShippingDetails").get(0);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_VerifyFindAStoreLinkIsPresentAtTopOfHomePage(){
		dsl.verifyFindAStoreLinkIsPresentAtTopOfHomePage();
		dsl.clickOnFindAStoreLink();
	}

//	@Test(groups = { "desktop", "mobile" })
//	public void TestStep03_VerifyFindAStorePage(){
//		dsl.verifyStoreLocatorTitle();
//	}
//
//	@Test(groups={"desktop","mobile"})
//	public void TestStep04_Search_Store_Using_Zip_Code(){
//		dsl.searchStoreUsingZipCode(shipping.get("Zip"));
//	}
//	
//	@Test(groups={"desktop","mobile"})
//	public void TestStep05_Search_Store_Using_Zip_Code(){
//		dsl.storeLocator.verifyStoreLocatorPage();
//		dsl.storeLocator.verifyStoresDistanceDispalyedInAscendingOrder();
//	}
//
//	



}
