package com.coach.tests.regions.viewports;
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

	public class VerifyPLPImagesForAllCategories extends CoachTest{
		Map<String, String> url;
		Map<String, String> categories;

		@BeforeClass(groups = { "desktop", "mobile" })
		public void start_test_session() {
			url = testData.get("BASE URL").get(0);
			categories = testData.get("Sub Categories").get(0);
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep01_Launch_Application_URL() {
			dsl.launchApplication(url.get("URL"));
			Reporter.log("User Launched Coach Website");
		}

		@Test(groups = { "desktop", "mobile" })
		public void TestStep02_VerifyPlpOfCategoryPages() {
			dsl.verifyPlpOfCategoryPages(categories.get("Number of Categories"));
			Reporter.log("Image verification");
		}
	}

	