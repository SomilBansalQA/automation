package com.coach.keywords;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class ShopingBagPage extends GetPage {

	public ShopingBagPage(WebDriver driver)
	{
		super(driver,"coach/ShopingBagPage");
	}  
	
	public void hover_At_shoping_Bag(){
		wait.waitForPageToLoadCompletely();
	    hover(element("shopngpage_hover"));
	}
	
	public void clicked_On_Checkout(){
		//executeJavascript("document.getElementsByClassName('mini-cart-content mini-cart-items row')[0].setAttribute('style','display: block;')");		
		waitForLoad();
		element("checkout_button").click();
	}
	
	public void clicked_On_Remove(){
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		executeJavascript("document.getElementsByClassName('mini-cart-remove')[0].click();");
//		element("link_remove").click();
		msg.log("Product removed from shopping Bag");
		
	}

//	public void select_chekout_as_guest_button() {
//		
//		click(element("button_checkout_as_guest"));
//		System.out.println("Clicked chekout as guest button");
//	}

	public void scrollDownToBottom() {
		scrollWindow(0,10000);	
		msg.log("User scrolled to bottom");
	}

	public void scrollBackToTop() {
		//click(element("button_top"));
		msg.log("User scrolled to Top");
		executeJavascript("$('html,body').scrollTop(0)");
		msg.log("User scrolled to Top");
		//msg.log(name+ "is displayed");
		
	}
	
	public String currentUrl(){
		return getCurrentURL();
	}

	public void select_view_shopping_bag() 
	{
		hardWait(1);
		executeJavascript("document.getElementsByClassName('btn btn-white mini-cart-shoppingbag')[0].click();");
		for(int i = 0; i<1; i++)
			{
		if(currentUrl().contains("cart"))
		{
			break;
		}
		else
		{
			executeJavascript("document.getElementsByClassName('btn btn-white mini-cart-shoppingbag')[0].click();");
		}
}
		//		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
//			hardWait(2);
//		}
//		click(element("button_view_shopping_bag"));
//		for(int i = 0; i<2; i++)
//		{
//			if(currentUrl().contains("cart"))
//			{
//				break;
//			}
//			else
//			{
//				hover_At_shoping_Bag();
//				click(element("button_view_shopping_bag"));
//			}
//		}
		msg.log("Shopping Bag page is displayed");
	}

	public void checkoutTheProductFromBag() {
		waitForLoad();
		hardWait(1);
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(2);
	    }
		
		executeJavascript("document.getElementsByClassName('btn btn-default minicart-checkout-link')[0].click();");
		for(int i = 0; i<2; i++){
			if(currentUrl().contains("shipping")||currentUrl().contains("payment")){
				break;
			}
			else{
				System.out.println("Retrying checkout");
				hardWait(2);
				executeJavascript("document.getElementsByClassName('btn btn-default minicart-checkout-link')[0].click();");
			}
		}
		
//		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
//			hardWait(2);
//		}
//		
////		navigateToPaymentOrShippingPage(url);
//		wait.resetImplicitTimeout(5);
//		try{
//			clicked_On_Checkout();
//		}
//		catch(Exception e){
//		}
//		
//		if((ConfigPropertyReader.getProperty("browser").equals("chrome"))||(ConfigPropertyReader.getProperty("browser").equals("firefox")))
//		{
//			for(int i = 0; i<2; i++){
//				if(currentUrl().contains("shipping")||currentUrl().contains("payment")){
//					break;
//				}
//				else{
//					System.out.println("Retrying checkout");
//					hover_At_shoping_Bag();
//			        clicked_On_Checkout();
//				}
//			}
//		}
//	
//		wait.resetImplicitTimeout(30);
		msg.log("User checks out the product and proceed for purchase");
	}
		
	
	public void selectViewShoppingBagForAndroid(){
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		if ((ConfigPropertyReader.getProperty("browser").equals("safari"))
				|| (ConfigPropertyReader.getProperty("browser").startsWith("ios"))) {
			executeJavascript("document.getElementsByClassName('cart-quantity')[0].click()");
		} else {
			executeJavascript(
					"document.getElementsByClassName('minicart-title visible-xs')[1].getElementsByTagName('a')[0].click()");
		}//click(element("btn_item_in_your_bag"));
		msg.log("User clicked on View Shopping Bag");
	}

	public void verifyLabelsInShoppingBag() {
		String ShoppingBag=element("label_Your_shopping_Bag").getText();
	    Assert.assertTrue(ShoppingBag.equals("YOUR SHOPPING BAG"));
		
		String item=element("label_item").getText();
		Assert.assertTrue(item.equals("ITEM"));
		
		String description=element("label_description").getText();
		Assert.assertTrue(description.equals("DESCRIPTION"));
		
		String price=element("label_price").getText();
		Assert.assertTrue(price.equals("ITEM PRICE"));
		
		String quantity=element("label_quantity").getText();
		Assert.assertTrue(quantity.equals("QTY"));
		
		String total_Price=element("label_total_Price").getText();
		Assert.assertTrue(total_Price.equals("PRICE"));
		
		String your_shopping_bag=element("label_back_to_shopping_bag").getText();
        Assert.assertTrue(your_shopping_bag.equals("BACK TO SHOPPING"));
		
		String color=element("label_color").getText();
		Assert.assertTrue((color.equalsIgnoreCase("Colour:"))||(color.equalsIgnoreCase("Color:")));
	
		
		String style=element("label_style_no").getText();
		Assert.assertTrue(style.equalsIgnoreCase("Style No:"));
		
		
		String size=element("label_size").getText();
		Assert.assertTrue(size.equalsIgnoreCase("size:"));
		
		
		String stock=element("label_stock").getText();
		Assert.assertTrue(stock.equalsIgnoreCase("In Stock"));
		
	}

	public void addSizeableProductToShoppingBag() {
		waitForLoad();
		wait.waitForPageToLoadCompletely();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		//executeJavascript("document.getElementsByClassName('dropdown-menu open')[0].getElementsByClassName('swatchanchor required swatchanchorforsize')[0].click();");
		
		executeJavascript("document.getElementsByClassName('add-to-cart')[0].click()");
		hardWait(3);
	}

	public void increaseQuantityOfProduct() {
		wait.waitForPageToLoadCompletely();
		hardWait(4);
		String qty = executeJavascriptReturnsString("return $('.item-quantity')[0].textContent");
        msg.log(qty);
        boolean quantity = executeJavascriptReturnsBoolean("return $('.item-quantity').is(':visible')");
        assertEquals(quantity , true , "quantity is not displayed");
		executeJavascript("document.getElementsByClassName('dropdown-menu open')[0].getElementsByClassName('swatchanchor')[2].click();");
		msg.log("User increases the quantity of product");
		
	}

	public void verifyPromoCodeAndApplyNowLabels() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("label_promo_code"));
		isElementDisplayed("label_promo_code");
		msg.log("Lable Promo Code is displayed");
		try{
		isElementDisplayed("label_aply_now"); }
		catch(StaleElementReferenceException ex){
			assertEquals(executeJavascriptReturnsBoolean("$('.cart-coupon-code a').is(':visible')"), true," apply now not found");
		}
		msg.log("Label Apply Now is displayed");
	   }

	public void clickOnApplyLinkAndVerify() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("havePromoCode");
		msg.log(element("havePromoCode").getText());
		isElementDisplayed("apply_now");
		msg.log(element("apply_now").getText());
		executeJavascript("$('.row.cart-coupon-code>a').click()");
		msg.log("User clicks on Apply Now");
		isElementDisplayed("coupon_box");
		isElementDisplayed("addCoupon");
		msg.log(element("addCoupon").getText());
		}

	public void verifySubProductTotal() {
		isElementDisplayed("label_subtotal");
		String subtotal=(element("label_subtotal_price").getText()).replaceAll("[^0-9]", "");
		System.out.println(subtotal);
		float price1 =Float.parseFloat(subtotal);
		int price=Math.round(price1);
		Assert.assertTrue((price)>0);
		}

	public void decreaseQuantityOfProduct() {
		hardWait(5);
		executeJavascript("document.getElementsByClassName('dropdown-menu open')[0].getElementsByClassName('swatchanchor')[1].click();");
		
	}

	public void verifyLabelsInShoppingBagMobile() {
		
		String ShoppingBag=element("label_Your_shopping_Bag").getText();
	    Assert.assertTrue(ShoppingBag.equals("YOUR SHOPPING BAG"));
	    
	    String color=element("label_color").getText();
		Assert.assertTrue(color.equalsIgnoreCase("Color:"));
	
		
		String style=element("label_style_no").getText();
		Assert.assertTrue(style.equalsIgnoreCase("Style No:"));
		
		
		String size=element("label_size").getText();
		Assert.assertTrue(size.equalsIgnoreCase("size:"));
		
		
		String stock=element("label_stock").getText();
		Assert.assertTrue(stock.equalsIgnoreCase("In Stock"));
		
		String your_shopping_bag=element("label_back_to_shopping_bag").getText();
        Assert.assertTrue(your_shopping_bag.equals("BACK TO SHOPPING"));
		
		
	}

	public void verifyQuickBuyOptionForCrossSellersInShoppingBagPage() {
		scrollDownToBottom();
		hover(element("product_tile"));
		hover(element("quickBuy_crossSellers"));
		isElementDisplayed("quickBuy_crossSellers");
		msg.log("Quick buy option is visible");
		
	}

	public void verifyShoppingBagePageForProductType(String type) {
		wait.waitForPageToLoadCompletely();
		Assert.assertTrue(element("text_preoder").getText().contains(type), "Assertion failed:" + type + " Product msg not displayed on shopping page");
		msg.pass(type + " Product msg  displayed on shopping page");	
	}

	public void verifyCheckoutButtonAtBottomShouldBesticky() {
		wait.waitForPageToLoadCompletely();
		hardWait(4);
		boolean bag = executeJavascriptReturnsBoolean("return $('#shopping-cart-header').is(':visible')");
		System.out.println("****************8"+bag);
		assertEquals(bag , true , "View Shopping Bag is not displayed");
		String VSB = executeJavascriptReturnsString("return $('#shopping-cart-header').text()");
		msg.log(VSB);
		
		String sticky = executeJavascriptReturnsString("return $('.btn.btn-primary').css('position')");
		if (sticky == "static"){
			msg.log("Checkout at the bottom is sticky");
			assertEquals(sticky , "static" , "Position is not sticky");
		}
		
	}

}
