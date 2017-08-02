package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
//import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class AddMonogramPage extends GetPage {

	WebDriver driver;
	public AddMonogramPage(WebDriver driver)
	{
		super(driver,"coach/AddMonogramPage");
		this.driver = driver;
	}  


	public void createMonogram() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		wait.waitForElementToBeClickable(element("btn_close_monogram"));
	//	boolean closeButton=executeJavascriptReturnsBoolean("$('.icon-coach-close-black').is(':visible')");
		assertEquals(element("btn_close_monogram").isDisplayed(), true,"Cross icon not visible ");
		wait.waitForElementToBeClickable(element("textfield1_letter"));
		hardWait(2);
		click(element("textfield1_letter"));
		executeJavascript("$('.monogram-text__icons li').eq(0).click()");
		executeJavascript("$('.monogram-text__icons li').eq(1).click()");
		executeJavascript("$('.monogram-text__icons li').eq(2).click()");
		msg.log("User enters the letters to be printed on monogram");
		hardWait(1);
		scrollWindow(0, 300);
		hardWait(2);
		executeJavascript("document.getElementsByClassName('gutter-right embosing-label')[6].click();");
		msg.log("User selects a color");
		//click(element("label_green_color"));
		hardWait(2);
		executeJavascript("document.getElementById('addToBag').click();");
		msg.log("User clicks on add to bag");
	}

	public void removeMonoGram() {
		click(element("link_remove"));		
	}

	public void editMonoGram() {
		click(element("link_edit"));
		//		click(element("label_font_twelve_pxl"));
		sendText(element("textfield1_letter"), "B");
		sendText(element("textfield2_letter"), "A");
		sendText(element("textfield3_letter"), "C");
		click(element("label_red_color"));
		executeJavascript("document.getElementById('monogramReviewButton').click()");

		//	click(element("btn_review_monogram"));	

	}

	public void addToBagFromMonogram() {
		click(element("button_add_to_bag"));

	}

	public void verifyMonogramAttributes() {
		isElementDisplayed("link_complimentory_monogramng");
		Assert.assertEquals(element("text_exterior_back").getText(),"Exterior Back");

	}


	public void checkoutfromviewpage() {
		String msg=element("text_monogram_msg").getText();
		isElementDisplayed("text_monogram_msg");
		//	Assert.assertFalse(element("dropdown_quantity").isEnabled());
		click(element("btn_proceed_checkout"));		
	}


	public void AddMonogramProductToShoppingBag() {
		hardWait(1);
		executeJavascript("-document.getElementsByClassName('add-monogram-link')[0].click();");
		hardWait(3);
		executeJavascript("document.getElementById('dwfrm_monogram_initials1').value='A'");
		driver.findElement(By.id("dwfrm_monogram_initials1")).sendKeys("A");
		executeJavascript("document.getElementById('dwfrm_monogram_initials2').value='B'");
		executeJavascript("document.getElementById('dwfrm_monogram_initials3').value='C'");
		executeJavascript("$('#dwfrm_monogram_monogramWithDots').click()");
		boolean checkBox=executeJavascriptReturnsBoolean("return $('#dwfrm_monogram_monogramWithDots').is(':checked')");
		assertEquals(checkBox, true,"checkbox is not clickable");
		//        executeJavascript("document.getElementById('monogramReviewButton').click();");
		hardWait(2);
		executeJavascript("document.getElementById('addToBag').click();");
		hardWait(2);
		msg.log("Product is added to shopping bag");
	}

	public void verifyUserIsNotAbleToIncreaseQuantityOfMonogrammingProduct() {

		waitForLoad();
		wait.waitForPageToLoadCompletely();	
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('btn dropdown-toggle selectpicker disabled btn-default')[0]");
		msg.log("User is not able to increase quantity of monogramming product");
		//isElementDisplayed("label_dropdown");

	}


	public void verify_MultipleColorVarientsAreNotPresentInAddAMonogramWindow(String color) throws InterruptedException {
		waitForLoad();
		scrollToElement("text_embossing");
		msg.log(color);
		System.out.println(getElementSize("text_embossing"));
		if(getElementSize("text_embossing")==6)
		{
			for(int i=0;i<6;i++){
				String text=executeJavascriptReturnsString("return $('.row>h3').text()");
				Assert.assertFalse(text.equals(color));
			}
			msg.log("Verified: Product's Multiple color varients are not present.");
		}
	}



	public void clickOnAddAMonogram() {
		hardWait(1);
		executeJavascript("document.getElementsByClassName('add-monogram-link')[0].click();");
		hardWait(5);

	}
	
	public boolean checkPreviewButtonVisibility(){
		return executeJavascriptReturnsBoolean("return $('#monogramPreviewButtontemp').is(':visible')");
	}
	
	public boolean checkMonogramDot(){
		return executeJavascriptReturnsBoolean("return $('.monogram-dots>label').is(':visible')");
	}


	public void verifyMonogrammingPage() throws InterruptedException {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		isElementDisplayed("monogram_heading");
		String mdelTitle=element("monogram_heading").getText();
		msg.log("Monogram heading is - "+mdelTitle);
		
		isElementDisplayed("monogram_product_name");
		String PrdtName=element("monogram_product_name").getText();
		msg.log("monogram product name is - "+PrdtName);
		
		
		if(ConfigPropertyReader.getProperty("browser").contains("iphone"))
		{
			hardWait(1);
			assertEquals(checkPreviewButtonVisibility(), true,"Preview Button not visible");
			logMessage("Preview button is visible");
		}
		executeJavascript("document.getElementById('monogram-start-over').textContent");
		executeJavascript("document.getElementById('addToBag').textContent");
		String embossing = executeJavascriptReturnsString("return $('.row>h3').text()");
		msg.log(embossing);
		isElementDisplayed("btn_close_monogram");
		hardWait(1);
		click(element("textfield1_letter"));
		executeJavascript("$('.symbol-wrapper li').eq(0).click()");
		executeJavascript("document.getElementById('dwfrm_monogram_initials2').value=3;");
		executeJavascript("document.getElementsByClassName('bx-clone')[0].click()");
		executeJavascript("document.getElementById('dwfrm_monogram_initials3').value=4;");
		msg.log("User enters the letters/symbols to be printed on monogram");
		hardWait(3);
		executeJavascriptReturnsString("$('.bx-prev').is(':visible')");
		msg.log("Arrows are visible for symbols");
		scrollWindow(0, 300);
		msg.log(element("monogram_start").getText());
		element("monogram_start").click();
		msg.log("User clicks on start over");
		scrollToElement("monogram_dots");
	    assertEquals(checkMonogramDot(), true,"dot not visible");
		element("monogram_dots").getText();
		msg.log((element("monogram_dots").getText())+ " is displayed");
	    
		isElementDisplayed("monogram_B_checkbox");
		element("monogram_B_checkbox").getText();
		msg.log((element("monogram_B_checkbox").getText())+ " is displayed");
		executeJavascriptReturnsString("$('#monogramAccordion .hidden-xs').is(':visible')");
		if(ConfigPropertyReader.getProperty("browser").contains("ios-iphone-browserstack"))
		{
//			hardWait(5);
//			isElementDisplayed("preview_monogram");
//			msg.log("Preview button is displayed");
		}
		
	}
	
	public String getStartOverBackGroundColor(){
		return executeJavascriptReturnsString("return $('#monogram-start-over').css('background-color')");
	}


	public void verifyStampsAreWorking() {
		if(ConfigPropertyReader.getProperty("browser").contains("iphone"))
		{
		String startOver=executeJavascriptReturnsString("return $('#monogram-start-over').attr('class')");
		assertEquals(startOver.contains("disabled"), true,"Start over button is enabled");
		String borderWidth=executeJavascriptReturnsString("return $('#monogramPreviewButtontemp').css('border-top-width')");
		logMessage("Border width *********"+borderWidth);
		assertEquals(borderWidth, "1px","Border Width not matched");
		}
		wait.waitForPageToLoadCompletely();
		executeJavascript("document.getElementsByClassName('add-stamps')[0].getElementsByTagName('ul')[0].getElementsByTagName('li')[0].click()");
		msg.log("User enters the stamp");
		
		if(ConfigPropertyReader.getProperty("browser").contains("iphone"))
		{
			hardWait(1);
			assertEquals(getStartOverBackGroundColor(), "rgb(255, 255, 255)","Color not matched");
			
		}
		
		
	}


	public void verifyAddAMonogramIsUpdatedToComplimentaryMonogram() {
		wait.waitForPageToLoadCompletely();
		String new_monogram = executeJavascriptReturnsString("return $('.add-monogram-link').text()");
		msg.log(new_monogram);
		hardWait(2);
	    boolean monogram =executeJavascriptReturnsBoolean("return $('.add-monogram-link').not(':contains(\"add a monogram\")').is(':visible')");
	    assertEquals(monogram,true,"Add a monogram is displayed");
	    msg.log("Add a monogram is updated with Complimentary Monogram");
		
	}
}
