Page Title: coach

#Object Definitions
====================================================================================
text_giftCard                         xpath                     (//div[@class='gift-services-link inline-for-now'])[1]
amount_giftCard                       id                         dwfrm_giftcard_purchase_amount
error_giftCard_Message                css                        .balance .error
field_giftcard_amount						xpath						    //input[@id='dwfrm_giftcard_purchase_amount']
btn_gift_add_to_bag							xpath						    //button[@id='giftcard-add-to-cart']
link_purchase_giftcard						xpath					       (//div[contains(@class,"gift-services-link")])[1]//a
link_check_your_giftCard_balance            id 							gift-card-balance
set_gift_card_Number						id							dwfrm_giftcard_inquireBalance_giftcardcode
set_gift_card_pin_Number					id							dwfrm_giftcard_inquireBalance_giftcardpin
btn_submit									xpath							.//button[contains(text(), 'Submit')]
