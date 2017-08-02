package com.coach.keywords;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;

public class Footer extends GetPage {

	WebDriver driver;
	public Footer(WebDriver driver)
	{
		super(driver,"coach/Footer");
		this.driver = driver;
	} 

	public void verifyFooterSection(){
		isElementDisplayed("section_Footer");
		isElementDisplayed("textbox_Enter_email_address");
		isElementDisplayed("textbox_Enter_confirm_email_address");
		isElementDisplayed("button_signUp");
		isElementDisplayed("footer_top_section");
		isElementDisplayed("label_ConnectWithCoach");
	}
	
	public void verifyFooterLinks()
	 {
	  wait.waitForPageToLoadCompletely();
	  waitForLoad();
	  handle_DontMissOutWindow();
	  int c = 0;
	  //String home = "//*[@id='header-v2']/div[2]";
	  for(int i = 1; i < 4; i++)
	  {
	   List<WebElement> els = webdriver.findElements((By.xpath("//*[@id='footer-accordian']/div/div[" + i + "]/ul/li[not(contains(@class,'mobile'))]/a")));
	   msg.log(els.size()+"");
	   for(int j = 1; j <= els.size(); j++)
	   {
	    String xpath = "//*[@id='footer-accordian']/div/div[" + i + "]/ul/li[" + j + "][not(contains(@class,'mobile'))]/a";
	    //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	    //driver.findElement(By.linkText("Store Locator")).sendKeys(selectLinkOpeninNewTab);
	    executeJavaScriptUsingXpath(xpath); 
	    wait.waitForPageToLoadCompletely();
	 
	    try{
	     wait.resetImplicitTimeout(2);
	     webdriver.findElement(By.cssSelector(".null-results"));
	     c++;
	     int time = Integer.parseInt(ConfigPropertyReader.getProperty("timeout"));
			wait.resetImplicitTimeout(time);
	     webdriver.navigate().back();
	     msg.log("Link broken: "+webdriver.findElement(By.xpath(xpath)).getText());
	     
	    }
	    catch (Exception e) {
	    	webdriver.navigate().back();
	    }
	   
	  
	    }   
	  }
	  assertThat(c==0);
	 }
	
	
	

	public void connectWithCoachByEnteringEmailInFooter(String Username){
		sendText(element("textbox_Enter_email_address"),Username);
		msg.logAssertion("Entered Email for the user: "  + Username);
		sendText(element("textbox_Enter_confirm_email_address"),Username);
		msg.log("Entered User Name for "+ Username);
		wait.waitForElementToBeClickable(element("button_signUp"));
		waitForLoad();
		isElementDisplayed("button_signUp");
		element("button_signUp").click();
		hardWait(1);
		isElementDisplayed("label_message_After_Connect_with_Coach");
		click(element("icon_Cross_Connect_With_Coach_window"));
	}

	public void mobile_verifyFooterSection(){
		isElementDisplayed("section_Footer");
		isElementDisplayed("textbox_Enter_email_address");
	}

	public void mobile_connectWithCoachByEnteringEmailInFooter(String userName) throws InterruptedException{
		sendText(element("textbox_Enter_email_address"),userName);
		wait.waitForPageToLoadCompletely();
		sendText(element("textbox_Enter_confirm_email_address"),userName);
		if(getCurrentURL().contains("uk-dwdevelopment2"))
		{
			scrollToElement("confirm_email_checkbox");
			if(getElementSize("confirm_email_checkbox")==1){
				element("confirm_email_checkbox").click();
				System.out.println("User checks on confirm email checkbox");
			}
			
		}
		
		click(element("icon_mobile_submit_connect_with_coach"));
	}


	public void navigationToLinkPage() {

		List<WebElement> e1=elements("links_footer");
		System.out.println("Size"+e1.size());
		//		for(WebElement link :e1){
		//			click(element("link"));
		//			System.out.println("clicked"+link.getText());
		//		}
	}

