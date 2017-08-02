coach

#Object Definitions
====================================================================================
quick_buy_close				xpath							(//div[@id='cont']//div//a[contains(@class,'quickbuy-close')])[2]
link_procuct_name			xpath							(//a[contains(@class,'name-link')])[2]
text_dollar_symbol			xpath							(//span[contains(text(),'$')])[3]
list_size_product			xpath							//ul[@class='swatches Size']/li
list_color_product			xpath							//ul[@class='swatches Color']//li//a
btn_add_cart				css								.add-to-cart
link_prodct_details			xpath							(//a[text()='View Product Details'])[1]
fullPricedProduct           xpath                           (//*[@class='price-sales'])[1]
strikedthrough_price        xpath                           (//*[contains(@class,'standardprice')])[1]
sale_price                  xpath                           (//*[contains(@class,'price-range-sales-price')])[1]
master_product              xpath                            //*[@title="DARK GUNMETAL/NAVY"]/img[contains(@src,'Coach/57276_dknav')]

