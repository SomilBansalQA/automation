package com.qait.automation;

import javax.mail.Header;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.coach.keywords.AddMonogramPage;
import com.coach.keywords.HomeLandingPage;
import com.coach.keywords.MainHeader;
import com.coach.keywords.ProductDetailsPage;
import com.coach.keywords.ProductResultPage;
import com.coach.keywords.ProductShipingPage;
//import com.coach.tests.regions.us.viewports.msg;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.YamlReader;

public class DSL extends TestSessionInitiator {

	public DSL(String testname) {
		super(testname);
	}

	public DSL(String testname, String browserName) {
		super(testname, browserName);
	}

	public void launchApplication(String url) {
		topBanner.launchSpecificUrl(url);
	}

	public void registerANewUser(String zipcode, String city, String phone) {
		if (ConfigPropertyReader.getProperty("browser").contains("ie")) {
			homeheader.hoverAtgiftsLink();
		}
		accountPage.clickOnRegisterButton();
		accountPage.enterRegisterInformation();
		accountPage.enterAddressInformationAfterSignUp(zipcode, city, phone);
	}

	public void logOutFromTheApplication() {
		topBanner.logout();
	}

	public void loginAsRegisteredUser(String userName, String password) {
		topBanner.clickOnSignINRegister().loginWithRegisteredUser(userName, password);
	}

	public void loginWithRegisteredUser(String userName, String password) {
		accountPage.loginWithRegisteredUser(userName, password);
	}

	public void searchProduct(String product) {
		search.verifyIfProductIsAvailable(product);
		search.handle_DontMissOutWindow();

	}

	public void verifyBreadCrumAndViewAllHeader(String breadCrumeValue) {
		landingPage.verifyBreadCrumsAndViewAllHeader(breadCrumeValue);
	}

	public void verifyViewAllBreadCrumDropDown() {
		landingPage.checkViewAllBreadCrumbDropDown();
	}

	public void VerifyBreadcrumbCountAfterApplyingFilters() {
		landingPage.VerifyBreadcrumbCountAfterApplyingFilters();
	}

	public void applyColorFromColorFilterForProductAndVerifySubFilter(String filter, String btnClear) {
		landingPage.verifyAndApplyColorFilter(filter);
		landingPage.verifysubFilter(filter);
		landingPage.verifyClearButton(btnClear);
	}

	public void verifySelectedfiltersShouldCleared() {
		landingPage.verifySelectedfiltersShouldCleared();
	}

	public void SelectFilterAndValidateFilterHeadercount(String filter, String filter2) {
		landingPage.clickOnColorFilterAndVerifyHeaderCount(filter, filter2);
	}

	public void verifySearchResultDisplayed(String product) {
		prodctresult.verifySearchResult(product);
	}

	public void takeScreenShotOnException(ITestResult result) {
		takescreenshot.takeScreenShotOnException(result);
	}

	public void goToMenSectionAndSelectItem() {
		homeheader.goToMenSection();
		menSection.select_mens_bag();

	}

	public void selectFirstProduct() {
		// prodctresult.handle_DontMissOutWindow();
		prodctresult.select_frst_product();

		// prodctresult.handle_DontMissOutWindow();
		// String getNameOfFirstProduct = prodctresult.getTextOfFirstProduct();
		// Assert.assertTrue(prodctdetails.verifyOnlySelectedProductOpensInTheProductDisplayPage(getNameOfFirstProduct));

	}

	public void addTheProductToBag() {

		prodctdetails.Add_To_Bag();
	}

	public void pickUpInAStore(String zip) {
		prodctdetails.pickUpInAStore(zip);
	}

	public void checkoutTheProductFromBag() {
		shopngbagpage.checkoutTheProductFromBag();
	}

	// public void selectchekoutasguestbutton() {
	// shopngbagpage.select_chekout_as_guest_button();
	// }

	public void selectViewShoppingBag() {
		// try{
		shopngbagpage.select_view_shopping_bag();
		// }
		// catch(Exception e){
		// shopngbagpage.hover_At_shoping_Bag();
		// shopngbagpage.select_view_shopping_bag();
		// }
		// for(int i = 0; i<2; i++){
		// if(shopngbagpage.currentUrl().contains("cart")){
		// break;
		// }
		// else{
		// shopngbagpage.hover_At_shoping_Bag();
		// shopngbagpage.select_view_shopping_bag();
		// }
		// }

	}

	public void select_View_Shopping_Bag_For_Android() {
		shopngbagpage.selectViewShoppingBagForAndroid();
	}

	public void selectCheckoutWithPaypal() {
		cartpage.select_Checkout_with_Paypal();
	}

	public void shipingTheProduct() {
		shipngpage.productShipping();
	}

	public void enterShipingDetails(String name, String lname, String address, String country, String zipcode,
			String city, String phno) {
		shipngpage.enterShipingDetails(name, lname, address, country, zipcode, city, phno);
	}

	public void enterBillingDetails(String name, String lname, String address, String country, String zipcode,
			String phno) {
		shipngpage.enterBillingDetails(name, lname, address, country, zipcode, phno);
	}

	public void makePaymentFromMasterCard(String card, String security, String email_id) {
		paymentpage.user_enter_card_number(card);
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(security, email_id);
		paymentpage.user_submit_payment();
	}

	public void makePaymentFromCreditCardUK(String card, String security, String email_id) {
		paymentpage.user_enter_card_number(card);
		paymentpage.user_select_card_expiry_month_and_year_uk();
		paymentpage.user_enter_securitycode_and_emailid(security, email_id);
		paymentpage.user_submit_payment();
	}

	public void placedOrder() {
		ordereviewpage.click_on_place_order();
	}

	public void makePaymentUsingCoachGifts(String card_no, String card_pin, String email_id) {
		paymentpage.user_enter_gift_card_number(card_no, card_pin);
		paymentpage.user_enter_emailid(email_id);
		paymentpage.user_submit_payment();

	}

