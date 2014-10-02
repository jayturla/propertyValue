package myrp.library;

import java.util.HashMap;

public class ObjectReference {
    ReadXmlData rxml = new ReadXmlData();
    
	public HashMap list = new HashMap();
   
    // URLs
    public String prod_url = rxml.data("prod_url");
    public String local_url = rxml.data("local_url");
    public String dev_url = rxml.data("devtest_url");
    public String stage_url = rxml.data("stagetest_url");
    public String awsDev_url = rxml.data("awsDevTest_url");
    public String awsStage_url = rxml.data("awsStageTest_url");    
    

    public String domacom_stage_url = rxml.data("domacom_stage_url");
    public String domacom_prod_url = rxml.data("domacom_prod_url");
    public String domacom_dev_url = rxml.data("domacom_dev_url");
    
    public String resi_dev_url = rxml.data("resi_dev_url");
    public String resi_stage_url = rxml.data("resi_stage_url");
    
    // Logos
    public static String rpdataLogo_xp = "//img[@alt='myrpdata site logo']";
    public static String domacomLogo_xp = "//img[@src='/servlet/imageDisplay?fileName=pkg_img_domacom_logo.png']";
    
    // Header
    public static String login_button_xp = "//a[@class='buttonLogin']";
    public static String cart_button_xp = "//a[@id='cartCount']";
    public static String signup_button_xp = "//div/a[@href='/o/Registration/myrp-312']";
    
    // Login
    public static String username_xp = "//*[@id='userName']";
    public static String password_xp = "//*[@id='password']";
    //public static String loginButton_xp = "//input[@id='loginButton']";
    //public static String logoutButton_xp = "//a[@id='logoutButton']";
    public static String loginButton_xp = "//input[@name='loginButton']";
    public static String logoutButton_xp = "//div/a[@onclick='logoutCustomer();']";
    public static String loginErrorEmptyUsername_xp = "//div[contains(.,'Username field should not be empty.')]";
    public static String loginErrorEmptyPassword_xp = "//div[contains(.,'Password field should not be empty.')]";
    public static String loginErrorEmpty_xp = "//*[@id='errorMessage']";
    public static String loginErrorFail_xp = "//div[contains(.,'Invalid Username and/or Password, please try again.')]";
    
    // Search
    public static String search_xp = "//input[@id='singleLineSearch']";
    public static String search_button_xp = "//input[@id='searchButtonIcon']";
    public static String searchAddress_xp = "//h1/span[@itemprop='streetAddress']";
    public static String postcodeAddress_xp = "//span[@class='fontStyle17']/h1";
    public static String slas_xp = "/html/body/div[4]/ul/li";
    public static String homepage_header_xp = "//span/h1";
    
    // Banners
    public static String HubBanner_xp = "//div/a/img[@src='/cropImage/myrp.images.hub_i_banner.jpg']";
    public static String PropertyServicesBanner_xp = "//div/a/img[@src='/cropImage/myrp.images.myrp_rpproperty_services.jpg']";
    public static String CordellBannerPaid_xp = "//div/a/img[@src='/cropImage/myrp.images.myrp_cordellBannerPaid.jpg']";
    public static String CordellBannerFree_xp = "//div/a/img[@src='/cropImage/myrp.images.cordellBannerFree.jpg']";
    
    public static String reportInfo_xp = "//td[p]";
    public static String suburbMap_button_xp = "//td/a[@href='/map/nsw/manly/2095']";
    public static String keyStats_button_xp = "//td/a[@href='/stats/nsw/manly/2095']";
    public static String localExperts_button_xp = "//tr/td/a[@href='/local-experts/nsw/manly/2095']";
    public static String localExpertsAddress_xp = "//div[@id='searchResults']/h1";
    
    // Breadcrumb
    public static String breadcrumbText_xp = "//div/label[@class='keyword']";
    public static String breadcrumbLink1_xp = "//div[1]/a/span[@itemprop='title']";
    public static String breadcrumbLink2_xp = "//div[2]/a/span[@itemprop='title']";
    public static String breadcrumbLink3_xp = "//div[3]/a/span[@itemprop='title']";
    public static String breadcrumbLink4_xp = "//div[4]/a/span[@itemprop='title']";
    
    // Property Report 
    // Aerial Map
    public static String propertyAerialMap_button_xp = "//div/input[@name='aerialMap']";
    public static String propertyAerialMap_modal_xp = "//div[@id='cboxLoadedContent']/div/h2";
    public static String propertyAerialMap_closebtn_xp = "//div[@id='cboxClose']/img";
    public static String propertyAerialMap_photo_xp = "//div[@id='cboxLoadedContent']/div/div/img";
    
