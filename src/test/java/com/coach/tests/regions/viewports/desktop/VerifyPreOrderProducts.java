package com.coach.tests.regions.viewports.desktop;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyPreOrderProducts extends CoachTest{
	
	Map<String, String> url;
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){
		dsl.launchApplication(url.get("URL"));
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep02_Navigate_To_ShopGrid(){
		dsl.selectViewAllForBagsForWomen();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep03_Search_PreOrder_Product_And_Add_To_Bag(){
		dsl.addProductToBagFromshopGridForaParticularProductType("PRE-ORDER");
		dsl.verifyQuickBuyForPreorderProduct("PRE-ORDER");
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_SelectViewShoppingBag() {
		dsl.selectViewShoppingBag();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_Verify_Shopping_bag_page_for_Pre_Order_Product(){
		dsl.verifyShoppingBagePageForProductType("Pre-Order");
	}
	

}