	public void makePaymentUsingPayPal(String email, String password) {

		String currentwindow = driver.getWindowHandle();
		paymentpage.switchToNewWindow();
		paymentpage.waitForLoad();
		paymentpage.switchToFrame("injectedUl");
		// paymentpage.user_enter_pay_pal_password_and_enter_submit(email,password);
		// paymentpage.switchToDefaultContent();
		// paymentpage.verifyErrormessage();
		// paymentpage.switchToFrame("injectedUl");
		paymentpage.user_enter_pay_pal_password_and_enter_submit(email, password);
		paymentpage.user_press_pay_pal_continue_button(currentwindow);
	}

	public void verifyLandingPage() {
		landingPage.verifyLandingPage();
		// homeheader.verifyLogo();
	}

	public void verifySearchDisplayed() {
		search.verifySearchDisplayed();
	}

	public void verifyFooterSection() {
		footer.verifyFooterSection();

	}

	public void verifyLinksOfFooter() {
		footer.verifyFooterLinks();

	}

	public void verifyTopNavigationBar() {
		topBanner.verifyTopNavigationBar();
	}

	public void verifyConnectWithCoachFunctionality(String Username) {
		footer.connectWithCoachByEnteringEmailInFooter(Username);
	}

	public void mobile_verifyConnectWithCoachFunctionality(String Username) throws InterruptedException {
		footer.mobile_connectWithCoachByEnteringEmailInFooter(Username);
	}

	public void navigate_To_Registeration_Page_From_Landing_Page() {
		topBanner.clickOnSignINRegister();
	}

	public void verifyUserAccountMenuTabOptions() {
		topBanner.verifyAccountMenuTabOptions();
	}

	public void registerANewUserBySkippingTheShippingDetails() {
		accountPage.clickOnRegisterButton();
		accountPage.enterRegisterInformation();
	}

	public void removeTheProductFromBag() {
		shopngbagpage.clicked_On_Remove();
	}

	public void footerLinkNavigationPage() {
		footer.navigationToLinkPage();
	}

	public void hoverAtHeaderLinks() {

		homeheader.hoverAtWomenLink();
		homeheader.hoverAtmenLink();
		// homeheader.hoverAtbagLink();
		homeheader.hoverAtcoach1941Link();
		// homeheader.hoverAtworlsofcoachLink();
		homeheader.hoverAtgiftsLink();
		// homeheader.hoverAtsaleLink();
		homeheader.hoverAtNewLink();
		homeheader.hoverAtPersonalizeLink();

	}

	public void mobileVerifyBurgerLinks() {
		homeheader.VerifyBurgerElements();

	}

	public void scrollDownToBottom() {
		landingPage.scrollDownToBottom();
	}

	public void backToTopByTopButton() {
		shopngbagpage.scrollBackToTop();

	}

	public void goToStoreLocatorPageFromFooter() {
		footer.goToStoreLocatorPageFromFooter();
	}

	public void verifyStorePage() {
		storeLocator.verifyStoreLocatorPage();

	}

	public void searchStoreUsingZipCode(String zipcode) {
		storeLocator.searchStoreUsingZipCode(zipcode);

	}

	public void makePaymentUsingcards(String card, String security, String email_id) {
		paymentpage.user_enter_card_number(card);
		paymentpage.user_select_card_expiry_month_and_year_uk();
		paymentpage.user_enter_securitycode_and_emailid(security, email_id);
		paymentpage.user_submit_payment();
	}

	public void verifyCorporateResponsibilityLinkPage() {
		footer.verifyCorporateResponsibilityLinkPage();
	}

	public void verifyproductDisplayPageDetails(String product) {
		// prodctdetails.verifyProductQuantity();
		prodctdetails.verifyProductName();
		prodctdetails.verifyBacktoResultPage();
		prodctresult.verifySearchResult(product);

	}

	public void verifyAndNavigateToLinkAddAMonogram() {
		prodctdetails.verifyAndNavigateToLinkAddAMonogram();

	}

	public void addAMonogramPage() {
		monogramPage.createMonogram();

	}

	public void removeMonoGram() {
		monogramPage.removeMonoGram();

	}

	public void editMonoGram() {
		monogramPage.editMonoGram();
	}

	public void addToBagFromMonogram() {
		monogramPage.addToBagFromMonogram();

	}

	public void verifyContactUsFunctionality(String country, String firstName, String lastName, String email) {
		footer.clickOnContactUsLink(country);
		customerCarePage.verifyContactUsLinkForm(firstName, lastName, email);

	}

	public void selectPaymentMethodAsPaypala(String email) {
		paymentpage.select_paypal_radio_button();
		paymentpage.user_enter_email_id_and_confirm_id(email);
		paymentpage.user_submit_payment();
	}

	public void verifyProductDescription() {
		prodctdetails.verifySelectedProductDescription();
	}

	public void verifyProductImageAndClickedOnZoom() {
		prodctdetails.verifySelectedProductImageAndClickedOnZoom();
	}

	public void verifylayout() {
		topBanner.verifyLayout();
	}

	public void verifyProductDescriptionOnCartPAge() {
		cartpage.verifySelectedProduct();
	}

	public void verifyMonogramAttributes() {
		monogramPage.verifyMonogramAttributes();
	}

	public void verifyProductTotal() {

		Assert.assertTrue(cartpage.verifyTotal());

	}

	public void verifyTax() {
		Assert.assertTrue(cartpage.verifyEstimatedTax());
	}

	public void verifyOtherElementsInTheCartPage() {

		cartpage.verifyCartPage();
	}

	public void verifyPickupInStore(String zip) {

		cartpage.verifyBopusProduct(zip);

	}

	public void verifyRemoveProductFromCartPage() {

		cartpage.verifyRemoveProduct();
	}

	public void checkOutAndProceed() {

		cartpage.selectCheckoutAndProceed();
	}

	public void userGoesToAccountSettingsPage() {
		topBanner.goToAccountSettingsPage();
	}

	public void editNameinAccountSetting(String existin_password) {
		accountPage.editNameAccountInformation(existin_password);
	}

	public void editAddressInAccountSettings() {
		accountPage.goToAddressBook();
		accountPage.editAddressInAccountSettings();
	}

	public void NavigateToquickShop() {
		// prodctresult.handle_DontMissOutWindow();
		prodctresult.NavigateToquickShop();
	}

