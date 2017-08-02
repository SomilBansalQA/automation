Page Title: coach

#Object Definitions
====================================================================================
frst_product                                  xpath                         (//div[@class='product-image'])[1]/a/img
header_ResultsFor							  xpath                         //h1//span
span_product_name_searched					  css							.container-shopGrid>h1>span
span_product_filter_by						  xpath							//div[contains(@class,'collapsed')]//h4
list_sort_by								  xpath							(//div[contains(@class,'sort-by')])[2]
list_sort_by_just_added						  xpath							//ul[@class="dropdown-menu"]//li//a[text()="Just Added"]
list_sort_by_bestseller						  xpath							//ul[@class="dropdown-menu"]//li//a[text()="Bestsellers"]
list_sort_by_Price_high_to_low				  xpath							//a[text()='Price High To Low']
list_sort_by_price_low_to_high				  xpath							//a[text()='Price Low To High']
link_product_name							  xpath							//a[contains(@class,"name-link")]
link_color_filter							  xpath							//section[@id='refinement-colorGroup']
btn_quick_shop								  xpath							(//a[@class='quickbuy-show'])[2]
mobile_Cross_icon							  xpath							//button[@type="button" and contains(@class,'icon')]
label_Bag_charm                               xpath                         //h3[@class='recommendations-heading']
image_bag_charm                               xpath                         (//div[@class='product-image'])[6]
icon_plus_Bag_Charm                           xpath                        (//a[@class='btn btn-default add-to-bag-cham collapsed addToBagCharm']//span)[4]
text_bag_charm                                xpath                        (//h3[@class='productellipse multiline']/a[@class='name-link']) [4]
text_verify_charm_added                       xpath                        //h2[@class='name']/a
label_you_may_like                            xpath                        //h3[@class='recommendations-heading']
hover_youMay_like_product                     xpath                        (//div[@class='product-image recommendation_image'])[1]
text_verify_product_added                    xpath                         //h1[@class='product-name-desc']
label_price_low_to_high                      xpath                         //a[text()='Price Low To High']
label_price_plp                                xpath                        (//div[@class='product-price'])[position()<5]
label_price_High_to_low                     xpath                         //a[text()='Price High To Low']
label                                        xpath                         //div[@class='row filters-row']
women_tab									  css                           .women						    
header_bags                                   xpath                         (//a[@class='level-2' ])[1]
image_MissingImage                            css                       	div.missing-image
labelTag_price_plp                            css                          .price-sales, .salesprice
coach1941                                     xpath                        //li[@class='top-level coach-1941']
coach1941Bags                                 xpath                          //li[@class='women-coach1941-bags']//a[contains(text(),'Bags')]
priceRange                                    css                           .price-sales.price-range:first-child
filter_container                              xpath                         (//div[@class='container filtering'])[1]
text_color_filter                             xpath                          //section[@id='refinement-colorGroup']//span[@class='category-dropdowntitle']
material_filter                               xpath                          //section[@id='refinement-fabrication']//span[@class='category-dropdowntitle']
category_filter                               xpath                          //section[@id='refinement-silhouette']//span[@class='category-dropdowntitle']
sortBy_filter                                 css                           .category-dropdownnav.sort-by.btn-group
color_select_filter                           css                           #refinement-colorGroup
filter_alignment                              css                            .filters-options .filters-row
new_tab                                       css                            .new
bags                                          css                            .women-handbags-new-arrivals>a
link_morecolors                               xpath                          (//a[contains(@class,'more-color')])[1]
text_color_selected                           xpath                       (//a[@class='refinement_anchor'])[1] [not(@id="span")]
tags_filter                                   xpath                            //div[@class='refinement-pill']/a
button_clear_all                              css                             [title="Clear"]
text_filter_by                                css                              .refined-by  .hidden-xs
price_name									  xpath								../../../../div/meta[1]
price_productId								  xpath								../../../../div/meta[2]
missing_image							      css							    .product-image.missing-image
missing_image_src							  css 								.product-image> a> .primary-image
missing_image_src_name						  xpath								./../../..//meta[1]
missing_image_src_productId					  xpath								./../../..//meta[2]
missing_image_name							  xpath								./..//meta[1]
missing_image_productId					   	  xpath								./..//meta[2]
tile_class									  css								div.col-lg-3.col-md-3.col-sm-4.col-xs-6.prod-grid
blank_tile									  xpath								./div
blank_tile_name								  xpath								.//meta[1]
blank_tile_productId						  xpath								.//meta[2]
missing_image_first						      css							    .product-image.missing-image:nth-child(1)
style_id                                      css                               .product-style
products_text_shopgrid                        css                               .product-msg a
quick_buy                                     xpath                               //a[@class="quickbuy-show"]
text_product_msg_preorder                     css                                .preorder-msg
text_product_msg_backorder                    css                                .backorder-msg
productCoach1914							  xpath							     .//a[contains(text(),'${text}')]
arrow_left                                    xpath                    //meta[@content='${text}']/parent::div/following-sibling::div[contains(@class,'product-swatches')]//div[contains(@class,'carousel-loaded')]/parent::div/child::a[1]
arrow_right                                   xpath                  //meta[@content='${text}']/parent::div/following-sibling::div[contains(@class,'product-swatches')]//div[contains(@class,'carousel-loaded')]/parent::div/child::a[2]
bar_swatches                                  xpath                //meta[@content='${text}']/parent::div/following-sibling::div[@class='product-swatches']
fullPricedProduct                             xpath                               (//*[@class='price-sales'])[1]
strikedthrough_price                          xpath                               (//*[contains(@class,'standardprice')])[1]
sale_price                                    xpath                               (//*[contains(@class,'price-range-sales-price')])[1]
master_product                                xpath                                //*[@title="DARK GUNMETAL/NAVY"]/img[contains(@src,'Coach/57276_dknav')]