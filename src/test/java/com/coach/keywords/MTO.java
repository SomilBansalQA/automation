package com.coach.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;

public class MTO extends GetPage {

	public MTO(WebDriver driver)
	{
		super(driver,"coach/MTO");
	}


	public void verifyUserOnMTOPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("text_choose_your_bag");
		msg.log("User is on  MTO Page");	
	}

	public void verifyUserOnBagcustomizationPage() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("text_choose_your_material");
		msg.log("User is on  Bag customization Page");	
	}

	public void selectBagSize() {
		click(element("image_bag"));
		msg.log("Bag size is selected");

	}

	public void selectLeatherType(String leatherType) {
		wait.hardWait(3);
		element("radio_leather_type", leatherType).click();
		msg.log("Leather Type Selected :  "  +  leatherType );

	}

	public void selectColor(String color) {
		wait.hardWait(3);
		element("img_color", color).click();
		msg.log("Color Selected :  "  +  color );

	}

	public void selectMaterial(String material) {
		wait.hardWait(3);
		element("tab_material",material).click();
		msg.log("Material selected :  " + material);
		wait.hardWait(3);

	}

	public void selectMetalType(String metal) {
		element("radio_hardware",metal).click();
		msg.log("Hardware selected :  " + metal);


	}

	public void addMonogramToDesignedBag() {
		click(element("radio_monogram"));
		msg.log("Monogram is added to bag");

	}

	public void saveDesignedBag() {
		click(element("radio_save_my_design"));
		msg.log("Designed Bag is Saved");
	}

	public void fillContactDetailsForDesignedBag(String fname,String lname,String email) {
		element("text_fname").sendKeys(fname);
		msg.log("Entered First Name : " +  fname);
		element("text_lname").sendKeys(lname);
		msg.log("Entered Last Name : " +  lname);
		element("text_email").sendKeys(email);
		msg.log("Entered Email : " +  email);		
	}

	public void clickMakeABagButton() {
		click(element("button_make_bag"));
		msg.log("Clicked on make my bag button");

	}

	public void checkDetailsOfBagOnThankYouPage(String bodycolour, String bodyleathertype,String handleleathertype,String handlecolor,String strapcolor,String liningcolor,String metaltype) {
		wait.hardWait(3);
		msg.log(elements("text_bag_content").get(0).getText());
		Assert.assertTrue(elements("text_bag_content").get(0).getText().contains(bodyleathertype), "Assertion failed :Body Leather type is different from the selected one");
		msg.pass("Body Leather type is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(0).getText().contains(bodycolour), "Assertion failed :Body color is different from the selected one");
		msg.pass("Body color is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(1).getText().contains(handleleathertype), "Assertion failed : Handle Leather type is different from the selected one");
		msg.pass(" Handle Leather type is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(1).getText().contains(handlecolor), "Assertion failed :Handle color is different from the selected one");
		msg.pass("Handle color is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(2).getText().contains(strapcolor), "Assertion failed :Strap color is different from the selected one");
		msg.pass("Strap color is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(3).getText().contains(liningcolor), "Assertion failed :Lining color is different from the selected one");
		msg.pass("Lining color is same as the selected one");
		Assert.assertTrue(elements("text_bag_content").get(4).getText().contains(metaltype), "Assertion failed :Metal type is different from the selected one");
		msg.pass("Metal type is same as the selected one");
	}


	public void clickOnClearAll() {
		element("button_clear_all").click();
		msg.log("Clicked on Clear all button");
	}


	public void verifyClearButtonIsClicked() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("text_body");
		msg.log("User is redirected to body tab");
	}


	public void clickOnViewInterior() {
		click(element("link_view_interior"));
		msg.log("Clicked on link View Interior");	
	}


	public void verifyViewIsChangedToInterior() {
		Assert.assertTrue(element("img_interior").getAttribute("data-show").equalsIgnoreCase("360"), "Assertion Failed : User is not able to view interior of the bag");
		msg.pass("User is able to view interior of the bag");
	}


	public void clickOnChangeBagSize() {
		click(element("link_change_bag_size"));
		msg.log("Clicked on change bag size");
		click(element("button_conform_bag_change"));
		msg.log("Clicked on Continue for bag size change");
	} 




}

