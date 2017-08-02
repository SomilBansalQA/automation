coach

#Object Definitions
====================================================================================
continue            				xpath						(//button[@type='submit'])[2]
shipng								xpath						//div[@class="checkout-progress-indicator"]//ul//li[contains(@class,'step-1')]
text_fname							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']
text_lname							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']
text_adress							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']
text_zip_code						xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_zip']
text_city							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']
text_phone_no						xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']
btn_country_dropdown				xpath							(//button[@class='btn dropdown-toggle selectpicker btn-default'])[1]
option_country						xpath							//a[@class='select-option']/span[text()='${option}']option_country						xpath							//a[@class='select-option']/span[text()='${option}']option_country						xpath							//a[@class='select-option']/span[text()='${option}']
text_fname_billing					xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_firstName']
text_lname_billing					xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_lastName']
text_address_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_address1']
text_zip_code_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_zip']
text_phone_no_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_phone']
btn_country_dropdown_billin			xpath						//button[@data-id='dwfrm_billing_billingAddress_addressFields_country']
option_country_billing				xpath						//a[@class='select-option']//span[text()='United States']
button_edit                         xpath                        (//a[@class='edit-payment'])[1]
button_add_new_card                 xpath                        (//a[@class='modal-action section-header-note dialogify address-create'])[2]
textbox_FirstName                   xpath            //input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']
textbox_LastName                    xpath           //input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']
shippingMethod_Overnight            xpath                          //input[@id='shipping-method-003_Overnight']
your_order                          xpath                          //div[@class='checkout-order-totals']
OrderTotal                          xpath                          (//li[contains(@class,'order-total')]/span)[2]
text_email                          xpath                          //input[contains(@id,'dwfrm_login_username')]
text_password                       css                          #dwfrm_login_password
text_sign_in                        css                          [name="dwfrm_login_login"]
panel_sign_in                       css                             .single-shopping-login
createAccount                       css                            .billingheading
tab_shipping                        css                            .checkout-progress-indicator li:nth-child(1)
checkbox_remember_me                css                            [ for="dwfrm_login_rememberme"]
link_forgot_password                css                            #password-reset
popup_password_request              css                            .password-send
link_cancel_password_request        css                            .cancel
text_email_password_request         css                            #dwfrm_requestpassword_email
button_submit_password_request      css							   .sendemail
icon_cross_password_request         css                            .icon-coach-close-black
error_invalid_login                 css                            .error-form
pop-up_ups_server                   css							   .UPSPopup
link_edit_address_UPS_Server        css                            .edit-entered-address
text_use_entered_address            css                            .entered-address.active
text_suggested_address              css                             .suggested-address
text_suggested_address_value        css                            #addLinePrimaryValueLI1 .address-list-item
text_sign_in_password_request       css                            .modal-content   [name="dwfrm_login_login"]
button_registered_customers         css							   [value="Sign in for a faster checkout"]
shippingPage                        css                            .visited.inactive>a
username                            id                             dwfrm_login_username_d0kfjmneerdd
password                            id                             dwfrm_login_password
submit                              css                            .btn.checkout.btn-default