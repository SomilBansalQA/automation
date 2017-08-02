Page Title: Official Site

#Object Definitions
====================================================================================
page_heading                                  xpath                                  //a[@title='COACH']/span
login_register_button                         xpath                                  //span[contains(text(),'Sign In/Register')]
button_sign_out								  xpath									(//span[contains(text(),'Account')])[1]
linkText_Signout							  xpath                                 //a[@title='Sign Out']


title                                         xpath                                   //h1[contains(text(),'Sorry, This Page No Longer Exists')]
search_box                                    xpath                                   //input[@id='search-box']
new_for_her                                   xpath                                   //h3[@class='pull-left' and contains(text(),'New For Her')]
new_for_him                                   xpath                                   //h3[@class='pull-left' and contains(text(),'New For Him')]
question                                      xpath                                   //h4[contains(text(),'Have Any Questions?')]
link_forgot_password                          css                                      #password-reset
popup_passwordRequest                         css                                     .modal-content
textbox_email_password_recovery               css                                     #dwfrm_requestpassword_email
button_submit_password_recovery               css                                      .sendemail
popup_password_recieve_email                  css                                     .modal-body p[class="text-center"]
label_new                                     css                                      .new
label_view_all                                css                                      .women-new-arrivals-new-arrivals>a
icon_account                                  css                                      .icm-icon-user
icon_wishlist                                 css                                      .icm-icon-like
icon_cart                                     css                                      .icm-icon-bag.hidden-xs
link_account_setting                          css                                      [title="Account Settings"]
link_order_history                            css                                      [title="Order History"]
link_sign_out                                 css                                    [aria-label="Sign Outlink"]
link_find_Your_Perfect_wallet                 css                                      .perfect-wallet__header
section_find_your_perfect_wallet              css                                       .perfect-wallet__filters
filters_find_your_perfect_wallet              css                                       .perfect-wallet__filter-title
checkbox_filters_perfect_wallet               css                                       .perfect-wallet__filter-item-img
radio_iphone7                                 css                                       #perfect-wallet__filter-item-iPhone_7_  img
button_results_wallet                         css                                        .perfect-wallet__btn-select.active
radio_monogramming                            css                                        #perfect-wallet__filter-item-Yes
button_clear                                  css                                         [title="Clear"]
total_products                                css                                      .product-image
link_clear_all_perfect_wallet                 css                                       .perfect-wallet__btn-clear
title_wallet_guide                            css                                       .wallet-guide__title
radio_bill_compartment						  css									    #perfect-wallet__filter-item-Bill_Compartments
radio_card_slot_4                             id                                       perfect-wallet__filter-item-4
categories_mens_wallet                        css                                       .wallet-guide__icon-nav div:nth-child(2)
category_card_wallet                          css                                       .wallet-guide__icon-nav__card div:nth-child(2)
category_shop_grid_wallet                     xpath                                      (//span[@class='category-dropdowntitle'])[1]
category_card_cases_wallet                    css                                       .wallet-guide__icon-nav__card div:nth-child(2)
shopGridContainer							  css										.container-shopGrid .search-result-content
shopGridCategoryBanner						  css										.category-banner .top-center-header
categorySelected							  css										.category-toplevel a
filterCategory					              xpath									    //*[@class='category-dropdownnav filtersColumn']//*[contains(text(),'${text}')]
filterSort									  xpath										//*[@class='category-dropdownnav sort-by btn-group']//*[contains(text(),'${text}')]
link_view_women_bags                          css                                       .women-handbags-view-all>a
link_breadCrum								  css										.hidden-xs.hidden-sm a
colorSubFilter								  xpath										//*[@aria-label="Color"]//li[@id='swatch-${text}']
colorSubFilterUK							  xpath										//*[@aria-label="Colour"]//li[@id='swatch-${text}']
subFilter									  css  										.refinement-pills a		
btnClear									  css										 .refinement-pill-clear>a
grayOut_filter                                id                                        perfect-wallet__filter-item-1
link_clear_all                                css                                       .perfect-wallet__btn-clear