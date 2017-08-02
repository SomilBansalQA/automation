package com.coach.keywords;
import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class ProductResultPage  extends GetPage {

	String name;
	String bagcharm;
	String Sneaker;
	String colour;
	public ProductResultPage(WebDriver driver)
	{
		super(driver,"coach/ProductResultPage");
	} 

	public void select_frst_product(){
		wait.waitForPageToLoadCompletely();	
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(1);
		}
		selectFirstProduct();
	}

	public void verifySearchResult(String productOrCategory) {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("header_ResultsFor");
		Assert.assertEquals(productOrCategory.toLowerCase(),element("header_ResultsFor").getText().toLowerCase());
		msg.log("Verified Search result is displayed");
	}
	public void verifyFilterByTag() {
		isElementDisplayed("span_product_filter_by");
		wait.waitForElementsToBeVisible(elements("span_product_filter_by"));
		scrollWindow(0, -250);
		//		JavascriptExecutor jse = (JavascriptExecutor)webdriver;
		//		jse.executeScript("window.scrollBy(0,-250)", "");
		click(element("span_product_filter_by"));
		isElementDisplayed("link_color_filter");

	}

	public void verifySortByTag() {
		wait.waitForPageToLoadCompletely();
		JavascriptExecutor jse = (JavascriptExecutor)webdriver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		wait.waitForElementToBeClickable(element("list_sort_by"));
		click(element("list_sort_by"));
		wait.waitForPageToLoadCompletely();
		//		isElementDisplayed("list_sort_by_just_added");
		//		isElementDisplayed("list_sort_by_bestseller");
		isElementDisplayed("list_sort_by_Price_high_to_low");
		isElementDisplayed("list_sort_by_price_low_to_high");
	}

	public String getTextOfFirstProduct() {
		return name;
	}

	public void NavigateToquickShop() {
		hardWait(1);
		executeJavascript("document.getElementsByClassName('quickbuy-show')[0].click();");
		msg.log("User clicks on quick buy");

	}

	public void verifyaddbagcharm() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		scrollWindow(0, 1000);
		isElementDisplayed("label_Bag_charm");
		msg.log("Add bag charm section is displayed");
	}

	public void verifyAddBagCharmProductsDisplayed() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("image_bag_charm");
		hover(element("image_bag_charm"));
		bagcharm= executeJavascriptReturnsString("return document.getElementsByClassName('product-name')[6].getElementsByTagName('meta')[0].getAttribute('content');").trim();
		msg.log("hovered on add bag charm section products");
		//		bagcharm = (String) executeJavascriptWithReturn("function getElementByXpath(path){  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; } return getElementByXpath(\"//h3[contains(@class,'productellipse')]/a[@class='name-link' and text() ='C PATCH BAG CHARM']\").textContent;");
	}

	public void addbagCharmProductToBag() {
		executeJavascript("document.getElementsByClassName('btn btn-default add-to-bag-cham collapsed addToBagCharm')[3].click();");
		msg.log("Bag charm is added to Bag");
	}


	public void verifybagcharmisadded() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		String a= element("text_verify_charm_added").getText().trim();
		assertEquals(a.contains("BAG CHARM"), true);

		msg.log("Bag charm is added");
	}


	public void verifyYouMayAlsoLike() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		scrollWindow(0, 300);
		isElementDisplayed("label_you_may_like");
		msg.log("User verified You May like section");

	}


	public void hoverOnYouMayAlsoLikeproducts() {
		waitForLoad();
		hover(element("hover_youMay_like_product"));
		msg.log("User hovered on You may like section products");

	}


	public void clickOnYouMayAlsoLikeproducts() {
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		Sneaker = element("hover_youMay_like_product").getAttribute("data-product-tooltip");
		executeJavascript("document.getElementsByClassName('product-image recommendation_image')[0].getElementsByTagName('a')[0].click();");
		msg.log("User Clicked on You may like section products");

		//click(element("hover_youMay_like_product"));
	}


	public void verifyProductIsDisplayedInPDP() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		String PdpResult=element("text_verify_product_added").getAttribute("data-product-url").toUpperCase();
		Assert.assertTrue(((Sneaker).contains(PdpResult)));
		msg.log("Product is dispalyed in PDP");
		isElementDisplayed("style_id");
		msg.log(element("style_id").getText());
	}

	public void searchProductfromHeader() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('top-level new')[0].getElementsByTagName('a')[6].click();");
		handle_DontMissOutWindow();
	}

	public void clickandVerifySortByForPriceLowToHigh() {
		wait.waitForPageToLoadCompletely();
		hardWait(7);
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		int [] a = new int[4];
		int i=0;


		String url = getCurrentURL();
		executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[3].click();");

		if((url.contains("uk.coach.com"))||(url.contains("uk-dwdevelopment.coach.com"))||(url.contains("uk-dwstaging.coach.com"))||(url.contains("uk-dwstaging2.coach.com"))||(url.contains("it.coach.com"))||(url.contains("fr.coach.com"))||(url.contains("de.coach.com"))||(url.contains("es.coach.com"))||(url.contains("de-dwstaging2.coach.com"))||(url.contains("fr-dwstaging2.coach.com"))||(url.contains("es-dwstaging2.coach.com"))||(url.contains("it-dwstaging2.coach.com"))){
			executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[0].click();");
			hardWait(3);
		}

		hardWait(2);
		//		click(element("label_price_low_to_high"));
		//		hardWait(5);

		try{
			for(i=0;i<elements("label_price_plp").size();)
				//for(WebElement price_tag: elements("label_price_plp"))
			{
				a[i] =Integer.parseInt(elements("label_price_plp").get(i).getText().substring(1));
				msg.log("a["+i+"]"+a[i]);
				i++;
				wait.hardWait(2);

			}
		}
		catch(NumberFormatException e){
			msg.log("NUMBER FORMAT EXCEPTION CAUGHT");
		}

		//		Assert.assertTrue(((a[0]<=a[1]) && (a[0]<=a[2]) && (a[0]<=a[3])),"Low to High Filter not working Correctly..!!");
		//		Assert.assertTrue(((a[1]<=a[2]) && (a[1]<=a[3]) ),"Low to High Filter not working Correctly..!!");
		//		Assert.assertTrue(((a[2]<=a[3])),"Low to High Filter not working Correctly..!!");

		msg.log("Low to High Filter working Correctly..!!");
	}

	public void clickandVerifySortByForPriceHighToLow() {
		hardWait(7);
		int [] a = new int[4];
		int i=0;
		executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[2].click();");
		hardWait(3);
		//		click(element("label_price_High_to_low"));
		//		hardWait(5);
		String url = getCurrentURL();
		if((url.contains("uk.coach.com"))||(url.contains("uk-dwdevelopment.coach.com"))||(url.contains("uk-dwdevelopment2.coach.com"))||(url.contains("uk-dwstaging.coach.com"))||(url.contains("uk-dwstaging2.coach.com"))||(url.contains("it.coach.com"))||(url.contains("fr.coach.com"))||(url.contains("de.coach.com"))||(url.contains("es.coach.com"))||(url.contains("de-dwstaging2.coach.com"))||(url.contains("fr-dwstaging2.coach.com"))||(url.contains("es-dwstaging2.coach.com"))||(url.contains("it-dwstaging2.coach.com"))){
			executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[1].click();");
			hardWait(3);
		}


		try{
			for(WebElement price_tag: elements("label_price_plp")){
				a[i] =Integer.parseInt(price_tag.getText().substring(1));
				msg.log("a["+i+"]"+a[i]);
				i++;

			}
		}
		catch(NumberFormatException e){
			msg.log("NUMBER FORMAT EXCEPTION CAUGHT");
		}


		Assert.assertTrue(((a[0]>=a[1]) && (a[0]>=a[2]) && (a[0]>=a[3])),"High to Low Filter not working Correctly..!!");
		Assert.assertTrue(((a[1]>=a[2]) && (a[1]>=a[3]) ),"High to Low Filter not working Correctly..!!");
		Assert.assertTrue(((a[2]>=a[3])),"High to Low Filter not working Correctly..!!");
		msg.log("High to Low Filter working Correctly..!!");
	}

	public void verifyImageIsPresentOrNotInShopGridTilesPLP() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}
		Assert.assertTrue(checkIfElementIsNotThere("image_MissingImage"),"URL is"+getCurrentURL());
	}

	public void selectAny1941ShopsForWomen() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('top-level coach-1941')[0].getElementsByTagName('a')[2].click();");
		handle_DontMissOutWindow();
	}

	public void clickAndVerifyFilterBy() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}

		executeJavascript("document.getElementsByClassName('panel-heading collapsed')[0].click()");

		int AfterFilter = Integer.parseInt(executeJavascriptWithReturn(
				"return document.getElementsByClassName('row filters-row')[0].getBoundingClientRect().top.toFixed()").toString());
		hardWait(2);
		Assert.assertTrue((AfterFilter!=0), "assert for filter failed");
		executeJavascript("document.getElementsByClassName('panel-heading')[0].click()");
	}

	public void selectAnyNon1941ShopsForWomen() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('top-level women')[0].getElementsByTagName('a')[3].click();");
		handle_DontMissOutWindow();
	}

	public void selectViewAllForBagsForWomen() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}
		executeJavascript("document.getElementsByClassName('top-level women')[0].getElementsByTagName('a')[2].click();");
		handle_DontMissOutWindow();
		msg.log("Clicked view all for handbags under women category");
	}

	public void clickOnImage() {
		element("image_MissingImage").click();

	}

	public void verifyPlpOfCategoryPages(String finalCount) {
		wait.waitForPageToLoadCompletely();
		//int k;
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}
		//int j = 0;
		//		int priceCounter = 0;
		int counts = Integer.parseInt(finalCount);
		//boolean flag = false;
		int e=0; int x=0;
		for (int i = 1; i <=counts; i++) {
			String xpath = "(//ul[@class='products-list']/li[not(contains(@data-hidden,'global'))]/a)[text()='Afficher tout' or text()='View All' or text()='Visualizza tutto' or text()='Ver todos' or text()='Alle anzeigen'][" + i + "]";
			executeJavaScriptUsingXpath(xpath);
			wait.waitForPageToLoadCompletely();
			waitForLoad();
			handle_DontMissOutWindow();

			if(i==1){
				x=checkMobileOrDesktop();
			}

			if(x==0)scrollDownFurtherForLazyLoading();
			else mobileLazyLoading();
			//msg.log("Current URL -> " + getCurrentURL());
			int a = checkForPricingOfAllProducts();
			int b =checkBlankTiles();

			int c = checkImageMissing();
			int d= checkImageMissingFromSrc();


			/*
			if (checkIfElementIsNotThere("image_MissingImage")) {
				msg.log("All the image are appearing fine in page > "+ getCurrentURL());
			} else {
				j++;
				msg.log("URL where product image is missing is > " + getCurrentURL());
			}*/

			if(a > 0|| b>0||c>0||d>0)e++;

			//			int [] a = new int[30];
			//			int inte=0;
			//			for(WebElement price_tag: elements("labelTag_price_plp"))
			//			{
			//				a[inte] =Integer.parseInt(price_tag.getText().substring(1));
			//				msg.log("a["+inte+"]"+a[inte]);
			//				inte++;
			//				if(a[inte]<0){
			//					priceCounter++;
			//					msg.log("Price less then 0, Please check immediately"+"URL where product price is missing is > " + getCurrentURL());
			//				}
			//			}

			//		}


			//		Assert.assertTrue(priceCounter == 0);

			// for(int i=0;i<14;i++) {
			// String xpath
			// ="((((//div[contains(@class,\'dropdown-menu\')])[1]//ul)[1]//li)["+i+"])//a";
			// executeJavaScriptUsingXpath(xpath);
			// wait.waitForPageToLoadCompletely();
			// waitForLoad();
			// }

		}
		assertThat(e).isEqualTo(0);
	}

	/*private void scrollDownFurtherForLazyLoading() {
		// TODO Auto-generated method stub
		Object reachedbottom = (executeJavascriptWithReturn(
				"return $(document).height() == ($(window).height() + $(window).scrollTop());"));
		while (reachedbottom.toString() == "false") {
			executeJavascript("window.scrollBy(0,1000)");

			reachedbottom = (executeJavascriptWithReturn(
					"return $(document).height() == ($(window).height() + $(window).scrollTop());"));
		}
	}*/


	private void scrollDownFurtherForLazyLoading() {
		long a, b, c, d;
		do
		{
			executeJavascript("window.scrollBy(0,1500)");
			a = (long)executeJavascriptWithReturn("return $(document).height();");
			b = (long)executeJavascriptWithReturn("return $(window).height();");
			c = (long)executeJavascriptWithReturn("return  $(window).scrollTop();");
			// Console.WriteLine(a + " " + b + " " + c + " " + (b + c));
			if (a == b + c)
			{
				int x = 0; d = a;
				while (x < 20 && a == d)
				{
					if (a == d)
						try {
							Thread.sleep(50);
						} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					d = (long)executeJavascriptWithReturn("return $(document).height();");
					x++;
				}

				if (a == d) break;
			}

		} while (1 > 0);
	}

	public int checkMobileOrDesktop()
	{
		int x=0;
		try
		{
			webdriver.findElement(By.cssSelector(".more-results")).click();
			x=1; System.out.println("Running on Mobile");
		}
		catch(Exception ex)
		{ 
			System.out.println("Running on Desktop");

		}
		return x;
	}
	public void mobileLazyLoading()
	{
		try{
			do
			{webdriver.findElement(By.cssSelector(".more-results")).click();
			try
			{Thread.sleep(50);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}while(1>0);
		}
		catch(Exception Ex)
		{

		} 

	}




	private int checkForPricingOfAllProducts(){
		int flag =0;List<WebElement> els =null;
		try{
			//int [] a = new int[1000];
			//int inte=0;
			els= webdriver.findElements(getLocator("labelTag_price_plp"));
			//msg.log("Number of items = "+els.size());
			for(WebElement price_tag: els)
			{
				//a[inte] =Integer.parseInt(price_tag.getText().replaceAll("[^0-9]", ""));

				//String price = price_tag.getText();

				String price = price_tag.getAttribute("innerText");
				//msg.log("Product "+inte+" price is : "+price);
				//inte++;
				if(price.length()==0){
					if(flag==0){msg.log("Current URL -> " + getCurrentURL());flag++;}

					//msg.log("Price less then 0, Please check immediately"+"URL where product price is missing is > " + getCurrentURL());
					//msg.log("Alert Price missing in the page with URL "+getCurrentURL());
					try{
						msg.log("Missing Price: [Name]: " + price_tag.findElement(getLocator("price_name")).getAttribute("content") +"\t[Id]: "+price_tag.findElement(getLocator("price_productId")).getAttribute("content"));
					}
					catch(NoSuchElementException e)

					{
						msg.log("Can't find name and product id for the missing price. Check Manually!");
					}
				}
			}
		}
		catch(TimeoutException e )
		{
			msg.log("Please check manually: Timeout" + "URL is  > " + getCurrentURL());
		}
		catch(NoSuchElementException e )
		{
			msg.log("2 Please check manually: No Such Element" + "URL is  > " + getCurrentURL());
		}
		catch(NumberFormatException e )
		{
			msg.log("3 Please check manually : Number Format" + "URL is  > " + getCurrentURL());
		}

		return flag;
	}

	private int checkImageMissing()
	{	
		wait.resetImplicitTimeout(2);
		/*try
			{	 webdriver.findElement(getLocator("missing_image_first"));}
			catch(NoSuchElementException e)
			{
				msg.log("Number of missing images = 0");
				return 0;
			}*/
		List<WebElement> els = null;

		try {
			els = webdriver.findElements(getLocator("missing_image"));
			//if(els.size()==0||els==null)return 0;
			int count=0;
			//msg.log("Number of missing images = " + els.size());
			//msg.log("Current URL -> " + getCurrentURL());
			for (WebElement ele :els)
			{if(count==0)msg.log("Current URL -> " + getCurrentURL());
			count++;
			try{
				msg.log("Missing Image: [Name]: "+ele.findElement(getLocator("missing_image_name")).getAttribute("content")+"\t [Id]: "+ele.findElement(getLocator("missing_image_productId")).getAttribute("content"));

			}
			catch(NoSuchElementException e)
			{
				msg.log("Can't find name and product id of missing image. Check Manually!");

			}
			}

			int time = Integer.parseInt(ConfigPropertyReader.getProperty("timeout"));
			wait.resetImplicitTimeout(time);
			return els.size();
		}
		catch (Exception e)
		{
			msg.log("Exception");
		}

		return -1;
	}

	public int checkImageMissingFromSrc()
	{wait.resetImplicitTimeout(2);
	int count=0;
	List<WebElement> image = webdriver.findElements(getLocator("missing_image_src"));
	for(WebElement missing :image)
	{
		String s= missing.getAttribute("src");
		if(s.contains("coach-missing-image.jpg"))
		{if(count==0)msg.log("Current URL -> " + getCurrentURL());
		count++;
		try{
			msg.log("Missing Image: [Name]: "+missing.findElement(getLocator("missing_image_src_name")).getAttribute("content")+"\t [Id]: "+missing.findElement(getLocator("missing_image_src_productId")).getAttribute("content"));

		}
		catch(NoSuchElementException e)
		{
			msg.log("Can't find name and product id of missing image. Check Manually!");

		}
		}

	}
	int time = Integer.parseInt(ConfigPropertyReader.getProperty("timeout"));
	wait.resetImplicitTimeout(time);
	return count;

	}

	private int checkBlankTiles()
	{
		int x = 2, count = 0,prev=0;
		WebElement temp=null;
		List<WebElement> els = webdriver.findElements(getLocator("tile_class"));
		for(WebElement ele : els)
		{

			try
			{
				ele.findElement(getLocator("blank_tile"));
				temp=ele;
			}
			catch(NoSuchElementException e)
			{if(count==0)msg.log("Current URL -> " + getCurrentURL());
			count++;
			try{
				//				msg.log("Blank after tile: [Name]: " + temp.findElement(getLocator("blank_tile_name"))+"\t [Id]: "+  temp.findElement(getLocator("blank_tile_productId")));
				msg.log("Blank after tile: [Name]: " + temp.findElement(getLocator("blank_tile_name")).getAttribute("content")+"\t [Id]: "+  temp.findElement(getLocator("blank_tile_productId")).getAttribute("content"));
			}
			catch (Exception ex)
			{ 
				msg.log("Can't find name and product id. Check Manually!");
			}
			}
		}
		// msg.log("No of blank tiles = "+count);
		return count;
	}

	private void checkLazyLoading() {
		// TODO Auto-generated method stub
		int flag = 1;
		Object reachedbottom = (executeJavascriptWithReturn(
				"return $(document).height() == ($(window).height() + $(window).scrollTop());"));
		while (reachedbottom.toString() == "false") 
		{
			executeJavascript("window.scrollBy(0,1000)");
			flag++;
			if(flag==5){
				break;
			}

			reachedbottom = (executeJavascriptWithReturn(
					"return $(document).height() == ($(window).height() + $(window).scrollTop());"));
		}

	}



	public void clickOnBagsFromCoach1941() {
		hardWait(5);
		hover(element("coach1941"));
		msg.log("User hovers on COACH1941 shop");
		click(element("coach1941Bags"));
		msg.log("User clicks on Bags");



	}

	public void verifyPriceRangeIsDisplayedRed() {
		scrollWindow(0, 250);
		String color = element("priceRange").getCssValue("color");
		msg.log("color of the price range is : " +color);
		Assert.assertTrue(color.contains("rgba(204, 0, 0"), "color not red");
	}

	public void clickandVerifySortByForJustAdded() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		int [] a = new int[4];
		int i=0;



		executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[0].click();");
		String url = getCurrentURL();
		Assert.assertTrue(url.contains("just-added"),"Sort By functionality for Just Added is not working");
		msg.log("Sort By Just Added Filter working Correctly..!!");
	}

	public void clickandVerifySortByForBestseller() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			hardWait(5);
		}
		int [] a = new int[4];
		int i=0;



		executeJavascript("document.getElementsByClassName('sortby list-unstyled')[0].getElementsByTagName('li')[1].click();");
		String url = getCurrentURL();
		Assert.assertTrue(url.contains("best-sellers"),"Sort By functionality for Bestsellers is not working");
		msg.log("Sort By Bestsellers Filter working Correctly..!!");

	}

	public void verifyMoreButton() throws InterruptedException {
		waitForLoad();
		//scrollWindow(0, 1000);
		scrollToElement("view_more_item");
		isElementDisplayed("view_more_item");
		msg.log("View more  button is displayed");
		click(element("view_more_item"));
		msg.log("User clicks on View More Item button");

	}

	public void verify_FilterContainerIsDisplayed() throws InterruptedException {
		waitForLoad();
		isElementDisplayed("filter_container");
		msg.log("Filter container is displayed");
		wait.hardWait(3);
		isElementDisplayed("text_color_filter");
		msg.log(element("text_color_filter ").getText() + " filter is present");
		hover(element("text_color_filter"));
		waitForLoad();
		scrollToElement("color_select_filter");
		if(getElementSize("color_select_filter")==1) {
			executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox refinement-checkbox')[1].click()");
			hardWait(5);
		}
		msg.log("Selected color from color filter");
		isElementDisplayed("material_filter");
		msg.log(element("material_filter ").getText() + " filter is present");
		hover(element("material_filter"));
		scrollToElement("material_filter");
		if(getElementSize("material_filter")==1) {
			executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox refinement-checkbox')[14].click()");
			hardWait(5);
		}
		msg.log("Selected material from material filter");
		isElementDisplayed("category_filter");
		msg.log(element("category_filter ").getText() + " filter is present");
		hover(element("category_filter"));
		scrollToElement("category_filter");
		if(getElementSize("category_filter")==1) {
			executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox refinement-checkbox')[30].click()");
			hardWait(5);
		}
		msg.log("Selected category from category filter");
		isElementDisplayed("sortBy_filter");
		msg.log(element("sortBy_filter ").getText() + " filter is present");
		hover(element("sortBy_filter"));
		String filter = element("filter_alignment").getCssValue("text-align");
		msg.log("filter alignment is on " +filter);

	}

	public void verify_LazyLoadingOnSearchResultPage() {
		waitForLoad();
		hover(element("new_tab"));
		msg.log("User hovers on new tab");
		element("bags").click();
		msg.log("user clicks on bags");
		waitForLoad();
		checkLazyLoading();
		msg.log("lazy loading completed");
	}

	public void clickOnMoreColors() {
		handle_DontMissOutWindow();
		wait.waitForPageToLoadCompletely();
		handle_DontMissOutWindow();
		scrollDown(element("link_morecolors"));
		wait.hardWait(4);
		executeJavascript("$('.more-colors .product-msg .name-link').get(1).click()");
		//		click(element("link_morecolors"));
		msg.log("Clicked on More colors");
	}

	public String selectColourFilter() {
		waitForLoad();
		isElementDisplayed("text_color_filter");
		msg.log(element("text_color_filter ").getText()  + " filter is present");
		handle_DontMissOutWindow();
		hover(element("text_color_filter"));
		wait.hardWait(4);
		colour=element("text_color_selected").getText();
		String colorname =colour.substring(8).trim();
		executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox refinement-checkbox')[0].click()");
		waitForLoad();
		//msg.log("Color Selected : " + colour );
		return colorname;

	}

	public void verifyShopGridDisplayedAccordingToAppliedFilter(String color) {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		wait.hardWait(3);
		String colorname =element("tags_filter").getText().substring(7).trim();
		Assert.assertTrue(colorname.contains(color.toUpperCase()), "Assertion Failed : Filter Not applied correctly");
		msg.pass("Filter Applied");

	}

	public String verifyProductCustomMessage(String message){
		return executeJavascriptReturnsString("return $('a:contains(\"SOLD OUT\")').text()");

	}

	public void verifySoldOutItems(){
		wait.waitForPageToLoadCompletely();
		String customMessage=verifyProductCustomMessage("SOLD OUT");
		assertEquals(customMessage, "SOLD OUT");
		clickUsingJavaScriptClickEvent("//*[@class='col-lg-3 col-md-3 col-sm-4 col-xs-6 prod-grid ']//*[contains(text(),'SOLD OUT')]");
	}

	public void verifySoldOutItemInPDP(String buttonName){
		wait.waitForPageToLoadCompletely();
		String addToCartButton=executeJavascriptReturnsString("return $('#add-to-cart').text()");
		assertEquals(addToCartButton, buttonName);
	}

	public void verifyAfterRefreshFilterRemains() {
		refreshThePage();
		wait.waitForPageToLoadCompletely();
		Boolean flag =element("tags_filter").isDisplayed();
		Assert.assertTrue(flag, "After Refresh Filters are not present");
		msg.log("After Refresh Filters are present");
	}

	public void clickOnClearAllButton() {
		wait.hardWait(1);
		executeJavaScriptUsingXpath("//a[@title='Clear']");		
		msg.log("Clicked on button Clear All");
	}

	public void verifyPageReturnToPreviousState() {
		wait.waitForPageToLoadCompletely();
		boolean flag = checkIfElementIsNotThere("text_filter_by");
		Assert.assertTrue(flag, "After clicking on clear all button, Page is not coming to previous state");
		msg.log("After clicking on clear all button,Page is  coming to previous state");

	}

	public void verifyMobile_FilterContainerIsDisplayed() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		executeJavascript("document.getElementsByClassName('category-dropdowntitle')[0].click();");
		msg.log("User clicks on Filter Drop down");
		executeJavascript("document.getElementById('refinement-colorGroup').click();");
		msg.log("User clicks on color option");
		executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox')[0].click();");
		executeJavascript("$('.category-dropdownnavlist').eq(1).css('display','none')");
		msg.log("User selects the color");
		executeJavascript("document.getElementById('refinement-fabrication').click();");
		msg.log("User clicks on Material");
		executeJavascript("document.getElementsByClassName('category-dropdownnavlist')[2].getElementsByTagName('li')[0].click()");
		executeJavascript("$('.category-dropdownnavlist').eq(2).css('display','none')");
		msg.log("Selected material from material filter");

		//		executeJavascript("document.getElementsByClassName('icon-coach-refinement-checkbox refinement-checkbox')[24].click()");
		//	    msg.log("Selected category from category filter");

		//

	}

	public void verifyQuickBuyForPreorderProduct(String productMessageType) {
		//Assert.assertTrue(element("text_product_msg_preorder").getText().contentEquals(productMessageType),"Assertion failed : Product message not displayed as expected");
		msg.pass("Product message displayed as Expected");
		hardWait(2);
		executeJavascript("$('#add-to-cart').click()");
		msg.log("clicked on Quik Buy link for " + productMessageType + " product" );
		executeJavascript("$('#add-to-cart').click()");

	}

	public void verifyProductNameInShopGrid() {
		wait.waitForPageToLoadCompletely();
		hardWait(2);
		String name = executeJavascriptReturnsString("return document.getElementsByClassName('name-link productellipse multiline')"
				+ "[0].title;");
		msg.log(name);

	}

	//	public void verifyWishlistIcon() {
	//		wait.waitForPageToLoadCompletely();
	//		Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.add-to-wishlist').eq(1).is(':visible')"), true);
	//		Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.icm-icon-like.add-to-wishlist').eq(1).is(':visible')"), true);
	//	}

	public void addProductToBagFromshopGridForaParticularProductType(String type) {
		  wait.waitForPageToLoadCompletely();
		  handle_DontMissOutWindow();
		  Boolean flag=false;
		  hardWait(5);
		  //System.out.println(elements("products_text_shopgrid").size());
		  long  productsLength=executeJavascriptReturnsLong("return $('.product-msg .name-link').length");
		  //List<WebElement> products = elements("products_text_shopgrid");
		  for (int i=0;i<productsLength;i++) { 
		   if(executeJavascriptReturnsString("return $('.product-msg .name-link').get("+i+").text").contentEquals(type))
		   {
		    Assert.assertTrue(executeJavascriptReturnsString("return $('.product-msg .name-link').get("+i+").text").contentEquals(type), "Assertion failed : Product type not displayed as expected");
		    msg.pass("Product type displayed as Expected");
		    executeJavascript("$('.product-msg .name-link').get("+i+").scrollIntoView()");
		    hardWait(2);
		    Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.icm-icon-plus').eq("+i+").is(':visible')"), true);
		    executeJavascript("$('.icm-icon-plus').eq("+i+").click()");
		    wait.hardWait(2);
		    msg.log("clicked on Quik Buy link for " + type + " product" );
		    break;
		   }
		  }
		 }


	public void verifyCoach1941TextOnAllProduct(String type) {
		wait.waitForPageToLoadCompletely();
		long length=executeJavascriptReturnsLong("return $('a:contains(\""+type+"\")').length");
		System.out.println("*******************"+length);
		for (int i=0;i<length;i++) { 
			String products=executeJavascriptReturnsString("return $('a:contains(\"COACH 1941\")').eq("+i+").text()");
			Assert.assertTrue(products.contentEquals(type), "Assertion failed : Product type not displayed as expected");

		}
	}

	public void verifyQuickBuyForBackOrderProduct(String type) {
		//Assert.assertTrue(element("text_product_msg_backorder").getText().contentEquals(type),"Assertion failed : Product message not displayed as expected");
		msg.pass("Product message displayed as expected");
		executeJavascript("document.getElementById('add-to-cart').click();");
		msg.log("clicked on Quik Buy link for " + type + " product" );

	}

	public void verifyWishlistIcon() {
		wait.waitForPageToLoadCompletely();
		Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.add-to-wishlist').eq(1).is(':visible')"), true);
		Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.icm-icon-like.add-to-wishlist').eq(1).is(':visible')"), true);
		msg.log("Data message Save It is displayed");
		hardWait(1);
		executeJavascript("document.getElementsByClassName('add-to-wishlist')[0].click();");
		msg.log("User clicks on add to wishlist icon");
		hardWait(2);
		Assert.assertEquals(executeJavascriptReturnsBoolean("return $('.icm-icon-like.add-to-wishlist.selected').eq(1).is(':visible')"), false);
		msg.log("Data message Saved is displayed");



	}

	public void selectAndVerifyProductWithLessThan8ColorSwatches(String productname) {
		wait.hardWait(10);
		wait.waitForPageToLoadCompletely();
		wait.hardWait(5);
		executeJavascript("$('a:contains(\""+productname.toLowerCase()+"\")').get(0).scrollIntoView()");
		isElementNotDisplayed("arrow_left",productname);
		msg.log("For Products with less than 8 products left scroll is not displayed");
		isElementNotDisplayed("arrow_right",productname);
		msg.log("For Products with less than 8 products right scroll is not displayed");
	}

	public void selectAndVerifyProductWithMoreThan8ColorSwatches(String productname) {
		executeJavascript("$('a:contains(\""+productname.toLowerCase()+"\")').get(0).scrollIntoView()");
		isElementDisplayed("arrow_left",productname);
		msg.log("For Products with more than 8 products left scroll is displayed");
		isElementDisplayed("arrow_right",productname);
		msg.log("For Products with more than 8 products right scroll is displayed");
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

	public void verifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel() {
		wait.waitForPageToLoadCompletely();
		String sale_range = executeJavascriptReturnsString("return $('.price-sales.price-range.price-range-sales-price').get(0).textContent");
		msg.log(sale_range + " is the sale range of product");
		msg.log("*****************************************************************");
		
		String sale_price =executeJavascriptReturnsString("return $('.salesprice').get(0).textContent");
		msg.log(sale_price);
		if((sale_price).contains("."));
		msg.log("The number " + sale_price + " has two digits after dot");
		msg.log("*****************************************************************");
		
		String sale_color = element("sale_price").getCssValue("color");
		msg.log(sale_color + " is displayed");
		Assert.assertTrue(sale_color.contains("rgba(204, 0, 0, 1"), "color not red");
		msg.log("*****************************************************************");
		
		String strike_through = element("strikedthrough_price").getCssValue("text-decoration");
		msg.log(strike_through + "is displayed" );
		msg.log("*****************************************************************");
		
		String color = element("strikedthrough_price").getCssValue("color");
		Assert.assertTrue(color.contains("rgba(0, 0, 0"), "color not black");
		msg.log("*****************************************************************");
		
	}

	public void verifyPriceRangeIsInSaleWhenOneColorIsInSale(String productname) {
		wait.waitForPageToLoadCompletely();
		executeJavascript("$('a:contains(\""+productname.toLowerCase()+"\")').get(0).scrollIntoView()");
		isElementDisplayed("master_product");
		element("master_product").click();
		String sale_price =executeJavascriptReturnsString("return $('.salesprice').get(0).textContent");
		msg.log(sale_price);
	}
}


