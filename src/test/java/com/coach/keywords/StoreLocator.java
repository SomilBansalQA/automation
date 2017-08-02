package com.coach.keywords;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class StoreLocator extends GetPage {

	WebDriver driver;
	public StoreLocator(WebDriver driver)
	{
		super(driver,"coach/Stores");
		this.driver = driver;
	} 

	public void verifyStoreLocatorPage(){
		//verifyPageTitleContains();
		boolean sorted = true;   
		handle_DontMissOutWindow();
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("text_country_selected");
		msg.log("Number of stores are displayed");
		isElementDisplayed("dropdown_radius_selection");
		msg.log("Radius drop down is displayed");
		click(element("dropdown_radius_selection"));
		msg.log("Number Of radius values: " + elements("list_radius_slection").size());
		for(WebElement a :elements("list_radius_slection"))	
		{   
			msg.log("Radius Values : " + a.getText());
		}
		Assert.assertTrue("20".contains(element("text_radius_default_value").getText()),"[Assertion Failed]:Default value of radius is not 20");
		msg.log("Default value of radius is  20");
		Assert.assertTrue(elements("list_store_category").get(0).getText().contains("Coach Flagship Store"),"[Assertion Failed] Category: Coach Flagship Store is  not dispalyed");
		msg.log("Category: Coach Flagship Store is dispalyed");
		Assert.assertTrue(elements("list_store_category").get(1).getText().contains("Coach Retail Stores"),"[Assertion Failed] Category: Coach Retail Stores is  not dispalyed");
		msg.log("Category: Coach Retail Stores is dispalyed");
		Assert.assertTrue(elements("list_store_category").get(2).getText().contains("Coach Outlet Stores"),"[Assertion Failed] Category: Coach Outlet Stores is  not dispalyed");
		msg.log("Category: Coach Outlet Stores is dispalyed");
		Assert.assertTrue(elements("list_store_category").get(3).getText().contains("Coach Department & Specialty Stores"),"[Assertion Failed] Category: Coach Department & Specialty Stores is  not dispalyed");
		msg.log("Category: Coach Department & Specialty Stores is dispalyed");
		Assert.assertTrue(elements("list_store_category").get(4).getText().contains("Women's Footwear"),"[Assertion Failed] Category: Women's Footwear is  not dispalyed");
		msg.log("Category: Women's Footwear is dispalyed");
		Assert.assertTrue(elements("list_store_category").get(5).getText().contains("Monogramming"),"[Assertion Failed] Category: Monogramming is  not dispalyed");
		msg.log("Category: Monogramming is dispalyed");

	}





	public boolean verifyStoreLocatorTitle(){
		return getCurrentURL().contains("store");
	}

	public void searchStoreUsingZipCode(String zipcode) {
		hardWait(1);
		executeJavascript("$('.icon-coach-close-black').click()");
		//handle_DontMissOutWindow();
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element("tab_location"));
		isElementDisplayed("tab_location");
		isElementDisplayed("iconCoach");
		element("textBox_Postal_Code").clear();
		element("textBox_Postal_Code").sendKeys(zipcode);
		msg.log(zipcode);
		hardWait(1);
		executeJavascript("$('.btn-primary.btn.btn-default').click()");
		
	}

	public void clickOnFirstStoreStaricon() {

		waitForLoad();
		click(element("icon_Set_Favourite_Store"));		
	}

	public void assertLabelFavoriteStore() {
		waitForLoad();
		isElementDisplayed("label_Favourite_Store");
	}

	public void clickOnViewMap() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("link_View_Map");
		click(element("link_View_Map"));
		msg.log("Clicked On View Map Link");

	}

	public void verifyUserClickedOnViewMap() {
		isElementDisplayed("popup_google_map");
		msg.log("Google Map for store locator is dispalyed");

	}

	public void clickOnCloseButtonForGoogleMap() {
		click(element("button_close_google_map"));
		msg.log("Clicked on close Button for store locator google Map");

	}

	public void verifyUserClosedViewMap() {
		wait.waitForPageToLoadCompletely();
		isElementNotDisplayed("popup_google_map");
		msg.log("Verified Google Map is closed");

	}

	public void verifyAddressAndTelephoneOnstorePage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("text_address");
		msg.log("Address of the store is displayed");
		isElementDisplayed("text_phoneno");
		msg.log("Phone Number of the store is displayed");
		isElementDisplayed("link_directions");
		msg.log("Directions Link of the store is displayed");

	}

	public void clickOnInternationalTab() {
		wait.waitForPageToLoadCompletely();
		handle_DontMissOutWindow();
		isElementDisplayed("tab_international");
		msg.log("International Tab is displayed");
		hardWait(2);
		executeJavascript("document.getElementsByClassName('international-tab')[0].click();");
		msg.log("Clicked on international tab");
	}

	public void verifyUserClickedOnInternationalTab() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("button_searchcountry");
		msg.log("User clicked on International Tab");
	}

	public void selectCountryAndSearchStore(String country) {
		executeJavascript("$('.btn.dropdown-toggle.selectpicker.btn-default').eq(2).click()");
		executeJavascript("$('.dropdown-menu.open span:contains(\""+country+"\")').click()");
		msg.log("User selected " + country + " for searching store");

     	hardWait(5);
		click(element("button_searchcountry"));
		msg.log("User clicked on search country button");
	}

	public void verifyCountryIsSelected(String country) {
		wait.waitForPageToLoadCompletely();
		int results =Integer.parseInt(element("text_country_selected").getText());
		assertTrue(element("text_store_locator").isDisplayed());
		msg.log("Store search for international site is working correctly" );
			
	}

	public void verifyStoresDistanceDispalyedInAscendingOrder() {
		ArrayList<Float> distanceint = new ArrayList<Float>();
		Boolean sorted = true;
		for(WebElement a :  elements("list_distance"))
		{
			String [] distance =a.getText().split(" ");
			Float input2 = Float.parseFloat(distance[0]);
			distanceint.add(input2);
		}

		for (int i = 1; i < distanceint.size(); i++) {
			int i1 =  Float.compare(distanceint.get(i-1), distanceint.get(i));
			if(i1>0)
			{   
				sorted = false;
				break;
			}
		}
		Assert.assertTrue(sorted, "[Assertion failed] :  Search results are  not Sorted according to increasing order of distance from the center of the zip code area.");
		msg.log("Search results are Sorted according to increasing order of distance from the center of the zip code area.");

	}

	public void cLickOnDirectionsLink() {
		element("link_direction").click();
		msg.log("Clicked On Direction Link");		
	}

	public void EnterWrongAdressForError(String address, String City, String State, String PostalCode) {
		element("textbox_address").sendKeys(address);
		msg.log("User Enter "+ address+ " for Searching direction");
		element("textbox_city").sendKeys(City);
		msg.log("User Enter "+ City+ " for Searching direction");
		hardWait(2);
		selectOptionFromDropDownList("dropdown_select_state", State);
		msg.log("User selected " + State + " for searching direction");
		element("textbox_postal_code").sendKeys(PostalCode);
		msg.log("User Enter "+ PostalCode+ "for Searching direction");
		element("button_get_direction").click();
		isElementDisplayed("text_verifyLocationAddress");
		msg.log("DATA NOT FOUND displayed");
	}

	public void verifyMobileStorePage() {
		waitForLoad();
		verifyPageTitleContains();
	}

	public void clickOnRedoSearch() {
		click(element("button_redoSearch"));
		msg.log("Clicked on redo search");	
		hardWait(2);
	}

}