    // Property Details
    public static String propertyPhoto_xp = "//td/img[@alt='Property photo of 79 Darley Road Manly']";
    public static String propertyDetailedReport_label_xp = "//div[.='Detailed property report']";
    public static String propertyDPR_ShortDesc_xp = "//div/p[.='Provides an estimated value and full property sale and listing history.']";
    public static String propertyServicesBanner_xp = "//a/img[@src='/cropImage/myrp.images.hub_i_banner.jpg']";
    public static String propertyCordellBanner_xp = "//div/a/img[@src='/cropImage/myrp.images.cordellBannerFree.jpg']";
    public static String propertyRelatedSearches_label_xp = "//td/span[.='Related Searches']";
    public static String localExpertsAgentSites_label_xp = "//tbody/tr/td/span[.='Manly local experts']";
    
    public static String propertyDetailedReport_btn_xp = "(//*[@id='purchaseButton'])[1]";
    public static String propertyEstimatedReport_btn_xp = "(//*[@id='purchaseButton'])[2]";
    public static String propertyEstSubscription_btn_xp = "(//*[@id='purchaseButton'])[3]";
    public static String propertySalesHistory_btn_xp = "(//*[@id='purchaseButton'])[4]";
    public static String propertyDesktopVal_btn_xp = "(//*[@id='purchaseButton'])[5]";
    public static String propertyShortVal_btn_xp = "(//*[@id='purchaseButton'])[6]";
    public static String propertyLongVal_btn_xp = "(//*[@id='purchaseButton'])[7]";
    
    public static String propertyDetailedModal_xp = "//*[@id='cboxLoadedContent']";
    public static String modalCloseBtn_xp = "//*[@id='cboxClose']";
    
    // Reports and Services
    public static String footerReportsAndServices_link_xp = "//td/a[.='Reports and Services']";
    public static String reportsAndServices_label_xp = "//td/span[.='Reports and Services']";
    //public static String propertyValueHigh_xp = "//li/div/label[@class='high']";
    
    // Resi Home Loans
    public static String resiHeading_label_xp = "//div[@class='rp-wgt-heading']";
    public static String resiProperties_tab_xp = "//a[@href='/n/Home-Loans-Address-Search/myrp-1061?addressType=1']";
    public static String resiSuburbs_tab_xp = "//a[@href='/n/Home-Loans-Address-Search/myrp-1061?addressType=3']";
    public static String resi_Info_xp = "//div[@class='pure-u-2-5']";
    public static String resi_price_xp = "//div[2][contains(@class,'center')]";
    public static String resi_viewSampleReport_xp = "//a[contains(@class,'link')]";
    public static String resi_slas_xp = "//*[@id='singleLineSearchHomeLoanForm']";
    public static String resi_slas_text_xp = "//input[contains(@id,'singleLineSearchHomeLoan')]";
    public static String resi_slas_properties_xp = "//input[contains(@placeholder,'Enter property')]";
    public static String resi_slas_select_xp = "//div[@class='acResults']";
    public static String resi_footer_disclaimer_xp = "//a[contains(@href,'disclaimer')][.='Copyright & Disclaimers']";
    public static String resi_footer_terms_xp = "//a[contains(@href,'terms')][.='Terms & Conditions']";
    public static String resi_footer_policy_xp = "//a[contains(@href,'privacy')][.='Privacy Policy']";
    public static String resi_logo_xp = "//div[contains(@class,'rp-wgt-logo-resi')]";
    public static String resi_myrp_logo_xp = "//div[contains(@class,'rp-wgt-logo-myrp')]";
    public static String resi_searchbtn_xp = "//a[1][contains(@class,'primary')]";
    public static String resi_CFAbtn_xp = "//a[2]";
    public static String resi_address_label_xp = "//div[contains(@class,'rp-wgt-property-street')]";
    public static String resi_confidence_Icon_xp = "//span[contains(@class,'fa fa-circle rp-wgt-traffic')]";
    public static String resi_confidence_label_xp = "//div[3][contains(@class,'acenter')]";
    public static String resi_email_field_xp = "//input[@id='userEmail']";
    public static String resi_purchase_btn_xp = "//a[1][contains(@class,'primary')]";
    public static String resi_getFree_btn_xp = "//a[2][contains(@class,'primary')]";
    public static String resi_tooltip_xp = "//span[contains(@class,'tooltip')]";
    public static String resi_email_validation_xp = "//span[contains(@class,'Error')]";
//    public static String resi_name_label_xp = "//label[contains(@for,'name')]"; // REMOVE
//    public static String resi_cardNo_label_xp = "//div[4]/label[contains(@for,'card-number')]";
//    public static String resi_expiration_label_xp = "//div[3]/label";
//    public static String resi_securityCode_label_xp = "//div[6]/label";
//    public static String resi_Terms_label_xp = "//div[8]/label[contains(@for,'card-number')]";
    public static String resi_Pay_btn_xp = "//button[@id='checkOutButton']";
    public static String resi_getFreeSuburb_btn_xp = "//a[@id='homeLoanGetThisFreeBtn']";
    public static String resi_thankYouFree_xp = "//div[contains(@class,'rp-wgt-content')]";
    public static String resi_freePaymentInfo_xp = "//*[@id='RESI_homeLoansLeadForm']/div/div";
    public static String resi_paymentFName_xp = "//label[@for='first-name']";
    public static String resi_paymentLName_xp = "//label[@for='last-name']";
    public static String resi_paymentEmail_xp = "//label[@for='email']";
    public static String resi_paymentNumber_xp = "//label[@for='contact-number']";
    public static String resi_paymentSuburb_xp = "//label[@for='suburb']";
    public static String resi_paymentRelationship_xp = "//label[@for='relationship']";
    public static String resi_paymentTime_xp = "//label[@for='time-to-act']";
    public static String resi_paymentPurpose_xp ="//label[@for='purpose']";
    public static String resi_paymentContact_xp = "//label[@for='contact-time']";
    public static String resi_paymentTerms_xp = "//label[@for='option-one']";
    //public static String resi_paymentAcceptTerms_xp = "";
    public static String resi_paymentCancelBtn_xp = "//*[@class='pure-button pure-button-cancel']";
    public static String resi_paymentSubmitBtn_xp = "//a[@id='freePackageSubmit']";
    public static String resi_paymentTermsLink = "//a[@href='http://www.rpdata.com/terms.html']";
    
