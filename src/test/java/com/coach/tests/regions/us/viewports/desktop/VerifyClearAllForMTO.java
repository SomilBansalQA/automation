package com.coach.tests.regions.us.viewports.desktop;

import org.testng.annotations.Test;

import com.coach.tests.CoachTest;

public class VerifyClearAllForMTO extends CoachTest {

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
	public void TestStep04_Select_handle_of_bag() {
		dsl.selectMaterial("HANDLE");
		dsl.selectLeatherType(handleleathertype);
		dsl.selectColor(handlecolor);		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep05_Select_Strap_of_bag() {
		dsl.selectMaterial("STRAP");
		dsl.selectColor(strapcolor);		
	}
	
	@Test(groups = { "desktop", "mobile" })
	public void TestStep06_Change_View_Of_Bag() {
		dsl.clickOnViewInterior();
		dsl.verifyViewIsChangedToInterior();		
	}

	@Test(groups = { "desktop", "mobile" })
	public void TestStep07_Verify_Clear_All() {
		dsl.clickOnClearAll();
		dsl.verifyClearButtonIsClicked();		
	}
	

}
