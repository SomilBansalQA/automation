package com.coach.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.PropFileHandler;

import io.appium.java_client.SwipeElementDirection;

public class WishList extends GetPage {

	public WishList(WebDriver driver) {
		
		super(driver,"coach/WishList");
	}  
	
	public void verifyProductOnWishlistPage(){
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
			scrollWindow(0, 300);
		}
		isElementDisplayed("Link_Product_Name");
		msg.log("Product name is displayed");
	}
	
	public void deleteProductFromWishList(){
		wait.waitForPageToLoadCompletely();
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
			hardWait(2);
		}
		executeJavascript("document.getElementsByClassName('icon-coach-close-grey')[0].click()");
		hardWait(2);
		executeJavascript("document.getElementsByClassName('btn danger')[0].click()");
		wait.waitForPageToLoadCompletely();
		msg.log("Product Is Deleted From WishList Page");
	}

	public void clickOnPublicButton() {
		wait.waitForPageToLoadCompletely();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		waitForLoad();
		isElementDisplayed("button_public_WishList");
		click(element("button_public_WishList"));
		
		
	}


	public void clickOnEmail() {
		wait.waitForPageToLoadCompletely();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		
		waitForLoad();
		isElementDisplayed("button_Email_WishList");
		click(element("button_Email_WishList"));
		
		
	}

	public void verifyEmail() {
		hardWait(3);
		isElementDisplayed("Label_Email_Friend");
		isElementDisplayed("Label_Email_FirstName");
		isElementDisplayed("Label_Email_LastName");
		isElementDisplayed("Label_Email_EmailAddress");
		isElementDisplayed("Label_Email_ConfirmEmail");
		isElementDisplayed("Label_Email_FriendsEmailAddress");
		executeJavascript("document.getElementsByClassName('form-row')[9].getElementsByTagName('span')[0];");
		//isElementDisplayed("Label_Email_Message");
		//isElementDisplayed("Label_Email_FriendsEmailAddress");
		
		}

	
	

	public void enterDetails(String firstname, String lastname,String email) {
		
		sendText(element("Text_Email_FillFirstName"), firstname);
		sendText(element("Text_Email_FillLastName"), lastname);
		sendText(element("Text_Email_FillEmailAddress"), email);
		sendText(element("Text_Email_FillConfirmEmail"), email);
		sendText(element("Text_Email_FillFriendsEmailAddress"), email);
        sendText(element("Text_Email_FillConfirmFriendsEmail"), email);
		executeJavascript("document.getElementsByClassName('input-textarea')[0].innerHTML='hi';");
		//sendText(element("Text_Email_FillMessage"), "hello");
		executeJavascript("document.getElementsByClassName('btn btn-default send-button')[0].click();");
		//click(element("Button_send"));
		}

	public void verifyEmailIsSent() {
		isElementDisplayed("verify_mailsent");
		isElementDisplayed("verify_mailsendtext");
		
		executeJavascript("document.getElementsByClassName('btn btn-default send-to-friend-close')[0].click();");
//		click(element("button_close"));
	}

	public void verifyWishListdisplayed() {
		wait.waitForPageToLoadCompletely();
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		isElementDisplayed("button_friend_whislist");
		
		
	}

	public void clickonwishlist() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		executeJavascript("document.getElementsByClassName('item-head')[2].click()");
		
		click(element("button_wishlist_accountpage"));
		
		
	}

	public void clickOnFindFriendWishList() {
		
		click(element("button_friend_whislist"));
		
	}

	public void verifyFindWishListPageDisplayed() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		isElementDisplayed("Label_Find_Wishlist");
		
	}

	public void enterFriendEmailAndSearch() {
		sendText(element("Text_Email_Friend_WishList"),"testautomation123@qa.com" );
		hardWait(3);
		click(element("Button_Search_FriendWishList"));
		
	}

	public void verifyPrivateListNotDisplayed() {
		isElementDisplayed("Result_After_Search_FriendWishList");
		
	}

	public void clickandVerifyMoveToWishList() {
		wait.waitForPageToLoadCompletely();
		waitForLoad();
		hardWait(1);
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
		hardWait(3);
		executeJavascript("document.getElementsByClassName('logged-in move-to-wishlist')[1].click()");
		msg.log("Clicked on Move to WishList");
		wait.waitForElementToBeVisible(element("popup_whislist"));
		isElementDisplayed("popup_whislist");
		msg.log("Verified Product is removed from Bag and added to Wislist");
		
		}

	public void closeWishListModal() {
		if(ConfigPropertyReader.getProperty("browser").contains("ios"))
		{
			   hardWait(5);
	    }
//		click(element("icon_close_wishlist "));
		hardWait(3);
		isElementDisplayed("Label_BagIs_Empty");
	}

	public void clickOnEmailLink() {
		wait.waitForPageToLoadCompletely();
		//element("Link_SendToFriend").click();
		hardWait(1);
		executeJavascript("document.getElementById('send-to-friend').click();");
		msg.log("User clicks on Email link");
		
	}

	public void verify_First_LastNameLimit_Is_30() {
		waitForLoad();
		msg.log("The maximum character limit for First name is :" +element("textbox_FirstName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_FirstName").getAttribute("maxlength"), Integer.toString(30));
		msg.log("Assertion for FIRST name character limit is passed");
		
		msg.log("The maximum character limit for Last name is :" +element("textbox_LastName").getAttribute("maxlength"));
		Assert.assertEquals(element("textbox_LastName").getAttribute("maxlength"), Integer.toString(30));
		msg.log("Assertion for LAST name character limit is passed");
		
	}

	public void enterEmailAFriendInformation() {
		wait.waitForPageToLoadCompletely();
		long Random = System.currentTimeMillis();
		String firstName = "A"+Random;
		String lastName = "A"+Random;
		String emailAddress = "A"+Random+"@qa.com";
		String friend_emailAddress = "A"+Random+"@qa.com";
		PropFileHandler.writeProperty("firstName", firstName);
		PropFileHandler.writeProperty("lastName", lastName);
		PropFileHandler.writeProperty("emailAddress", emailAddress);
		waitForLoad();
		sendText(element("textbox_FirstName"), firstName);
		sendText(element("textbox_LastName"), lastName);
		sendText(element("Text_Email_FillEmailAddress"), emailAddress);
		sendText(element("Text_Email_FillConfirmEmail"), emailAddress);
		sendText(element("Text_Email_FillFriendsEmailAddress"),friend_emailAddress);
		if((ConfigPropertyReader.getProperty("browser").equals("safari"))||(ConfigPropertyReader.getProperty("browser").startsWith("ios"))){
		executeJavascript("$('#dwfrm_sendtofriend_emailconfirm').get(0).scrollIntoView();");
		}
		scrollDown(element("Text_Email_FillConfirmFriendsEmail"));
		sendText(element("Text_Email_FillConfirmFriendsEmail"),friend_emailAddress);
		hardWait(1);
		executeJavascript("document.getElementById('dwfrm_sendtofriend_message').value='Please ignore this message';");
		//sendText(element("Text_Email_FillMessage"),"Please ignore this message");
		hardWait(1);
		executeJavascript("document.getElementsByClassName('btn btn-default send-button')[0].click();");
		hardWait(1);
		element("close_emailAfriend").click();
		
	}

	public void verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("label_sendToFriendYouAreSigningMsg");
	    if(getElementSize("label_sendToFriendYouAreSigningMsg")==1) {
	    	Assert.assertNotSame(element("label_sendToFriendYouAreSigningMsg").getText(),"Sign me up to receive emails about the latest Coach, Inc. news & styles. Read our privacy policy","msg not found");
			msg.log(element("label_sendToFriendYouAreSigningMsg").getText());
	    }
	    else {
			msg.log(" SIGN ME UP TO RECEIVE EMAILS ABOUT THE LATEST COACH NEWS & STYLES. READ OUR PRIVACY POLICY is not displayed");
	    }
	    element("icon_close_wishlist").click();
		element("span_removeWishlist").click();
		msg.log("User clicks on remove icon");
		element("button_confirm").click();
		msg.log("User clicks on Yes button");
	}

	public void italy_verifyObtinCheckboxMessage() throws InterruptedException {
		waitForLoad();
		scrollToElement("italy_label_sendtoyourfriend");
	    if(getElementSize("italy_label_sendtoyourfriend")==1) {
	    	Assert.assertEquals(element("italy_label_sendtoyourfriend").getText(),"Selezionando la casella, l’utente accetta di ricevere comunicazioni pubblicitarie da Coach, Inc. tramite posta elettronica.");
			msg.log(element("italy_label_sendtoyourfriend").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
	    
	    waitForLoad();
		scrollToElement("italy_label_addtorecommendationlist");
	    if(getElementSize("italy_label_addtorecommendationlist")==1) {
	    	Assert.assertEquals(element("italy_label_addtorecommendationlist").getText(),"Selezionando la casella, l’utente accetta che Coach possa utilizzare i dati personali dell’utente per analizzare le preferenze e/o le tendenze individuali.");
			msg.log(element("italy_label_addtorecommendationlist").getText());
	    }
	    else {
			msg.log("Message was not found");
	    }
	}

	public void removeTheProductFromWishlist() {
		waitForLoad();
		element("delete_product_wishlist").click();
		msg.log("User clicks on remove product from wishlist");
		element("button_danger").click();
		msg.log("user removes the product from wishlist");
		
	}
		
	
}