    //Rates Online Estimated Value Report
    public static String ro_getThisFree_btn_xp = "//*[@id='getThisFree']";
    public static String form_EstimatedVHeader_label_xp = "//*[@id='purchaseButtonForm']/label";
    public static String ro_submit_btn_xp = "//input[@id='freePackageSubmit']";
    
    public static String firstName_field_xp = "//input[@id='firstName']";
    public static String lastName_field_xp = "//input[@id='lastName']";
    public static String emailAdd_field_xp = "//input[@id='emailAdd']";
    public static String contactNumber_field_xp = "//input[@id='contactNumber']";
    public static String loan_relationship_opt_xp = "//select[@id='relationshipOnProperty']";
    public static String timeToAct_opt_xp = "//select[@id='timeToAct']";
    public static String purposeOfRequest_field_xp = "//input[@id='purposeOfRequest']";
    public static String preferredContactTime_xp = "//select[@id='preferredContactTime']";
    public static String suburb_field_xp = "//input[@id='suburb'][@type='text']";
    public static String agreeCb_xp = "//input[@id='iAgree']";
    
    
    // Smoke Test
    
    //register
    public static String smokeFirstName_xp = "//input[@id='firstName']";
    public static String smokeLastName_xp = "//input[@id='lastName']";
    public static String smokeEmail_xp = "//input[@id='userEmail']";
    public static String smokeConfirmEmail_xp = "//input[@id='confirmUserEmail']";
    public static String smokePassword_xp = "//input[@id='userPass']";
    public static String smokeConfirmPassword_xp = "//input[@id='confirmUserPass']";
    public static String smokeSecurityQuestion_xp = "//input[@id='securityQuestion']";
    public static String smokeSecurityQuestionAnswer_xp = "//input[@id='securityAnswer']";
    public static String smokeBtnDone_xp = "//a[@id='subRegInd']";
    public static String smokeTermsAndConditions_xp = "//input[@id='termsConditions']";
    public static String smokeSuccessRegister = "//span[@class='bodyText']";
    
