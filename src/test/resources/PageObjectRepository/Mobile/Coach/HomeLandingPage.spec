Page Title: Official Site

#Object Definitions
====================================================================================
page_heading                                  xpath                                  //a[@title='COACH']/span
login_register_button                         xpath                                  //span[contains(text(),'Sign In/Register')]
button_sign_out								  xpath									(//span[contains(text(),'Account')])[1]
linkText_Signout							  xpath                                 //a[@title='Sign Out']

****404 PAGE ****
title                                         xpath                                   //h1[contains(text(),'Sorry, This Page No Longer Exists')]
search_box                                    xpath                                   //input[@id='search-box']
new_for_her                                   xpath                                   //h3[@class='pull-left' and contains(text(),'New For Her')]
new_for_him                                   xpath                                   //h3[@class='pull-left' and contains(text(),'New For Him')]
question                                      xpath                                   //h4[contains(text(),'Have Any Questions?')]
link_find_Your_Perfect_wallet                 css                                      .perfect-wallet__header
section_find_your_perfect_wallet              css                                       .perfect-wallet__filters
filters_find_your_perfect_wallet              css                                       .perfect-wallet__filter-title
checkbox_filters_perfect_wallet               css                                       .perfect-wallet__filter-item-img
radio_iphone7                                 css                                       #perfect-wallet__filter-item-iPhone_7_  img
button_results_wallet                         css                                        .perfect-wallet__btn-select.active
radio_monogramming                            css                                        #perfect-wallet__filter-item-Yes
button_clear                                  css                                         [title="Clear"]
btnClear									  css										 .refinement-pill-clear>a
total_products                                css                                      .search-result-content .product-image
link_clear_all_perfect_wallet                 css                                       .perfect-wallet__btn-clear
title_wallet_guide                            css                                       .wallet-guide__title
radio_bill_compartment						  css									    #perfect-wallet__filter-item-Bill_Compartments
radio_card_slot_4                             css                                       #perfect-wallet__filter-item-4
categories_mens_wallet                        css                                       .wallet-guide__icon-nav div:nth-child(2)
category_card_wallet                          css                                       .wallet-guide__icon-nav__card div:nth-child(2)
category_shop_grid_wallet                     xpath                                      (//span[@class='category-dropdowntitle'])[1]
category_card_cases_wallet                    css                                       .wallet-guide__icon-nav__card div:nth-child(2)
shopGridContainer							  css										.container-shopGrid .search-result-content