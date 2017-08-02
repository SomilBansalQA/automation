package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mozilla.javascript.tools.idswitch.SwitchGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.SeleniumWait;

public class ProductPaymentPage  extends GetPage {

	String [] layoutTags = {"objects2"};
	WebDriver driver;
	static String totalOrder;
	public ProductPaymentPage(WebDriver driver)
	{
		super(driver,"coach/ProductPaymentPage");
	}  
	
	public void user_enter_card_number(String cardno){
//		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
//			hardWait(3);
//		}
		
		if(ConfigPropertyReader.getProperty("browser").startsWith("iphone")){
			hardWait(5);
			waitForLoad();
			scrollWindow(0, 300);
		}
		wait.waitForElementsToBeVisible(elements("form_payment"));
		isElementDisplayed("form_payment");
		msg.log("User is on Billing page");
		waitForLoad();
		hardWait(1);
		//wait.waitForElementToBeVisible(element("cardno_text"));
		sendText(element("cardno_text"),cardno);
		hardWait(1);
		isElementDisplayed("icon_credit_card_type");
		msg.log("Entered Card Number");
		
	}
	
	public void user_select_card_expiry_month_and_year(){
		click(element("card_exp_month_button"));
		click(element("month_may_text"));
		click(element("card_exp_year_button"));
		click(element("year_2017_text"));
		executeJavascript("document.getElementById('dwfrm_billing_paymentMethods_creditCard_saveCard').click();");
		msg.log("Entered expiry month and year");
	}
	
	public void user_select_card_expiry_month_and_year_uk(){
//		click(element("card_exp_month_button"));
//		click(element("month_may_text_uk"));
//		click(element("card_exp_year_button"));
//		click(element("year_2017_text"));
		executeJavascript("document.getElementById('dwfrm_billing_paymentMethods_creditCard_month').value=3;");
		executeJavascript("document.getElementById('dwfrm_billing_paymentMethods_creditCard_year').value=2020");
		executeJavascript("document.getElementById('dwfrm_billing_paymentMethods_creditCard_saveCard').click();");
		msg.log("Entered expiry month and year");
		
	}
	
	public void user_select_card_expiry_month_and_year_tier2(){
		click(element("card_exp_month_button"));
		click(element("month_may_text"));
		click(element("card_exp_year_button"));
		click(element("year_2017_text"));
		msg.log("Entered expiry month and year");
	}
	
	
	public void user_enter_securitycode_and_emailid(String cardtype, String username){
		hardWait(1);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		sendText(element("textbox_SecurityCode"), cardtype );
		hardWait(1);
		sendText(element("textbox_Email"),username);
		hardWait(1);
		sendText(element("textbox_ConfirmEmail"), username);
		msg.log("Entered security code and Email ID");
		
		hardWait(1);
	}
	
	public void user_enter_emailid(String username){
		wait.waitForPageToLoadCompletely();	
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
			scrollWindow(0, 300);
		}
		wait.waitForElementToBeVisible(element("text_email_paypal"));
		sendText(element("text_email_paypal"), username);
		sendText(element("textbox_ConfirmEmail"), username);
		click(element("text_email_paypal"));
		click(element("textbox_ConfirmEmail"));
		
	}
	
	public void user_submit_payment(){
		hardWait(1);
		waitForLoad();
		click(element("btn_ConfirmContinue"));
		msg.log("Clicked on payment continue button");
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
	}

	public void user_enter_gift_card_number(String cardno, String cardpin) {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(3);
		}
		wait.waitForElementsToBeVisible(elements("coach_gift_card"));
	    isElementDisplayed(("coach_gift_card"));
		sendText(element("coach_gift_card"), cardno);
		msg.log("Card number entered" + cardno);
		isElementDisplayed("coach_gift_card_pin");
		sendText(element("coach_gift_card_pin"), cardpin);
		msg.log("Card pin entered" + cardpin);
		isElementDisplayed("button_apply_gift");
		msg.log("Entered gift card no and card pin");
		click(element("button_apply_gift"));
		msg.log("Clicked on apply gift button");
	}

	public void select_paypal_radio_button() {
		wait.waitForPageToLoadCompletely();
			hardWait(3);
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			hardWait(5);
		}
		executeJavascript("$('#is-PayPal').click()");
	}

	public void user_enter_email_id_and_confirm_id(String emailid) {
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		sendText(element("text_email_paypal"), emailid);
		sendText(element("textbox_ConfirmEmail"), emailid);		
	}

	public void user_enter_pay_pal_password_and_enter_submit(String email,String paypalpassword) {
		hardWait(1);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		element("textbox_email_paypal").clear();
		sendText(element("textbox_email_paypal"), email);
		sendText(element("text_password_paypal"), paypalpassword);
		click(element("button_paypal_submit"));
		hardWait(5);
//		wait.waitForLoaderToDisappearOnPayPalPage();
		
	}

	public void user_press_pay_pal_confirm_button() {
	
		click(element("button_paypal_confirm"));
		
	}
    public void verifyErrormessage(){
    	if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
    	wait.waitForElementsToBeVisible(elements("paypal_error_message"));
    	isElementDisplayed("paypal_error_message");
    }
	public void user_press_pay_pal_continue_button(String currentwindow) {
		switchToDefaultContent();
		hardWait(5);
		msg.log(webdriver.getTitle());
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			scrollWindow(0, 1000);
			hardWait(5);
		}
		wait.waitForElementToBeVisible(element("button_paypal_continue"));
		wait.waitForElementToBeClickable(element("button_paypal_continue"));
		isElementDisplayed("text_paypal_shipping_address");
		isElementDisplayed("button_paypal_continue");
		hardWait(2);
		executeJavascript("document.getElementById('confirmButtonTop').click();");
		changeWindow(0);
		
		//switchWindow();
		//msg.log("problem");

