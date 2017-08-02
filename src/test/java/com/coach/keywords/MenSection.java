package com.coach.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class MenSection extends GetPage {

	public MenSection(WebDriver driver)
	{
		super(driver,"coach/MenSection");
	} 
	public void select_mens_bag(){
		click(element("men_bags"));
		System.out.println("clicked on bag section");
	}
	

}