	public void deleteSavedCard() {
		accountPage.goToSavedCreditCardsPage();
		accountPage.deleteSavedCard();
	}

	public void verifyQuickShopPageAndAddToBag() {
		quickbuy.verifyQuickShopPageAndAddToBag();

	}

	public void verifyAddAGiftMessageFunctionality() {
		cartpage.scrollWindow(0, 200);
		cartpage.verifyAddAGiftMessage("}");
		cartpage.verifyErrorMessage();
		// cartpage.removeGiftMessage();
		cartpage.verifyAddAGiftMessage("abcd");
		cartpage.clickOnMessageSave();
		// cartpage.verifyPriview();
	}

	public void navigateToFooterGiftCardsLink() {
		footer.navigateToFooterGiftCardsLink();

	}

	public void purchaseGiftCard() {
		giftCard.purchaseGiftCard();

	}
	
	public void CheckYourBalance(String giftcardNumber,String pinNumber){
	   giftCard.CheckYourBalance(giftcardNumber, pinNumber);

	}

	public void saveCard(String carno, String cvv) {
		accountPage.goToSavedCreditCardsPage();
		accountPage.saveCard(carno, cvv);
	}

	public void enterCvv(String cvv) {
		ordereviewpage.enterCvv(cvv);
	}

	public void continueShipping() {
		shipngpage.continueShipping();

	}

	public void makePaymentUsingCoachGiftsForPickUpInStore(String card_no, String card_pin) {
		paymentpage.user_enter_gift_card_number(card_no, card_pin);

	}

	public void enterEmailAndClickedOnContinue(String email_id) {
		paymentpage.user_enter_emailid(email_id);
		paymentpage.user_submit_payment();

	}

	public void mobile_clickOnAboutUsLink() {
		footer.mobile_clickOnAboutUsLinkMobile();

	}

	public void handleDontMissoutWindow() {
		prodctresult.handle_DontMissOutWindow();

	}

	public void handle_foreSeeSurvey() {
		prodctresult.handle_ForeSeeSurvey();
	}

	public void mobile_clickOnStoresAndSites() {
		footer.mobile_clickOnStoresAndSites();

	}

	public void mobile_clickOnCustomerCareLink() {
		footer.mobile_clickOnCustomerCareLink();

	}

	public void mobile_verifyFooterSection() {
		footer.mobile_verifyFooterSection();
	}

	public void mobile_clickOnProductInformation() {
		footer.mobile_clickOnProductInformation();
	}

	public void verifyWishListPopUp() {
		prodctdetails.closeWishlistPopup();
	}

	public void navigateToWishList() {
		topBanner.verifyMoveToWishList();
		wishlistpage.verifyProductOnWishlistPage();
	}

	public void addProductToWishList() {
		prodctdetails.addProductToWishlist();
	}

	public void deleteProductFromWishList() {
		wishlistpage.deleteProductFromWishList();

	}

	public void closeCrossCookieIcon() {
		topBanner.closeCrossCookieIcon();

	}

	public void selectPaymentMethodAsPayPalUK() {
		paymentpage.select_paypal_radio_button_uk();

	}

	public void continuePaypal() {
		paymentpage.continuePayPal();

	}

	public void orderReview() {
		ordereviewpage.orderReview();
	}

	public void clickOnPublicButton() {
		wishlistpage.clickOnPublicButton();
		// span[text()[normalize-space()='Your First Name']]

	}

	public void clickOnEmail_WhishList() {
		wishlistpage.clickOnEmail();
		wishlistpage.verifyEmail();
	}

	public void enterEmailDetails(String firstname, String lastname, String email) {
		wishlistpage.enterDetails(firstname, lastname, email);
	}

	public void checkSoldOutItems(String buttonName) {
		prodctresult.verifySoldOutItems();
		prodctresult.verifySoldOutItemInPDP(buttonName);
	}

	public void checkOnlineExclusiveItem(String itemName) {
		landingPage.verifyOnlineExclusiveItem(itemName);
	}

	public void verifyEmailIsSent() {
		wishlistpage.verifyEmailIsSent();
	}

	public void clickonwishlist() {
		wishlistpage.clickonwishlist();

	}

	public void verifyWishListdisplayed() {

		wishlistpage.verifyWishListdisplayed();

	}

	public void clickOnFindFriendWishListButton() {
		wishlistpage.clickOnFindFriendWishList();

	}

	public void verifyFindWishListPageDisplayed() {
		wishlistpage.verifyFindWishListPageDisplayed();

	}

	public void enterFriendEmailAndSearch() {
		wishlistpage.enterFriendEmailAndSearch();

	}

	public void verifyPrivateListNotDisplayed() {
		wishlistpage.verifyPrivateListNotDisplayed();

	}

	public void clickandVerifyMoveToWishList() {
		wishlistpage.clickandVerifyMoveToWishList();

	}

	public void closeWishListModal() {
		wishlistpage.closeWishListModal();

	}

	public void verifyaddbagcharm() {
		prodctresult.verifyaddbagcharm();

	}

	public void addbagCharmProductsDisplayed() {

		prodctresult.verifyAddBagCharmProductsDisplayed();
	}

	public void addbagCharmProductToBag() {
		prodctresult.addbagCharmProductToBag();

	}

	public void verifybagcharmisadded() {
		prodctresult.verifybagcharmisadded();

	}

	public void verifyYouMayAlsoLike() {
		prodctresult.verifyYouMayAlsoLike();

	}

	public void hoverOnYouMayAlsoLikeproducts() {
		prodctresult.hoverOnYouMayAlsoLikeproducts();
	}

	public void clickOnYouMayAlsoLikeproducts() {
		prodctresult.clickOnYouMayAlsoLikeproducts();

	}

	public void verifyProductIsDisplayedInPDP() {
		prodctresult.verifyProductIsDisplayedInPDP();
	}

	public void verifySearchText() {
		search.verifySearchText();

	}

	public void verifySuggestionAppearAfterEntering3Letters() {
		search.verifySuggestionAppearAfterEntering3Letters();

	}

	public void verifySearchNotDisplayed() {
		search.verifySearchNotDisplayed();

	}