    // Search
    public static String smokeSearchLine_xp = "//input[@id='singleLineSearch']";
    public static String smokeBtnSearch_xp = "//input[@id='searchButtonIcon']";
    public static String smokeSearchAddress_xp = "//h1/span[@itemprop='streetAddress']";
    public static String smokeStateBreadCrumb_xp = "//div[1]/a/span[@itemprop='title']";
    public static String smokeCouncilBreadCrumb_xp = "//div[2]/a/span[@itemprop='title']";
    public static String smokeSuburbBreadCrumb_xp = "//div[3]/a/span[@itemprop='title']";
    public static String smokeStreetBreadCrumb_xp = "//div[4]/a/span[@itemprop='title']";
 
    
    //Buy Detailed Property Report
    
   public static String smokeBtnAddToCartDetailedPropertyReport_xp = "(//*[@id='purchaseButton'])[1]";
   public static String smokeBtnContinueBuyingDetailedPropertyReport_xp = "//input[@id='continueBuying']";
   public static String smokeBtnGoToCart_xp = "//input[@id='goToCart']";
   
   
   //Cart List
   public static String smokeCartLabel_xp = "//label[@class='mainLabel']";
   
   
   //Get Title Document 
   public static String smokeBtnGetTitleDocument_xp = "//input[@id='buyPropertyDoc']";
   
   
   //Buy Estimated Value Report
   public static String smokeBtnAddToCartEstimatedValueReport_xp = "(//*[@id='purchaseButton'])[3]";
   public static String smokeBtnGetThisFree_xp = "//input[@id='getThisFree']";
   public static String smokeBtnGetThisFreeClose_xp = "//div[@id='cboxClose']";
   public static String smokeBtnContinueBuying_xp = "//input[@id='continueBuying']";
   public static String smokeRelationShipOnProperty_xp = "//select[@id='relationshipOnProperty']";
   public static String smokeTimeToAct_xp ="//select[@id='timeToAct']";
   public static String smokeLoanAmount_xp = "//input[@id='loanAmount']";
   public static String smokePreferredContactTime =  "//select[@id='preferredContactTime']";
   public static String smokeContactNumber_xp =  "//input[@id='contactNumber']";
   public static String smokeBtnIAgree_xp =  "//input[@id='iAgree']";
   public static String smokeBtnSubmitDetails_xp = "//input[@id='freePackageSubmit']";
   public static String smokeEmailLead_xp = "//input[@id='emailAdd']";
   
   //Buy Estimated Value Subscription
   
   public static String smokeBtnAddToCartEstimatedValueSubscription_xp = "(//*[@id='purchaseButton'])[4]";
   
   //Buy Sales History Report
   
   public static String smokeBtnAddToCartSalesHistoryReport_xp = "(//*[@id='purchaseButton'])[4]";
   
   //Buy Suburb Sales History Report
   
   public static String smokeBtnAddToCartSuburbSalesHistoryReport_xp = "(//*[@id='purchaseButton'])[1]";
   public static String smokeBtnAddToLastThreeYearsSalesMap_xp = "(//*[@id='purchaseButton'])[2]";
   public static String smokeBtnAddToSuburbValueMap_xp = "(//*[@id='purchaseButton'])[3]";
   public static String smokeBtnAddToFreeSuburbProfileReport_xp = "(//*[@id='purchaseButton'])[5]";
   public static String smokeFreePackageEmail_xp = "//input[@id='freePackageEmail']";
   public static String smokeBtnFreePackageSubmit_xp = "//input[@id='freePackageSubmit']";
   
   //key stats
   public static String smokeBtnKeyStats_xp = "//a[contains(@href,'/stats/')]";
   public static String smokeImgAgeSexRatio_xp = "//img[@id='ageSexRatioimg']";
   public static String smokeBtnAgeSexRatio_xp = "//*[@id='area0li']/table/tbody/tr/td[2]/a";
   public static String smokeBtnIncome_xp = "//*[@id='area1li']/table/tbody/tr/td[2]/a";
   public static String smokeImgIncome_xp = "//img[@id='incomeimg']";
   public static String smokeBtnStructure_xp = "//*[@id='area2li']/table/tbody/tr/td[2]/a";
   public static String smokeImgStructure_xp = "//img[@id='structureimg']";
   public static String smokeBtnOccupancy_xp = "//*[@id='area3li']/table/tbody/tr/td[2]/a";
   public static String smokeImgOccupancy_xp = "//img[@id='occupancyimg']";
   
   //local experts
   public static String smokeBtnLocalExperts_xp = "//a[contains(@href,'/local-experts/')][2]";
   
   //Home loans
   public static String smokeBtnHomeLoans_xp = "//a[contains(@href,'http://homeloans.myrp.com.au')]";
   
