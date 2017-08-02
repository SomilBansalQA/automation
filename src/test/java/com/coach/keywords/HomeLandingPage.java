package com.coach.keywords;

import static org.testng.Assert.*;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class HomeLandingPage extends GetPage {

	WebDriver driver;
	String url;
	public HomeLandingPage(WebDriver driver)
	{
		super(driver,"coach/HomeLandingPage");
		this.driver = driver;
	}

	public void verifyLandingPage(){
		verifyPageTitleContains();
	}

	public void verify_404_page() {
		isElementDisplayed("title");
		logMessage("Sorry, This Page No Longer Exists is displayed");
		isElementDisplayed("search_box");
		logMessage("SEARCH BOX is displayed");
		isElementDisplayed("new_for_her");
		logMessage("NEW FOR HER is displayed");
		scrollWindow(0,250);
		isElementDisplayed("new_for_him");
		logMessage("NEW FOR HIM is displayed");
		scrollWindow(0, 1000);
		isElementDisplayed("question");
		logMessage("Have Any Questions? is displayed");

	}

	public void clickOnForgotPasswordLink() {
		element("link_forgot_password").click();
		msg.log("Clicked on forgot password link");

	}
	
	public String getLandingPageTitle() {
		wait.waitForPageToLoadCompletely();
		
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void checkSelectedCategory(String selectedCategory1){
		isElementDisplayed("categorySelected");
		String selectedCategory=element("categorySelected").getText();
		assertEquals(selectedCategory, selectedCategory1,"Category not matched");
	}
	
	
	public void verifyShopGridCategoryBannerAndTitle(String pageTitle1,String categoryBanner){
		
		//assertEquals(getLandingPageTitle(), pageTitle1,"Title not matched");
		assertEquals(getCategoryBanner(), categoryBanner,"Category not matched");
	}
	
	public String getCategoryBanner() {
		waitForLoad();
		isElementDisplayed("shopGridCategoryBanner");
		String category = element("shopGridCategoryBanner").getText();
		return category;

	}
	
	public void verifyFilterCategory(){
		isElementDisplayed("filterCategory","Material");
		msg.log("Filter Material found");
		url=driver.getCurrentUrl();
		if(url.contains("uk")){
			isElementDisplayed("filterCategory","Colour");
		}
		else{
			isElementDisplayed("filterCategory","Color");
		}
		
		msg.log("Filter Color found");
		isElementDisplayed("filterCategory","Category");
		msg.log("Filter Color found");
		isElementDisplayed("filterSort", "Sort");
		msg.log("Filter Sort found");
		
	}
	
	public void verifyAndApplyColorFilter(String filter){
		url=driver.getCurrentUrl();
		if(url.contains("uk"))
		{
		hoverClick(element("filterCategory","Colour"));
		executeJavascript("document.getElementById('refinement-colorGroup').getElementsByClassName('category-dropdownnavlist')[0].style.display = 'block'");
		isElementDisplayed("colorSubFilterUK", "Red");
		isElementDisplayed("colorSubFilterUK", "Beige");
		isElementDisplayed("colorSubFilterUK", "Black");
		isElementDisplayed("colorSubFilterUK", "Blue");
		isElementDisplayed("colorSubFilterUK", "Brown");
		isElementDisplayed("colorSubFilterUK", "Green");
		isElementDisplayed("colorSubFilterUK", "Grey");
		element("colorSubFilterUK", ""+filter+"").click();
		element("colorSubFilterUK", ""+filter+"").click();
		}
		else{
			hoverClick(element("filterCategory","Color"));
			executeJavascript("document.getElementById('refinement-colorGroup').getElementsByClassName('category-dropdownnavlist')[0].style.display = 'block'");
			isElementDisplayed("colorSubFilter", "Red");
			isElementDisplayed("colorSubFilter", "Beige");
			isElementDisplayed("colorSubFilter", "Black");
			isElementDisplayed("colorSubFilter", "Blue");
			isElementDisplayed("colorSubFilter", "Brown");
			isElementDisplayed("colorSubFilter", "Green");
			isElementDisplayed("colorSubFilter", "Grey");
			element("colorSubFilter", ""+filter+"").click();
		}
		
		
		
	}
	
	public void clickOnColorFilterAndVerifyHeaderCount(String filter,String filter2){
		handle_DontMissOutWindow();
		waitForLoad();
		executeJavascript("document.getElementById('refinement-colorGroup').getElementsByClassName('category-dropdownnavlist')[0].style.display = 'block'");
		hardWait(1);
		if(url.contains("uk")){
			wait.waitForElementToBeClickable(element("colorSubFilterUK", ""+filter+""));
			executeJavascript("$('#refinement-colorGroup')[0].getElementsByTagName('li')[1].click()");
			hardWait(3);
			wait.waitForPageToLoadCompletely();
			executeJavascript("$('#refinement-colorGroup')[0].getElementsByTagName('li')[0].click()");
			hardWait(3);
			wait.waitForPageToLoadCompletely();
			}
		else{
			element("colorSubFilter", ""+filter+"").click();
			wait.waitForPageToLoadCompletely();
			wait.hardWait(3);
			executeJavascript("document.getElementById('refinement-colorGroup').getElementsByClassName('category-dropdownnavlist')[0].style.display = 'block'");
			element("colorSubFilter", ""+filter2+"").click();
			hardWait(3);
		}
		
		String colorHeaderCount=executeJavascriptReturnsString("return $('#refinement-colorGroup .refinement-count').text()");
		assertEquals(colorHeaderCount.trim(), "(2)");
	}
	
	public void verifysubFilter(String text){
		wait.waitForElementsToBeVisible(elements("subFilter"));
		assertTrue(element("subFilter").isDisplayed());
		String subFilter=element("subFilter").getText().replaceAll("\\r\\n|\\r|\\n", "");
		String localeStr = StringUtils.substringBetween(subFilter, "REMOVE", "X");
		assertEquals(localeStr, text.toUpperCase());
		logMessage("sub filter is visible");
		
	}
	
	public void verifySelectedfiltersShouldCleared(){
		wait.waitForPageToLoadCompletely();
		boolean subFilter=executeJavascriptReturnsBoolean("return $('.refinement-pill-clear>a').is(':visible')");
		assertEquals(subFilter, true ,"subFilter not visible");
		isElementDisplayed("btnClear");
		element("btnClear").click();

		
	   
	}
	
	public void verifyClearButton(String btnClear){
		wait.waitForElementsToBeVisible(elements("btnClear"));
		assertTrue(element("btnClear").isDisplayed());
		String text=element("btnClear").getText();
		assertEquals(text, btnClear,"button not matched");
	}
	
	public void verifyBreadCrumsAndViewAllHeader(String breadCrumeValue){
		wait.waitForPageToLoadCompletely();
		boolean viewAllHeader=executeJavascriptReturnsBoolean("return $('span:contains(\"View All\")').is(':visible')");
		Assert.assertEquals(viewAllHeader, true,"View all Header not visible");
		String breadCrum=element("link_breadCrum").getText();
		logMessage("BreadCrum-----"+breadCrum);
		Assert.assertEquals(breadCrum, breadCrumeValue,"BreadCrum not matched");
	}
	
	public void checkViewAllBreadCrumbDropDown(){
		waitForLoad();
		executeJavascript("$('.category-dropdownnavlist')[0].style.display='block'");
		hardWait(1);
		assertEquals(getBreadCrumbFontWeight(0), true,"View All is not in Bold Font");
		
	}
	
	public void VerifyBreadcrumbCountAfterApplyingFilters(){
		executeJavascript("$('.category-level-1.list-unstyled li')[1].children[0].click()");
		String selectProduct=executeJavascriptReturnsString("$('.list-unstyled li')[1].children[0].text");
		String selectedBreadCrumb=executeJavascriptReturnsString("$('.category-dropdowntitle').eq(0).text()");
		wait.waitForPageToLoadCompletely();
		assertEquals(selectProduct, selectedBreadCrumb,"product not matched");
		executeJavascript("$('.category-dropdownnavlist')[0].style.display='block'");
		hardWait(1);
		String fontWeight=executeJavascriptReturnsString("return $('.refinement-link.view-all').eq(1).css('font-weight')");
		assertEquals(fontWeight, "bold","View All is not in Bold Font");
		String productCount=executeJavascriptReturnsString("return $('a.refinement-link.view-all')[1].getElementsByClassName('product-count')[0].textContent");
		String breadCrumbProductcount=StringUtils.substringBetween(productCount, "(", ")");
		long landingPageCount=executeJavascriptReturnsLong("return $('.search-result-content .col-xs-6.prod-grid').length");
		String landingPageCount1=String.valueOf(landingPageCount);
		assertEquals(breadCrumbProductcount, landingPageCount1,"Count not matched");
		
	}
	
	public boolean getBreadCrumbFontWeight(int i){
		String fontWeight=executeJavascriptReturnsString("return $('.refinement-link.view-all').eq("+i+").css('font-weight')");
		int foo = Integer.parseInt(fontWeight);
		logMessage("Font Weight for selected product is : "+fontWeight);
		if(foo>400){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	

	public void verifyPasswordRequestPopupIsOpen() {
		isElementDisplayed("popup_passwordRequest");
		msg.log("Password Request Pop up is displayed");

	}

	public void enterEmailAddressForPasswordRecovery(String email) {
		element("textbox_email_password_recovery").sendKeys(email);
		msg.log("Entered email for password recovery");
		element("button_submit_password_recovery").click();
		msg.log("Clicked on submit button for password recovery");

	}

	public void verifyEmailIsSendToUser() {
		wait.waitForLoad();
		isElementDisplayed("popup_password_recieve_email");
		msg.log("Email is send to user for password recovery");

	}
	
	public void verifyOnlineExclusiveItem(String itemName){
		long totalNumberOfOnlineExclusiveItem=executeJavascriptReturnsLong("return $('a:contains(\""+itemName+"\")').length");
		logMessage("Total number of Online Exclusive item "+totalNumberOfOnlineExclusiveItem);
		boolean item=executeJavascriptReturnsBoolean("return $('a:contains(\""+itemName+"\")').is(':visible')");
		assertEquals(item, true);
	}

	public void clickOnViewAllForSectionNew() {
		handle_DontMissOutWindow();
		wait.waitForPageToLoadCompletely();
		hover(element("label_new"));
		msg.log("Clicked on New Category");
		element("label_view_all").click();
		msg.log("Clicked on View All for New Category");


	}

	public void verifyHeaderIcons() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("icon_account");
		msg.log("Header Icon Account Is displayed");
		isElementDisplayed("icon_wishlist");
		msg.log("Header Icon WishList Is displayed");
		isElementDisplayed("icon_cart");
		msg.log("Header Icon Card Is displayed");
	}

	public void clickOnAccountIconFromHeader() {
		isElementDisplayed("icon_account");
		element("icon_account").click();
		msg.log("Clicked on Account Icon from header");
	}

	public void verifyUtilityNavigationDropdown() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		hover(element("icon_account"));
		wait.hardWait(4);
		isElementDisplayed("link_account_setting");
		msg.log("Account Setting is displayed");
		isElementDisplayed("link_order_history");
		msg.log("Order history is displayed");
		isElementDisplayed("link_sign_out");
		msg.log("Sign Out is displayed");
	}

	public void clickOnFindYourPerfectWallet() {
		isElementDisplayed("link_find_Your_Perfect_wallet");
		handle_DontMissOutWindow();
		click(element("link_find_Your_Perfect_wallet"));
		msg.log("Clicked on Find Your Perfect Wallet");
		wait.hardWait(2);
		isElementDisplayed("section_find_your_perfect_wallet");
		msg.log("Find Your perfect wallet section is displayed");
	}

	public void verifyFindYourPerfectWallet() {
		for(WebElement filters : elements("filters_find_your_perfect_wallet"))
		{  
			msg.log(filters.getText());	
		}

	}

	public void verifyFiltersForFindYourPerfectWallet() {
		for(int i=0;i<elements("checkbox_filters_perfect_wallet").size();i++)	
		{   
			boolean  flag=elements("checkbox_filters_perfect_wallet").get(i).isEnabled();
			Assert.assertTrue(flag, "Assertion failed: Radio buttons are not enabled");
		}
		msg.log("Assertion passed : Radio buttons are enabled");

	}

	public void clickOnAnyFilterForPerfectWallet() {
		wait.waitForPageToLoadCompletely();
		hardWait(3);
		executeJavascript("$('#perfect-wallet__filter-item-4').click()");
		msg.log("User click on perfect wallet filter 4");
		hardWait(3);
		executeJavascript("$('#perfect-wallet__filter-item-Bill_Compartments').click()");
		msg.log("User clicks on perfect wallet bill compartment");
		wait.waitForPageToLoadCompletely();
		hardWait(3);
		String disabled = executeJavascriptReturnsString("return document.getElementById('perfect-wallet__filter-item-ID_Window').getAttribute('class')");
        if (disabled.contains("disabled")){
        	msg.log("Element is gary out");
        }
        else
        	msg.log("Element is not gray out");
		isElementDisplayed("button_results_wallet");
		msg.log("Results button is enabled after selecting filters");

	}

	public void verifyResultsButton() {
		wait.waitForPageToLoadCompletely();
		String results=element("button_results_wallet").getText();
		msg.log(results);
		hardWait(3);
		executeJavascript("$('.perfect-wallet__btn-select.active')[0.].click();");
		msg.log("Clicked on results button"); 
		wait.waitForElementToBeVisible(element("button_clear"));
		String[] parts = results.split(" ");
		msg.log(parts[1]);
		hardWait(2);
		long total_products = executeJavascriptReturnsLong("return $('.product-image').length;");
		//msg.log(total_products);
		String s=String.valueOf(total_products);  
		hardWait(3);
		Assert.assertEquals(s, parts[1],"Products are not dispalyed as per the filters selected");
		msg.log("Products are dispalyed as per the filters selected");

	}

	public void clickOnClearAllOnFindYourperfectwalletSection() {
		click(element("link_clear_all"));
		msg.log("Clicked on clear-all on perfect wallet");

	}

	public void closePerfectWalletSection() {
		click(element("title_wallet_guide"));
		msg.log("Closed Perfect wallet section");


	}
	
	public void verifyShopGridIsVisible(){
		wait.waitForElementToBeVisible(element("shopGridContainer"));
		assertEquals(element("shopGridContainer").isDisplayed(), true,"Shop grid container not visible");
	}
	
	
	
	

	public void verify_InvalidParameterPassedInURLPage() {
		isElementDisplayed("title");
		logMessage("Sorry, This Page No Longer Exists is displayed");
		isElementDisplayed("search_box");
		logMessage("SEARCH BOX is displayed");
		isElementDisplayed("new_for_her");
		logMessage("NEW FOR HER is displayed");
		scrollWindow(0,250);
		isElementDisplayed("new_for_him");
		logMessage("NEW FOR HIM is displayed");
		scrollWindow(0, 1000);
		isElementDisplayed("question");
		logMessage("Have Any Questions? is displayed");


	}

	public void verifyWalletcategories() {
		wait.waitForPageToLoadCompletely();
		for(WebElement a : elements("categories_mens_wallet"))
		{ 
			Assert.assertTrue(a.isDisplayed(), "Assertion failed : All Mens categories not displayed");
			msg.log("Assertion Passed : " + a.getText() + "  category is displayed" );
		}
	}

	public String clickOnAnyCategoryForWalletsForMen() {
		click(element("category_card_wallet"));
		msg.log("Clicked on category Card under Men's wallet");
		String category =element("category_card_wallet").getText();
		return category;
	
	}

	public void verifyShopGridForCategorySelected(String category) {
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		System.out.println(element("category_shop_grid_wallet").getText().toLowerCase());
		Assert.assertTrue(element("category_shop_grid_wallet").getText().toLowerCase().contains(category.toLowerCase()), "Assertion Failed : Shop grid results  not displayed based on the category selected");
		msg.log("Assertion passed : Shop grid results displayed based on the category selected");
	}

	public void verifyShopGridForCategoryIsDeSelected() {
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		handle_DontMissOutWindow();
		Assert.assertTrue(element("category_shop_grid_wallet").getText().toLowerCase().contains("View All".toLowerCase()), "Assertion Failed : Shop grid with view all filter not displayed on  deselecting the category ");
		msg.log("Assertion Passed : Shop grid with view all filter displayed on  deselecting the category ");
	}

	public String clickOnAnyCategoryForWalletsForWomen() {
		String category =element("category_card_cases_wallet").getText();
		click(element("category_card_cases_wallet"));
		msg.log("Clicked on category Card  Cases under Women's wallet");
		return category;
	}

	public void clickOnViewAllForWomenBags() {
	   element("link_view_women_bags").click();
	   msg.log("Clicked on view all for women bags");		
	}
	
	public void scrollDownToBottom() {
		wait.waitForPageToLoadCompletely();
		scrollWindow(0,10000);	
		msg.log("User scrolled to bottom");
	}
}