	public void clickOnContactUsFunctionality(String country) {
		footer.clickOnContactUsLink(country);

	}

	public void verifyErrorMessage() {
		ordereviewpage.verifyErrorMessage();

	}

	public void addNewCreditCard() {
		shipngpage.addNewCreditCard();

	}

	public void saveNewCard(String carno, String cvv) {
		accountPage.saveNewCard(carno, cvv);

	}

	public void enterEmailAndContinue(String userName) {
		accountPage.enterEmailAndContinue(userName);

	}

	public void userGoesTosavedcreditcard() {
		accountPage.goToSavedCreditCardsPage();

	}

	public void delete_SavedCreditCard() {
		accountPage.delete_SavedCreditCard();

	}

	public void verifyPLPPageIsDisplayed(String term) {
		search.verifyPLPPageIsDisplayed(term);

	}

	public void noSearchResultPage() {
		search.noSearchResultPage();

	}

	public void AddMonogramProductToShoppingBag() {

		monogramPage.AddMonogramProductToShoppingBag();

	}

	public void verifyUserIsNotAbleToIncreaseQuantityOfMonogrammingProduct() {

		monogramPage.verifyUserIsNotAbleToIncreaseQuantityOfMonogrammingProduct();
	}

	public void verifyAddAGiftMessage() {
		cartpage.verifyAddAGiftMessage("hello");
		cartpage.clickOnMessageSave();

	}

	public void verifyPriview() {
		cartpage.verifyPriview();

	}

	public void verifyLabelsInShoppingBag() {
		shopngbagpage.verifyLabelsInShoppingBag();

	}

	public void addSizeableProductToShoppingBag() {
		shopngbagpage.addSizeableProductToShoppingBag();

	}

	public void increaseQuantityOfProduct() {
		shopngbagpage.increaseQuantityOfProduct();

	}

	public void decreaseQuantityOfProduct() {
		shopngbagpage.decreaseQuantityOfProduct();

	}

	public void verifyPromoCodeAndApplyNowLabels() {
		shopngbagpage.verifyPromoCodeAndApplyNowLabels();
	}

	public void clickOnApplyLinkAndVerify() {
		shopngbagpage.clickOnApplyLinkAndVerify();

	}

	public void verifySubProductTotal() {
		shopngbagpage.verifySubProductTotal();

	}

	public void verifyLabelsInShoppingBagMobile() {
		shopngbagpage.verifyLabelsInShoppingBagMobile();

	}

	public void verifyPriceGreaterThanZero() {
		prodctdetails.verifyPriceGreaterThanZero();

	}

	public void verifyInnerImageAndCurrentImageOfTheProductWithName() {
		prodctdetails.verifyCurrentImageAndFullViewImage();

	}

	public void verifyLablesInPDPPage() {
		prodctdetails.verifyLablesInPDPPage();

	}

	public void verifyIconsAndSizeChart() {
		prodctdetails.verifyIconsAndSizeChart();

	}

	public void searchProductfromHeader() {
		prodctresult.searchProductfromHeader();
	}

	public void clickandVerifySortByForPriceLowToHigh() {
		prodctresult.clickandVerifySortByForPriceLowToHigh();

	}

	public void clickandVerifySortByForPriceHighToLow() {
		prodctresult.clickandVerifySortByForPriceHighToLow();

	}

	public void verifyImage() {
		prodctresult.verifyImageIsPresentOrNotInShopGridTilesPLP();

	}

	public void selectAny1941ShopsForWomen() {
		prodctresult.selectAny1941ShopsForWomen();

	}

	public void clickAndVerifyFilterBy() {
		prodctresult.clickAndVerifyFilterBy();

	}

	public void selectAnyNon1941ShopsForWomen() {
		prodctresult.selectAnyNon1941ShopsForWomen();

	}

	public void selectViewAllForBagsForWomen() {
		prodctresult.selectViewAllForBagsForWomen();

	}

	public void verifyBradCrumAndSwiperContainer() {
		prodctdetails.verifyBradCrumAndSwiperContainer();

	}

	public void clickOnImage() {
		prodctresult.clickOnImage();

	}

	public void verifyPlpOfCategoryPages(String finalCount) {
		prodctresult.verifyPlpOfCategoryPages(finalCount);

	}

	public void verifyGiftCardAdded() {
		paymentpage.verifyGiftCardAdded();

	}

	public void removeGiftCard() {
		paymentpage.removeGiftCard();

	}

	public void user_Enter_Gift_Details(String card_no, String cardpin) {

		paymentpage.user_enter_gift_card_number(card_no, cardpin);

	}

	public void clickOnWishListFromHeader() {

		search.clickOnWishListFromHeader();

	}

	public void navigateToAccountPageFromWishListPage() {

		search.navigateToAccountPageFromWishListPage();
	}

	public void verifyFindAStoreLinkIsPresentAtTopOfHomePage() {
		homeheader.verifyFindAStoreLinkIsPresentAtTopOfHomePage();
	}

	public void clickOnFindAStoreLink() {
		homeheader.ClickOnFindAStoreLink();

	}

	public void verifyStoreLocatorTitle() {
		storeLocator.verifyStoreLocatorTitle();

	}

	public void verifyQuickBuyOptionForCrossSellersInShoppingBagPage() {
		shopngbagpage.verifyQuickBuyOptionForCrossSellersInShoppingBagPage();

	}

	public void clickOnBagsFromCoach1941() {
		prodctresult.clickOnBagsFromCoach1941();

	}

	public void verifyPriceRangeIsDisplayedRed() {
		prodctresult.verifyPriceRangeIsDisplayedRed();

	}

	public void verifyGiftCardPaymentMethodIsNotDisplaedOnBillingPage() {
		paymentpage.verifyGiftCardPaymentMethodIsNotDisplaedOnBillingPage();

	}

	public void verify_404_page() {
		landingPage.verify_404_page();

	}

	public void verifyGiftMessageErrorMessage() {
		cartpage.verifyGiftMessageErrorMessage();

	}

	public void verifySizeDropDwonIsNotDisplayed() {
		prodctdetails.verifySizeDropDwonIsNotDisplayed();
	}

