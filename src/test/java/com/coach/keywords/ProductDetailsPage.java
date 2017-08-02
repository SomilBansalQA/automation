package com.coach.keywords;


import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

import org.openqa.selenium.By;

public class ProductDetailsPage extends GetPage {

	public ProductDetailsPage(WebDriver driver)
	{
		super(driver,"coach/ProductDetailsPage");
	}  

	public void Add_To_Bag(){
		wait.waitForPageToLoadCompletely();
		waitForLoad();		
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('add-to-cart')[1].click();");
		hardWait(3);
		msg.log("Clicked on Add to bag");
		//methodToVerifyProductHasBeenAddedToCart();

	}
	public void verifyProductQuantity() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("list_product_quantity");
		String Qty = executeJavascriptReturnsString("return $('#variant-label').text()");
		msg.log(Qty + "is displayed");
		msg.log("Verify product quantity is displayed");

	}

	public void verifyProductWishList() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(element("button_product_wishlist"));
		isElementDisplayed("button_product_wishlist");
	}

	public void verifyBacktoResultPage() {
		wait.waitForPageToLoadCompletely();
		backButton();
		msg.log("Verify back to result page is displayed and click");
	}

	public void verifyAndNavigateToLinkAddAMonogram(){
		wait.waitForPageToLoadCompletely();
		scrollWindow(0, 300);
		waitForLoad();
		executeJavascriptReturnsBoolean("return $('.add-monogram-link').is(':visible')");
		String monogram = executeJavascriptReturnsString("return $('.add-monogram-link').text()");
		msg.log(monogram);
		executeJavascript("document.getElementsByClassName('add-monogram-link')[0].click();");
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		hardWait(2);
	}	

	public boolean verifyOnlySelectedProductOpensInTheProductDisplayPage(String productNameinResultPage) {
		if (productNameinResultPage.contains(element("link_product_name_indisplay_page").getText())) {
			return true;
		}
		return false;

	}

	public String status(){
		return webdriver.findElement(
				By.cssSelector(".product-add-to-cart #add-to-cart"))
				.getText().toLowerCase();
	}

	public void verifySelectedProductDescription() {
		hardWait(2);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			scrollWindow(0, 500);
			hardWait(5);
		}
		String Pname = executeJavascriptReturnsString("return $('.title-area.clr>h1').text()");
		msg.log(Pname);
		isElementDisplayed("tag_product_detail");
		isElementDisplayed("tag_product_full_description");
		String description = executeJavascriptReturnsString("return $('.pdp-info__details-content').text()");
		msg.log(description);
		boolean Pdes = executeJavascriptReturnsBoolean("return $('.pdp-info__details-content').is(':visible')");
		assertEquals(Pdes, true,"Discription is not visible");
		msg.log("Product description is displayed");
	}

	public void verifySelectedProductImageAndClickedOnZoom() {
		// TODO Auto-generated method stub
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		isElementDisplayed("image_icon");
		isElementDisplayed("button_zoom_product_image");
	}


	public void pickUpInAStore(String zip){
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		scrollWindow(0, -200);	
		if((ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			executeJavascript("document.getElementsByTagName('dt')[0].getElementsByTagName('a')[0].click();");
			waitForLoad();
		}
		else{
			waitForLoad();
			isElementDisplayed("link_pick_up_in_store");
			hardWait(2);
			click(element("link_pick_up_in_store"));
		}
		waitForLoad();
		sendText(element("text_bopus_search"), zip);
		click(element("btn_bopus_submit"));
		hardWait(2);
		scrollWindow(0, -400);
		executeJavascript("document.getElementById('add-to-cart-bopus').click();");
	}

	public void purchaseGiftCard() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		handle_DontMissOutWindow();
		click(element("link_purchase_giftcard"));
		msg.log("Clicked on purchase gift cards");
		hardWait(3);
		sendText(element("field_giftcard_amount"), "100");
		click(element("btn_gift_add_to_bag"));
		msg.log("Clicked on button gift add to bag");
	}

	public void addProductToWishlist() {

		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		scrollWindow(0,500);
		hardWait(1);
		waitForLoad();
		executeJavascript("document.getElementsByClassName('add-to-wishlist')[0].click();");
		msg.log("Product is added to WishList");
		//element("button_product_wishlist").click();
	}

	public void closeWishlistPopup() {
		waitForLoad();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("btn_close_popup_wishlist");
	}

	public void verifyPriceGreaterThanZero() {
		String price="";
		try{
		isElementDisplayed("label_price");
		price=(element("label_price").getText());
		}
		
		catch(AssertionError ex){
			price= element("productPrice").getText();

		}
		//		String price=(element("label_price").getText()).substring(1);
		
		String newPrice = price.replaceAll("[^0-9]", "");


		System.out.println(price);
		System.out.println(newPrice);

		float price1 =Float.parseFloat(newPrice);

		int price2=Math.round(price1);
		Assert.assertTrue((price2)>0);
	}
	

	public void verifyCurrentImageAndFullViewImage() {
		isElementDisplayed("current_image");
		isElementDisplayed("innerImage");
		isElementDisplayed("productName");

		//		String back=element("label_back").getText();
		//		Assert.assertTrue(back.equals("< BACK"));

		//		String close = element("label_close").getText();
		//		Assert.assertTrue(close.equals("close"));

		//executeJavascript("document.getElementById('closeFullScreen').click();");
	}

	public void verifyLablesInPDPPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("label_details");
		isElementDisplayed("label_colour_name");
		isElementDisplayed("label_description");
		isElementDisplayed("lable_styleNo");
		
		msg.log("PDP Page is Displayed  and labels are verified");

	}

	public void verifyIconsAndSizeChart() {
		wait.waitForPageToLoadCompletely();
		boolean sizeChart = executeJavascriptReturnsBoolean("return $('.custom-select.select-size').is(':visible')");
		assertEquals(sizeChart,true,"Size chart is not displayed");{
		msg.log("Size chart is displayed");
		}
		isElementDisplayed("link_sizeChart");
		isElementDisplayed("icon_facebook");
		isElementDisplayed("icon_twitter");
		isElementDisplayed("button_product_wishlist");
		isElementDisplayed("icon_pin");
		element("link_sizeChart").click();
		hardWait(1);
		assertEquals(element("tableSizeChart").isDisplayed(), true);
		
	}

	public void verifyBradCrumAndSwiperContainer() {
		wait.waitForPageToLoadCompletely();
		assertTrue(isElementDisplayed("label_breadcrum"), "breadCrumNotvisible");
		assertTrue(isElementDisplayed("img_swiperContainer"), "swiper container not visible");
	}

	public void verifySizeDropDwonIsNotDisplayed() {
		waitForLoad();
		isElementNotDisplayed("link_sizeChart");
		System.out.println("Size label is not displayed");
		

	}


	public void selectSizeOfTheProduct(String size) {
		waitForLoad();
		isElementDisplayed("link_sizeChart");
		msg.log("Size is displayed");
		selectOptionFromDropDownList("options_size", size);
		//		executeJavascript("document.getElementsByClassName('btn dropdown-toggle selectpicker btn-default')[0].click()");
		//		msg.log("User clicks on select button");
		//		executeJavascript("document.getElementsByClassName('swatchanchor required swatchanchorforsize')[1].click()");
		msg.log("User selects a size");

	}

	public void clickOnNotifyMe() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("button_notifyMe");
		msg.log("NOTIFY ME is displayed");
		element("button_notifyMe").click();
		msg.log("User clicks on Notify Me");

	}

	public void verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("notifyMeMessage");
		if(getElementSize("notifyMeMessage")==1) {
			Assert.assertNotSame(element("notifyMeMessage").getText(),"Sign me up to receive emails about the latest Coach, Inc. news & styles. Read our privacy policy","msg not found");
			msg.log(element("notifyMeMessage").getText());
		}
		else {
			msg.log(" SIGN ME UP TO RECEIVE EMAILS ABOUT THE LATEST COACH NEWS & STYLES. READ OUR PRIVACY POLICY is not displayed");
		}

	}

	public void italy_verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("italy_label_notifysignup_customer");
		if(getElementSize("italy_label_notifysignup_customer")==1) {
			Assert.assertEquals(element("italy_label_notifysignup_customer").getText(),"Selezionando la casella, l’utente accetta di ricevere comunicazioni pubblicitarie da Coach, Inc. tramite posta elettronica.");
			msg.log(element("italy_label_notifysignup_customer").getText());
		}
		else {
			msg.log("Message was not found");
		}

		waitForLoad();
		scrollToElement("italy_label_addtorecommendationlist");
		if(getElementSize("italy_label_addtorecommendationlist")==1) {
			Assert.assertEquals(element("italy_label_addtorecommendationlist").getText(),"Selezionando la casella, l’utente accetta che Coach possa utilizzare i dati personali dell’utente per analizzare le preferenze e/o le tendenze individuali.");
			msg.log(element("italy_label_addtorecommendationlist").getText());
		}
		else {
			msg.log("Message was not found");
		}

		element("close_notifyMe").click();
		msg.log("Notify me is closed");

	}

	public String verify_ProductColorVarientsArePresent() throws InterruptedException {
		waitForLoad();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			scrollWindow(0, 500);
		}
		waitForLoad();
		scrollToElement("swatches_color");
		if(getElementSize("swatches_color")==1)
		{
			isElementDisplayed("swatches_color");
			msg.log("swatches color is displayed");
		}
		else
			msg.log("Color swatches are not displayed");
		isElementDisplayed("label_color");
		String color=element("label_colour_name ").getText();
		return color;
	}

	public void verifyAllcolorsOfproductisdisplayed() {
		List<WebElement> colors = elements("list_colors");
		boolean flag= false;
		if(colors.size()>1){
			flag=true;
			msg.log("Color Variants are present");
		}
		Assert.assertTrue(flag,"Assertion Failed : Color Variants are  not present");
	}

	public void verifyRecentlyViewedItemsAredisplayed() {
		wait.waitForPageToLoadCompletely();
		scrollDown(element("text_recently_viewed_items"));
		isElementDisplayed("text_recently_viewed_items");
		msg.log("Recently viewed section is displayed");

	}

	public void increaseQuantityOfProductPDPpage(String quantity) {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		selectOptionFromDropDownList("list_dropdown_quantity",quantity );
		msg.log("Selected quantity value: " +  quantity);
	}

	public void verifyErrorMsgDisplayedAfterItemExceedsQuantityRestriction() {
		wait.hardWait(4);
		isElementDisplayed("text_error_msg");
		msg.log("Verified Error Msg Displayed After Item Exceeds Quantity Restriction");
	}

	public void verifyArrowsForScrollFunctionalityForMiniCart() {
		isElementDisplayed("arrow_scrollup");
		msg.log("Scroll Up button is displayed for mini cart");
		isElementDisplayed("arrow_scrolldown");
		msg.log("Scroll Down button is displayed for mini cart");

	}

	public void verifyPDPForNotifyLink(String email) {
		isElementDisplayed("button_notify_me");
		msg.log("Notify me is displayed for Sold Out or Coming Soon Products");
		click(element("button_notify_me"));
		msg.log("Clicked on notify link button");
		element("text_email_notify").sendKeys(email);
		msg.log("Entered email for notify me link");
		element("text_confirm_email_notify").sendKeys(email);
		msg.log("Entered confirm email for notify link");
		click(element("button_submit_notify"));
		msg.log("Clicked on submit button for notify link");

	}


	public void verifyPriceFromat(String country)
	{ String pricepattern;
		try{
		
		 pricepattern= element("label_price").getText();
	}
	catch(AssertionError ex){
		 pricepattern= element("productPrice").getText();
	}
		
		String validPatternForpriceint = null,validPatternForpricefloat = null;
		switch(country)
		{
		case "IT" :
		case "FR" :
		case "ES" :	
			validPatternForpriceint= "\\d{1,5}\\€";
			validPatternForpricefloat="\\d{1,5}\\.\\d{1,5}\\€";
			break;
		case "UK" :
			 validPatternForpriceint= "\\£\\d{1,5}";
			 validPatternForpricefloat="\\£\\d{1,5}\\.\\d{1,5}";
			break;
		case "DE" :
			validPatternForpriceint= "\\€\\d{1,5}";
			validPatternForpricefloat="\\€\\d{1,5}\\.\\d{1,5}";
			break;
		case "US" :
			validPatternForpriceint= "\\$\\d{1,5}";
			validPatternForpricefloat="\\$\\d{1,5}\\.\\d{1,5}";
		}
	
		Assert.assertTrue(verifyFormat(pricepattern, validPatternForpriceint)|| verifyFormat(pricepattern, validPatternForpricefloat),"Assertion failed : Price pattern is not matching");
		msg.log("Assertion passed : price pattern matched for :  "  + country );
	}

	public void verifyProductName() {
		wait.waitForPageToLoadCompletely();
		hardWait(1);
		String Pname = executeJavascriptReturnsString("return $('.title-area.clr>h1').text()");
		msg.log(Pname);
		
	}

	public void verifyProductNameIsDisplayedInPDPAndMiniCart() {
		hardWait(1);
		String mini_cart_name = executeJavascriptReturnsString("return document.getElementsByClassName('mini-cart-name')[0].getElementsByTagName('a')[0].textContent");
		msg.log(mini_cart_name); //ROGUE 25 IN GLOVETANNED PEBBLE LEATHER
		System.out.println("2");
		String prdt_name = executeJavascriptReturnsString("return document.getElementsByClassName('product-name-desc')[0].textContent");
		msg.log(prdt_name);
		System.out.println("3"); //rogue   25   in glovetanned pebble leather
		Assert.assertEquals(mini_cart_name.trim().toUpperCase() , prdt_name.trim().toUpperCase().trim(),"Product name in PDP & mini cart are not same");
		
	}


}
