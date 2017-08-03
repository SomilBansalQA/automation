package com.coach.keywords;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class GiftCard extends GetPage {
	
	WebDriver driver;
	 String EXCEL_FILE_LOCATION = "C:\\Users\\somilbansal\\Desktop\\Coach_Gift_Card_Balance_Details_at_particular_time.xls";
    WritableWorkbook myFirstWbook = null;
    static int index=0;
    
	public GiftCard(WebDriver driver)
	{
		super(driver,"coach/GiftCard");
		this.driver = driver;
	}
	public void clickOnPurchaseAGiftCard() {
		waitForLoad();
		executeJavascript("sessionStorage.setItem('pagevisit',4);");
		driver.manage().deleteAllCookies();
		Cookie ck = new Cookie("emailoverlay", "value");
		driver.manage().addCookie(ck);
		
		Cookie ck2 = new Cookie("fsr.s", "{'v2':2,'v1':1,'rid':'d0367025370225726458fd6921ea','to':3,'c':'http://dwdevelopment.coach.com/','pv':1,'lc':{'d0':{'v':1,'s':true}},'cd':0,'sd':0,'l':'en','i':0}");
		driver.manage().addCookie(ck2);
		
		Cookie ck1 = new Cookie("fsr.r", "{'d':90,'i':'1292956831475_954940','e':1293563385893,'s':1}");
		driver.manage().addCookie(ck1);
		handle_DontMissOutWindow();
		isElementDisplayed("text_giftCard");
		msg.log("Purchase a Gift Card is displayed");
		hardWait(1);
		scrollDown(element("text_giftCard"));
		executeJavascript("$('.gift-services-link.inline-for-now a')[0].click()");
		msg.log("User clicks on Purchase A gift Card");
	}
	public void enterGiftCardAmount() {
		waitForLoad();
		isElementDisplayed("amount_giftCard");
		msg.log("User enters gift card amount");
		sendText(element("amount_giftCard"), "30");
	}
	public void addTheGiftCardToBag() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();		
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		executeJavascript("document.getElementById('giftcard-add-to-cart').click()");
		hardWait(1);
		msg.log("Clicked on Add to bag");
		
	}
	public void verifyGifCardErrorMessage() {
		waitForLoad();
		isElementDisplayed("error_giftCard_Message");
		msg.log(element("error_giftCard_Message").getText());
		
	}

	public void purchaseGiftCard() {
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		handle_DontMissOutWindow();
		scrollDown(element("link_purchase_giftcard"));
		click(element("link_purchase_giftcard"));
		msg.log("Clicked on purchase g	ift cards");
		hardWait(3);
		sendText(element("field_giftcard_amount"), "100");
		click(element("btn_gift_add_to_bag"));
		msg.log("Clicked on button gift add to bag");
	}
	public String getText(By loc) {
        hardWait(1);
		String cardText = driver.findElement(loc).getText();
		return cardText;
	}

	
	public WritableSheet createExcelSheet(){
		WritableSheet excelSheet = null;
		Label label=null;
        try {
            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
           excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
           excelSheet.setColumnView(0,50);
           excelSheet.setColumnView(1,25);
           excelSheet.setColumnView(2,10);
           excelSheet.setColumnView(3,100);
           label = new Label(0, 0, "Coach_Gift_Card_Balance_Details");
           excelSheet.addCell(label);
          
           label = new Label(0, 1, "Time");
           excelSheet.addCell(label); 
           label = new Label(1, 1, "gift_card_number");
           excelSheet.addCell(label);
           label = new Label(2, 1, "pin_number");
           excelSheet.addCell(label);
           label = new Label(3, 1, "gift_card_balance");
           excelSheet.addCell(label);

           myFirstWbook.write();    
	  } catch (IOException e) {
          e.printStackTrace();
      } catch (WriteException e) {
          e.printStackTrace();
      }finally {

	        if (myFirstWbook != null) {
	            try {
	                myFirstWbook.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (WriteException e) {
	                e.printStackTrace();
	            }
	        }
	        
	    }
        return excelSheet;
	}
	  
	
	public WritableSheet modifyingExcelSheet(String giftcardNumber,String pinNumber,String gift_card_balance){
		WritableSheet excelSheet = null;
		  
			 
		      try {
		    	  Workbook workbook1 = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
				myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION), workbook1);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
			
				e.printStackTrace();
			}
		      excelSheet = myFirstWbook.getSheet(0);
		 
		      
		      index=excelSheet.getRows();
		      try{		
					
			    	Label label;
			    	label = new Label(0,index, String.valueOf(new Date()));
			        excelSheet.addCell(label);
			        label = new Label(1, index, giftcardNumber);
			        excelSheet.addCell(label);
			        label = new Label(2, index, pinNumber);
			        excelSheet.addCell(label);
			        label = new Label(3, index, gift_card_balance);
			        excelSheet.addCell(label);
			        
			        myFirstWbook.write();
			        index++;
			   } catch (IOException e) {
			       e.printStackTrace();
			   } catch (WriteException e) {
			       e.printStackTrace();
			   } 
			    finally {

			        if (myFirstWbook != null) {
			            try {
			                myFirstWbook.close();
			            } catch (IOException e) {
			                e.printStackTrace();
			            } catch (WriteException e) {
			                e.printStackTrace();
			            }
			        }
			        
			    }
			
				
        return excelSheet;
	}
	
	
	
	

   public void CheckYourBalance(String giftcardNumber,String pinNumber){
     
	   wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(3);
		}
		
		handle_DontMissOutWindow();
		//wait.waitForElementToBeClickable(element("link_check_your_giftCard_balance"));
		//scrollDown(element("link_check_your_giftCard_balance"));
		//click(element("link_check_your_giftCard_balance"));
	   	executeJavascript("$('#gift-card-balance').click();");
		msg.log("Clicked on Check your Balance");
		hardWait(3);
    	msg.log("Card Number:"+giftcardNumber+"   Pin Number:"+pinNumber);
		sendText(element("set_gift_card_Number"), giftcardNumber );
		sendText(element("set_gift_card_pin_Number"), pinNumber);
		click(element("btn_submit"));
		msg.log("Clicked on submit button");
		String gift_card_balance=getText(By.xpath(".//div[@class='row balance-row']/span"));
		msg.log(gift_card_balance);
		
		WritableSheet excelSheet;
			if(!new File(EXCEL_FILE_LOCATION).exists()){
		excelSheet=createExcelSheet();	
		}
		else{excelSheet=modifyingExcelSheet(giftcardNumber,pinNumber,gift_card_balance);
		}         

		executeJavascript("document.querySelector('button[class=\"icon-coach-close-black\"]').click()");
		hardWait(3);
	  }
   
   
}