	public void verify_First_LastNameLimit_Is_30() {
		accountPage.verify_First_LastNameLimit_Is_30();
	}

	public void clickOnEmailLink() {
		wishlistpage.clickOnEmailLink();

	}

	public void clickOnBurgerButtonForMenu() {
		accountPage.clickOnBurgerButtonForMenu();

	}

	public void clickOnRegisterANewUserForMobile(String zipcode, String city, String phone) {
		accountPage.enterRegisterInformation();
		accountPage.enterAddressInformationAfterSignUp(zipcode, city, phone);

	}

	public void clickandVerifySortByForJustAdded() {
		prodctresult.clickandVerifySortByForJustAdded();

	}

	public void clickandVerifySortByForBestseller() {
		prodctresult.clickandVerifySortByForBestseller();

	}

	public void enterEmailAFriendInformation() {
		wishlistpage.enterEmailAFriendInformation();

	}

	public void change_Shipping_Method(String name, String lname, String address, String country, String zipcode,
			String city, String phno) {
		shipngpage.change_Shipping_Method(name, lname, address, country, zipcode, city, phno);

	}

	public void clickOnWomenTab() {
		homeheader.clickOnWomenTab();
		homeheader.clickOnWomenBag();

	}

	public void verifyMoreButton() throws InterruptedException {
		prodctresult.verifyMoreButton();

	}

	public void makePaymentUsingGiftCard(String card_no, String card_pin, String email_id) {
		paymentpage.user_enter_gift_card_number(card_no, card_pin);
		paymentpage.user_enter_emailid(email_id);

	}

	public void selectSizeOfTheProduct(String size) {
		prodctdetails.selectSizeOfTheProduct(size);

	}

	public void verifyOptInCheckBoxIsDefaultSelected() throws InterruptedException {
		paymentpage.verifyOptInCheckBoxIsDefaultSelected();

	}

	public void verify_EasyTrackOrdersUnderCreateAnAccount() {
		paymentpage.verify_EasyTrackOrdersUnderCreateAnAccount();

	}

	public void verify_WhatIsThisIconInPaymentPage() {
		paymentpage.verify_WhatIsThisIconInPaymentPage();

	}

	public void verifySaveThisCC_BelowCreateAnAccount() throws InterruptedException {
		paymentpage.verifySaveThisCC_BelowCreateAnAccount();

	}

	public void verify_ThisIsTheBillingInformationStatementIsRemovedBelowBillingAddress() throws InterruptedException {
		paymentpage.verify_ThisIsTheBillingInformationStatementIsRemovedBelowBillingAddress();

	}

	public void verifyObtinCheckboxMessage() throws InterruptedException {
		accountPage.verifyObtinCheckboxMessage();

	}

	public void clickOnNotifyMe() {
		prodctdetails.clickOnNotifyMe();

	}

	public void mobile_SignIn(String userName, String password) {
		accountPage.mobile_loginWithRegisteredUser(userName, password);

	}

	public void italy_verifyObtinCheckboxMessage() throws InterruptedException {
		accountPage.italy_verifyObtinCheckboxMessage();

	}

	public void italy_VerifyObtInMessageAtFooter() throws InterruptedException {
		footer.italy_VerifyObtInMessageAtFooter();

	}

	public void verify_UserIsAbleToChangeTheLanguageFromFooter() {
		footer.verify_UserIsAbleToChangeTheLanguageFromFooter();

	}

	public void verifyCountryDropdown() {
		footer.verifyCountryDropdown();

	}

	public void verify_FilterContainerIsDisplayed() throws InterruptedException {
		prodctresult.verify_FilterContainerIsDisplayed();

	}

	public String verify_ProductColorVarientsArePresent() throws InterruptedException {
		String color = prodctdetails.verify_ProductColorVarientsArePresent();
		return color;

	}

	public void verify_MultipleColorVarientsAreNotPresentInAddAMonogramWindow(String color)
			throws InterruptedException {
		monogramPage.verify_MultipleColorVarientsAreNotPresentInAddAMonogramWindow(color);

	}

	public void clickOnAddAMonogram() {
		monogramPage.clickOnAddAMonogram();

	}

	public void changeTheCountryFromFooter() {
		footer.changeTheCountryFromFooter();

	}

	public void clickOnShoppingBagIcon() {
		topBanner.clickOnShoppingBagIcon();

	}

	public void verifyShippingAddressIsOfChangedCountry() {
		paymentpage.verifyShippingAddressIsOfChangedCountry();

	}

	public void mobile_loginAsRegisteredUser(String userName, String password) {
		topBanner.mobile_clickOnSignINRegister().mobile_loginWithRegisteredUser(userName, password);

	}

	public void verifyMonogrammingPage() throws InterruptedException {
		monogramPage.verifyMonogrammingPage();

	}

	public void verifyUserOnAccountPage() {
		accountPage.verifyUserOnAccountPage();
	}

	public void verify_LazyLoadingOnSearchResultPage() {
		prodctresult.verify_LazyLoadingOnSearchResultPage();

	}

	public void ClickOnAccountSetting() {
		accountPage.clickOnAccountSetting();

	}

	public void VerifyUserOnAccountEditPage() {
		accountPage.verifyUserOnAccountEditPage();

	}

	public void verifyUserCanViewaccountInfo() {
		accountPage.verifyUserCanViewaccountInfo();

	}

	public void clickOnAccountIconFromHeader() {
		landingPage.clickOnAccountIconFromHeader();

	}

	public void clickonwishlistIconFromAccountPage() {
		accountPage.clickonwishlistIconFromAccountPage();
	}

	public void verify_COACH_LogoRedirectsToHomepage() {
		topBanner.verify_COACH_LogoRedirectsToHomepage();

	}

	public void verifyProductOnWishlistPage() {
		wishlistpage.verifyProductOnWishlistPage();

	}

	public void clickOnCancelLinkOnPayPalWindowAndverifyClickingCancelOfPaypalWindowUserIsNavigatedBackToBillingPage() {
		String currentwindow = driver.getWindowHandle();
		paymentpage.switchToNewWindow();
		paymentpage.waitForLoad();
		paymentpage.verifyErrorMessageisDisplayedAfterenterninginvalidcredentials("abc");
		paymentpage.clickOnCancelLinkOnPayPalWindow();
		paymentpage.verifyClickingCancelOfPaypalWindowUserIsNavigatedBackToBillingPage();

	}

