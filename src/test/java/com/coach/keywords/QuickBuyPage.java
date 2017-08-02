package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;

public class QuickBuyPage extends GetPage {

	public QuickBuyPage(WebDriver driver)
	{
		super(driver,"coach/QuickBuyPage");
	}

	public void verifyQuickShopPageAndAddToBag() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		boolean addToBag = executeJavascriptReturnsBoolean("return $('#add-to-cart').is(':visible')");
		assertEquals(addToBag, true,"Add to bag is not displayed");
		wait.hardWait(2);
		executeJavascript("document.getElementById('add-to-cart').click()");
		msg.log("User clicks on Add to Bag button");
        
	}

	public void verifyProductNameInQuickBuy() {
		waitForLoad();
		hardWait(1);
		String PLP_Name = executeJavascriptReturnsString("return document.getElementsByClassName('name-link productellipse multiline')"
				+ "[0].title;");
		msg.log(PLP_Name);
		hardWait(1);
		String Quick_Buy_Name = executeJavascriptReturnsString("return document.getElementsByClassName('name-link productellipse multiline')"
				+ "[0].title;");
		msg.log(Quick_Buy_Name);
		Assert.assertEquals(PLP_Name.replaceAll("[\\\t|\\\n|\\\r]", "").trim(), Quick_Buy_Name.replaceAll("[\\\t|\\\n|\\\r]", "").trim(),"Both names are displaying different");
		
	}
	
	
	public void Verify_PriceForFullPricedProduct() {
		wait.waitForPageToLoadCompletely();
		try {
			scrollToElement(element("fullPricedProduct"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isElementDisplayed("fullPricedProduct");
		msg.log(element("fullPricedProduct").getText()+ "is the full price of a product");
		String fullPricedProduct = element("fullPricedProduct").getAttribute("color");
		msg.log(fullPricedProduct + "is the color");
		String price = element("fullPricedProduct").getText();
		Assert.assertFalse(price.contains("."), "Price contains decimal numbers");
		msg.log("Full priced product is displayed");
		
	}

	public void verifyQuickBuyPriceRange() {
		wait.waitForPageToLoadCompletely();
		Verify_PriceForFullPricedProduct();
		
		
		
	}	
	
}
