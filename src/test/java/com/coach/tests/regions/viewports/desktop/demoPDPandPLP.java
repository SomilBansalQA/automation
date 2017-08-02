package com.coach.tests.regions.viewports.desktop;
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

public class demoPDPandPLP extends CoachTest{
	
	Map<String, String> url;
	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication("http://dev16-global-coach.demandware.net/s/Coach_US/shop/women-new-arrivals-new-arrivals");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_VerifyImagePLP() {
		dsl.verifyImage();
		Reporter.log("Image is verified For PLP");

	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_ClickOnImage() {
		dsl.clickOnImage();
		Reporter.log("Image is verified");

	}
	

	@Test(groups={"desktop","mobile"})
	public void TestStep05_VerifyPrimaryImageOnPDPAndProductName(){
		dsl.verifyInnerImageAndCurrentImageOfTheProductWithName();
		Reporter.log("Primary Image is verified For PDP");

	}

	

}