	public void verify_UserIsNotAbleToToggleBetweenLangAndCountryAtCheckoutPage() {
		paymentpage.verify_UserIsNotAbleToToggleBetweenLangAndCountryAtCheckoutPage();

	}

	public void verify_UserIsRedirectedToHomepageOnChangingTheLanguage() {
		homeheader.verify_UserIsRedirectedToHomepageOnChangingTheLanguage();

	}

	public void VerifyFooterLinks() {
		footer.clickOnEveryFooterlements();

	}

	public void verify_SofortIconIsDisplayed() {
		paymentpage.verify_SofortIconIsDisplayed();

	}

	public void continueSofort() {
		paymentpage.continueSofort();

	}

	public void increaseQuantityOfProductPDPpage(String quantity) {
		prodctdetails.increaseQuantityOfProductPDPpage(quantity);

	}

	public void clickOnUnsubscribeLink() {
		accountPage.clickOnUnsubscribeLink();

	}

	public void unsubscribeEmail(String Email) {
		accountPage.unsubscribeEmail(Email);

	}

	public void verifyUserhasUnsubscribed() {
		accountPage.verifyUserhasUnsubscribed();

	}

	public void verifyUtilityNavigationDropdown() {
		landingPage.verifyUtilityNavigationDropdown();
	}

	public void addAnotherCard() {
		paymentpage.addAnotherCard();

	}

	public void verify_InvalidCVV(String card, String security, String email_id) {
		paymentpage.user_enter_card_number(card);
		paymentpage.user_select_card_expiry_month_and_year_uk();
		paymentpage.user_enter_invalid_securitycode_and_emailid(security, email_id);
		paymentpage.user_submit_payment();
		paymentpage.verify_InvalidCVV();

	}

	public void verifyGiftCardIsRemoved() {
		paymentpage.verifyGiftCardIsRemoved();

	}

	public void clickOnGiftCard() {
		footer.clickOnGiftCard();
		giftCard.clickOnPurchaseAGiftCard();
	}

	public void enterGiftCardAmount() {
		giftCard.enterGiftCardAmount();

	}

	public void addTheGiftCardToBag() {
		giftCard.addTheGiftCardToBag();

	}

	public void verifyGifCardErrorMessage() {
		giftCard.verifyGifCardErrorMessage();

	}

	public void makePaymentUsingCoachGiftCard(String card_no, String card_pin, String email_id) {
		paymentpage.user_enter_gift_card_number(card_no, card_pin);

	}

	public void verifyArrowsForScrollFunctionalityForMiniCart() {
		prodctdetails.verifyArrowsForScrollFunctionalityForMiniCart();

	}

	public void verifyPDPForNotifyLink(String email) {
		prodctdetails.verifyPDPForNotifyLink(email);

	}

	public void verifySignInSectionOnShippingDetailPage() {
		shipngpage.verifySignInSectionOnShippingDetailPage();

	}

	public String createAccountFromPaymentPage(String cardnumber, String securitycode, String password) {
		paymentpage.user_enter_card_number(cardnumber);
		paymentpage.user_select_card_expiry_month_and_year_uk();
		String username = paymentpage.entersecuritycodeandNewUsername(securitycode, password);
		paymentpage.user_submit_payment();
		return username;

	}

	public void removeTheProductFromWishlist() {
		wishlistpage.removeTheProductFromWishlist();

	}

	public void verifyErrorMessageIsdisplayedWhenEnteringInvalidCredentialsForPaypal() {
		paymentpage.verifyErrorMessageIsdisplayedWhenEnteringInvalidCredentialsForPaypal();

	}

	public void signInFromShippingpage(String username, String password) {
		shipngpage.signInFromShippingPage(username, password);

	}

	public void clickOnShippingTab() {
		shipngpage.clickOnShippingTab();

	}

	public void verifyAddressIsChanged(String address) {
		paymentpage.verifyAddressIsChanged(address);

	}

	public void VerifyForgotPasswordLinkFromSignInpage() {
		shipngpage.clickOnForgotPasswordLink();
		shipngpage.verifypasswordLink();

	}

	public void verifyUserCannotSignFromInValidUsername() {
		shipngpage.verifyUserCannotSignFromInValidUsername();
	}

	public void verifyUserIsAbleToSignIn() {
		shipngpage.verifyUserIsAbleToSignIn();

	}

	public void verifyAddressVerificationUPSServer() {
		shipngpage.verifyAddressVerificationUPSServer();

	}

	public void verifyWalletGuideForMen() {
		homeheader.hoverAtmenLink();
		homeheader.verifyWalletGuideForMen();
	}

	public void clickOnWalletGuideFormen() {
		homeheader.clickOnWalletGuideFormen();
		homeheader.verifyWalletGuideShopForMenDisplayed();

	}

	public void clickOnFindYourPerfectWallet() {
		landingPage.clickOnFindYourPerfectWallet();

	}

	public void verifyFindYourPerfectWallet() {
		landingPage.verifyFindYourPerfectWallet();
		landingPage.verifyFiltersForFindYourPerfectWallet();
		landingPage.clickOnAnyFilterForPerfectWallet();
		landingPage.verifyResultsButton();

	}

	public void clickOnClearAllOnFindYourperfectwalletSection() {
		landingPage.clickOnClearAllOnFindYourperfectwalletSection();

	}

	public void closePerfectWalletSection() {
		landingPage.closePerfectWalletSection();

	}

	public void clickOnBackButtonFromBrowser() {
		paymentpage.clickOnBackButtonFromBrowser();

	}

	public void clickOnComplimentaryGiftBoxCheckbox() {
		cartpage.clickOnComplimentaryGiftBoxCheckbox();
		cartpage.verifyComplimentaryGiftBoxCheckBoxIsChecked();

	}

	public void addGiftMessageInProduct2() throws InterruptedException {
		cartpage.addGiftMessageInProduct2();

	}