   //PostCode
   public static String moonbria = "//a[contains(@href,'/moonbria/')]";
   public static String morago = "//a[contains(@href,'/morago/')]";
   public static String prettyPine = "//a[contains(@href,'/pretty_pine/')]";
   public static String steamPlains = "//a[contains(@href,'/steam_plains/')]";
   public static String studPark = "//a[contains(@href,'/stud_park/')]";
   public static String wakool = "//a[contains(@href,'/wakool/')]";
   public static String wandook = "//a[contains(@href,'/wandook/')]";
   public static String wanganella = "//a[contains(@href,'/wanganella/')]";
   public static String warragoon = "//a[contains(@href,'/warragoon/')]";
   public static String willurah = "//a[contains(@href,'/willurah/')]";
   public static String barratta = "//a[contains(@href,'/barratta/')]";
   public static String birganbigil = "//a[contains(@href,'/birganbigil/')]";
   public static String booroorban = "//a[contains(@href,'/booroorban/')]";
   public static String bullatale = "//a[contains(@href,'/bullatale/')]";
   public static String calimo = "//a[contains(@href,'/calimo/')]";
   public static String caldwell = "//a[contains(@href,'/caldwell/')]";
   public static String	conargo = "//a[contains(@href,'/conargo/')]";
   public static String coree = "//a[contains(@href,'/coree/')]";
   public static String deniliquin = "//a[contains(@href,'/deniliquin/')]";
   public static String hartwood = "//a[contains(@href,'/hartwood/')]";
   public static String lindiferron = "//a[contains(@href,'/lindifferon/')]";
   public static String mathoura = "//a[contains(@href,'/mathoura/')]";
   
   
   
   //Council
   public static String councilReport_xp = "//a[contains(@href,'/council/')]";
   public static String mostRecentSales_xp = "//img[@class='photo_thumbnail']";
   
   //infographics
   public static String SmokeBtnInfographics_xp = "//a[contains(@href,'/infographic/')]";
   
   //login
   public static String smokeBtnLogin_xp = "//a[@class='buttonLogin']";
   public static String smokeUserNameLogin_xp = "//input[@id='userName']";
   public static String smokePasswordLogin_xp = "//input[@id='password']";
   public static String smokeBtnSubmitLogin_xp = "//input[@name='loginButton']";
   public static String smokeBtnMyAccount_xp = "//a[contains(@href,'/My-reports/')]";
   
   //checkout
   public static String smokeCardName_xp = "//input[@id='cardName']";
   public static String smokeCardNumber_xp = "//input[@id='cardNumber']";
   public static String smokeSecurityCode_xp = "//input[@id='securityCode']";
   public static String smokeBtnPayNow_xp = "//input[@id='checkOutButton']";
   public static String smokeGuest_xp = "//input[@id='customerEmail']";
   public static String smokePurchasedSuccessful_xp = "//span[@class='wbdRichText']";
   public static String smokeTxtPromoCode_xp = "//input[@id='promotionCode']";
   public static String smokeBtnPromoCode_xp = "//input[@name='applyPromoCodeButton']";
   
   
   //change password
   public static String smokeBtnMyDetails_xp = "//a[contains(@href,'/My-details/')]";
   public static String smokeBtnChangePassword_xp = "//a[@class='formTextLink']";
   public static String smokeChangePassword_xp = "//input[@id='changePassword']";
   public static String smokeRePassword_xp = "//input[@id='repassword']";
   public static String smokeBtnUpdate_xp = "//a[@id='subRegInd']";
   
   //logout
   public static String smokeBtnLogout_xp = "//a[contains(@onclick,'logout')]";
   
   //check health
   public static String smokeBtnAdmin_xp = "//a[contains(@href,'/User-Search/')]";
   public static String smokeBtnHealthCheck_xp = "//a[@href ='/n/Health-Check/myrp-478']";
   public static String smokeBtnCheckAllConnections_xp = "//a[contains(@href,'/myrp-478?check=all')]";
   
   //LJ hooker estimated Value Report
   public static String smokeBtnBuyLJHookerReport_xp = "//a[contains(@class,'landingReportLink')]";
   public static String smokeBtnLJHookerContinueBuying_xp = "//input[@id='leadGenContinueBuying']";
   public static String smokeSearchLJHooker_xp = "//input[@id='landingSearch']";
   public static String smokeBtnLJHookerFindProperty_xp = "//input[@id='landingSearchButton']";
   public static String smokeLJHookerCboxWrapper_xp = "//div[@id='cboxWrapper']";
   
