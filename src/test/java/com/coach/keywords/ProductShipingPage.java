package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import org.assertj.core.api.AssertDelegateTarget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.thoughtworks.selenium.webdriven.commands.GetXpathCount;

public class ProductShipingPage extends GetPage {

	public ProductShipingPage(WebDriver driver)
	{
		super(driver,"coach/ProductShipingPage");
	}  
	
	
	public void productShipping(){
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(element("shipng"));
		click(element("shipng"));
		wait.waitForElementToBeClickable(element("continue"));
		click(element("continue"));
		
	}


	public void enterShipingDetails(String name, String lname, String address, String country, String zipcode,String city, String phno) {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		hardWait(2);
		wait.waitForElementToBeVisible(element("text_fname"));
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
//		hardWait(1);
		
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
		waitForLoad();
		isElementDisplayed("continue");
		wait.waitForElementToBeClickable(element("continue"));
		click(element("continue"));	
		msg.log("User clicks on continue");
		hardWait(5);
		waitForLoad();
		msg.log("User enters shipping details");
	}
	
	public void continueShipping(){
		hardWait(1);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		click(element("continue"));
		msg.log("Clicked on continue for bopus");
	}
	public void enterBillingDetails(String name, String lname, String address, String country, String zipcode, String phno) {
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		sendText(element("text_fname_billing"), name);
		sendText(element("text_lname_billing"), lname);
		sendText(element("text_address_billing"), address);
	//	if(country.equalsIgnoreCase("canada")){
		
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			scrollWindow(0, 300);
		}
		
		if(!ConfigPropertyReader.getProperty("browser").startsWith("ios")){
			scrollWindow(0, 300);
			click(element("btn_country_dropdown_billin"));
			waitForLoad();
			element("option_country_billing", country).click();
		}
			
		//	click(element("option_country"));
		 //   element("option_country", country).click();
		//}
		