	public void verifyWalletGuideForWomen() {
		homeheader.hoverAtWomenLink();
		homeheader.verifyWalletGuideForWomen();
	}

	public void clickOnWalletGuideForWomen() {
		homeheader.clickOnWalletGuideForWomen();
		homeheader.verifyWalletGuideShopForMenDisplayed();

	}

	public void verifyConnectWithCoachFunctionalityUK(String Username) {
		footer.connectWithCoachByEnteringEmailInFooterUK(Username);

	}

	public void verifyPriceFromat(String country) {
		prodctdetails.verifyPriceFromat(country);

	}

	public void verifyNocallToUPSServerForPerfectMatchEntered() {
		shipngpage.verifyNocallToUPSServerForPerfectMatchEntered();

	}

	public void giftCardNotDisplayedOnShippingPageForEU() {

		paymentpage.giftCardNotDisplayedOnShippingPageForEU();
	}

	public void linkGiftCardNotDisplayedOnOrderReviewPage() {
		paymentpage.linkGiftCardNotDisplayedOnOrderReviewPage();
	}

	public void verify_InvalidEmailOnShippingPage() {
		shipngpage.verify_InvalidEmailOnShippingPage();

	}

	public void verify_ValidEmailOnShippingPage() {
		shipngpage.verify_ValidEmailOnShippingPage();

	}

	public void verify_InvalidParameterPassedInURLPage() {
		landingPage.verify_InvalidParameterPassedInURLPage();

	}

	public void verifyWalletcategories() {
		landingPage.verifyWalletcategories();

	}

	public void verifyShopGridForCategorySelected() {
		String category = landingPage.clickOnAnyCategoryForWalletsForMen();
		landingPage.verifyShopGridForCategorySelected(category);

	}

	public void verifyShopGridPage() {
		landingPage.verifyShopGridIsVisible();
	}

	public void verifyMobileStorePage() {
		storeLocator.verifyMobileStorePage();
	}

	public void verifyShopGridForCategoryIsDeSelected() {
		String category = landingPage.clickOnAnyCategoryForWalletsForMen();
		landingPage.verifyShopGridForCategoryIsDeSelected();

	}

	public void checkShopGridCategory(String pageTitle1, String categoryBanner, String selectedCategory1) {
		landingPage.verifyShopGridCategoryBannerAndTitle(pageTitle1, categoryBanner);
		landingPage.checkSelectedCategory(selectedCategory1);
	}

	public void verifyShopGridForCategorySelectedForWomen() {
		String category = landingPage.clickOnAnyCategoryForWalletsForWomen();
		landingPage.verifyShopGridForCategorySelected(category);
	}

	public void verifyShopGridForCategoryIsDeSelectedForWomen() {
		String category = landingPage.clickOnAnyCategoryForWalletsForWomen();
		landingPage.verifyShopGridForCategoryIsDeSelected();
	}

	public void verifyGenderFieldOnAccountPage() {
		accountPage.verifyGenderFieldOnAccountPage();

	}

	public void verifySignInSectionOnShippingDetailPageForMobile() {
		shipngpage.verifySignInSectionOnShippingDetailPageForMobile();

	}

	public void clickOnGiftBoxForProduct1() {
		cartpage.clickOnGiftBoxForProduct1();
	}

	public void verify_wishlistOptionInMenu() {
		homeheader.verify_wishlistOptionInMenu();
	}

	public void addGiftBoxForProduct1AndGiftMessageForProduct2() {
		cartpage.addGiftMessageInProduct2();
		cartpage.clickOnMessageSave();
		cartpage.clickOnGiftBoxForProduct1();

	}

	public void verifyMobile_FilterContainerIsDisplayed() {
		prodctresult.verifyMobile_FilterContainerIsDisplayed();

	}

	public void addGiftBoxAndGiftMessageOnProduct2() {
		cartpage.addGiftBoxAndGiftMessageOnProduct2();

	}

	public void enterInvalidEmailInPayPal() {
		String currentwindow = driver.getWindowHandle();
		paymentpage.switchToNewWindow();
		paymentpage.waitForLoad();
		paymentpage.switchToFrame("injectedUl");
		paymentpage.user_enter_invalid_credentials("abc@qa.com", "123");

	}

	public void verifyShopGridFilter() {
		landingPage.verifyFilterCategory();
	}

	public void verifyEnteredDataOnShippingPageIsNotChangedIfNoAddressIsSavedInUserAddressBook() {
		paymentpage.verifyEnteredDataOnShippingPageIsNotChangedIfNoAddressIsSavedInUserAddressBook();

	}

	public void navigateBackToShippingPage() {
		shipngpage.navigateBackToShippingPage();

	}

	public void enterEmailId(String username) {
		paymentpage.enterEmailId(username);

	}

	public void verifyUserOnMTOPage() {
		mto.verifyUserOnMTOPage();

	}

	public void verifyUserOnBagcustomizationPage() {
		mto.verifyUserOnBagcustomizationPage();

	}

	public void selectBagSize() {
		mto.selectBagSize();

	}

	public void selectLeatherType(String leatherType) {

		mto.selectLeatherType(leatherType);
	}

	public void selectColor(String color) {
		mto.selectColor(color);

	}

	public void selectMaterial(String material) {
		mto.selectMaterial(material);

	}

	public void selectMetalType(String metal) {
		mto.selectMetalType(metal);

	}

	public void addMonogramToDesignedBag() {
		mto.addMonogramToDesignedBag();

	}

	public void saveDesignedBag() {
		mto.saveDesignedBag();

	}

	public void fillContactDetailsForDesignedBag(String fname, String lname, String email) {
		mto.fillContactDetailsForDesignedBag(fname, lname, email);

	}

	public void clickMakeABagButton() {
		mto.clickMakeABagButton();

	}

	public void checkDetailsOfBagOnThankYouPage(String bodycolour, String bodyleathertype, String handleleathertype,
			String handlecolor, String strapcolor, String liningcolor, String metaltype) {
		mto.checkDetailsOfBagOnThankYouPage(bodycolour, bodyleathertype, handleleathertype, handlecolor, strapcolor,
				liningcolor, metaltype);

	}

