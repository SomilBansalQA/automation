Page Title: coach

#Object Definitions
====================================================================================
text_choose_your_material             css                     .bag-customize-heaing-text
text_choose_your_bag                  css                      [aria-label="Choose your Rogue bag size to start"]										
image_bag 							  css                      .listItems .item-1
radio_leather_type                    xpath                     //li[@ng-click="selectMaterial(item)"]/span[text()='${lnk}']
img_color                             xpath                    .//*[@id='list-color']//a/img[contains(@alt,'${lnk}')]
tab_material                          xpath                     //li[@ng-click="selectHandle(item)" or contains(@ng-click,"monogram" )]/a[contains(text(),'${lnk}')]
radio_hardware                        xpath                     //*[@ng-repeat="item in listColorShow"] /span[text()='${lnk}']
radio_monogram                        css                       [aria-label="Add a complimentary monogram to your hangtag (available in store only)"]
radio_save_my_design                  css                       [ng-click="saveOrder()"]
text_fname							  css                       #firstName
text_lname                            css                       #lastName
text_email                            css                       #email
button_make_bag                       css                       [ng-click="comleteOrder()"]
text_bag_content                      css                       .text-detail-content
button_clear_all                      css                       [ ng-click="clearAllData()"]
text_body                             css                       .title.ng-binding
link_view_interior                    css                       [ng-click="insideView()"]
img_interior                          css                       .view-image
link_change_bag_size                  css                       [ng-click="changeBagSize()"]
button_conform_bag_change             css                       [ng-click="changeBagSizeConfirm()"]