package com.coach.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;



public class TopBanner extends GetPage {
	String [] layoutTags = {"objects1"};
	WebDriver driver;

	public TopBanner(WebDriver driver) {
		super(driver, "coach/TopBanner");
		this.driver = driver;
	}

	public AccountPage clickOnSignINRegister() {
		wait.waitForPageToLoadCompletely();
		scrollWindow(0, 0);
		waitForLoad();
		executeJavascript("document.getElementsByClassName('icm-icon-user')[0].click()");
		//click(element("login_register_button"));
		wait.waitForPageToLoadCompletely();
		msg.log("User clicks on account label");
		return new AccountPage(driver);
	}
	

	public void logout() {
			wait.waitForPageToLoadCompletely();
			scrollWindow(0,0);
//			hover(element("button_sign_out"));
//			wait.waitForPageToLoadCompletely();
//			hover(element("button_sign_out"));
			executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[3].getElementsByTagName('a')[0].click()");
			//executeJavascript("document.getElementsByTagName('li')[0].getElementsByTagName('a')[5].click()");
//			if((ConfigPropertyReader.getProperty("browser").contains("safari"))||(ConfigPropertyReader.getProperty("browser").contains("iosMobile"))){
//				executeJavascript("document.getElementsByTagName('li')[0].getElementsByTagName('a')[5].click()");
//			}
//			else{
//				click(element("linkText_Signout"));
//			}
			
//			wait.waitForPageTitleToContain("Coach: My Account");		
			logMessage("User LogOuts form application");
	}

	public void verifyTopNavigationBar() {
		isElementDisplayed("login_register_button");
		isElementDisplayed("navigation_bar_TopBanner");
	}
	
	public void verifyAccountMenuTabOptions() {
		waitForLoad();
		//executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[4].getElementsByTagName('a')[0]");
		// instead of hover using js to find out whether elements are there or not
		waitForLoad();
		executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[0].getElementsByTagName('a')[0];");
		executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[1].getElementsByTagName('a')[0]");
		executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[2].getElementsByTagName('a')[0]");
		executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[3].getElementsByTagName('a')[0]");
//		hover(element("button_sign_out"));
//		hover(element("button_sign_out"));
//		
//		if(!((ConfigPropertyReader.getProperty("browser").contains("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios")))){
//			isElementDisplayed("linkText_AccountSettings");
//			isElementDisplayed("linkText_OrderHistory");
//			isElementDisplayed("linkText_WishList");
//			isElementDisplayed("linkText_Signout");
//		}
	}
	
	public void verifyLayout() {
		wait.waitForPageToLoadCompletely();
		Assert.assertTrue(testPageLayout(layoutTags),"[ASSERT FAILED]: Layout Test failed");
		
	}

	public void goToAccountSettingsPage() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").contains("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(10);
		}
		executeJavascript("document.getElementsByClassName('dropdown-menu')[0].getElementsByTagName('li')[1].getElementsByTagName('a')[0].click()");
		//executeJavascript("document.getElementsByTagName('li')[0].getElementsByTagName('a')[2].click()");		
	}

	public void verifyMoveToWishList() 
	{
		if((ConfigPropertyReader.getProperty("browser").contains("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(1);
			
		}
		hardWait(1);
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("label_your_wishlist");
		logMessage("label wishlist is displayed");
		element("label_your_wishlist").click();
		wait.waitForPageToLoadCompletely();
		logMessage("Verified product is moved to WishList");
//			executeJavascript("document.getElementsByTagName('li')[0].getElementsByTagName('a')[4].click()");
	}

	public void closeCrossCookieIcon() {
		executeJavascript("document.getElementsByClassName('icon-cookie-close')[0].click();");
//		click(element("icon_cross_cookie"));
	}

	public void clickOnShoppingBagIcon() {
		waitForLoad();
		hardWait(3);
		executeJavascript("document.getElementsByClassName('cart-quantity')[0].click()");
		logMessage("User clicks on Cart bag");
		executeJavascript("document.getElementsByClassName('btn btn-primary')[0].click()");
		logMessage("User clicks on Proceed to checkout");
	}

	public AccountPage mobile_clickOnSignINRegister() {
		wait.waitForPageToLoadCompletely();
		scrollWindow(0, 300);
		waitForLoad();
		executeJavascript("document.getElementsByClassName('btn btn-default signin')[1].click()");
		//click(element("login_register_button"));
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		logMessage("User clicks on sign in");
		return new AccountPage(driver);
	
	}

	public void verify_COACH_LogoRedirectsToHomepage() {
		waitForLoad();
		hardWait(1);
		executeJavascript("document.getElementsByClassName('large-logo-v2')[0].getElementsByTagName('a')[0].click();");
		msg.log("User clicks on COACH logo");
	}

}