   //netbank detailed property report
   public static String smokeBtnNetBankAddToCart_xp = "//input[@id='purchaseButton']";

   //getNetbankBuyOrRent
   public static String smokeTickAppointment_xp = "//input[@id='aussieBroker']";
   public static String smokeBrokerName_xp = "//input[@id='brokerName']";
   public static String smokeBrokerContactNumber_xp = "//input[@id='contactNumber']";
   public static String smokeBrokerSuburb_xp = "//input[@id='suburb']";
   public static String smokeBrokerGetReport_xp = "//input[@id='submitDetailsButton']";
   
   // search Nab Address
   public static String smokeBtnNabSearch_xp = "//input[@id='searchButtonIcon']";
   public static String smokeNabSearchLine_xp = "//input[@id='searchAddress']";
   public static String smokeNabStreetAddress_xp = "//span[@itemprop='streetAddress']";
   	
   //verify Keep shopping link
   public static String smokeBtnMyCart_xp = "//a[@id='cartCount']";
   public static String smokeBtnKeepShopping = "//input[@value='Keep Shopping']";
   
   //verify Searches
   public static String smokeAddressSearch_xp = "//input[@id='singleLineSearch']";
   public static String smokeBtnAddressSearch_xp = "//input[@id='searchButtonIcon']";
   
   
   //property search mobile
   public static String mobileTxtSearch_xp = "//input[@id='slasMobile_autoComplete']";
   public static String mobileBtnSearch_xp = "//a[@id='searchButton']";
   public static String mobileImgProperty_xp = "//img[@class='photo_thumbnail property-photo-thumb']";
   public static String mobileLabelAddress_xp = "//div[@class='street-header-text']";
   public static String mobileLabelBedAttribute_xp = "//td[@class='prop_attr bed_rooms']";
   public static String mobileLabelBathAttribute_xp = "//td[@class='prop_attr bath_rooms']";
   public static String mobileLabelGarageAttribute_xp = "//td[@class='prop_attr car_spaces']";
   public static String mobileBtnDetailedReport_xp = "(//*[@id='detailedPropertyReport'])[0]";
   public static String mobileBtnEstimatedValueReport_xp = "(//*[@id='detailedPropertyReport'])[1]";
   public static String mobileBtnPropertySalesReport_xp = "(//*[@id='detailedPropertyReport'])[2]";
   public static String mobileBtnStreetReport_xp = "(//*[@id='detailedPropertyReport'])[3]";
   public static String mobileBtnSuburbReport_xp = "(//*[@id='detailedPropertyReport'])[4]";
   public static String mobileImgDetailedReport_xp = "//tr[3]/td/div/div/div/div[3]/div/img";
   public static String mobileDescDetailedReport_xp = "//tr[3]/td/div/div/div/div[3]/form/div/span";
   public static String mobileImgEstimatedValueReport_xp = "//tr[4]/td/div/div/div/div[3]/div/img";
   public static String mobileDescEstimatedValueReport_xp = "//tr[4]/td/div/div/div/div[3]/form/div/span";
   public static String mobileImgSalesReport_xp = "//tr[5]/td/div/div/div/div[3]/div/img";
   public static String mobileDescSalesReport_xp = "//tr[5]/td/div/div/div/div[3]/form/div/span";
   public static String mobileImgStreetReport_xp = "//tr[6]/td/div/div/div/div[3]/div/img";
   public static String mobileDescStreetReport_xp = "//tr[6]/td/div/div/div/div[3]/form/div/span";
   public static String mobileImgSuburbReport_xp = "//tr[7]/td/div/div/div/div[3]/div/img";
   public static String mobileDescSuburbReport_xp = "//tr[7]/td/div/div/div/div[3]/form/div/span";
   
   
   //MOBILE
   public  String mobileDev_url = rxml.data("mobileDev_url");
   public  String mobileStage_url = rxml.data("mobileStage_url");
   
   
   //homepage
   public static String slasMobile_xp = "//input[@id='slasMobile_autoComplete']";
   public static String searchBtnMobile_xp = "//form[2][@class='searchBtn']";
   
   //menu
   public static String headerLogo_xp = "//a/img[contains(@src,'headerLogo')]";
   public static String basketIcon_xp = "//a/img[contains(@src,'basketIcon')]";
   public static String userIcon_xp = "//a/img[contains(@src,'userIcon')]";
   public static String searchIcon_xp = "//a/img[contains(@src,'Search-white')]";
   // login menu
   public static String loginMButton_xp = "//div[@id='login_btn']"; //Login & My Account btn
   public static String login2mButton_xp = "//div[@id='login-btn-submit']";
   public static String emailMField_xp = "//input[@id='rp_username']";
   public static String passwordMField_xp = "//input[@id='rp_password']";
   
