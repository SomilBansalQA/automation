package com.coach.keywords;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.PropFileHandler;

public class CustomerCarePage extends GetPage {

	WebDriver driver;
	public CustomerCarePage(WebDriver driver)
	{
		super(driver,"coach/CustomerCarePage");
		this.driver = driver;
	} 
	
	
	public void verifyContactUsLinkForm(String firstName, String lastName, String email) {
		wait.waitForPageToLoadCompletely();
		verifyPageTitleContains();
		isElementDisplayed("labelHeading_ContactUS");
		isElementDisplayed("label_required_text");
		sendText(element("textbox_FirstName"), firstName);
		sendText(element("textbox_LastName"), lastName);
		sendText(element("textbox_email"), email);
		sendText(element("textbox_confirmEmail"), email);
		sendText(element("textbox_phoneNumber"), "98680996126");
		sendText(element("textbox_comment"), "test message, kindly ignore");
		click(element("button_SubmitRequest"));
		logMessage("User submits the Contact Us form");
		hardWait(1);
		isElementDisplayed("label_Confirm_Message");
		isElementDisplayed("label_WeWillContact");		
		logMessage("User has verified the functionality of Contact Us form Present in Footer links");
	}


	public void verify_First_LastNameLimit_Is_30() {
		waitForLoad();
		logMessage("The maximum character limit for First name is :" +element("textbox_FirstName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_FirstName").getAttribute("maxlength"), Integer.toString(30));
		logMessage("Assertion for FIRST name character limit is passed");
		
		logMessage("The maximum character limit for Last name is :" +element("textbox_LastName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_LastName").getAttribute("maxlength"), Integer.toString(30));
		logMessage("Assertion for LAST name character limit is passed");
		
	}
	

}
