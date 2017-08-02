Page Title: coach

#Object Definitions
====================================================================================
section_Footer					css									.footer-lower-wrap
textbox_Enter_email_address		id								signup-email
textbox_Enter_confirm_email_address		id						signup-confirm-email
button_signUp					xpath							//button[@value='sign up']
footer_top_section				css					        	.footer-Desktop-top
label_ConnectWithCoach			css								h4.connect-text
label_message_After_Connect_with_Coach    				css     .email-confirm-msg
icon_Cross_Connect_With_Coach_window 					xpath      //*[@id='universal-modal']//button[@class='icon-coach-close-black']
label_Thank_You_Connect_With_Coach 						xpath      //h4[text()="Thank you"]		
linkText_Store_Locator			xpath							//a[text()="STORE LOCATOR"]
coachfoundation_link         	xpath  						//a[text()='COACH FOUNDATION']
text_coachfoundation         	xpath 							 (//img[@alt='The Coach Foundation'])[1]
text_our_mission            	xpath       				 	//*[@id='primary']/div/section/h1
linkText_ContactUS    			xpath   				    //div[@id='footer-accordian']//a[text()="CONTACT US"]			
link_gift_cards					xpath						(//a[text()="Gift Cards"])[2]
italy_label_signupmessage       xpath                       //label[@for='dwfrm_billing_billingAddress_addToEmailSignuplist']
italy_label_addtorecommendationlist xpath                   //label[@for='dwfrm_billing_billingAddress_addToRecommendationlist']
change_language                 xpath                        //a[@class='locale']
current_language                xpath                         //a[@class='locale selected']
country_dropdown                xpath                         //em[@class='country-toggle-flag-bottom flag flag-icon-IT']
country_dropdown_list           xpath                         //ul[@class='dropdown-menu-toggle selector desktop-country-togggle hidden-xs']//li//a[@class='country-flag locale-link']//span["+ i +"]
list_footer_Subcategories       xpath                          (//ul[@class="list-unstyled"]/li[not(contains(@class,'mobile'))]//a)[${Count}]
footer_SubCategories_Size       xpath                           //ul[@class="list-unstyled"]/li[not(contains(@class,'mobile'))]//a
text_Page_Not_Exist             xpath                           //section[@class = 'section-header null-results']/h1[contains(text(),"Sorry, This Page No Longer Exists")]
error_select_box_to_recieve     css                            .terms-conditions-error
checkbox_select_box_to_recieve  css                           #dwfrm_profile_customer_addtoemailSignuplist