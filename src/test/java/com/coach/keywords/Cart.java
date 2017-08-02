package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class Cart extends GetPage {
	WebDriver driver;
	public Cart(WebDriver driver)
	{
		super(driver,"coach/Cart");
		this.driver = driver;
	}
	public void select_Checkout_with_Paypal(){
		wait.waitForPageToLoadCompletely();
		//		hardWait(5);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		isElementDisplayed("button_proceed_to_checkout");
		wait.waitForElementToBeVisible(element("button_checkout_with_paypal"));
		wait.waitForElementToBeClickable(element("button_checkout_with_paypal"));
		element("button_checkout_with_paypal").click();
	}
	public void verifySelectedProduct(){
		  if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
		   hardWait(3);
		  }
		  String color = executeJavascriptReturnsString("return $('span.value').eq(7).text()");
		  msg.log(color);
		  
		 }
	public boolean verifyTotal() {


		String sprice= executeJavascriptReturnsString("return $('.price-standard').eq(1).text().trim()");
		String stotalprice= executeJavascriptReturnsString("return $('.price-total').text()");

		assertEquals(sprice, stotalprice,"Price not matched");
		String a=stotalprice.replaceAll("\\$", "");
		String b=sprice.replaceAll("\\$|", "");
		float price1 = Float.valueOf(a);
		float totalprice1=Float.valueOf(b);
		String qaunt=executeJavascriptReturnsString("return $('.filter-option.pull-left').text()");
	
		int quantity=1;
		System.out.println("*******"+quantity);
		if(quantity==1){
			executeJavascript("$('.btn.dropdown-toggle.selectpicker.btn-default').click()");
			executeJavascript("$('.selectpicker li').eq(1).click()");
		}
		waitForLoad();
		hardWait(2);
		if((price1*quantity)==totalprice1){
			msg.log("verify Products total according to the quantity");
			return true;
		}

		return false;

	}
	public boolean verifyEstimatedTax() {
		// TODO Auto-generated method stub
		String stax= (element("link_product_estimated_tax").getText()).substring(1);
		float tax = Float.parseFloat(stax);
		if(tax==0){
			return true;
		}
		return false;
	}
	public void verifyCartPage() {
		// TODO Auto-generated method stub
		wait.waitForElementsToBeVisible(elements("product_image"));
		isElementDisplayed("product_image");
		hardWait(3);
		boolean proceed =executeJavascriptReturnsBoolean("return $('.btn.btn-primary').eq(2).is(':visible')");
		assertEquals(proceed , true , "Proceed to checkout is not visible");{
			msg.log("Proceed to checkout is displayed");
		}
		String PTC = executeJavascriptReturnsString("return $('.btn.btn-primary').eq(2).text()");
		msg.log(PTC);
		String color = executeJavascriptReturnsString("return $('span.value').eq(0).text()");
		msg.log(color);
		String cName = executeJavascriptReturnsString("return $('span.value').eq(0).text()");
		msg.log(cName);
		msg.log("verify Image,Color,Proceed to check and other elements in the cart page");
	}
	public void verifyBopusProduct(String zip){
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("link_buy_now_pick_up_in_store"));
		click(element("link_buy_now_pick_up_in_store"));
		wait.waitForElementsToBeVisible(elements("text_box_bopus_zip_search"));
		sendText(element("text_box_bopus_zip_search"), zip);
		click(element("button_find"));
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(element("button_save_and_pickup"));
		click(element("button_save_and_pickup"));
		wait.waitForElementToBeClickable(element("button_bopus_close"));
		click(element("button_bopus_close"));
		wait.waitForElementsToBeVisible(elements("selected_buy_now_pickup_in_store"));
		isElementDisplayed("selected_buy_now_pickup_in_store");
	}
	public void verifyRemoveProduct(){
		//		wait.waitForElementToBeClickable(element("button_remove_from_cart"));
		//		click(element("button_remove_from_cart"));
		executeJavascript("document.getElementsByClassName('remove-product')[0].click();");
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		isElementDisplayed("tag_cart_empty");
		msg.log("Product is removed from shopping bag");
	}
	public void selectCheckoutAndProceed() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		executeJavascript("$('.btn.btn-primary')[2].click()");
		msg.log("User clicks on Proceed to checkout");
	}
	public void verifyAddAGiftMessage(String message) {
		// TODO Auto-generated method stub
		hardWait(1);
		executeJavascript("document.getElementsByClassName('gift-msg collapsed')[0].click();");
		//		click(element("link_add_a_gift_message"));
		hardWait(1);
		wait.waitForElementToBeVisible(element("text_message"));
		element("text_message").sendKeys(message);
		msg.log("Added gift Message");
	}
	public void verifyErrorMessage(){
		scrollWindow(0,100);
		isElementDisplayed("tag_error");
		msg.log("Verify user is able to add gift message and also able to verify special characters should not be in message box");
	}
	public void removeGiftMessage() {
		// TODO Auto-generated method stub
		click(element("button_remove_gift_message"));

	}
	public void clickOnMessageSave() {
		executeJavascript("document.getElementsByClassName('btn btn-default save-msg')[1].click();");
		msg.log("Clicked On Save message button");
	}
	public void verifyPriview() {
		// TODO Auto-generated method stub
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(3);
			verifyMonogramMessage();
		}
		isElementDisplayed("link_priview");

	}

	public void verifyMonogramMessage() {
		isElementDisplayed("text_monogram_msg");
		msg.log(element("text_monogram_msg").getText());

	}
	public void verifyAddGiftMessage(String message) {

		hardWait(1);
		click(element("link_add_gift_message"));
		hardWait(1);
		sendText(element("text_message"), message);
	}
	public void verifyGiftMessageErrorMessage() {
		click(element("link_add_a_gift_message"));
		msg.log("ADD A GIFT MESSAGE is clicked");

		sendText(element("text_message"), "[");
		isElementDisplayed("tag_error");
		msg.log("Error message is displayed");


	}
	public void clickOnComplimentaryGiftBoxCheckbox() {
		wait.waitForPageToLoadCompletely();
		wait.hardWait(3);
		executeJavascript("document.getElementById('compGiftBox_1').click();");
		msg.log("Clicked on complimentary gift box checkbox");
		wait.hardWait(3);

	}
	
	
	public void clickOnGiftBoxForProduct1() {
		waitForLoad();
		executeJavascript("document.getElementById('compGiftBox_2').click();");
		msg.log("Gift Box is added for product 1 ");

	}
	
	public void addGiftMessageInProduct2(){
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementsByClassName('gift-msg collapsed')[0].click()");
		hardWait(1);
		wait.waitForElementToBeVisible(element("text_message"));
		element("text_message").sendKeys("please ignore this message");
		msg.log("Added Gift Message for product 2");
	}
	
	public void addGiftBoxAndGiftMessageOnProduct2() {
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementById('compGiftBox_2').click();");
		msg.log("Gift Box is added for product 2 ");
		executeJavascript("document.getElementsByClassName('gift-msg collapsed')[0].click()");
		hardWait(1);
		wait.waitForElementToBeVisible(element("text_message"));
		element("text_message").sendKeys("please ignore this message");
		msg.log("Added Gift Message for product 2");
		
	}
	public void verifyProductsAddedInCart() {
		wait.waitForPageToLoadCompletely();
		int i=0;
		for(i=0;i<2;)
		{
				String text=(String)executeJavascriptWithReturn("return document.getElementsByTagName('h2')[0].getElementsByTagName('span')["+i+"].textContent");
				msg.log(text);
				i++;
		}
		
	}
	public void verifyPreOrderBagInCartPage() throws InterruptedException {
		wait.waitForPageToLoadCompletely();
		scrollToElement(element("preOrderMessage"));
		isElementDisplayed("preOrderMessage");
		msg.log(element("preOrderMessage").getText());
		hardWait(2);
		executeJavascript("document.getElementsByClassName('btn btn-primary')[2].click()");
		msg.log("Clicked on Proceed to checkouts");
	}
	public void verifyBackOrderBagInCartPage() {
		wait.waitForPageToLoadCompletely();
		try {
			scrollToElement(element("backorderMessage"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed("backorderMessage");
		msg.log(element("backorderMessage").getText());
		hardWait(2);
		executeJavascript("document.getElementsByClassName('btn btn-primary')[2].click()");
		msg.log("Clicked on Proceed to checkouts");
		
	}
	public void verifyComplimentaryGiftBoxCheckBoxIsChecked() {
		String checkbox=element("chckbox_complimenatry_gift_box").getAttribute("class");
		Assert.assertTrue(checkbox.toLowerCase().contains("checked".toLowerCase()), "Assertion failed : Complimentary gift box is not checked");
		msg.pass("Complimentary gift box is checked");
		
	}
	public void verifyPriceChange() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		String before = executeJavascriptReturnsString("return $('span.price-standard').eq(1).text()");
		msg.log(before);
		String after = executeJavascriptReturnsString("return $('.price-total').text()");
		msg.log(after);
		Assert.assertNotEquals(before, after, "Quantity didn't increase,both prices are same");
		
	}

}