   //My Accounts 
   public static String MyReportsTab_xp =	"//a[@id='tabLinkMyReport']";
   public static String MyDetailsTab_xp =	"//a[@id='tabLinkMyDetails']";
   
   //My Reports
   public static String MyPurchasesBtn_xp = "//*[@id='myReportsForm']/table[1]/tbody/tr/td[1]/a";
   public static String MyValuationsBtn_xp = "//*[@id='myReportsForm']/table[2]/tbody/tr/td[1]/a";
   public static String MyTrackedPropertiesBtn_xp ="";
   public static String MyMapsBtn_xp ="";
   
   //My Purchases
   
   // Street report
   public static String streetReportAccordion_xp = "//div[@class='street-report'][1]";
   public static String streetReportBtnMobile_xp = "//div[@class='street-sales-report-button']";
   
   //CFA
   public static String btnSearchCFA_xp = "";
   public static String btnOpenCFA_xp = "";
   public static String btnCloseCFA_xp = "";
   public static String btnClearCFA_xp = "";
   public static String txtUnitNumber_xp = "";
   public static String txtStreetNumber_xp = "";
   public static String txtLotNumber_xp = "";
   public static String txtStreetName_xp = "";
   public static String txtStreetType_xp = "";
   public static String txtSuburbStatePostcode_xp = "";
   
   //SEO RELATED SEARCHES
   public static String txtSuburbSEO_xp = "//tr[3]/td/a[@class='fontStyle15 related-search']";
   public static String txtStreetSEO_xp = "//tr[4]/td/a[@class='fontStyle15 related-search']";
   public static String txtCouncilSEO_xp = "//tr[5]/td/a[@class='fontStyle15 related-search']";
   public static String txtStateSEO_xp = "//tr[6]/td/a[@class='fontStyle15 related-search']";
   public static String txt1stStreet_xp = "//*[@id='streetListContainer']/a[1]";
   public static String txt2ndStreet_xp = "//*[@id='streetListContainer']/a[2]";
   public static String txt3rdStreet_xp = "//*[@id='streetListContainer']/a[3]";
   public static String txt4thStreet_xp = "//*[@id='streetListContainer']/a[4]";
   public static String txtFirstStreetPhraseSEO_xp = "//tr[3]/td/a[@class='fontStyle15 related-search']";
   public static String txtSecondStreetPhraseSEO_xp = "//tr[4]/td/a[@class='fontStyle15 related-search']";
   public static String txtThirdStreetPhraseSEO_xp = "//tr[5]/td/a[@class='fontStyle15 related-search']";
   public static String txtFourthStreetPhraseSEO_xp = "//tr[6]/td/a[@class='fontStyle15 related-search']";
   public static String txt1stSuburb_xp = "//*[@id='SuburbListByCouncil']/div[2]/a[1]";
   public static String txt2ndSuburb_xp = "//*[@id='SuburbListByCouncil']/div[2]/a[2]";
   public static String txt3rdSuburb_xp = "//*[@id='SuburbListByCouncil']/div[2]/a[3]";
   public static String txt4thSuburb_xp = "//*[@id='SuburbListByCouncil']/div[2]/a[4]";
   public static String txtFirstSuburbPhraseSEO_xp = "";
   public static String txtSecondSuburbPhraseSEO_xp = "";
   public static String txtThirdSuburbPhraseSEO_xp = "";
   public static String txtFourthSuburbPhraseSEO_xp = "";
   public static String btnSuburbMapSEO_xp = "//td[2]/a[contains(@href,'map')]";
   public static String btnKeyStatsSEO_xp = "//td[2]/a[contains(@href,'stats')]";
   public static String btnLocalExpertsSEO_xp = "//td[2]/a[contains(@href,'experts')]";
   public static String txtFirstLocalExpertPhraseSEO_xp = "//tr[3]/td/a[@class='fontStyle15 related-search']";
   public static String txtSecondLocalExpertPhraseSEO_xp = "//tr[4]/td/a[@class='fontStyle15 related-search']";
   public static String txtThirdLocalExpertPhraseSEO_xp = "//tr[5]/td/a[@class='fontStyle15 related-search']";
   public static String txtFourthLocalExpertPhraseSEO_xp = "//tr[6]/td/a[@class='fontStyle15 related-search']";
   
  
   //Property Unavailable
   public static String btnSuburbPU_xp = "//a[@class='suburb-link']";
   
