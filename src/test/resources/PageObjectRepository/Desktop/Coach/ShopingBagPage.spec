Page Title: coach

#Object Definitions
====================================================================================
shopngpage_hover           xpath            //li[@id='miniCartContainer']//i[contains(@class,"arrow-down")]
checkout_button      	   xpath      		//li[@id='miniCartContainer']//a[contains(.,'Checkout')]
button_checkout_as_guest   xpath      		//button[@value='CHECKOUT AS GUEST']
link_remove       		   xpath      		(//a[@class='mini-cart-remove' and @title='REMOVE'])[1]
button_top                 xpath       		//div[@id='message']/a
button_view_shopping_bag   xpath      		//li[@id='miniCartContainer']//a[text()="View Shopping Bag"]
label_Your_shopping_Bag    xpath               //span[text()='Your Shopping Bag']
label_item                 xpath                //span[@class='item-name']
label_description          xpath               //span[@class='item-description']
label_price                xpath               //span[@class='item-price']
label_quantity             xpath              //span[@class='item-quantity']
label_total_Price          xpath              //span[@class='header-total-price']
label_promo_code           xpath             //span[contains(@class,'have-promo')]
label_aply_now             css              li>.collapsed
label_coupon_code_text     id                dwfrm_cart_couponCode
label_apply                id            	  add-coupon
label_subtotal             xpath            //span[contains(@class,'ele subtotal')]
label_subtotal_price       xpath            (//*[@id='cart-items-form']//span[2])[last()]
label_you_may_like         xpath          //h3[contains(@class,'recommendations-heading')]
label_back_to_shopping_bag xpath           //button[@class='btn btn-primary button-text']
label_color                xpath           (//span[@class='color'])[3]
label_style_no             css             .label
label_size                 xpath         (//span[@class='color'])[4]
label_stock                xpath         (//li[@class='is-in-stock'])[2]
product_tile               xpath          (//div[@class='product-tile'])[1]
quickBuy_crossSellers      xpath          (//a[@class='btn btn-default add-to-bag-cham collapsed addToBagCharm'])[1]
text_preoder               css             .item-details .on-order
apply_now                  css             .row.cart-coupon-code>a
havePromoCode              css             .have-promo.gutter-right.gutter-right-ele
coupon_box                 id               dwfrm_cart_couponCode
addCoupon                  id               add-coupon