//		if(!ConfigPropertyReader.getProperty("browser").contains("ios")){
//			switchToDefaultWindow1(currentwindow);		
//		}
		
		
	}

	public void select_paypal_radio_button_uk() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(3);
		}
		executeJavascript("document.getElementById('is-PAYPAL-EXPRESS').click();");
	}

	public void continuePayPal() {
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(1);
		}
		click(element("input_Continue_PayPal"));
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(3);
		}
	}

	public void user_enter_password_for_new_registeration() {
		waitForLoad();
		sendText(element("textbox_password"),"Qait@1234");
		sendText(element("textbox_ConfirmPassword"),"Qait@1234");
	}

	public void verifyGiftCardAdded() {
		hardWait(2);
//		if(isElementDisplayed("error_gift_msg"))
//		{
//			String error=element("error_gift_msg").getText();
//			msg.log(error);
//			Reporter.log(error);
//			Assert.fail("Gift Card Fails with Error Message -" + error);
//		}
//		else
//		{ 
			isElementDisplayed("text_gift_card");
			msg.log("Applied gift card is dispalyed");
			isElementDisplayed("text_balance_due");
			msg.log("Balance due is dispalyed");
			msg.log("gift card is added");
			totalOrder=element("text_total_order").getText();
			
//		}
	}



	public void removeGiftCard() {
		executeJavascript("document.getElementsByClassName('remove')[0].click()");
		msg.log("Gift card is removed");
	}

	public void verifyGiftCardPaymentMethodIsNotDisplaedOnBillingPage() {
		waitForLoad();
		isElementNotDisplayed("coach_gift_card_title");
		msg.log("GIFT CARD payment method is not displayed on Billing page");
	}

	public void verifyOptInCheckBoxIsDefaultSelected() throws InterruptedException {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
	    boolean checkbox = executeJavascriptReturnsBoolean("return $('#dwfrm_billing_billingAddress_sameAsShippingAddress').is(':checked');");
        assertEquals(checkbox , true , "Checkbox is not selected by default");
        msg.log("Checkbox is selected by default");
	}

	public void verify_EasyTrackOrdersUnderCreateAnAccount() {
		waitForLoad();
		scrollWindow(0,1000);
		isElementDisplayed("create_acc_msg");
		msg.log("Easily track orders and enjoy faster checkout with an account is displayed");
		
	}

	public void verify_WhatIsThisIconInPaymentPage() {
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			scrollWindow(0,900);
			hardWait(5);
		}
		isElementDisplayed("tool_tip");
		msg.log("? icon is diplayed");
		hover(element("tool_tip"));
		msg.log("User hover on ? icon");
		hardWait(5);
		isElementDisplayed("img_tool_tip");
		msg.log("What is this image is displayed");
	}

	public void verifySaveThisCC_BelowCreateAnAccount() throws InterruptedException {
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			//scrollWindow(0,500);
		}
	    scrollToElement("input_saveThisCC");
	    if(getElementSize("input_saveThisCC")==1) {
			msg.log("Save this Credit Card is displayed");
	    }
	    else {
			msg.log("Save this Credit Card is not displayed");
	    }
	   
		
	}

	public void verify_ThisIsTheBillingInformationStatementIsRemovedBelowBillingAddress() throws InterruptedException {
	    waitForLoad();
	    scrollWindow(0, 300);
	    
	    isElementDisplayed("h3_billing");
		msg.log("Billing Address is displayed");
		waitForLoad();
			String text = element("billing_statement").getText();
			Assert.assertNotSame(text, "This is the billing information exactly as it appears on your credit card statement.","Text are same");
	   msg.log("This is the billing information exactly as it appears on your credit card statement is REMOVED");
	}

	public void verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("signup_statement");
	    if(getElementSize("signup_statement")==1) {
	    	Assert.assertNotSame(element("signup_statement").getText(),"Sign me up to receive emails about the latest Coach, Inc. news & styles. Read our privacy policy","msg not found");
			msg.log(element("signup_statement").getText());
	    }
	    else {
			msg.log(" SIGN ME UP TO RECEIVE EMAILS ABOUT THE LATEST COACH NEWS & STYLES. READ OUR PRIVACY POLICY is not displayed");
	    }
	}

	public void italy_verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("italy_label_billingAddress");
	    if(getElementSize("italy_label_billingAddress")==1) {
	    	Assert.assertEquals(element("italy_label_billingAddress").getText(),"Selezionando la casella, l’utente accetta di ricevere comunicazioni pubblicitarie da Coach, Inc. tramite posta elettronica.");
			msg.log(element("italy_label_billingAddress").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
	    
	    waitForLoad();
		scrollToElement("italy_label_addToRecommendationlist");
	    if(getElementSize("italy_label_addToRecommendationlist")==1) {
	    	Assert.assertEquals(element("italy_label_addToRecommendationlist").getText(),"Selezionando la casella, l’utente accetta che Coach possa utilizzare i dati personali dell’utente per analizzare le preferenze e/o le tendenze individuali.");
			msg.log(element("italy_label_addToRecommendationlist").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
		
	}

	public void verifyShippingAddressIsOfChangedCountry() {
		waitForLoad();
		String newCountry = element("address").getText();
		msg.log("Country address is " +newCountry);
		Assert.assertEquals(getCurrentURL().contains("es"), element("address").getText().contains("ES"),"Country address is different");
	}

	public void verifylayout() {
		wait.waitForPageToLoadCompletely();
		hardWait(5);
		Assert.assertTrue(testPageLayout(layoutTags),"[ASSERT FAILED]: Layout Test failed");
		
		
	}

	public void clickOnCancelLinkOnPayPalWindow() {
		 scrollDown(element("link_cancel_paypal"));
		 isElementDisplayed("link_cancel_paypal");
		 click(element("link_cancel_paypal"));
		 msg.log("User clicked on cancel link for paypal");
		 wait.hardWait(4);
		 switchWindow();
		
	}

	public void verifyClickingCancelOfPaypalWindowUserIsNavigatedBackToBillingPage() {
	    waitForLoad();
		wait.waitForPageToLoadCompletely();
		wait.hardWait(4);
		isElementDisplayed(("form_payment"));	
		msg.log("Verified after clicking cancel on paypal window ,User is navigated to billing page");
	}

	public void verifyErrorMessageisDisplayedAfterenterninginvalidcredentials(String paypalpassword) {
		switchToFrame("injectedUl");
		sendText(element("text_password_paypal"), paypalpassword);
		msg.log("User entered wrong password");
		click(element("button_paypal_submit"));
		msg.log("User clicked on log-in button");
		hardWait(5);
		switchToDefaultContent();
		isElementDisplayed("text_error_paypal");
		msg.log("Error msg after entering wrong credintials is displayed");
	}

	public void verify_UserIsNotAbleToToggleBetweenLangAndCountryAtCheckoutPage() {
		waitForLoad();
		scrollWindow(0, 1000);
		isElementNotDisplayed("shipping");
		msg.log("Shipping is not displayed");
		isElementNotDisplayed("language");
		msg.log("Language is not displayed");
	}


	public void verify_SofortIconIsDisplayed() {
		waitForLoad();
		isElementDisplayed("sofort");
		msg.log("SOFORT icon is displayed");
		hardWait(1);
		executeJavascript("document.getElementById('is-SOFORT-SSL').click()");
		msg.log("User clicks on SOFORT icon");
	}

	public void continueSofort() {
		waitForLoad();
		element("sofort_continue").click();
		
	}

	public void addAnotherCard() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(element("addAnotherCard"));
;		isElementDisplayed("addAnotherCard");
		msg.log("Add another card is displayed");
		element("addAnotherCard").click();
		msg.log("User clicks on add another card");
	}


	public void user_enter_invalid_securitycode_and_emailid(String cardtype, String username) {
		sendText(element("textbox_SecurityCode"), "12" );
		hardWait(1);
		sendText(element("textbox_Email"),username);
		hardWait(1);
		sendText(element("textbox_ConfirmEmail"), username);
		msg.log("Entered security code and Email ID");
		
		hardWait(1);
	}

	public void verify_InvalidCVV() {
		waitForLoad();
		isElementDisplayed("cvv_errorMessage");
		msg.log("INVALID SECURITY CODE is displayed");
	
	}

	public void verifyGiftCardIsRemoved() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("text_gift_card");
		isElementDisplayed("form_payment");
		msg.log("After removing gift card user is on Payment page");
		isElementNotDisplayed("text_balance_due");
		Assert.assertTrue(totalOrder.equalsIgnoreCase(element("text_total_order").getText()),"Assertion Failed: Total order is not same after removing gift card");
		msg.log("Assertion Passed: Total order is same after removing gift card");
	}

	public String entersecuritycodeandNewUsername(String cardtype,String password) {
		hardWait(1);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		sendText(element("textbox_SecurityCode"), cardtype );
		hardWait(1);
		long Random = System.currentTimeMillis();
		String emailAddress = "AB_"+Random+"_@qa.com";
		sendText(element("textbox_Email"),emailAddress);
		hardWait(1);
		msg.log("User entered Email address : " + emailAddress);
		hardWait(1);
		sendText(element("textbox_ConfirmEmail"), emailAddress);
		hardWait(1);
		msg.log("User entered confirm Email address : " + emailAddress);
		sendText(element("textbox_password"),password);
		msg.log("User entered password : " +password);
		sendText(element("textbox_confirmpassword"), password);
		msg.log("User entered confirm  password : " + password);
		return emailAddress;
	}

	public void verifyErrorMessageIsdisplayedWhenEnteringInvalidCredentialsForPaypal() {
		switchToDefaultContent();
		isElementDisplayed("error_paypallogin");
		msg.log("Error msg displayed on entering invalid credentials for paypal login");
	}

	public void verifyAddressIsChanged(String zipcode) {
		wait.waitForPageToLoadCompletely();
		msg.log(element("text_new_zipcode").getText());
		Assert.assertTrue((element("text_new_zipcode").getText().contains(zipcode)), "Assertion failed: Address not changed" );
		msg.log("Address is changed");
		
	}

	public void clickOnBackButtonFromBrowser() {
	    waitForLoad();
		backButton();
		isElementDisplayed("shipping_address");
		msg.log("verified on clicking back button from browser from payment page,the user navigates back to shipping page");
		isElementDisplayed("continue");
		click(element("continue"));	
	}

	public void giftCardNotDisplayedOnShippingPageForEU() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("coach_gift_card");
		msg.log("Gift Card Payment Method not displayed on payment page for EU");
		
	}

	public void linkGiftCardNotDisplayedOnOrderReviewPage() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("link_giftcard_order");
		msg.log("Link Gift card is not displayed on order review page");
	}

	public void user_enter_invalid_pay_pal_password_and_enter_submit() {
		hardWait(1);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		element("textbox_email_paypal").clear();
		sendText(element("textbox_email_paypal"), "abc@qa.com");
		sendText(element("text_password_paypal"), "123");
		click(element("button_paypal_submit"));
		hardWait(5);
		
	}

	public void verifyEnteredDataOnShippingPageIsNotChangedIfNoAddressIsSavedInUserAddressBook() {
		wait.waitForPageToLoadCompletely();
		int i=1;
		int size = getElementSize("updated_address");
		int count =1;
		
		while(size>0)
		{
			msg.log(element("updated_address2",Integer.toString(count)).getText());
			size--;
			count++;
		}
		
	}



	public void enterEmailId(String username) {
		sendText(element("textbox_Email"),username);
		hardWait(1);
		sendText(element("textbox_ConfirmEmail"), username);
		msg.log("Entered security code and Email ID");
		
	}

	public void user_enter_invalid_credentials(String email , String paypalpassword) {
		//switchToFrame("injectedUl");
		element("textbox_email_paypal").clear();
//		email="abc@qa.com";
//		paypalpassword="1234";
		sendText(element("textbox_email_paypal"), email);
		sendText(element("text_password_paypal"), paypalpassword);
		click(element("button_paypal_submit"));
		hardWait(5);
		
	}

	public void verifyGCIsPersistedEvenAfterUserNavigateBackToShippingPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("continue");
		click(element("continue"));	
		wait.waitForPageToLoadCompletely();
		executeJavascriptReturnsString("$('.remove').is(':visible')");
		hardWait(2);
		String remove = executeJavascriptReturnsString("$('.remove')[0.].textContent");
		msg.log(remove+ "is displayed");
		
	}

	public void validateProductName() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		String checkoupage_Pname = executeJavascriptReturnsString("return document.getElementsByClassName('mini-cart-name')[0].getElementsByTagName('a')[0]"
				+ ".textContent");
		msg.log(checkoupage_Pname);
		element("edit_link").click();
		hardWait(2);
		msg.log("User clicks on edit link from checkout's mini cart page");
		String cart_Pname = executeJavascriptReturnsString("return document.getElementsByClassName('name')[0].getElementsByTagName('a')[0].textContent");
		msg.log(cart_Pname);
		Assert.assertEquals(checkoupage_Pname.toUpperCase().replaceAll("[\\\t|\\\n|\\\r]", "").trim(), cart_Pname.toUpperCase().replaceAll("[\\\t|\\\n|\\\r]", "").trim(), "Product names are different");
	}

	public void verifyCurrentEnteredAddress() {
		wait.waitForPageToLoadCompletely();		
		String address = executeJavascriptReturnsString("return document.getElementsByClassName('updated-billing-address')[0].textContent");
		msg.log(address);
	}

	public void verifyAddressAfterAndBeforeLoginAreSame() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		String address = executeJavascriptReturnsString("return document.getElementsByClassName('updated-billing-address')[0].textContent");
		msg.log(address);
		String afterLoginAddress = executeJavascriptReturnsString("return document.getElementsByClassName('updated-billing-address')[0].textContent");
		msg.log(afterLoginAddress);
		Assert.assertEquals(address, afterLoginAddress);
		
	}

	public void verifyEnteredDataIsShownForUserHavingNoAddresSaved(String firstname, String lastname, String address) {
		wait.waitForPageToLoadCompletely();
		String name=(firstname + " " + lastname).toUpperCase();
		Assert.assertTrue((element("text_name").getText().equalsIgnoreCase(name)), "Assertion failed: Entered data of the user is not saved" );
		Assert.assertTrue((element("text_address").getText().equalsIgnoreCase(address)), "Assertion failed: Entered data of the user is not saved" );
		msg.pass(" Entered data of the user is  saved");
	}

	public void verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary() {
		verifyCurrentEnteredAddress();
		
	}

	public void changeTheBillingAddress(String name, String lname, String address, String country, String zipcode,String city, String phno) {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		sendText(element("text_fname"), name);
	    msg.log("User entered first name : " + name);
		sendText(element("text_lname"), lname);
		msg.log("User entered last name : " + lname);
		sendText(element("text_adress"), address);
		msg.log("User entered address : " + address);
		

		if(country.equalsIgnoreCase("canada")){
			click(element("btn_country_dropdown"));
			waitForLoad();
			element("option_country", country).click();
		}
		
		sendText(element("text_zip_code"), zipcode);		
		hardWait(1);
		click(element("text_city"));
		hardWait(3);
		
		sendText(element("text_city"), city.toUpperCase());
		hardWait(2);
		
		waitForLoad();
		sendText(element("text_phone_no"), phno);
		hardWait(2);
				
		click(element("text_city"));
		hardWait(2);
		click(element("text_phone_no"));
		hardWait(5);
		isElementDisplayed("continue");
		click(element("continue"));	
		msg.log("User clicks on continue");
		
	}


	public void clickOnBillingAddressCheckbox() throws InterruptedException {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("billingAdd_sameAsShippingAddress");
		scrollToElement(element("billingAdd_sameAsShippingAddress"));
		element("billingAdd_sameAsShippingAddress").click();
		
		
	}	

}

