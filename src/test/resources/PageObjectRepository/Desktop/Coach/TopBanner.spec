Page Title: coach

#Object Definitions
====================================================================================
page_heading                                  xpath                                  //a[@title='COACH']/span
login_register_button                         xpath                                  //li[@id='account-dropdown']
button_sign_out								  xpath									(//span[contains(text(),'Account')])[1]
linkText_Signout							  xpath                                 //a[@title='Sign Out']
linkText_TopBanner         					  xpath                                 //a[contains(@class,"top-utility-nav-msg shipping_") and contains(text(),"ENJOY FREE SHIPPING AND RETURNS")]
navigation_bar_TopBanner     				  xpath                                  //header[@id="header-v2" ]
linkText_AccountSettings   					  xpath 		                        //a[text()="Account Settings " and @title="Account Settings"]
linkText_OrderHistory						  xpath    		                       //a[text()="Order History" and @title="Order History"]
linkText_WishList							  xpath			                       //a[text()="Wishlist " and @title="Wishlist"]
section_header								  xpath			                      //header[@class="header-top"]
linkText_wishlist							  xpath			                      //a[text()="Wishlist "]
icon_cross_cookie							  xpath 		                       //a[@class='icon-cookie-close']
btn_Go_To_Wishlist							  xpath			                       //a[text()="GO TO WISHLIST"]
label_your_wishlist                           xpath                                (//ol[@class='breadcrumb']//li)[2]
box_mini_order_summary                        css                                  .mini-cart-items
box_promo_code                                css                                  #dwfrm_cart_couponCode
box_product_details                           css                                   .checkout-order-totals
button_country                                xpath                                 (//button[@class='btn dropdown-toggle selectpicker btn-default'])[1]
zip                                           css                                   #dwfrm_singleshipping_shippingAddress_addressFields_zip
======================================================================
@objects
-------------------------------
navigation_bar_TopBanner
      inside: section_header 0px top 
      

@objects1
box_promo_code
      below: box_product_details 
      above: box_mini_order_summary

@objects1      
button_country
      near: zip 5 to 30px left 