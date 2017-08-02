package com.coach.tests.regions.us.viewports;
import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qait.automation.DSL;
import com.qait.automation.utils.YamlReader;

public class VerifyGiftCard extends CoachTest{

	Map<String, String> url;
	Map<String, String> products;
	Map<String, String> users;
	Map<String, String> shipping;
	Map<String, String> creditCards;
	Map<String, String> giftCards;
	Map<String, String> Lastname;

	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		products = testData.get("Products").get(0);
		users = testData.get("Users").get(3);
		shipping = testData.get("GuestShippingDetails").get(0);
		giftCards = dsl.testData.get("d1").data
		            .get("Gift Cards").get(1);

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));
		Reporter.log("User Launched Coach Website");

	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_SearchAProductFromLandingPage() {
		dsl.searchProduct((products.get("Style Number")));
		Reporter.log("Found Search Result");

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep03_SelectTheFirstProduct(){
		dsl.selectFirstProduct(); 
		Reporter.log("User selects the firt product");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Add_The_Product_To_Bag() {
		dsl.addTheProductToBag();
		Reporter.log("User add the product to shopping bag");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Check_Out_the_product() {
		dsl.checkoutTheProductFromBag();
		Reporter.log("User checks out the product and proceed for purchase");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Enter_Shipping_Details() {
		dsl.enterShipingDetails(shipping.get("FirstName"),shipping.get("LastName"),shipping.get("StreetAddress"),shipping.get("Country"),shipping.get("Zip"),shipping.get("City"),shipping.get("PhoneNumber"));
		Reporter.log("User enters shipping details");
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep07_User_Enter_GiftCard_Details(){
		dsl.user_Enter_Gift_Details(giftCards.get("Number"),giftCards.get("Pin"));
		Reporter.log("Gift card number and Pin Added");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_VerifyGiftCardAdded() {
		dsl.verifyGiftCardAdded();
		Reporter.log("Gift card added");
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_RemoveGiftCard() {
		dsl.removeGiftCard();
		dsl.verifyGiftCardIsRemoved();
	}

}
