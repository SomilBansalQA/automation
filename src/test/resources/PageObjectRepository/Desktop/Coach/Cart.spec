Page Title: coach

#Object Definitions
====================================================================================
button_checkout_with_paypal							xpath					    (//div[@class='paypal-button']//button[@type="submit"and contains(@class,'textbutton')])[last()]
text_box_paypal_email								xpath						//input[@id="email"]
text_box_paypal_password							xpath						//input[@id="password"]
button_paypal_btnLogin								xpath						//button[@id="btnLogin"]
button_paypal_confirmbutton							xpath						//input[@id="confirmButtonTop"]
link_remove_product									xpath						(//div[@class='item-user-actions']//a[@title="Remove"])[last()]
link_move_to_wish_list								xpath						//a[@class="move-to-wishlist"]
link_standard_item_price							css						    .item-price.hidden-xs .price-standard
link_product_quantity								xpath						//button[contains(@class,'dropdown-toggle')]
link_total_price									xpath						//span[@class="price-total"]
link_product_name									xpath						//div[@class="name"]/a
link_product_color									xpath						(//div[contains(@class,'product-info')]/span[@class='color'])[last()]
link_product_color_value							xpath					     ((//div[contains(@class,"va-color")])[2]//span)[2]
link_product_estimated_tax							xpath						//li[contains(@class,'order-sales-tax')]/span[2]
link_back_to_shop									xpath						//div[contains(@class,'hidden-xs')]//button[contains(@name,'continueShopping')]
link_proceed_to_check_out							css						    .stickymobile-bottom-container.US .proceed-to-checkout
product_image										css							.item-image img
link_product_quantity_value							xpath						//span[@class="text" and text()="2"]
link_add_a_gift_message								xpath						//span[contains(text(),"gift message")]
link_buy_now_pick_up_in_store						xpath						//div[contains(@class,'hidden-xs')]//a[text()="BUY NOW, PICK UP IN STORE"]
text_box_bopus_zip_search							xpath						//input[@id="bopusZipSearch"]
button_find											xpath						//button[text()="FIND"]
button_save_and_pickup								xpath						//button[text()="SAVE & PICKUP"]
selected_buy_now_pickup_in_store					xpath						//div[@class="hidden-xs bopus-fl"]//p
button_bopus_close									xpath						//button[contains(@class,'close-bopus-popup')]
button_remove_from_cart								xpath						//div[contains(@class,'hidden-xs')]//div//a[contains(@class,'remove-product')]
tag_cart_empty										xpath						//div[@class="cart-empty"]
link_add_a_gift_message								xpath						//a[contains(@class,'gift-msg')]//span
text_message										id						     giftMessage1
tag_error											xpath						//*[@class="error"]
button_message_save									xpath						(//div[contains(@class,'hidden-xs')]/span/button)[2]
button_remove_gift_message							xpath						(//div[contains(@class,'hidden-xs')]/span/button)[1]
link_priview										css						    .hasimgpreview-hover.symbol>span
button_add_gift_message								xpath						//span[text()="Add gift message"]
button_proceed_to_checkout                          xpath                          (//button[@name='dwfrm_cart_checkoutCart'])[last()]
promocode                                           xpath                       //a[@data-parent='cart-coupon-code']
textbox_promocode                                   id                          #dwfrm_cart_couponCode
complimentary_checkbox                              css                         #compGiftBox_1
giftMessage                                         xpath                       (//a[@class='gift-msg collapsed'])[2]
text_message2                                       xpath                        //textarea[contains(@class,'giftMessage') and contains(@name,'giftMessage2')]
preOrderMessage                                     xpath                        (//li[@class='on-order'and contains(text(),'Pre-Order')])[2]
backorderMessage                                    xpath                        (//li[@class='on-order'and contains(text(),'Backorder')])[2]
chckbox_complimenatry_gift_box                      css                         .checkbox-group span