	public void clickOnClearAll() {
		mto.clickOnClearAll();

	}

	public void verifyClearButtonIsClicked() {
		mto.verifyClearButtonIsClicked();

	}

	public void clickOnViewInterior() {
		mto.clickOnViewInterior();
	}

	public void verifyViewIsChangedToInterior() {
		mto.verifyViewIsChangedToInterior();

	}

	public void clickOnChangeBagSize() {
		mto.clickOnChangeBagSize();

	}

	public void verifyGCIsPersistedEvenAfterUserNavigateBackToShippingPage() {
		paymentpage.verifyGCIsPersistedEvenAfterUserNavigateBackToShippingPage();

	}

	public void goToAddressBook() {
		accountPage.goToAddressBook();

	}

	public void clickOnAddANewAddress() {
		accountPage.clickOnAddANewAddress();

	}

	public void enterShippingAddress(String zipcode, String city, String phone) {
		accountPage.enterShippingAddress(zipcode, city, phone);

	}

	public void verifyQuickBuyForPreorderProduct(String productMessageType) {
		prodctresult.verifyQuickBuyForPreorderProduct(productMessageType);

	}

	public void verifyShoppingBagePageForProductType(String type) {
		shopngbagpage.verifyShoppingBagePageForProductType(type);

	}

	public void verifyProductNameInShopGrid() {
		prodctresult.verifyProductNameInShopGrid();

	}

	public void verifyProductNameInQuickBuy() {
		quickbuy.verifyProductNameInQuickBuy();

	}

	public void verifyProductNameIsDisplayedInPDPAndMiniCart() {
		prodctdetails.verifyProductNameIsDisplayedInPDPAndMiniCart();

	}

	public void validateProductName() {
		paymentpage.validateProductName();

	}

	public void verifyWishlistIcon() {
		prodctresult.verifyWishlistIcon();

	}

	public void addProductToBagFromshopGridForaParticularProductType(String type) {
		prodctresult.addProductToBagFromshopGridForaParticularProductType(type);

	}

	public void verifyCoach1941TextOnAllProduct(String type) {
		prodctresult.verifyCoach1941TextOnAllProduct(type);

	}

	public void verifyQuickBuyForBackOrderProduct(String type) {
		prodctresult.verifyQuickBuyForBackOrderProduct(type);

	}

	public void verifyProductsAddedInCart() {
		cartpage.verifyProductsAddedInCart();
	}

	public void enterNewShipingDetails() {
		shipngpage.enterNewShipingDetails();

	}

	public void verifyCurrentEnteredAddress() {
		paymentpage.verifyCurrentEnteredAddress();

	}

	public void loginFromShippingPage(String username, String password) {
		shipngpage.loginFromShippingPage(username, password);
	}

	public void verifyAddressAfterAndBeforeLoginAreSame() {
		paymentpage.verifyAddressAfterAndBeforeLoginAreSame();

	}

	public void verifyAddressIsNotMarkedPrimary() {
		accountPage.verifyAddressIsNotMarkedPrimary();

	}

	public void selectAndVerifyProductWithLessThan8ColorSwatches(String productname) {
		prodctresult.selectAndVerifyProductWithLessThan8ColorSwatches(productname);

	}

	public void selectAndVerifyProductWithMoreThan8ColorSwatches(String productname) {
		prodctresult.selectAndVerifyProductWithMoreThan8ColorSwatches(productname);
	}

	public void verify_PriceForFullPricedProduct() {
		prodctresult.Verify_PriceForFullPricedProduct();

	}

	public void verifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel() {
		prodctresult.verifyPriceForProductAtSaleAndMerchandizedAtDifferentLevel();

	}

	public void verifyPriceRangeIsInSaleWhenOneColorIsInSale(String productname) {
		prodctresult.verifyPriceRangeIsInSaleWhenOneColorIsInSale(productname);

	}

	public void verifyCheckoutButtonAtBottomShouldBesticky() {
		shopngbagpage.verifyCheckoutButtonAtBottomShouldBesticky();

	}

	public void verifyStampsAreWorking() {
		monogramPage.verifyStampsAreWorking();
	}

	public void verifyEnteredDataIsShownForUserHavingNoAddresSaved(String firstname, String lastname, String address) {
		paymentpage.verifyEnteredDataIsShownForUserHavingNoAddresSaved(firstname, lastname, address);

	}

	public void verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary() {
		paymentpage.verify_AddressIsPersistedEvenIfRegisteredUserHasSavedAddressButNotMarkedPrimary();
	}

	public void verifyPreOrderBagInCartPage() throws InterruptedException {
		cartpage.verifyPreOrderBagInCartPage();

	}

	public void changeTheBillingAddress(String name, String lname, String address, String country, String zipcode,
			String city, String phno) {
		paymentpage.changeTheBillingAddress(name, lname, address, country, zipcode, city, phno);

	}

	public void clickOnBillingAddressCheckbox() throws InterruptedException {
		paymentpage.clickOnBillingAddressCheckbox();

	}

	public void makePaymentUsingcardsForPayment(String card, String security, String email_id) {
		paymentpage.user_enter_card_number(card);
		paymentpage.user_select_card_expiry_month_and_year_uk();
		paymentpage.user_enter_securitycode_and_emailid(security, email_id);

	}

	public void verifyShippingAddressAndBillingAddressAreDifferent() {
		ordereviewpage.verifyShippingAddressAndBillingAddressAreDifferent();

	}

	public void verifyBackOrderBagInCartPage() {
		cartpage.verifyBackOrderBagInCartPage();

	}

	public void verifyQuickBuyPriceRange() {
		quickbuy.verifyQuickBuyPriceRange();

	}

	public void verifyLoginFromShippingPageDoesnotHaveRememberMeCheckbox() {
		shipngpage.verifyLoginFromShippingPageDoesnotHaveRememberMeCheckbox();
	}

	public void verifyAddAMonogramIsUpdatedToComplimentaryMonogram() {
		monogramPage.verifyAddAMonogramIsUpdatedToComplimentaryMonogram();

	}

	public void verifyPriceChange() {
		cartpage.verifyPriceChange();
	}

}