   //Home page Footer
   public static String btnFacebookF_xp = "//td[6]/table/tbody/tr[1]/td/a";
   public static String btnTwitterF_xp = "//td[6]/table/tbody/tr[2]/td/a";
   public static String btnYoutubeF_xp = "//td[6]/table/tbody/tr[3]/td/a";
   public static String btnBlogF_xp = "//td[6]/table/tbody/tr[4]/td/a";
   
   //key stats
   
   
   //textLink
   public static String txtPropertyAdLink_xp = "";
   public static String txtStreetAdLink_xp = "";
   public static String txtSuburbAdLink_xp = "";
   
   //Investor Insights
   public static String txtInvestor_xp = "";
   public static String txtInvestorLink_xp = "";
   public static String imgInvestorLink_xp = "";
   
   
   //Investor Landing page
   public static String btnInvestorLandingPage_xp = "//td[4]/table/tbody/tr/td[2]/a";
   public static String txtIntroInvestorLandingPage_xp = "//tr[5]/td/table/tbody/tr/td[1]/p";
   public static String btnPurchaseInvestorLandingPage_xp = "//input[@id='purchaseButton']";
   
   
   //Cutdown Pages URL
   public static String btnPropertyPages_xp = "//tr[3]/td[1]/span/a";
   public static String btnCutdownEstimatedValueSubscription_xp = "//tr[3]/td/div/ul/li[2]/div/a";
   public static String btnCutdownDetailedPropertyReport_xp = "//tr[3]/td/div/ul/li[3]/div/a";
   public static String btnCutdownTitleDocument_xp = "//tr[3]/td/div/ul/li[4]/div/a";
   public static String btnCutdownSalesHistory_xp = "//tr[3]/td/div/ul/li[5]/div/a";
   public static String btnServicesPages_xp = "//tr[7]/td[1]/table/tbody/tr/td[2]/h2/a";
   public static String btnCutdownDesktopValuationUrl_xp = "//tr[3]/td/div/ul/li[2]/div/a";
   public static String btnCutdownShortForm_xp = "//tr[3]/td/div/ul/li[3]/div/a";
   public static String btnCutdownLongForm_xp = "//tr[3]/td/div/ul/li[4]/div/a";
   public static String btnCutdownAgentsValuersBrokers_xp = "//tr[3]/td/div/ul/li[5]/div/a";
   public static String btnStreetPage_xp = "//td[2]/div/table/tbody/tr[1]/td[3]/table/tbody/tr/td[2]/h2/a";
   public static String btnSuburbPages_xp = "//td[2]/div/table/tbody/tr[7]/td[3]/table/tbody/tr/td[2]/h2/a";
   public static String btnCutdownSuburbSalesReport_xp = "//tr[3]/td/div/ul/li[2]/div/a";
   public static String btnCutdownSuburbSalesMapSubscription_xp = "//tr[3]/td/div/ul/li[3]/div/a";
   public static String btnCutdownSuburbValueMapSubscription_xp = "//tr[3]/td/div/ul/li[4]/div/a";
   public static String btnCutdownRentalInsightReport_xp = "//tr[3]/td/div/ul/li[5]/div/a";
   
   //westpac
   public static String westpacTxtPromoCode_xp = "//input[@id='promotionCode']";
   public static String westpacBtnPromoCode_xp = "//img[@name='applyPromoCodeButton']";
   public static String westpacTxtSlas_xp = "//input[@id='searchAddress']";
   public static String westpacBtnSearch_xp = "//input[@id='searchButtonIcon']";
   public static String westpacBtnPurchase_xp = "//input[@id='purchaseButton']";
   public static String westpacTxtFirstName_xp = "//input[@id='firstName']";
   public static String westpacTxtLastName_xp = "//input[@id='lastName']";
   public static String westpacTxtEmail_xp = "//input[@id='emailAdd']";
   public static String westpacTxtPhoneNumber_xp ="//input[@id='contactNumber']";
   public static String westpacTxtPostCode_xp = "//input[@id='postcode']";
   public static String westpacBtnIAgree_xp = "//input[@id='iAgree']";
   public static String westpacBtnSubmit_xp = "//input[@id='freePackageSubmit']";
   
   public static String btnCart_xp = "//a[@id='cartCount']";
   
}
