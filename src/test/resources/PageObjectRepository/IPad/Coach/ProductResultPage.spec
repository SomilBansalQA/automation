Page Title: coach

#Object Definitions
====================================================================================
frst_product                                  xpath                                 (//div[@class='product-image'])[1]/a/img
header_ResultsFor							  xpath                                   //div[@class='container-shopGrid']/h1
span_product_name_searched					  css							.container-shopGrid>h1>span
span_product_filter_by						  xpath							//div[contains(@class,'collapsed')]//h4
list_sort_by								  xpath							(//div[contains(@class,'sort-by')])[2]
list_sort_by_just_added						  xpath							//ul[@class="dropdown-menu"]//li//a[text()="Just Added"]
list_sort_by_bestseller						  xpath							//ul[@class="dropdown-menu"]//li//a[text()="Bestsellers"]
list_sort_by_Price_high_to_low				  xpath							//a[text()='Price High To Low']
list_sort_by_price_low_to_high				  xpath						    //a[text()='Price Low To High']
link_product_name							  xpath							(//a[contains(@class,"name-link")])[2]
link_color_filter							  xpath							//section[@id='refinement-colorGroup']
btn_quick_shop								  xpath							(//a[@class='quickbuy-show'])[2]
mobile_Cross_icon							  xpath							//button[@type="button" and contains(@class,'icon')]
label_Bag_charm                               xpath                         //h3[@class='recommendations-heading']
image_bag_charm                               xpath                         (//div[@class='product-image'])[6]
icon_plus_Bag_Charm                           xpath                        (//a[@class='btn btn-default add-to-bag-cham collapsed addToBagCharm']//span)[4]
text_bag_charm                                xpath                        (//h3[@class='productellipse multiline']/a[@class='name-link']) [4]
text_verify_charm_added                       xpath                        //div[@class='name']
label_you_may_like                            xpath                        //h3[@class='recommendations-heading']
hover_youMay_like_product                     xpath                        (//div[@class='product-image recommendation_image'])[1]
text_verify_product_added                    xpath                         //h1[@class='product-name-desc']
image_MissingImage                            xpath                       (//div[contains(@class,'missing-image')])[1]
coach1941                                     xpath                        //li[@class='top-level coach-1941']
coach1941Bags                                 xpath                          //li[@class='women-coach1941-bags']//a[contains(text(),'Bags')]
priceRange                                    css                           .price-sales.price-range:first-child
label_price_plp                                xpath                        (//div[@class='product-price'])[position()<5]
more_button                                   xpath                          //a[@class='more-results pull-right load-results']
filter_container                              xpath                         (//div[@class='container filtering'])[1]
text_color_filter                             xpath                          //section[@id='refinement-colorGroup']//span[@class='category-dropdowntitle']
material_filter                               xpath                          //section[@id='refinement-fabrication']//span[@class='category-dropdowntitle']
category_filter                               xpath                          //section[@id='refinement-silhouette']//span[@class='category-dropdowntitle']
sortBy_filter                                 xpath                          //div[@class='category-dropdownnav sort-by btn-group']//span[@class='category-dropdowntitle']
color_select_filter                           xpath                          (//div[@class='category-dropdownnavlist']//ul//li[@class='refinement'][2]//span[@class='icon-coach-refinement-checkbox refinement-checkbox'])[1]
filter_alignment                              css                            .filters-options .filters-row
new_tab                                       css                            .new
bags                                          css                            .women-handbags-new-arrivals>a
link_morecolors                               xpath                          (//a[contains(@class,'more-color')])[1]
text_color_selected                           xpath                          (//span[@class='icon-coach-refinement-checkbox refinement-checkbox'])[1]/..//a
tags_filter                                   css                             .refinement-pill a
button_clear_all                              css                             [title="Clear"]
text_filter_by                                css                              .refined-by  .hidden-xs

