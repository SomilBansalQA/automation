package com.coach.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

public class Search extends GetPage {

	public Search(WebDriver driver) {
		super(driver, "coach/Search");
	}

	public void enterProductIntoSearchBox(String productCategoryOrName) {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		hardWait(1);
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		executeJavascript("document.getElementsByClassName('headerv2-search')[1].click()");
		hardWait(1);
		//click(element("textbox_Search"));
		//click(element("textbox_Search"));
		sendText(element("textbox_Search"), productCategoryOrName);
		hardWait(3);
		logMessage("[INFO] User entered product in search Box");
	
	}

	public void clickOnSearchBox() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		//pressEnter();
		click(element("icon_Search"));
		logMessage("[INFO] User clicked on search icon");
		
	}

	public void verifySearchDisplayed() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		executeJavascript("document.getElementsByClassName('headerv2-search')[1].click()");
		hardWait(3);
		isElementDisplayed("textbox_Search");
		isElementDisplayed("icon_Search");
	}

	public void verifySearchText() {
		
		executeJavascript("document.getElementsByClassName('top-level women')[0].getElementsByTagName('a')[0].click()");
		wait.waitForPageToLoadCompletely();
		String Search= element("text_Search").getText().toUpperCase();
		Assert.assertTrue(Search.equals("SEARCH"));
		
		
	}

	public void verifySuggestionAppearAfterEntering3Letters() {
		hardWait(1);
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		executeJavascript("document.getElementsByClassName('headerv2-search')[1].click()");
		hardWait(3);
		wait.waitForElementToBeVisible(element("textbox_Search"));
		element("textbox_Search").sendKeys("S");
		hardWait(1);
		element("textbox_Search").sendKeys("H");
		hardWait(1);
		element("textbox_Search").sendKeys("O");
		hardWait(1);
		element("textbox_Search").sendKeys("E");
		hardWait(2);
		isElementDisplayed("sroll_suggestion");
		
		}

	public void verifySearchNotDisplayed() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		isElementNotDisplayed("text_Search");
		
	}

	public void verifyPLPPageIsDisplayed(String term) {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		//isElementDisplayed("label_Filter_By");
		isElementDisplayed("label_Sort_By");
		isElementDisplayed("label_Term");
		//isElementDisplayed("label_women");
		//isElementDisplayed("label_bags");
		//isElementDisplayed("label_color");
		
		//isElementDisplayed("label_crossbody_bags");
}

	public void noSearchResultPage() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		isElementDisplayed("label_0_resultFor");
		isElementDisplayed("label_New_For_Her");
		isElementDisplayed("label_New_For_Him");
	}

	public void clickOnWishListFromHeader() {
		hardWait(1);
		executeJavascript("document.getElementsByClassName('icm-icon-like')[0].click()");
		logMessage("Clicked On Heart Icon");

	}

	public void navigateToAccountPageFromWishListPage() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		if (ConfigPropertyReader.getProperty("browser").contains("ios")) {
			hardWait(5);
		}

		executeJavascript("document.getElementById('list-signin').click()");
		logMessage("Navigate To Account Page From WishListPage");

	}

	public void verifyIfProductIsAvailable(String product) {
		int i;
		String[] NumberOfProducts = product.split(",");
		Boolean Flag = null;

			for (i = 0; i < NumberOfProducts.length; i++) {

				System.out.println("[INFO] Entered product is : " + NumberOfProducts[i]);
				enterProductIntoSearchBox(NumberOfProducts[i]);
				clickOnSearchBox();
				handle_DontMissOutWindow();
				Flag = checkIfProductIsAvailable(NumberOfProducts[i]);
				if (Flag == true) {
					break;
				} else {
					continue;
				}
			}

			if (Flag == false) {
				logMessage("[INFO] Products are not available");
			}
		}


	private Boolean checkIfProductIsAvailable(String p1) {
//		Boolean Flag = false;
		wait.waitForPageToLoadCompletely();
		waitForLoad();

		System.out.println("[INFO] Current URL is : "+getPageTitle());
		if (getPageTitle().contains("No Search Result")||getPageTitle().contains("Keine Suchergebnisse")||getPageTitle().contains("Aucun résultat pour la recherche")||getPageTitle().contains("Nessun risultato di ricerca")||getPageTitle().contains("No hay resultados de la búsqueda")){
			System.out.println("[INFO] 0 search results");
			return false;
		} else {
			System.out.println("[INFO] Result found for product");
			return true;
		}
		
//		if (checkIfElementIsThere("label_0_resultFor")) {
//			System.out.println("0 search results");
//			return Flag;
//		} else {
//			System.out.println("Result found for product");
//			Flag = true;
//			return Flag;
//		}
	}
}
