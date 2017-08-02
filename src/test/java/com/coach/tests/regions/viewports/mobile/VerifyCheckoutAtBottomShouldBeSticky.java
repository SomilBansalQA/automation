package com.coach.tests.regions.viewports.mobile;
import java.util.Map;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.coach.tests.CoachTest;

public class VerifyCheckoutAtBottomShouldBeSticky extends CoachTest {
	Map<String, String> url;
	Map<String, String> products;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(2);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Search_A_Product() {
		dsl.searchProduct(products.get("Style Number"));
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_SelectTheFirstProduct() {
		dsl.selectFirstProduct();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_AddMultipleProductsToBag() {
		dsl.addTheProductToBag();
	/*	dsl.searchProduct("58839");
		dsl.selectFirstProduct();
		dsl.addTheProductToBag();
		dsl.searchProduct("58690");
		dsl.addTheProductToBag();
		dsl.searchProduct("58118");
		dsl.addTheProductToBag();	*/	
	}
		
	@Test(groups={"desktop","mobile"})
	public void TestStep05_SelectViewShoppingBag(){
		dsl.select_View_Shopping_Bag_For_Android();
	}
	
	@Test(groups={"desktop","mobile"})
	 public void TestStep06_VerifyCheckoutButtonAtBottomShouldBesticky(){
	  dsl.verifyCheckoutButtonAtBottomShouldBesticky();
	 }	
}
