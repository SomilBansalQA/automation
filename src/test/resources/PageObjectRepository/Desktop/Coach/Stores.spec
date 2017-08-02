Page Title: Store

#Object Definitions
====================================================================================
textBox_Postal_Code 				id				dwfrm_storelocator_postalCode
button_Search_Zip					css				button[ value='Search zip']
icon_Set_Favourite_Store			xpath			(//i[@class="icon-coach-fav"])[1]
label_Favourite_Store				xpath			//span[text()='FAVORITE STORE']
link_View_Map                       xpath            (//a[@class='google-map'])[1]
popup_google_map                    css              #map-canvas
button_close_google_map             css              .icon-coach-close-white
text_address                        xpath            (//div[@class='store-info'])[1]//div[@class='store-address']
text_phoneno                        xpath            ((//div[@class='store-info'])[1]//div[@class='store-address'] //span)[5]
link_directions                     xpath             (//a[@class='google-map-direction'])[1]
tab_international                   css                .international-tab-location
button_searchcountry                css                [name="dwfrm_storelocator_findbycountry"]
dropdown_select_country             xpath          //button[@data-id='dwfrm_storelocator_address_international']/following-sibling::div/ul/li/a/span
text_country_selected               css              .form-horizontal >:nth-child(1)
text_error_message                  css              .container>p
text_store_locator                  css              #store-location-results-list
dropdown_radius_selection           css              [data-toggle="dropdown"] 
list_radius_slection                css              #store-miles option
text_radius_default_value           css              [data-toggle="dropdown"] span
list_distance                       css              .distance-info
list_store_category                 css              #secondary [role="checkbox"]
icon_close_Dont_miss_out			xpath			//button[@class="icon-coach-close-black"]
link_direction						xpath			(//a[@title = 'Directions'])[1]
textbox_address						css			    #dwfrm_storelocator_address_addressfordirection
textbox_city						xpath			//input[@name=  "dwfrm_storelocator_address_city"]
textbox_postal_code					xpath			//input[@name=  "dwfrm_storelocator_address_zip"]
dropdown_select_state				xpath 			//div[@data-required-text = "Please select state"]/select/option
button_get_direction				xpath			//button[@id=  "direction-submit"]
text_verifyLocationAddress			xpath			//strong[text() = "DATA NOT FOUND"]
button_redoSearch                   css            .refine-search div:nth-child(1) 
tab_location					    css			   .location.us-tab-location
iconCoach							css			   .icon-coach-ustab