		sendText(element("text_zip_code_billing"), zipcode);
		hardWait(1);
		sendText(element("text_phone_no_billing"), phno);
		wait.waitForElementToBeClickable(element("continue"));
		hardWait(1);
		click(element("continue"));		
	}


	public void addNewCreditCard() {
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		if(ConfigPropertyReader.getProperty("browser").contains("ios")){
			executeJavascript("document.getElementsByClassName('edit-arrow')[3].click();");

		}
		else
		{
			click(element("button_edit"));
		}
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		executeJavascript("document.getElementsByClassName('modal-action section-header-note dialogify address-create')[1].click();");
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


	public void change_Shipping_Method(String name, String lname, String address, String country, String zipcode,String city, String phno) {
       
		wait.waitForPageToLoadCompletely();
		sendText(element("text_fname"), name);
		sendText(element("text_lname"), lname);
		sendText(element("text_adress"), address);

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
		
		waitForLoad();
		
		
		msg.log("Shipping method STANDARD is selected");
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(2);
			scrollWindow(0, 1000);
		}
		isElementDisplayed("your_order");
		msg.log("Your order is displayed");
		
		String before_change1 = element("OrderTotal").getText();
		System.out.println("OrderTotal total is : "+before_change1);
		hardWait(2);
		executeJavascript("document.getElementsByClassName('input-radio')[2].click()");
		hardWait(5);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(2);
			scrollWindow(0, 1000);
		}
		
		String after_change1 = element("OrderTotal").getText();
		System.out.println("OrderTotal total is : "+after_change1);

		Assert.assertNotEquals(before_change1,after_change1 ,"Order total is not updated");
		
		msg.log("Order Total is updated on changing shipping method");
		
		
	}


	public void verifySignInSectionOnShippingDetailPage() {
		isElementDisplayed("panel_sign_in");
		msg.log("Sign in section is displayed");
		isElementDisplayed("text_email");
		msg.log("Email text field is displayed in sign in section");
		isElementDisplayed("text_password");
		msg.log("Password text field is displayed in sign in section");
		isElementDisplayed("text_sign_in");
		msg.log("Sign-In text field  is displayed in sign in section");
	}
	
	
	public void signInFromShippingPage(String username,String password)
	{   wait.waitForPageToLoadCompletely();
	    isElementNotDisplayed("checkbox_remember_me");
	    msg.log("Remember me checkbox not displayed on shipping page");
	    isElementDisplayed("panel_sign_in");
	    msg.log("Sign in section is displayed");
	    isElementDisplayed("text_email");
		element("text_email").sendKeys(username);
		msg.log("Entered user name : " + username );
		isElementDisplayed("text_password");
		element("text_password").sendKeys(password);
		msg.log("Entered password : " + password);
		isElementDisplayed("text_sign_in");
		hardWait(2);
		executeJavascript("document.getElementsByClassName('btn checkout btn-default')[0].click()");
		msg.log("clicked on sign-in");
	}


	public void clickOnShippingTab() {
		click(element("tab_shipping"));
		isElementDisplayed("tab_shipping");
		msg.log("User on shipping page");
	}


	public void clickOnForgotPasswordLink() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("link_forgot_password");
		msg.log("Link forgot password is displayed on shipping page");
		click(element("link_forgot_password"));
		msg.log("Clicked on forgot passoword link");
		
	}


	public void verifypasswordLink() {
		isElementDisplayed("popup_password_request");
		msg.log("Modal pop of password request is displayed");
		//boolean msg = executeJavascriptReturnsBoolean("return $('.modal-body>p').text()");
		//assertTrue(msg , true,"");
		isElementNotDisplayed("text_sign_in_password_request");
		msg.log("Sign-In Button is not displayed on Password request pop-up");
		isElementDisplayed("link_cancel_password_request");
		msg.log("Cancel link is displayed on modal pop of password request");
		isElementDisplayed("text_email_password_request");
		msg.log("Email is displayed on modal pop of password request");
		isElementDisplayed("button_submit_password_request");
		msg.log("Submit button is displayed on modal pop of password request");
		isElementDisplayed("icon_cross_password_request");
		msg.log("Cross Icon is displayed on modal pop of password request");
		click(element("icon_cross_password_request"));
		msg.log("Closed modal pop of password request");	
	}


	public void verifyUserCannotSignFromInValidUsername() {
	  isElementDisplayed("error_invalid_login");
	  msg.log("User is not able to sign in with Invalid username");	
	}


	public void verifyUserIsAbleToSignIn() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("error_invalid_login");
		msg.log("User is able to sign in from shipping page");
		hardWait(2);
		executeJavascript("$('#billingSubmitButton').click()");
		msg.log("User clicks on continue button");
		
	}


	public void verifyAddressVerificationUPSServer() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("pop-up_ups_server"));
		isElementDisplayed("pop-up_ups_server");
		msg.log("Address verification window is displayed");
		isElementDisplayed("text_use_entered_address");
		msg.log("Use entered address is displayed");
		isElementDisplayed("text_suggested_address");
		msg.log("Suggested address is dispalyed");
		isElementDisplayed("text_suggested_address_value");
		msg.log("Suggested address value is displayed");
		click(element("link_edit_address_UPS_Server"));
		msg.log("User clicked on edit to change address");
		sendText(element("text_adress"), "11 C street 12");
		msg.log("User entered address : " + "11 C street 12");
		click(element("continue"));	
		msg.log("User clicks on continue");
		isElementDisplayed("pop-up_ups_server");
		msg.log("Address verification window is displayed");
	}



	public void verifyNocallToUPSServerForPerfectMatchEntered() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("pop-up_ups_server");
		msg.log("Address verification window is  not displayed - Address matched correctly");
	}



	public void verify_InvalidEmailOnShippingPage() {
		waitForLoad();
		isElementDisplayed("text_email_password_request");
		msg.log("Password modal is displayed");
		sendText(element("text_email_password_request"), "qa.com");
		msg.log("User enters and invalid email");
		element("button_submit_password_request").click();
		msg.log("User clicks on Submit button");
		hardWait(2);
		executeJavascript("document.getElementById('span_dwfrm_requestpassword_email').textContent;");
		msg.log("Invalid email address is displayed");
		isElementDisplayed("icon_cross_password_request");
		msg.log("Cross Icon is displayed on modal pop of password request");
		click(element("icon_cross_password_request"));
		msg.log("Closed modal pop of password request");	
		
		
	}


	public void verify_ValidEmailOnShippingPage() {
		waitForLoad();
		isElementDisplayed("text_email_password_request");
		msg.log("Password modal is displayed");
		sendText(element("text_email_password_request"), "abc@qa.com");
		msg.log("User enters and valid email");
		element("button_submit_password_request").click();
		msg.log("User clicks on Submit button");
		hardWait(2);
		executeJavascript("document.getElementsByClassName('modal-body')[0].getElementsByTagName('p')[0].textContent;");
		hardWait(1);
		isElementDisplayed("icon_cross_password_request");
		msg.log("Cross Icon is displayed on modal pop of password request");
		click(element("icon_cross_password_request"));
		msg.log("Closed modal pop of password request");	
	}


	public void verifySignInSectionOnShippingDetailPageForMobile() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("button_registered_customers");
		click(element("button_registered_customers"));
		msg.log("Clicked on Registered button to expand sign-In section");	
	}


	public void navigateBackToShippingPage() {
		wait.waitForPageToLoadCompletely();
		element("shippingPage").click();
		msg.log("User navigates back to shipping page");
	}


	public void enterNewShipingDetails() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		sendText(element("text_fname"), "ABC");
	    msg.log("User entered first name");
		sendText(element("text_lname"), "XYZ");
		msg.log("User entered last name");
		sendText(element("text_adress"), "15 Houston 28 Street");
		msg.log("User entered address");
		
		sendText(element("text_zip_code"), "B33 8TH");
