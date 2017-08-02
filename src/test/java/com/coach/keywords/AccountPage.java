package com.coach.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;

public class AccountPage extends GetPage {

	public AccountPage(WebDriver driver)
	{
		super(driver,"coach/AccountPage");
	} 
	
	public void clickOnRegisterButton(){
		wait.waitForPageToLoadCompletely();
		hardWait(3);
		if(ConfigPropertyReader.getProperty("browser").contains("ios")){
			hardWait(5);
		}
		waitForLoad();
		wait.waitForElementToBeClickable(element("button_Register"));
		wait.waitForElementToBeVisible(element("button_Register"));
		isElementDisplayed("button_Register");
		click(element("button_Register"));
	}
	
	public void enterRegisterInformation(){
		long Random = System.currentTimeMillis();
		String firstName = "A"+Random;
		msg.log("New User firtName : " +  firstName);
		String lastName = "A"+Random;
		msg.log("New User lastName : " +  lastName);
		String emailAddress = "A"+Random+"@qa.com";
		msg.log("New User emailAddress : " +  emailAddress);
		String password = "auto1234";
		msg.log("New User password : " +  password);
		PropFileHandler.writeProperty("firstName", firstName);
		PropFileHandler.writeProperty("lastName", lastName);
		PropFileHandler.writeProperty("emailAddress", emailAddress);
		PropFileHandler.writeProperty("password", password);
		waitForLoad();
		sendText(element("textbox_FirstName"), firstName);
		sendText(element("textbox_LastName"), lastName);
		sendText(element("textbox_eMailAddress"), emailAddress);
		sendText(element("textbox_confirmEmail"), emailAddress);
		sendText(element("textbox_password"), "auto1234");
		sendText(element("textbox_confirmPassword"), "auto1234");
		executeJavascript("document.getElementsByClassName('btn btn-default continue')[0].click();");
		msg.log("Clicked on Continue Button to register new user");
//		click(element("button_SignUp"));
	}
	
	public void enterAddressInformationAfterSignUp(String zipcode, String city, String phone){
		sendText(element("textbox_addressField1"), "First");
		sendText(element("textbox_addressField2"), "Second");
		sendText(element("textbox_postalCode"), zipcode);
		hardWait(1);
		click(element("textbox_city"));
		hardWait(3);
		sendText(element("textbox_city"),city.toUpperCase());
		hardWait(1);
		sendText(element("textbox_phone"), phone);
		hardWait(1);
		try{
			executeJavascript("document.getElementsByClassName('apply-button btn')[0].click()");
//			element("button_Complete").sendKeys(Keys.ENTER);
		}
		catch(Exception e){
			executeJavascript("document.getElementsByClassName('apply-button btn')[0].click()");
		}
		isElementDisplayed("textMessage_Welcome");
	}	
	
	public void loginWithRegisteredUser(String userName, String password) {
		wait.waitForPageToLoadCompletely();
	    hardWait(2);
		wait.waitForElementToBeVisible(element("signin_button"));
		wait.waitForElementToBeClickable(element("signin_button"));
		waitForLoad();
	//	click(element("signin_button"));
		executeJavascript("$('.btn.btn-default.signin').eq(1).click()");
		hardWait(2);
		sendText(element("username_field"), userName);
		sendText(element("password_field"), password);
		click(element("signin_button2"));
		msg.log("User logins into the application");
	}