	public void goToStoreLocatorPageFromFooter() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		executeJavascript("document.getElementsByClassName('list-new-unstyled')[0].getElementsByTagName('a')[0].click()");
		msg.log("User searches a store from store locator");
		//handle_DontMissOutWindow();
	}

	public void verifyCorporateResponsibilityLinkPage() {
		hardWait(5);
		clickUsingJavaScriptClickEvent(".//*[contains(text(),'ABOUT US')]/following-sibling::ul//*[contains(text(),'Corporate Responsibility')]");
		//element("static_page").click();
		//executeJavascript("document.getElementsByClassName('list-new-unstyled')[2].getElementsByTagName('li')[4].getElementsByTagName('a')[0].click()");
		wait.waitForPageToLoadCompletely();
		hardWait(5);
		Assert.assertTrue(getCurrentURL().contains("corporate-responsibility"), "Corporate Responsibility Page does not open. Please check");
		msg.log("User clicks on Coach Foundation Page and verifies the navigation from the footer");

	}

	public void clickOnContactUsLink(String country) {
		wait.waitForPageToLoadCompletely();
		if(country.equals("US")){
			clickUsingJavaScriptClickEvent(".//*[contains(text(),'CUSTOMER CARE')]/following-sibling::ul//li[8]/a");
		}
		else{
			clickUsingJavaScriptClickEvent(".//*[contains(text(),'CUSTOMER CARE')]/following-sibling::ul//li[5]/a");

		}

		msg.log("User clicks on Contact Us Link in the Footer");
	}

	public void navigateToFooterGiftCardsLink() {
		//isElementDisplayed("link_gift_cards");
		executeJavascript("document.getElementsByClassName('list-new-unstyled')[1].getElementsByTagName('li')[5].getElementsByTagName('a')[0].click()");
		//click(element("link_gift_cards"));

	}

	public void mobile_clickOnAboutUsLinkMobile() {
		waitForLoad();
		scrollWindow(0, 1000);
		click(element("linkText_AboutUs"));
		msg.log("Clicked on About Us link");
	}

	public void mobile_clickOnStoresAndSites() {
		click(element("linkText_StoresAndSites"));
		msg.log("User scrolls down and clicks on Stores And Sites");
	}

	public void mobile_clickOnCustomerCareLink() {
		executeJavascript("document.getElementsByClassName('list-unstyled')[1].getElementsByTagName('li')[7].getElementsByTagName('a')[0].click()");
		msg.log("User scroll downs and clicks Customer Care Link");
		//click(element("linkText_CustomerCare"));

	}

	public void mobile_clickOnProductInformation() {
		executeJavascript("document.getElementsByClassName('list-unstyled')[1].getElementsByTagName('li')[5].getElementsByTagName('a')[0].click()");
		//click(element("link_mobile_ProductInformation"));
	}

	public void italy_VerifyObtInMessageAtFooter() throws InterruptedException {
		waitForLoad();
		scrollWindow(0, 1000);

		waitForLoad();
		scrollToElement("italy_label_signupmessage");
		if(getElementSize("italy_label_signupmessage")==1) {
			Assert.assertEquals(element("italy_label_signupmessage").getText(),"Selezionando la casella, l’utente accetta di ricevere comunicazioni pubblicitarie da Coach, Inc. tramite posta elettronica.");
			msg.log(element("italy_label_signupmessage").getText());
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
	}

	public void verify_UserIsAbleToChangeTheLanguageFromFooter() {
		waitForLoad();
		scrollWindow(0, 1000);
		isElementDisplayed("current_language");
		msg.log("Element to change the language is displayed");
		element("current_language").click();
		msg.log(element("current_language").getText()+ "is the selected language");

		handle_DontMissOutWindow();
		waitForLoad();
		scrollWindow(0, 1000);
		isElementDisplayed("change_language");
		msg.log("Element to change the language is displayed");
		element("change_language").click();
		msg.log(element("change_language").getText()+ "is the selected language");


	}

	public void verifyCountryDropdown() {
		waitForLoad();
		scrollWindow(0, 2000);
		executeJavascript("document.getElementsByClassName('country-class-wrapper')[0].click();");
		msg.log("Drop Down is displayed");
	}

	public void changeTheCountryFromFooter() {
		waitForLoad();
		scrollWindow(0, 1000);
		hardWait(2);
		verifyCountryDropdown();
		executeJavascript("document.getElementsByClassName('country-name')[3].click()");
		hardWait(5);

	}

	public void clickOnEveryFooterlements(){
		msg.log("Total no. of elements is : "+ elements("footer_SubCategories_Size").size());
		for(int i=1;i<=elements("footer_SubCategories_Size").size();i++){
			if(isElementDisplayed("list_footer_Subcategories",Integer.toString(i))){
				try{
					element("list_footer_Subcategories",Integer.toString(i)).click();
					msg.log("Element Clicked : " + i);
					msg.log("Page link is  : " + getCurrentURL());
					handle_DontMissOutWindow();
					isElementNotDisplayed("text_Page_Not_Exist");
					msg.log("This Page Not Exist does not displayed");
					driver.navigate().back();
					switchToDefaultContent();
					waitForLoad();
				}catch(Exception e){msg.log("Element not clickable :"+ i);}
			}
			else
				break;
		}
		msg.log("Every footer element has been verified");
	}

	public void clickOnGiftCard() {
		wait.waitForPageToLoadCompletely();
		scrollWindow(0, 1000);;
		executeJavascript("document.getElementsByClassName('list-new-unstyled')[1].getElementsByTagName('li')[5].getElementsByTagName('a')[0].click()");
		msg.log("User scroll downs and clicks Gift Card Link");
	}

	public void connectWithCoachByEnteringEmailInFooterUK(String Username) {
		sendText(element("textbox_Enter_email_address"),Username);
		msg.log("Entered Email for the user: "  + Username);
		sendText(element("textbox_Enter_confirm_email_address"),Username);
		msg.log("Entered User Name for "+ Username);
		wait.waitForElementToBeClickable(element("button_signUp"));
		waitForLoad();
		isElementDisplayed("button_signUp");
		element("button_signUp").click();
		isElementDisplayed("error_select_box_to_recieve");
		msg.log("Verified that user should not be able to proceed without checking the opt in box and error message should pop up");
		executeJavascript("document.getElementById('signup-addtoemailsignuplist').click()");
		msg.log("User clicked on option box for recieving mails");
		element("button_signUp").click();
		msg.log("Clicked on sign up button for connect with coach");
		hardWait(1);
		isElementDisplayed("label_message_After_Connect_with_Coach");
		click(element("icon_Cross_Connect_With_Coach_window"));

	}
	
	


}
