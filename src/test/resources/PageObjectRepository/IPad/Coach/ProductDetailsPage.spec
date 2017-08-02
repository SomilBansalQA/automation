Page Title: coach

#Object Definitions
====================================================================================
btn_addtobag								  xpath							//button[@id='add-to-cart' and contains(text(),'Add to Bag')]
list_product_colors					          xpath							//div[@class='value color']
list_product_quantity						  xpath							(//select[@name="Quantity"])[1]
button_product_wishlist						  xpath							//a[contains(@class,'wishlist')]
tag_back_to_result_page						  xpath							//a[@class='back-to-results']
link_product_name_indisplay_page			  xpath							(//span[@class="product-name"])[2]
tag_product_description						  xpath							//*[text()='Description']
tag_product_full_description				  xpath							//p[@class='panel-body']
image_icon									  xpath							//img[@id='primaryImage']
button_zoom_product_image				      xpath							//img[@id='primaryImage']
link_add_a_monogram       					  xpath   					    (//a[@class='add-monogram-link'])[1]
link_pick_up_in_store						 	xpath						//a[@class='collapsed']
text_bopus_search								xpath						//section[@class='instorepickup']//input[@id='bopusZipSearch']
btn_bopus_submit								xpath						//section[@class='instorepickup']//button[contains(text(),'Search Zip')]
tabs_list_map									xpath						//ul[@class='nav nav-tabs']
section_item available							xpath						//div[@id='instorepickup-search-result-list']//div[@class='search-text row']
btn_save_and_pick								id						add-to-cart-bopus
link_purchase_giftcard						xpath						//span[contains(text(),'purchase')]/..	
field_giftcard_amount						xpath						//input[@id='dwfrm_giftcard_purchase_amount']
btn_gift_add_to_bag							xpath						//button[@id='giftcard-add-to-cart']
btn_close_popup_wishlist						xpath						//button[@class="icon-coach-close-black"]
label_size									xpath	 	     					//span[@id='variant-size-label']
label_price                                 xpath                       (//span[contains(@class,'price')])[1]
label_back                                  xpath                          //div[@id='backFullScreen']
label_close                                 xpath                               //div[@id='closeFullScreen']
label_details                               xpath                               (//div[contains(@id,'productDetailsAccordion_swatchloaddefault')]//span)[3]
label_reviews                                xpath                               //span[text()='Reviews']
label_color                                  xpath                               (//span[@class='selected-color'])
label_colour_name                           xpath                              //span[@class="color-name"]
label_share_this                             xpath                              //a[@class='socialMedia_button_compact']
label_description                           css                                   .panel-group dl:nth-child(1) span:nth-child(1)
primary_image                               xpath                            //a[@class='product-image main-image image-zoom']/img
swatches_color                              css                                  .selected-color
label_description                           css                                   .panel-group dl:nth-child(1) span:nth-child(1)
list_colors                                 css                                   .color .swatchanchor>img
text_recently_viewed_items                  css                                    #recently-viewed
list_dropdown_quantity                      css                                    [name="Quantity"] option
label_view_full_image                       xpath                            //a[@id='fullPageContent']