	public void clickOnSkip() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(element("linkText_Skip"));
		executeJavascript("document.getElementsByClassName('skip-button')[0].click()");
		//click(element("textbox_addressField1"));
//		click(element("linkText_Skip"));
		msg.log("Clicked on Skip button");
	}

	public void editNameAccountInformation(String existin_password) {
		long Random = System.currentTimeMillis();
		String firstName = "A"+Random;
		String lastName = "A"+Random;
		String emailAddress = "Auto"+Random+"@qa.com";
		PropFileHandler.writeProperty("firstName", firstName);
		PropFileHandler.writeProperty("lastName", lastName);
		PropFileHandler.writeProperty("emailAddress", emailAddress);
		sendText(element("textbox_FirstName"), firstName);
		sendText(element("textbox_LastName"), lastName);
		sendText(element("textbox_eMailAddress"), emailAddress);
		sendText(element("textbox_confirmEmail"), emailAddress);
		sendText(element("textbox_current_password_account_information_section"), existin_password);
		click(element("button_Save_Changes"));		
	}
	
	public void goToAddressBook(){
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			wait.hardWait(3);
		}
		
		click(element("linkText_Address_Book"));
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			wait.hardWait(5);
		}
		waitForLoad();
		isElementDisplayed("label_Address_Book");
		isElementDisplayed("button_Add_New_Address");
	}

	public void editAddressInAccountSettings() {
		click(element("linkText_Edit_Address"));
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			hardWait(3);
			scrollWindow(0, 10000);
		}	
		waitForLoad();
		hardWait(2);
		executeJavascript("document.getElementsByClassName('save-btn')[0].click();");
		//element("button_Save_Address").click();
