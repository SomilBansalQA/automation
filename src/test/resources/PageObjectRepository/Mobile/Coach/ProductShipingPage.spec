coach

#Object Definitions
====================================================================================
continue            				xpath						//button[contains(text(),'Continue')]
shipng								xpath						//div[@class="checkout-progress-indicator"]//ul//li[contains(@class,'step-1')]
text_fname							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']
text_lname							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']
text_adress							xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']
text_zip_code						xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_zip']
text_city						    xpath					    //input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']
text_phone_no						xpath						//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']
btn_country_dropdown				xpath						//select[@id="dwfrm_singleshipping_shippingAddress_addressFields_country"]
option_country						xpath						//a[@class='select-option']/span[text()='${option}']
text_fname_billing					xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_firstName']
text_lname_billing					xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_lastName']
text_address_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_address1']
text_zip_code_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_zip']
text_phone_no_billing				xpath						//input[@id='dwfrm_billing_billingAddress_addressFields_phone']
btn_country_dropdown_billin			xpath						//button[@data-id='dwfrm_billing_billingAddress_addressFields_country']
option_country_billing				xpath						//a[@class='select-option']//span[text()='United States']
button_edit                         xpath                       (//span[@class="edit-arrow"])[3]
button_add_new_card                 xpath                       (//a[@class='modal-action section-header-note dialogify address-create'])[2]
textbox_FirstName                   xpath                       //input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']
textbox_LastName                    xpath                       //input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']
checkbox_remember_me                css                         [ for="dwfrm_login_rememberme"]
pop-up_ups_server                   css							 .UPSPopup
link_edit_address_UPS_Server        css                          .edit-entered-address
your_order                          xpath                          //div[@class='checkout-order-totals']
OrderTotal                          xpath                          (//li[contains(@class,'order-total')]/span)[2]
tab_shipping                        css                            .checkout-progress-indicator li:nth-child(1)