//		hardWait(1);
		
		hardWait(1);
		click(element("text_city"));
		hardWait(3);
		
		sendText(element("text_city"), "Manchester".toUpperCase());
		hardWait(2);
		
		waitForLoad();
		sendText(element("text_phone_no"), "9876543210");
		hardWait(2);
				
		click(element("text_city"));
		hardWait(2);
		click(element("text_phone_no"));
		hardWait(5);
		waitForLoad();
		isElementDisplayed("continue");
		click(element("continue"));	
		msg.log("User clicks on continue");
		hardWait(5);
		waitForLoad();
		msg.log("User enters shipping details");
		
	}


	public void loginFromShippingPage(String username, String password) {
       wait.waitForPageToLoadCompletely();
        isElementDisplayed("panel_sign_in");
		msg.log("Sign in section is displayed");
		isElementDisplayed("text_email");
		sendText(element("text_email"), username);
		msg.log("Email text field is displayed in sign in section");
		isElementDisplayed("text_password");
		msg.log("Password text field is displayed in sign in section");
		sendText(element("text_password"), password);
		isElementDisplayed("text_sign_in");
		element("text_sign_in").click();
		msg.log("Sign-In text field  is displayed in sign in section");
	}


	public void verifyLoginFromShippingPageDoesnotHaveRememberMeCheckbox() {
	        wait.waitForPageToLoadCompletely();
	        isElementDisplayed("panel_sign_in");
			msg.log("Sign in section is displayed");
			isElementDisplayed("text_email");
			msg.log("Email text field is displayed in sign in section");
			isElementDisplayed("text_password");
			msg.log("Password text field is displayed in sign in section");
			hardWait(2);
			boolean remember = executeJavascriptReturnsBoolean("return $('#dwfrm_login_rememberme').is(':hidden')");
			assertEquals(remember, false,"checkbox is present");
			boolean text =executeJavascriptReturnsBoolean("return $('#dwfrm_login_rememberme-label').is(':hidden')");
			assertEquals(text , false , "Remember me is displayed");
			msg.log("Remember me checkbox is not displayed");
			
	}
	

}