//		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
//			wait.hardWait(3);
//			scrollWindow(0,-100);
//		}	
		isElementDisplayed("label_Message_after_Save_Address");
		click(element("button_Close_Address"));
		wait.waitForPageToLoadCompletely();	
	}

	public void goToSavedCreditCardsPage() {
		waitForLoad();
		isElementDisplayed("linkText_Saved_Credit_Cards");
		click(element("linkText_Saved_Credit_Cards"));
	}

	public void deleteSavedCard() {
		click(element("icon_Delete_Saved_Cards"));
		click(element("button_Yes_Delete_Cards"));
		isElementDisplayed("label_You_dont_have_Cards");
	}
	
	
	public void saveCard(String carno, String cvv){
		waitForLoad();
		click(element("btn_add_new_credit_card"));
		sendText(element("field_card_no"), carno);
		sendText(element("field_cvv_no"), cvv );
		hardWait(2);
		waitForLoad();
		click(element("dropdown_card_month"));
		click(element("text_card_mnth"));
		click(element("dropdown_card_year"));
		click(element("text_card_year"));
		click(element("field_card_no"));
		hardWait(2);
		waitForLoad();
		executeJavascript("document.getElementById('dwfrm_paymentinstruments_creditcards_newcreditcard_isPrimaryCreditCard').click()");
		wait.hardWait(3);
		executeJavascript("document.getElementById('dwfrm_paymentinstruments_creditcards_newcreditcard_isPrimaryCreditCard').click()");
		click(element("btn_card_save"));
		wait.waitForPageToLoadCompletely();
		click(element("btn_card_close"));
		wait.waitForPageToLoadCompletely();
		hardWait(5);
	}

	public void verifyLabelCreateAnAccount() {
		if(ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			wait.hardWait(3);
			scrollWindow(0,-100);
		}
		waitForLoad();
		element("button_account").click();
		isElementDisplayed("label_CreateAnAccount");
		msg.log("User verifies label Create Account on Account Page");
		
	}

	public void verifyLabelRegisterNow() {
		waitForLoad();
		isElementDisplayed("label_RegisterNowToAccess");
		msg.log("User verifies label Register Now on Account Page");
	}

	public void verifyLabelPasswordMustBe() {
		waitForLoad();
		isElementDisplayed("label_PasswordMustBeAtleast");
	}

	public void verifyCheckBoxSignUpAndLabelYouAreSigningUp() {
		waitForLoad();
		isElementDisplayed("label_YouAreSigningUpToReceive");
		msg.log("User verifies label for password and signup letters");
	}

	public void clickOnSignUpButton() {
		waitForLoad();
		executeJavascript("document.getElementsByClassName('btn btn-default continue')[0].click();");
		msg.log("User clicks on Sign Up Button");
		
	}

	
	public void verifyErrorMessagesWhenUserClicksSignUpButtonWithoutEnteringAnyInformation() {
		waitForLoad();
		isElementDisplayed("label_EnterAFirstName");
		isElementDisplayed("label_EnterALastName");
		isElementDisplayed("label_EnterYourEmailAddress");
		isElementDisplayed("label_ConfirmYourEmailAddress");
		isElementDisplayed("label_EnterYourPassword");
		isElementDisplayed("label_ConfirmYourPassword");
		msg.log("User verifies error messages when sign up button is clicked without entering any information");
	}

	public void enterExistingUserInformation(String firstName, String lastName, String emailAddress, String confirmEmailAddress,
			String password, String confirmPassword) {
		waitForLoad();
		sendText(element("textbox_FirstName"), firstName);
		sendText(element("textbox_LastName"), lastName);
		sendText(element("textbox_eMailAddress"), emailAddress);
		sendText(element("textbox_confirmEmail"), confirmEmailAddress);
		sendText(element("textbox_password"), password);
		sendText(element("textbox_confirmPassword"), confirmPassword);
		msg.log("User registers with an existing email");
	}

	public void verifyErrorMessageForExistingUser() {
		waitForLoad();
		isElementDisplayed("label_EmailAlreadyRegistered");
		msg.log("User verifies error message for registeration with an existing email");
	}

	public void clickOnSignInButton() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
	    hardWait(2);
		wait.waitForElementToBeVisible(element("signin_button"));
		wait.waitForElementToBeClickable(element("signin_button"));
		waitForLoad();
		click(element("signin_button"));
		msg.log("Clicked On Sign In Button");
		hardWait(2);
		
	}

	public void clickForgotPassword() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
	    hardWait(2);
		wait.waitForElementToBeVisible(element("linkText_ForgotPassword"));
		wait.waitForElementToBeClickable(element("linkText_ForgotPassword"));
		waitForLoad();
		click(element("linkText_ForgotPassword"));
		hardWait(2);	
	}

	public void assertLabelPasswordRequest() {
		waitForLoad();
		isElementDisplayed("label_PasswordRequest");
	}

	public void enterEmailForForgotPasswordAndNavigateBackToAccountPage(String email) {
		waitForLoad();
		sendText(element("textBox_PasswordRequest"), email);
		click(element("button_SubmitForgotPassword"));
		click(element("linkText_SignInAgain"));
	}

	public void verifyErrorMessageForWrongValuesInRegistrationForm() {
		waitForLoad();
		isElementDisplayed("label_EmailsDoNotMatch");
		isElementDisplayed("label_YourPasswordMustBeEight");
		isElementDisplayed("label_PasswordsDoNotMatch");
	}

	public void saveNewCard(String carno, String cvv) {
		waitForLoad();
		sendText(element("field_card_no"), carno);
		sendText(element("field_cvv_no"), cvv);
		hardWait(2);
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios")){
			executeJavascript("document.getElementById('dwfrm_paymentinstruments_creditcards_newcreditcard_month').value=3;");
			executeJavascript("document.getElementById('dwfrm_paymentinstruments_creditcards_newcreditcard_year').value=2020;");
		}
		else{
			click(element("dropdown_Newcard_month"));
			click(element("text_Newcard_mnth"));
			click(element("dropdown_Newcard_year"));
			click(element("text_Newcard_year"));
		}
		click(element("btn_card_save"));
		click(element("btn_card_close"));
		wait.waitForPageToLoadCompletely();
		hardWait(5);
	}

	public void enterEmailAndContinue(String userName) {
		sendText(element("button_confirm_email"), userName);
		click(element("continue"));
	}

	public void delete_SavedCreditCard() {
		waitForLoad();
		click(element("btn_conform_card_delete"));
		hardWait(2);
		click(element("icon_conform_delete"));
		waitForLoad();
	}

	public void verifyPrimaryCard() {
		waitForLoad();
		isElementDisplayed("box_primaryCreditCard");
	}

	public void makeTheCreditCardSecondory() {
		waitForLoad();
		click(element("linkText_EditLinkForCreditCard"));
		waitForLoad();
		executeJavascript("document.getElementById('dwfrm_paymentinstruments_creditcards_newcreditcard_isPrimaryCreditCard').click();");
//		click(element("checkbox_MakePrimaryPayment"));
		click(element("btn_card_save"));
		click(element("btn_card_close"));
	}

	public void verify_First_LastNameLimit_Is_30() {
		waitForLoad();
		msg.log("The maximum character limit for First name is :" +element("textbox_FirstName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_FirstName").getAttribute("maxlength"), Integer.toString(30));
		msg.log("Assertion for FIRST name character limit is passed");
		
		msg.log("The maximum character limit for Last name is :" +element("textbox_LastName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_LastName").getAttribute("maxlength"), Integer.toString(30));
		msg.log("Assertion for LAST name character limit is passed");
	}

	public void clickOnBurgerButtonForMenu() {
		wait.waitForPageToLoadCompletely();
		hardWait(3);
		executeJavascript("document.getElementsByClassName('burger icm-icon-burger')[0].click();");
		msg.log("User clicks on burger icon to see the menu");
		
	}

	public void clickOnRegisterButtonForMobile() {
		wait.waitForPageToLoadCompletely();
		hardWait(3);
		if(ConfigPropertyReader.getProperty("browser").contains("ios")){
			hardWait(5);
		}
		waitForLoad();
		wait.waitForElementToBeClickable(element("button_Register"));
		wait.waitForElementToBeVisible(element("button_Register"));
		isElementDisplayed("button_Register");
		click(element("button_Register"));
		
	}

	public void verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		scrollToElement("label_YouAreSigningUpToReceive");
	    if(getElementSize("label_YouAreSigningUpToReceive")==1) {
	    	Assert.assertNotSame(element("label_YouAreSigningUpToReceive").getText(),"Sign me up to receive emails about the latest Coach, Inc. news & styles. Read our privacy policy","msg not found");
			msg.log(element("label_YouAreSigningUpToReceive").getText());
	    }
	    else {
			msg.log(" SIGN ME UP TO RECEIVE EMAILS ABOUT THE LATEST COACH NEWS & STYLES. READ OUR PRIVACY POLICY is not displayed");
	    }
		msg.log("Verified that the opt in checkbox should not be checked by default");
	}

	public void mobile_loginWithRegisteredUser(String userName, String password) {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		sendText(element("username_field"), userName);
		sendText(element("password_field"), password);
		click(element("signin_button2"));
		msg.log("User logins into the application");
		
	}

	public void italy_verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("italy_label_YouAreSigningUpToReceive");
	    if(getElementSize("italy_label_YouAreSigningUpToReceive")==1) {
	    	Assert.assertEquals(element("italy_label_YouAreSigningUpToReceive").getText(),"Selezionando la casella, l’utente accetta di ricevere comunicazioni pubblicitarie da Coach, Inc. tramite posta elettronica. Leggi la nostra Polizza Sulla Privacy o contattaci per maggiori dettagli.");
	    	msg.log(element("italy_label_YouAreSigningUpToReceive").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
	    
	    waitForLoad();
		scrollToElement("italy_label_Recommendationlist");
	    if(getElementSize("italy_label_Recommendationlist")==1) {
	    	Assert.assertEquals(element("italy_label_Recommendationlist").getText(),"Selezionando la casella, l’utente accetta che Coach possa utilizzare i dati personali dell’utente per analizzare le preferenze e/o le tendenze individuali.");
			msg.log(element("italy_label_Recommendationlist").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
	}

	public void verifyUserOnAccountPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("textMessage_Welcome");	
		msg.log("User  on Account Page");
	}

	public void clickOnAccountSetting() {
		element("icon_account_setting").click();
		msg.log("User clicked on Account Setting Icon On Account Page");
		
	}

	public void verifyUserOnAccountEditPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("list_leftSideBar_accounteditpage");
		msg.log("User on Account Edit Page");
				
		
	}

	public void verifyUserCanViewaccountInfo() {
		Assert.assertTrue(element("label_firstName").getText().contains("FIRST NAME"),"Assertion Failed:Label First Name is not displayed");
		msg.log("Label First Name Is Displayed");
		Assert.assertTrue(element("label_lastName").getText().contains("LAST NAME"),"Assertion Failed:Label Last Name is not displayed");
		msg.log("Label Last Name Is Displayed");
		Assert.assertTrue(element("label_emailAddress").getText().contains("EMAIL ADDRESS"),"Assertion Failed:Label Email Address is not displayed");
		msg.log("Label Email Address Is Displayed");
		Assert.assertTrue(element("label_currentpassword").getText().contains("CURRENT PASSWORD"),"Assertion Failed:Label Current Password is not displayed");
		msg.log("Label Current Password Is Displayed");
		Assert.assertTrue(element("label_newpassword").getText().contains("NEW PASSWORD"),"Assertion Failed:Label New Password is not displayed");
		msg.log("Label New Password Is Displayed");
		Assert.assertTrue(element("label_confirmpassword").getText().contains("CONFIRM PASSWORD"),"Assertion Failed:Label confirm Password is not displayed");
		msg.log("Label confirm Password Is Displayed");
	}

	public void clickonwishlistIconFromAccountPage() {
		
		isElementDisplayed("icon_wishlist");
		click(element("icon_wishlist"));
		msg.log("User clicked on WhisList Icon On Account Page");
		
	}

	public void clickOnUnsubscribeLink() {
		wait.waitForPageToLoadCompletely();
		click(element("link_unsubscribe"));
		msg.log("Clicked on Unsubscribe link from My Profile page");
	}

	public void unsubscribeEmail(String Email) {
		changeWindow(1);
		wait.waitForPageToLoadCompletely();
		element("text_email_unsubscribe").sendKeys(Email);
		msg.log("Entered email to Unsubscribe");
		element("radio_unsubscribe_email_address").click();
		msg.log("Clicked on radio button");
		element("button_submit_unsubscribe").click();
		msg.log("Clicked on submit button to Unsubscribe");
	}

	public void verifyUserhasUnsubscribed() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("img_thankyou_unsubscribe");
		msg.log("Verified user is able to Unsubscribe");
		
	}

	public void verifyGenderFieldOnAccountPage() {
		wait.waitForPageToLoadCompletely();
		Assert.assertTrue(element("label_gender").getText().equalsIgnoreCase("Select Gender"),"Assertion Failed : Default Gender value : Select Gender not displayed");
		msg.log("Assertion Passed : Default Gender value : Select Gender is displayed");

	}

	public void clickOnAddANewAddress() {
        wait.waitForPageToLoadCompletely();
        executeJavascript("document.getElementsByClassName('address-create')[0].click()");
        msg.log("User clicks on Add A new Address");
	}

	public void enterShippingAddress(String zipcode, String city, String phone) {
		wait.waitForPageToLoadCompletely();
		long Random = System.currentTimeMillis();
		String firstName = "A"+Random;
		msg.log("New User firtName : " +  firstName);
		String lastName = "A"+Random;
		msg.log("New User lastName : " +  lastName);
		PropFileHandler.writeProperty("address_first_name", firstName);
		PropFileHandler.writeProperty("address_first_name", lastName);
		waitForLoad();
		sendText(element("address_first_name"), firstName);
		sendText(element("address_last_name"), lastName);
		sendText(element("textbox_addressField1"), "First");
		sendText(element("textbox_addressField2"), "Second");
		sendText(element("textbox_postalCode"), "10001");
		hardWait(1);
		click(element("textbox_city"));
		hardWait(3);
		sendText(element("textbox_city"),city.toUpperCase());
		hardWait(1);
		sendText(element("textbox_phone"), phone);
		hardWait(1);
        executeJavascript("document.getElementsByClassName('apply-button btn')[0].click()");
        isElementDisplayed("error_msg");
        msg.log(element("error_msg").getText());
	}

	public void verifyAddressIsNotMarkedPrimary() {
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementsByClassName('icm-icon-user')[0].click()");
		executeJavascript("document.getElementsByClassName('icon-coach-addressbook')[0].click()");
		element("linkText_Edit_Address").click();
		msg.log("User clicks on edit link");
		element("primary_address_checkbox").click();
		msg.log("Address is not marked as primary address");
		hardWait(2);
		executeJavascript("document.getElementsByClassName('save-btn')[0].click();");
		String saved_address = executeJavascriptReturnsString("return document.getElementsByClassName('updated-checkout-address')[0].textContent");
		msg.log(saved_address);
		
	}
	
}



