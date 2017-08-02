coach

#Object Definitions
====================================================================================
cardno_text            				xpath						//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_number')]	
textbox_SecurityCode                xpath                       //input[contains(@id,'password_dwfrm_billing_paymentMethods_creditCard_cvn')]
textbox_ConfirmEmail				xpath      					//input[@id='dwfrm_billing_billingAddress_email_emailconfirm']
btn_ConfirmContinue                 xpath                       //button[@id='billingSubmitButton']
btn_PlaceOrder                      xpath                       (//button[contains(text(),'Place Order') and @class='btn btn-default place-order-btn'])[1]
card_exp_month_button				xpath						//button[@data-id='dwfrm_billing_paymentMethods_creditCard_month']
month_may_text						xpath						//a[@class='select-option']/span[contains(text(),'05')]
card_exp_year_button                xpath						//button[contains(@data-id,'dwfrm_billing_paymentMethods_creditCard_year')]
year_2017_text						xpath						//span[contains(text(),'2017')]
checkbox_shipng_adress              xpath						//input[@id='dwfrm_billing_billingAddress_sameAsShippingAddress']
checkbox_sign_me_up					xpath						//input[@id='dwfrm_billing_billingAddress_addToEmailList']
coach_gift_card						id   						dwfrm_billing_giftCardCode
coach_gift_card_pin					id  						dwfrm_billing_giftCardPin
button_apply_gift					id						    applyGiftCard	
radio_button_pay_pal				id  						is-PayPal
text_email_paypal    				id  					    dwfrm_billing_billingAddress_email_emailAddress
button_paypal_submit				id  						btnLogin
button_paypal_confirm				xpath						//input[@id='confirmButtonTop']
textbox_Email     					 css     				    #dwfrm_billing_billingAddress_email_emailAddress
icon_credit_card_type 				xpath 						//span[contains(@class,"card-type-icon")]
button_paypal_continue   			 xpath   				   //input[@id="confirmButtonTop"]
text_password_paypal    			xpath   				   //input[@id="password"]
textbox_email_paypal 				xpath						//input[@id="email"]
icon_spinner						css							#spinner p[id="spinner-message"]
checkbox_save_card					xpath						(//div[@class='custom-checkbox']/span)[2]
paypal_error_message				xpath						//div[@id="pageLevelErrors"]//span
month_may_text_uk					xpath						//a[@class='select-option']/span[contains(text(),'May')]
input_Continue_PayPal				id							PMMakePayment
textbox_password					id							dwfrm_billing_billingAddress_passwordfields_password
textbox_ConfirmPassword				id							dwfrm_billing_billingAddress_passwordfields_passwordconfirm
gift_card_value                     xpath                       //span[contains(text(),"-$25.00")]
error_gift_msg                      xpath                      //span[@class='error' and text()='An unexpected problem occurred. Please call 1-888-262-6224 to place your order. ']
coach_gift_card_title               xpath                       //a[contains(text(),'GIFT CARD')]
strong_name                         css                          .strong
create_acc_msg                      css                          .create-account-msg
tool_tip                            xpath                        //span[@class='tooltip tool-tip-tablet-postion euposition-tool-tip-tablet-postion']
img_tool_tip                        xpath                        .//span[@class='tooltip-content']/p/img[contains(@src,'credit_card_code')]
input_saveThisCC                    xpath                        //input[@id='dwfrm_billing_paymentMethods_creditCard_saveCard']
h3_billing                          xpath                        //h3[@class='heading inline-billingheading']
billing_statement                   xpath                        (//div[@class='custom-checkbox']/following-sibling::label)[1]
signup_statement                    xpath                         //label[@for='dwfrm_billing_billingAddress_addToEmailList']
italy_label_billingAddress          xpath                         //label[@for='dwfrm_billing_billingAddress_addToEmailSignuplist']
italy_label_addToRecommendationlist xpath                         //label[@for='dwfrm_billing_billingAddress_addToRecommendationlist']
address                             xpath                         //div[@class='row address-detail']
year                                xpath                         (//button[@class='btn dropdown-toggle selectpicker btn-default'])[2]
link_cancel_paypal                  css                           #cancelLink
form_payment                       css                           .checkout-billing-form 
text_error_paypal                   css                           #pageLevelErrors
shipping                            css                            .shipping-to-label
language                            css                             .locale.selected
text_paypal_shipping_address		xpath						//div[@ng-if = "showShippingAddress"]
sofort                              xpath                         (//span[@class='payment-label'])[3]
sofort_continue                     xpath                          //div[@id='jsEnabled']/a/img[contains(@src,'makepayment.gif')]
addAnotherCard                      css                             #add-another-gift-card
cvv_errorMessage                    xpath                          //span[@class='error-message']
text_gift_card                      css                           .order-total .giftcert-pi
text_total_order                   xpath                          (//li[contains(@class,'order-total')]/span)[2]
text_balance_due                   css                             #order-total span:nth-child(2)
textbox_password                   css                             #dwfrm_billing_billingAddress_passwordfields_password
textbox_confirmpassword            css                             #dwfrm_billing_billingAddress_passwordfields_passwordconfirm
error_paypallogin                  css                             #pageLevelErrors
text_new_zipcode                   css                             .updated-checkout-address>p:nth-child(3)
shipping_address                   css                             .shipping-address-info
continue            			   xpath						(//button[@type='submit'])[2]
link_giftcard_order                css                           .gift-card-balance
updated_address                    xpath                          //address[@class='updated-checkout-address']/p
updated_address2                   xpath                          (//address[@class='updated-checkout-address']/p)[${size}]
address_dropdown                   css                             .btn.dropdown-toggle.selectpicker.btn-default
list_address                       xpath                             //select [@id="dwfrm_singleshipping_addressList"]
edit_link                          css                             .link
text_name                          css                            .updated-checkout-address>p:nth-child(1)
text_address                       css                             .updated-checkout-address>p:nth-child(2)
billingAdd_sameAsShippingAddress   id                               dwfrm_billing_billingAddress_sameAsShippingAddress
text_fname						   id						        dwfrm_billing_billingAddress_addressFields_firstName
text_lname						   id						        dwfrm_billing_billingAddress_addressFields_lastName
text_adress						   id    						    dwfrm_billing_billingAddress_addressFields_address1
text_zip_code					   id     						    dwfrm_billing_billingAddress_addressFields_zip
text_city					       id 						        dwfrm_billing_billingAddress_addressFields_city
text_phone_no					   id						        dwfrm_billing_billingAddress_addressFields_phone
==============================================================================================================
@objects2      
cardno_text
      aligned horizontally all:  card_exp_month_button
card_exp_month_button
      aligned horizontally all:  year 
year      
      aligned horizontally all:  textbox_SecurityCode      