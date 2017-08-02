package com.coach.tests.regions.us.viewports.desktop;

import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class DesignBagMTO extends CoachTest {

	String firstname,lastname,email;
	String bodycolour="Corn Flower";
	String bodyleathertype="Glovetanned Pebble Leather";
	String handleleathertype="Crocodile";
	String handlecolor ="Oxblood";
	String strapcolor="Black";
	String liningcolor="Burgundy";
	String metaltype="Black Copper";

	@Test(groups = { "desktop", "mobile" })
	public void TestStep01_Launch_Application_URL() {
		dsl.launchApplication("http://onlinemto.coach.com");
		dsl.verifyUserOnMTOPage();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep02_Select_bag_Size() {
		dsl.selectBagSize();
		dsl.verifyUserOnBagcustomizationPage();
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Select_body_of_bag() {
		dsl.selectLeatherType(bodyleathertype);
		dsl.selectColor(bodycolour);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep03_Select_handle_of_bag() {
		dsl.selectMaterial("HANDLE");
		dsl.selectLeatherType(handleleathertype);
		dsl.selectColor(handlecolor);		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep04_Select_Strap_of_bag() {
		dsl.selectMaterial("STRAP");
		dsl.selectColor(strapcolor);		
	}


	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Select_Lining_of_bag() {
		dsl.selectMaterial("LINING");
		dsl.selectColor(liningcolor);		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Select_Hardware_of_bag() {
		dsl.selectMaterial("HARDWARE");
		dsl.selectMetalType("Black Copper");		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Add_Monogram_To_Bag() {
		dsl.selectMaterial("Monogram");
		dsl.addMonogramToDesignedBag();		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep08_Save_Designed_Bag() {
		dsl.saveDesignedBag();
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep09_Check_Details_Of_Bag_on_Thank_you_Page()
	{
		dsl.checkDetailsOfBagOnThankYouPage(bodycolour,bodyleathertype,handleleathertype,handlecolor,strapcolor,liningcolor,metaltype);
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep10_Fill_Contact_Details() {
		dsl.fillContactDetailsForDesignedBag("qa","test","qatest@qa.com") ;
		dsl.clickMakeABagButton();
	}
}
