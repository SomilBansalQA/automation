Page Title: coach

#Object Definitions
====================================================================================
shopngpage_hover           css             .icon-coach-gray-arrow-down
checkout_button      	   xpath      		(//button[@name='dwfrm_cart_checkoutCart'])[2]
button_checkout_as_guest   xpath      		//button[@value='CHECKOUT AS GUEST']
link_remove       		   xpath      		(//a[@class='mini-cart-remove' and @title='REMOVE'])[2]
button_top                 xpath       		//div[@id='message']/a
button_view_shopping_bag   xpath      		//li[@id='miniCartContainer']//a[text()="View Shopping Bag"]
btn_item_in_your_bag	   xpath			(//a[@title="View Shopping Bag"]//span[text()='Items in Your Bag'])[2]
add_gift_message           xpath          (//span[contains(text(),'Add a gift message')])[1]
label_promo_code           xpath             //span[contains(@class,'have-promo')]
label_aply_now             xpath             //a[@class='collapsed']
label_subtotal_price       xpath            (//*[@id='cart-items-form']//span[2])[last()]
label_you_may_like         xpath          //h3[contains(@class,'recommendations-heading')]
label_back_to_shopping_bag xpath           //button[@class='btn btn-primary button-text']
label_color                xpath           (//span[@class='color'])[3]
label_style_no             css             .label
label_size                 xpath         (//span[@class='color'])[4]
label_stock                xpath         (//li[@class='is-in-stock'])[2]
product_tile               xpath          (//div[@class='product-tile'])[1]
quickBuy_crossSellers      xpath          (//a[@class='btn btn-default add-to-bag-cham collapsed addToBagCharm'])[1]
label_Your_shopping_Bag    xpath               //span[text()='Your Shopping Bag']
button_checkout_with_paypal      	 	xpath      	(//div[@class='paypal-button']//button[@type="submit"and contains(@class,'textbutton')])[last()]