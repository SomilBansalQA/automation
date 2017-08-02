Page Title: coach

#Object Definitions
====================================================================================
button_Register            			 	xpath                  (//button[@class="btn btn-default signin"])[1]
textbox_FirstName					 	xpath				   //input[@id='dwfrm_profile_customer_firstname']
textbox_LastName						xpath				   //input[@id='dwfrm_profile_customer_lastname']
textbox_eMailAddress					xpath				   //input[@id='dwfrm_profile_customer_email']
textbox_confirmEmail        			xpath 				   //input[@id='dwfrm_profile_customer_emailconfirm']
textbox_password						xpath				   //input[@id='dwfrm_profile_login_password']
textbox_confirmPassword					xpath				   //input[@id='dwfrm_profile_login_passwordconfirm']
checkbox_SignMeIN						xpath				   //input[@id='dwfrm_profile_customer_addtoemaillist']
button_SignUp							xpath				   //button[@class='btn btn-default continue' and @name='dwfrm_profile_confirm']
textbox_addressField1					xpath				   //input[@id='dwfrm_profile_address_address1']
textbox_addressField2					xpath                  //input[@id='dwfrm_profile_address_address2']
textbox_postalCode						xpath				   //input[@id='dwfrm_profile_address_zip']
textbox_city							xpath 				   //input[@id='dwfrm_profile_address_city']
textbox_phone							xpath				   //input[@id='dwfrm_profile_address_phone']
button_Complete 						xpath				   //button[@class='apply-button btn' and contains(text(),"Complete")]
textMessage_Welcome						xpath 				   //p[@class='text-center welcome-massage']
page_heading                			xpath                  //a[@title='COACH']/span
button_login_register      			    xpath                  //span[contains(text(),'Sign In/Register')]
login_button                			xpath                  (//span[contains(text(),'Sign In')])[2]
username_field              			xpath                  //input[contains(@id,'dwfrm_login_username')]
password_field              			xpath                  //input[@id='dwfrm_login_password']
signin_button               			xpath                  (//button[@class="btn btn-default signin"])[2]
signin_button2	            			xpath                  //button[@class='btn checkout btn-default']
checkbox_remember		    			xpath	   			   //*[contains(text(),'dwfrm_login_rememberme')]
linkText_Skip							css				        .skip-button.goback
button_Save_Changes						xpath				   //button[@name='dwfrm_profile_savechanges']
textbox_current_password				xpath					#dwfrm_profile_login_currentpassword
textbox_new_password					xpath					#dwfrm_profile_login_newpassword
textbox_current_password_account_information_section	 xpath		(//input[@id='dwfrm_profile_login_currentpassword'])[1]
linkText_Address_Book 					xpath					(//div[@id='secondary']//a)[last()]
label_Address_Book						xpath					//div[@id='addresses']//h3
button_Add_New_Address					xpath					(//div[@id='addresses']//a[@class='modal-action section-header-note address-create btn btn-default account-store'])[1]
linkText_Edit_Address					xpath					//div[@id='addresses']//a[@class='modal-action address-edit']
button_Save_Address						xpath					//button[@name='submit-button']
label_Message_after_Save_Address		xpath			//div[@class='text-center']
button_Close_Address					xpath					//div[@class='text-center']/button
linkText_Saved_Credit_Cards				xpath					//div[@id='secondary']//a[text()="Saved Credit Cards"]
icon_Delete_Saved_Cards  				xpath					//div[@id='primary']//a[contains(@class,'button-text delete')]
button_Yes_Delete_Cards					xpath					//form[@id='creditcards_1']/button[contains(text(),"Yes")]
label_You_dont_have_Cards				xpath					//div[@id='primary']//h5[contains(text(),"You do not have a saved credit card.")]
btn_add_new_credit_card					xpath 					//a[@title='Add New '] 
field_card_no							xpath					(//input[contains(@name,'dwfrm_paymentinstruments_creditcards_newcreditcard')])[2]
field_cvv_no							xpath					//input[contains(@id,'password_dwfrm_paymentinstruments')]
dropdown_card_month						xpath					(//span[text()='MONTH']/..)[1]
dropdown_card_year						xpath					(//span[text()='YEAR']/..)[1]
text_card_mnth							xpath					//span[text()='09']
text_card_year							xpath					//span[text()='2020']
btn_card_save							xpath					//button[@id='applyBtn']
window_card								xpath					//div[@class='modal-content']
window_card_close						xpath					//button[@class='icon-coach-close-black']
btn_card_close							xpath					//button[contains(@value,'Close')]
label_State								xpath					//span[text()="State"]
label_CreateAnAccount					xpath					(//*[@class='section-header text-center'])[1]
label_RegisterNowToAccess				xpath					(//div[@class='dialog-required text-center'])[1]
label_PasswordMustBeAtleast 			xpath					//p[contains(@class,'password-information')]
checkBox_Signup							id						dwfrm_profile_customer_addtoemaillist
label_YouAreSigningUpToReceive		    xpath					//label[@for='dwfrm_profile_customer_addtoemaillist']
label_EnterAFirstName					xpath					//span[@class='error' and @for='dwfrm_profile_customer_firstname']
label_EnterALastName					xpath					//span[@class='error' and @for='dwfrm_profile_customer_lastname']
label_EnterYourEmailAddress 			xpath					//span[@class='error' and @for='dwfrm_profile_customer_email']
label_ConfirmYourEmailAddress	 		xpath   				//span[@class='error' and @for='dwfrm_profile_customer_emailconfirm']
label_EnterYourPassword					xpath					//span[@class='error' and @for='dwfrm_profile_login_password']
label_ConfirmYourPassword				xpath					//span[@class='error' and @for='dwfrm_profile_login_passwordconfirm']
label_EmailAlreadyRegistered 	 		xpath					//span[@class='form-caption error-message']
linkText_ForgotPassword			 		xpath					(//form[@id='dwfrm_login']//a[@id='password-reset'])[1]
textBox_PasswordRequest		   			id 						dwfrm_requestpassword_email
button_SubmitForgotPassword				xpath					//form[@id='PasswordResetForm']//button
label_PasswordRequest					xpath					//h4[text()='Password Request']
linkText_SignInAgain					classname				sign-in-again
label_EmailsDoNotMatch					xpath				//span[@class='error' and @for='dwfrm_profile_customer_emailconfirm']
label_YourPasswordMustBeEight			xpath				//span[@class='error' and @for='dwfrm_profile_login_password']
label_PasswordsDoNotMatch				xpath				//span[@class='error' and @for='dwfrm_profile_login_passwordconfirm']
box_primaryCreditCard					classname				primary
linkText_EditLinkForCreditCard			xpath				//a[contains(text(),"Edit")]
checkbox_MakePrimaryPayment				id					dwfrm_paymentinstruments_creditcards_newcreditcard_isPrimaryCreditCard
button_confirm_email             		xpath               //input[@id='dwfrm_billing_billingAddress_email_emailconfirm']
continue            					xpath						//button[contains(text(),'Continue')]
dropdown_Newcard_month        			xpath                (//button[@class='btn dropdown-toggle selectpicker btn-default'])[4]
text_Newcard_mnth             			xpath              (//a[@class='select-option']//span[@class='text' and text()='01'])[2]
dropdown_Newcard_year         			xpath                   (//button[@class='btn dropdown-toggle selectpicker btn-default'])[5]
text_Newcard_year             			xpath                   (//a[@class='select-option']//span[@class='text' and text()='2020'])[2]
btn_conform_card_delete        			xpath                  //a[@class="button-text delete icon-coach-close-grey"][1]
icon_conform_delete                 	xpath                  //button[@class='btn danger'] 
italy_label_YouAreSigningUpToReceive    xpath                  (//label[@for='dwfrm_profile_customer_addtoemailSignuplist'])[1]
italy_label_Recommendationlist          xpath                    (//label[@for='dwfrm_profile_customer_addtorecommendationlist'])[1]
icon_order_history                      css                       .text-center.box.icon-coach-orderhistory
icon_account_setting                    css                      .icon-coach-accountsetting
list_leftSideBar_accounteditpage        css                      .account-left-nav
label_firstName                         css                      [for="dwfrm_profile_customer_firstname"] span
label_lastName                          css                      [for="dwfrm_profile_customer_lastname"] span
label_emailAddress                      css                      [for="dwfrm_profile_customer_email"] span
label_currentpassword                   css                      [name="dwfrm_profile_passwordchange"] [for="dwfrm_profile_login_currentpassword"] span
label_newpassword                       css                      [name="dwfrm_profile_passwordchange"] [for="dwfrm_profile_login_newpassword"] span
label_confirmpassword                   css                      [for="dwfrm_profile_login_passwordconfirm"] span
icon_wishlist                           css                      .icon-coach-wishlist
checkbox_primary_card                   css                      #dwfrm_paymentinstruments_creditcards_newcreditcard_isPrimaryCreditCard
link_unsubscribe                        css                      .un-subscribe
text_email_unsubscribe                  css                      [name="EMAIL_ADDRESS_"][type="text"]
radio_unsubscribe_email_address         css                      [value="Unsubscribe"]
button_submit_unsubscribe               css                      [value="Submit"]
img_thankyou_unsubscribe                css                      [alt="thank you."]
button_account                          css                      #account-dropdown
checkbox_NotcheckedYouAreSigningUP      xpath                   //input[@id='dwfrm_profile_customer_addtoemaillist']
label_gender                            css                      [data-id="dwfrm_profile_customer_gender"]  span:nth-child(1)
error_msg                               css                      .error.error-msg
address_first_name                      id                       dwfrm_profile_address_firstname
address_last_name                       id                       dwfrm_profile_address_lastname
primary_address_checkbox                id                       dwfrm_profile_address_isPrimaryAddress