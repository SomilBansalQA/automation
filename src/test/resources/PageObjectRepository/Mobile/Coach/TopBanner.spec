Page Title: coach

#Object Definitions
====================================================================================
page_heading                                  xpath                                  //a[@title='COACH']/span
login_register_button                         xpath                                  //span[contains(text(),'Sign In/Register')]
button_sign_out								  xpath									(//li[contains(@class,'account-login')]//span[contains(text(),'Account')])[1]
linkText_Signout							  xpath                                 //a[@title='Sign Out']
linkText_TopBanner         					  xpath                                 //a[contains(@class,"top-utility-nav-msg shipping_") and contains(text(),"ENJOY FREE SHIPPING AND RETURNS")]
navigation_bar_TopBanner     				  xpath         //div[@class="container-fluid"]/div/div[contains(@class,"navbar navbar")]
linkText_AccountSettings   					  xpath 		//a[text()="Account Settings " and @title="Account Settings"]
linkText_OrderHistory						  xpath    		//a[text()="Order History" and @title="Order History"]
linkText_WishList							  xpath			//a[@title="Wishlist"]
section_header								  xpath			//header[@class="header-top"]
linkText_wishlist							  xpath			//a[text()="Wishlist "]
icon_cross_cookie							  xpath 		//a[@class='icon-cookie-close']
btn_Go_To_Wishlist							  xpath			//a[text()="GO TO WISHLIST"]
label_your_wishlist                           xpath         //a[@class='text-center box icon-coach-wishlist']

======================================================================
@objects
-------------------------------
navigation_bar_TopBanner
      inside: section_header 0px top 