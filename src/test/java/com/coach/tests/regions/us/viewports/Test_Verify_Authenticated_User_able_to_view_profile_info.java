package com.coach.tests.regions.us.viewports;

import java.util.Map;
import com.coach.tests.CoachTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Verify_Authenticated_User_able_to_view_profile_info extends CoachTest {

	Map<String, String> url;
	Map<String, String> users;


	@BeforeClass(groups = { "desktop", "mobile" })
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		users = testData.get("Users").get(0);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication(url.get("URL"));

	}

	@Test(groups={"desktop","mobile"})
	public void TestStep02_Login_With_User_Credentials(){
		dsl.loginAsRegisteredUser(users.get("Username"),users.get("Password"));  
		dsl.verifyUserOnAccountPage();
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep03_Click_On_Account_Setting(){
		dsl.ClickOnAccountSetting();
		dsl.VerifyUserOnAccountEditPage();
	}

	@Test(groups={"desktop","mobile"})
	public void TestStep04_Verify_User_Can_View_account_Info(){
		dsl.verifyUserCanViewaccountInfo();
	}
	
	@Test(groups={"desktop","mobile"})
	public void TestStep05_Verify_User_Is_Able_To_Unsubscribe(){
		dsl.clickOnUnsubscribeLink();
		dsl.unsubscribeEmail(users.get("Username"));
		dsl.verifyUserhasUnsubscribed();
	}
	
	

}
