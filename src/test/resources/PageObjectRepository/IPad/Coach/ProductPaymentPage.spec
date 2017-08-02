coach

#Object Definitions
====================================================================================
cardno_text            				xpath						//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_number')]	
textbox_SecurityCode                xpath                       //input[contains(@id,'password_dwfrm_billing_paymentMethods_creditCard_cvn')]
textbox_ConfirmEmail				xpath      					//input[@id='dwfrm_billing_billingAddress_email_emailconfirm']
btn_ConfirmContinue                 xpath                       //button[@id='billingSubmitButton']
btn_PlaceOrder                      xpath                       (//button[contains(text(),'Place Order') and @class='btn btn-default place-order-btn'])[1]
card_exp_month_button				xpath						//select[@id='dwfrm_billing_paymentMethods_creditCard_month']
month_may_text						xpath						 //option[@class='select-option' and @label='05']
card_exp_year_button                xpath						//select[contains(@id,'dwfrm_billing_paymentMethods_creditCard_year')]
year_2017_text						xpath						//option[@class="select-option" and @label="2017"]
checkbox_shipng_adress              xpath						//input[@id='dwfrm_billing_billingAddress_sameAsShippingAddress']
checkbox_sign_me_up					xpath						//input[@id='dwfrm_billing_billingAddress_addToEmailList']
coach_gift_card						xpath						//input[@id='dwfrm_billing_giftCardCode']
coach_gift_card_pin					xpath						//input[@id='dwfrm_billing_giftCardPin']
button_apply_gift					xpath						//button[@id='applyGiftCard']	
radio_button_pay_pal				xpath						//input[@id='is-PayPal']
text_email_paypal    				xpath  					    //input[@id="dwfrm_billing_billingAddress_email_emailAddress"]
button_paypal_submit				xpath						//button[@id='btnLogin']
button_paypal_confirm				xpath						//input[@id='confirmButtonTop']
textbox_Email     					 css     				    #dwfrm_billing_billingAddress_email_emailAddress
icon_credit_card_type 				xpath 						//span[contains(@class,"card-type-icon")]
button_paypal_continue   			 xpath   				   //input[@id="confirmButtonTop"]
text_password_paypal    			xpath   				   //input[@id="password"]
textbox_email_paypal 				xpath						//input[@id="email"]
spinner								id							//div[@class="spinWrap"]/p[1]								id							spinnerspinner								id							spinner
checkbox_save_card					xpath						(//div[@class='custom-checkbox']/span)[2]
paypal_error_message				xpath						//div[@id="pageLevelErrors"]//span
month_may_text_uk					xpath						//a[@class='select-option']/span[contains(text(),'May')]
input_Continue_PayPal				id							PMMakePayment
textbox_password					id							dwfrm_billing_billingAddress_passwordfields_password
textbox_ConfirmPassword				id							dwfrm_billing_billingAddress_passwordfields_passwordconfirm
strong_name                         css                          .strong
create_acc_msg                      css                          .create-account-msg
tool_tip                            xpath                        //span[@class='tooltip tool-tip-tablet-postion euposition-tool-tip-tablet-postion']
img_tool_tip                        xpath                        .//span[@class='tooltip-content']/p/img[contains(@src,'credit_card_code')]
input_saveThisCC                    xpath                        //input[@id='dwfrm_billing_paymentMethods_creditCard_saveCard']
h3_billing                          xpath                        //h3[@class='heading inline-billingheading']
gift_card_value                     xpath                       //span[contains(text(),"-$25.00")]
coach_gift_card_title               xpath                       //a[contains(text(),'GIFT CARD')]
form_payment                       css                           .checkout-billing-form 
text_paypal_shipping_address		xpath						//div[@ng-if = "showShippingAddress"]
billing_statement                   xpath                        (//div[@class='custom-checkbox']/following-sibling::label)[1]
cvv_errorMessage                    xpath                          //span[@class='error-message']

