package com.coach.tests.regions.us.viewports.desktop;


import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class TestGiftCards extends CoachTest{
	Map<String,String> url;
	Map<String, String> giftCards;
    int Number_Of_gift_Card;
	
	@BeforeClass(groups={"desktop","mobile"})
	public void start_test_session() {
		url = testData.get("BASE URL").get(0);
		giftCards = testData.get("Gift Cards").get(0);
		}

	@Test(groups={"desktop","mobile"})
	public void TestStep01_Launch_Application_URL(){		 
		dsl.launchApplication(url.get("URL"));
		Reporter.log("Successfully Launched Coach Website");
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_NavigateToFooterGiftCardsLink() throws InterruptedException{
		dsl.scrollDownToBottom();
		dsl.navigateToFooterGiftCardsLink();
		Reporter.log("Successfully click on Gift Card link");
	}
		
	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_CheckAllGiftCardBalance() {
	    for(int index=0;index<testData.get("Gift Cards").size();index++)
	    {
	    	giftCards = testData.get("Gift Cards").get(index);
     		dsl.CheckYourBalance(giftCards.get("Number"),giftCards.get("Pin"));
	    	Reporter.log("Successfully check all Gift cards");
	    }
	    }
	
	
}

