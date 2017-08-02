package com.coach.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class OrderReviewPage extends GetPage {

	public OrderReviewPage(WebDriver driver)
	{
		super(driver,"coach/OrderReviewPage");
	} 
	
	public void click_on_place_order() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		wait.waitForElementToBeVisible(element("button_order_place"));
		isElementDisplayed("button_order_place");
		msg.log("User is on Order confirmation page");
		element("button_order_place").click();
		msg.log("Clicked On Place Order");
		
	}

	public void enterCvv(String cvv) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("field_cvv"));
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		isElementDisplayed("field_cvv");
		click(element("field_cvv"));
		sendText(element("field_cvv"),cvv);
		hardWait(1);
	}
	
	public void orderReview(){
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(10);
		}
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("label_OrderConformation"));
		isElementDisplayed("label_OrderConformation");
		msg.log("Order is confirmed");
	}

	public void verifyErrorMessage() {
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementsByClassName('error-form')[0];");
		}

	public void verifyShippingAddressAndBillingAddressAreDifferent() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").contains("ios"))){
			hardWait(5);
		}
		String shipping_address = executeJavascriptReturnsString("return document.getElementsByClassName('updated-address mob-content')[0].textContent");
		msg.log(shipping_address);
		
		String billing_address = executeJavascriptReturnsString("return document.getElementsByClassName('updated-address')[1].textContent");
		msg.log(billing_address);
		Assert.assertNotEquals(shipping_address, billing_address,"Both address are same");
	}

}
