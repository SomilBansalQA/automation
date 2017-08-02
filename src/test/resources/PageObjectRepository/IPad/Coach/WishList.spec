Page Title: coach

#Object Definitions
====================================================================================
Link_Product_Name					    xpath			(//div[@class='product-name'])[1]
icon_delete_product_From_WishList	    xpath			(//span[text()="DELETE"])[1]
button_YesDelete_Product_From_WishList	xpath		    //button[contains(text(),"Yes")]
button_public_WishList	                xpath           //button[@name='dwfrm_wishlist_setListPublic']
button_Email_WishList                   xpath          (//span[@class='icon-coach-mail'])[1] 
Label_Email_Friend                      xpath           //h4[@class='modal-title']
Label_Email_FirstName                   xpath           //span[text()[normalize-space()='Your First Name']]
Label_Email_LastName                    xpath           //span[text()[normalize-space()='Your Last Name']]
Label_Email_EmailAddress                xpath           //span[text()[normalize-space()='Your Email Address']]
Label_Email_ConfirmEmail                xpath           //span[text()[normalize-space()='Confirm Email']]
Label_Email_Message                     xpath           //span[text()[normalize-space()='Message']]
Label_Email_FriendsEmailAddress         xpath           //span[text()[normalize-space()="Friend's Email Address"]]
Text_Email_FillFirstName                xpath           //input[@id='dwfrm_sendtofriend_yourfirstname']
Text_Email_FillLastName                 xpath           //input[@id='dwfrm_sendtofriend_yourlastname']
Text_Email_FillEmailAddress             xpath           //input[@id='dwfrm_sendtofriend_youremailaddress']
Text_Email_FillConfirmEmail             xpath           //input[@id='dwfrm_sendtofriend_emailconfirm']
Text_Email_FillFriendsEmailAddress      xpath           //input[@id='dwfrm_sendtofriend_friendsemailaddress']
Text_Email_FillConfirmFriendsEmail      xpath           //input[@id='dwfrm_sendtofriend_confirmfriendsemail']
Text_Email_FillMessage                  id               dwfrm_sendtofriend_message
Button_send                             xpath           //button[@class='btn btn-default send-button']
verify_mailsent                         xpath           //h4[@class='modal-title']
button_close                            xpath           //div[@class='form-group']/button
verify_mailsendtext                     xpath           //div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 wishlist-send-to-friend-confirmation']
button_wishlist_accountpage             xpath            //a[@class='text-center box icon-coach-wishlist']
button_friend_whislist                  xpath            //a[@class='find-wishlist btn btn-white text-right'] 
Label_Find_Wishlist                     xpath             //h2[@class='section-header'] 
Text_Email_Friend_WishList              xpath            //input[@id='dwfrm_wishlist_search_email']  
Button_Search_FriendWishList            xpath           //button[@class='btn btn-default']
Result_After_Search_FriendWishList      xpath           //div[@id='searchresultcontent']/p  
Button_Move_to_WhishList                xpath            //a[@class='logged-in move-to-wishlist']
icon_close_wishlist                     xpath           //button[@class='icon-coach-close-black']
Label_BagIs_Empty                       xpath            //div[@class='cart-empty']  
Label_your_wishlist                     xpath           //h4[@id='myModalLabel']
Link_SendToFriend                       xpath            //a[@id='send-to-friend']
textbox_FirstName                       xpath            //input[@id='dwfrm_sendtofriend_yourfirstname']
textbox_LastName                        xpath            //input[@id='dwfrm_sendtofriend_yourlastname'] 
close_emailAfriend                      css              .btn.btn-default.send-to-friend-close  
delete_product_wishlist                 css              .icon-coach-close-grey
button_danger                           css              .btn.danger