package com.coach.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class MainHeader extends GetPage {
	WebDriver driver;

	public MainHeader(WebDriver driver)
	{
		super(driver,"coach/MainHeader");
	} 
	
	public boolean verify_Home_Page_Header(){
		wait.waitForPageToLoadCompletely();
		return (isElementDisplayed("header_tab"));
	}
	
	public void goToWoMenSection(){
		hover(element("women_tab"));
		msg.log("Hover At womwn section");
	}
	
	public void goToMenSection(){
		wait.waitForPageToLoadCompletely();
		hover(element("men_tab"));
		msg.log("Hover At men Section");
	}

	public void logout() {
		hover(element("button_sign_out"));
		click(element("linkText_Signout"));
		
	}
	
	public void verifyLogo(){
		  isElementDisplayed(("logo_Coach"));
		 }


	public void hoverAtWomenLink() {
		wait.waitForPageToLoadCompletely();
		hover(element("women_tab"));
		msg.log("Hovered on Women category");
		isElementDisplayed("subcategories");
		msg.log("Subcategories for women are dispalyed");
	}

	public void hoverAtbagLink() {
		hover(element("bags_tab"));
		hardWait(2);
	}

	public void hoverAtcoach1941Link() {
		hover(element("coach1941_tab"));
		msg.log("Hovered on Coach 1941 category");
		hardWait(2);
		isElementDisplayed("subcategories");
		msg.log("Subcategories for coach 1941 are dispalyed");
		
	}

	public void hoverAtgiftsLink() {
		hover(element("gifts_tab"));
		msg.log("Hovered on Gifts category");
		hardWait(2);
		isElementDisplayed("subcategories");
		msg.log("Subcategories for gifts are dispalyed");
		
	}

	public void hoverAtsaleLink() {
		hover(element("sale_tab"));
		hardWait(2);
		
	}

	public void hoverAtworlsofcoachLink() {
		hover(element("worlsofcoach_tab"));
		
	}

	public void hoverAtmenLink() {
		hover(element("men_tab"));
		msg.log("Hovered on Men category");
		hardWait(3);
		isElementDisplayed("subcategories");
		msg.log("Subcategories for men are dispalyed");
		
	}

	public void VerifyBurgerElements() {
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementsByClassName('burger icm-icon-burger')[0].click()");		
		verifyPresenceOfLinks();		
		//nvigateToLinks();
		
	}

	private void nvigateToLinks() {
		click(element("women_tab"));
		hardWait(1);
		click(element("women_tab"));
		
		click(element("men_tab"));
		hardWait(1);
		click(element("men_tab"));
		
		click(element("bags_tab"));
		hardWait(1);
		click(element("bags_tab"));
		
		click(element("coach1941_tab"));
		hardWait(1);
		click(element("coach1941_tab"));
		
		click(element("worlsofcoach_tab"));
		hardWait(1);
		click(element("worlsofcoach_tab"));
		
		click(element("gits_tab"));
		hardWait(1);
		click(element("gits_tab"));
		}

	private void verifyPresenceOfLinks() {
		isElementDisplayed("women_tab");
		isElementDisplayed("men_tab");
		//isElementDisplayed("bags_tab");
		isElementDisplayed("coach1941_tab");
		//isElementDisplayed("personalise_tab ");
		//isElementDisplayed("worlsofcoach_tab");
		isElementDisplayed("gifts_tab");
		//isElementDisplayed("sale_tab");
		msg.log("User verify the header links and categories");
	}

	public void hoverAtNewLink() {
		hover(element("new_tab"));
		msg.log("Hovered on New category");
		wait.hardWait(2);
		isElementDisplayed("subcategories");
	}

	public void hoverAtPersonalizeLink() {
		hover(element("personalize_tab"));
		msg.log("Hovered on personalize category");
		hardWait(2);
		isElementDisplayed("subcategories");
		msg.log("Subcategories for personalize are dispalyed");
	}


	public void verifyFindAStoreLinkIsPresentAtTopOfHomePage() {
		isElementDisplayed("find_a_store_link");
		msg.log("Find A Store is present");
		
	}

	public void ClickOnFindAStoreLink() {
		click(element("find_a_store_link"));
		msg.log("Use clicks on Find A Store");
		
	}

	public void clickOnWomenTab() {
		waitForLoad();
		click(element("women_tab"));
		msg.log("User clicks on Women Tab");
		
	}

	public void clickOnWomenBag() {
		waitForLoad();
		click(element("bags_tab"));
		waitForLoad();
		click(element("women_handbags_satchels"));
	
		hardWait(5);
	}

	public void verifyCategoriesOnHeader() {
		isElementDisplayed("men_tab");
		msg.log("Men Category  is displayed");
		isElementDisplayed("women_tab");
		msg.log("Women Category  is displayed");
		isElementDisplayed("new_tab");
		msg.log("New Category  is displayed");
		isElementDisplayed("coach1941_tab");
		msg.log("Coach 1941 Category  is displayed");
		isElementDisplayed("personalize_tab");
		msg.log("Personalize Category  is displayed");
		isElementDisplayed("gifts_tab");
		msg.log("Gifts Category  is displayed");
//		isElementDisplayed("sale_tab");
//		msg.log("Sale Category  is displayed");
		isElementDisplayed("icon_search");
		msg.log("Search Icon is displayed");
		isElementDisplayed("text_search");
		msg.log("Search text is displayed");
	}

	public void verifyFooterSections() {
		isElementDisplayed("text_stores_sites");
		msg.log("Store and site section  is present in footer");
		isElementDisplayed("text_customercare");
		msg.log("Customer section  is present in footer");
		isElementDisplayed("text_about_us");
		msg.log("About Us section  is present in footer");
		isElementDisplayed("text_follow_us_on");
		msg.log("Follow Us On section  is present in footer");
		isElementDisplayed("text_connect");
		msg.log("Connect With Coach section  is present in footer");
		
	}

	public void verify_UserIsRedirectedToHomepageOnChangingTheLanguage() {
		waitForLoad();
		hardWait(1);
		scrollWindow(1000, 0);
		executeJavascript("document.getElementsByClassName('large-logo-v2')[0].getElementsByTagName('a')[0].click();");
		msg.log("User clicks on COACH logo");
		scrollWindow(0, 10000);
		isElementDisplayed("current_language");
		msg.log("Element to change the language is displayed");
		element("current_language").click();
		msg.log(element("current_language").getText()+ "is the selected language");
		getCurrentURL().contains("home");
		Assert.assertTrue(getCurrentURL().contains("home"));
		msg.log("verified user is redirected to homepage on changing the language");
		
	}

	public void verifyWalletGuideForMen() {
		isElementDisplayed("link_wallet_guide_men");
		msg.log("Wallet guide is displayed under Men section");
		
	}

	public void clickOnWalletGuideFormen() {
		click(element("link_wallet_guide_men"));
		msg.log("Clicked on wallet guide under Men Section");
		
	}

	public void verifyWalletGuideShopForMenDisplayed() {
		wait.waitForPageToLoadCompletely();
		handle_DontMissOutWindow();
		isElementDisplayed("title_wallet_guide");
		msg.log("Wallet guide page is displayed for men");
		
	}

	public void verifyWalletGuideForWomen() {
		isElementDisplayed("link_wallet_guide_women");
		msg.log("Wallet guide is displayed under Women section");
		
	}
	
	public void clickOnWalletGuideForWomen() {
		click(element("link_wallet_guide_women"));
		msg.log("Clicked on wallet guide under Women Section");
		
	}

	public void verify_wishlistOptionInMenu() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("wishlist");
		msg.log("Wishlist option is displayed in menu bar");
		
	}
	
	

}
