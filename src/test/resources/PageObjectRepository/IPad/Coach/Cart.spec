Page Title: coach

#Object Definitions
====================================================================================
button_checkout_with_paypal      	 	xpath      	(//div[@class='paypal-button']//button[@type="submit"and contains(@class,'textbutton')])[last()]
text_box_paypal_email        			xpath      //input[@id="email"]
text_box_paypal_password      	 		xpath      //input[@id="password"]
button_paypal_btnLogin        			xpath      //button[@id="btnLogin"]
button_paypal_confirmbutton       		xpath      //input[@id="confirmButtonTop"]
link_remove_product         			xpath      (//div[@class='item-user-actions']//a[@title="Remove"])[last()]
link_move_to_wish_list        			xpath      //a[@class="move-to-wishlist"]
link_standard_item_price       			xpath      //div[contains(@class,'visible-xs')]//span[@class="price-standard"]
link_product_quantity        			xpath      //select[@name="dwfrm_cart_shipments_i0_items_i0_quantity"]
link_total_price         				xpath      //span[@class="price-total"]
link_product_name         				xpath      //div[@class="name"]/a
link_product_color         				xpath      (//div[contains(@class,'product-info')]/span[@class='color'])[last()]
link_product_color_value       			xpath     ((//div[contains(@class,"va-color")])[2]//span)[2]
link_product_estimated_tax       		xpath      //li[contains(@class,'order-sales-tax')]/span[2]
link_back_to_shop         				xpath      //div[contains(@class,'visible-xs')]//button[contains(@name,'continueShopping')]
link_proceed_to_check_out       		xpath      (//button[@name='dwfrm_cart_checkoutCart'])[2]
product_image          					css       	.item-image img
link_product_quantity_value       		xpath      //select[@name="dwfrm_cart_shipments_i0_items_i0_quantity"]//option[@value="2"]
link_add_a_gift_message        			xpath      //span[contains(text(),"gift message")]
link_buy_now_pick_up_in_store      		xpath      (//a[contains(@href,"bopus") and contains(text(),"PICK UP")])[2]
text_box_bopus_zip_search       		xpath      //input[@id="bopusZipSearch"]
button_find           					xpath      //button[text()="FIND"]
button_save_and_pickup        			xpath      //button[text()="SAVE & PICKUP"]
selected_buy_now_pickup_in_store     	xpath      //div[@class="visible-xs bopus-fl"]//p
button_bopus_close         				xpath     	 //button[contains(@class,'close-bopus-popup')]
button_remove_from_cart        			xpath      //div[contains(@class,'visible-xs')]//div//a[contains(@class,'remove-product')]
tag_cart_empty          				xpath      //div[@class="cart-empty"]
link_add_a_gift_message					xpath		//a[contains(@class,'gift-msg')]//span
text_message          					xpath       //textarea[contains(@class,"msg-text giftMessage")]
tag_error           					xpath       //*[@class="error"]
button_message_save         			xpath      //div[contains(@class,'visible-xs')]/span/button[text()="SAVE"]
button_remove_gift_message       		xpath      (//div[contains(@class,'hidden-xs')]/span/button)[1]
link_priview          					xpath      //p[text()="+Gift Message "]
button_add_gift_message					xpath	   //span[text()="Add gift message"]
button_proceed_to_checkout              xpath      (//button[@name='dwfrm_cart_checkoutCart'])[last()]
text_monogram_msg					    xpath	    //p[text()='Note: Personalized items cannot be returned or exchanged.']