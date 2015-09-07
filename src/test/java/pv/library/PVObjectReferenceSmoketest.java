package pv.library;

public class PVObjectReferenceSmoketest {
	
	//HealthCheck
	public static String checkResult = "//*[@id='checkResult']";
	//Add to watchlist XPATH
	public static String actionBar = "//*[@class='action-bar']";
	public static String propertyWatchlistHeader = "//*[@id='watchlist-nproperties']";
	public static String propertyWatchlistTable = "//*[@id='watchlist-properties-div']";
	public static String streetWatchlistHeader = "//*[@id='street-results-title']";
	public static String streetWatchlistTable = "//*[@id='watchlist-streets-div']";
	public static String suburbWatchlistHeader = "//*[@id='suburb-results-title']";
	public static String suburbWatchlistTable ="//*[@id='wl-suburb-section']";
	//HeaderZones
	public static String verifyLogin = "//*[@class='login']";
	public static String clickLogin = "//*[@class='logged-out'][1]";
	public static String verifyLoginPage = "//*[@class='form']";
	public static String userName = "//*[@id='userName']";
	public static String password = "//*[@id='password']";
	public static String loginSite = "//*[@class='form']//button";
	public static String verifyLoginName = "//*[@class='login']";
	public static String clickMenu = "//*[@class='logged-in']";
	public static String clickLogOut = "(//*[@class='login']//a)[8]";
	public static String clickMenuWatchlist = "//*[@class='logged-in-nav']/ul/li/a[contains(.,'Watchlist')]";
	public static String selectPropety = "//*[@class='home-slas-def']//ul//li";
	public static String verifyPropertyInsights = "(//*[@class='wbdRichText']//h2)[1]";
	public static String clickAddtoWatchList = "(//*[@class='hidden-xs']//li//a)[1]";
	public static String goToWatclist = "(//*[@class='login']//a)[3]";
	public static String verifyifPropertyisAddedtoWatchlist = "//*[@class='row'][3]";
	public static String checkWatchlist = "//*[@class='DivWidget suburb watchlist']";
	public static String verifyStreetInsights = "//*[@class='col-sm-12 col-md-10']";
	public static String clickLogo = "//*[@class='logo']//a";
	public static String verifySuburbInsights = "//*[@class='col-sm-12 col-md-10']";
	public static String viewSuburbProfile = "//*[@class='default-btn blue-btn hidden-xs hidden-sm']";
	public static String forgottenPassword = "(//*[@class='col-xs-12 col-sm-6 col-md-6 col-lg-6']//a)[1]";
	public static String emailForgottenPassword = "//*[@id='resetPassword_input']";
	public static String verifyResetPW = "//*[@class='user-sign']";
	public static String resetFP = "//*[@id='resetPassword_submit']";
	public static String advanceSearch = "(//*[@class='active']//button)[16]";
	public static String fpPage = "//*[@class='container'][1]";
	public static String unitAdvanceSearch = "//*[@id='adv_unitnumber']";
	public static String advanceSearchPage = "//*[@class='form']";
	public static String streetAdvanceSearch = "//*[@id='adv_streetname']";
	public static String searchResultsAdvanceSearch = "//*[@class='row sectionAnchor']";
	public static String gotoMyAccount = "(//*[@class='login']//a)[7]";
	public static String verifyAccountPage = "//*[@class='container'][1]";
	public static String navWatchlist = "//a[contains(.,'Watchlist')]";
	public static String portfolioTab = "//*[@class='DivWidget container']/div/div/ul/li/a[contains(.,'Portfolio')]";
	public static String watchlistDropDown = "//*[@id='dropdownMenu1']";
	public static String removeWatchlist = "//*[@id='watched-pty-206']/td[4]/div/ul/li[4]/a";
	public static String removeStreet = "//*[@id='watched-street-house-207']/td[5]/div/ul/li[3]/a";
	public static String removeSuburb = "//*[@id='watched-suburb-house-208']/td[6]/div/ul/li[4]/a";
	public static String advSearchSuggest = "//*[@class='popover-content']";
	public static String advSearchResults = "//*[@class='adv-results']";
		
	//HeaderZone jeck
	public static String clickExplore = "//a[contains(.,'Explore')]";
	public static String explorePage = "//p[contains(.,'Explore every State in Australia by ordering suburbs based on your buying criteria.')]";
	public static String stateRegionFilter = "//*[@id='explore_form']/div/div/div[1]";
	public static String functionState = "//*[@id='explore_state_select']/a";
	public static String functionRegion = "//*[@id='explore_region_select']/a";
	public static String clickPortfolio = "//a[contains(.,'Portfolio')]";
	public static String getPremium = "//a[contains(.,'Get Premium')]";
	
	public static String explorePaeHeader = "//h1[contains(.,'Find the suburbs that are right for you')]";
	//Explore page XPATH 
	
	public static String toggleButton ="//*[@class='houses-units']";
	public static String stateFilter = "//*[@id='explore_state_select']/a";
	public static String regionFilter = "//*[@id='explore_region_select']/a";
	public static String selectState = "//*[@id='explore_state_select']/div/ul/li[2]";
	public static String selectRegion ="//*[@id='explore_region_select']/div/ul/li[2]/a";
	public static String marketActPane = "//*[@id='explore_activity_pane']";
	public static String metricSorting ="//*[@id='explore_metric_div']/a";
	public static String selectTopSuburb = "//*[@class='results-table']";
	public static String suburbList = "//*[@title='Forrest, ACT 2603']";
	public static String checkProfilePage = "//*[@class='property-summary']";
	public static String suburbPage = "//*[@id='paddress']";
		
	//Homepage
	public static String headerNav = "//*[@class='main']";
	public static String slasBox = "id('propertysearch')";
	public static String statNat = "//*[@class='home-graph']";
	public static String topSuburbs = "//*[@class='top-suburbs']";
	public static String medianPriceChange = "//*[@id='topsuburblistpanel']/div[1]/div";
	public static String medianGrossYield = "//*[@id='topsuburblistpanel']/div[2]/div";
	public static String footer = "//footer";

	//Admin Report
	public static String adminLogin = "//*[@id='adminloginform']/input[5]";
	public static String clickRevenueReport = "//a[contains(.,'Property Value Revenue Report')]";
	public static String dateFrom = "//*[@id='dateFrom']";
	public static String dateTo = "//*[@id='dateTo']";
	public static String product = "//*[@id='productId_selection']";
	public static String optionAll = "//*[@id='productId_selection']/option[2]";
	public static String document = "//*[@id='Document']";
	public static String volume = "//*[@id='__bookmark_1']/tbody/tr[3]/td[2]/div";
	public static String grossSales = "//*[@id='__bookmark_1']/tbody/tr[3]/td[3]/div";
	public static String GTS = "//*[@id='__bookmark_1']/tbody/tr[3]/td[4]/div";
	public static String btnReports = "//*/div[1]/table/tbody/tr[5]/td/div/div/nav/ul/li[1]/a";
	public static String adminReports = "//a[contains(.,'Admin Reports')]";
	public static String paramOk = "//*[@id='parameterDialogokButton']/input";
	public static String waitFrame = "//*[@id='AUTOGENBOOKMARK_1_08bda8a2-2ea7-4b4c-800c-446b1dba68fe']/tbody/tr[1]/td/div";
	public static String clickMobileSplit = "//a[contains(.,'Revenue Report (Mobile split)')]";
	public static String volumeMobileSplit = "//*[@id='__bookmark_2']/tbody/tr[2]/th[5]/div";
	public static String grossSalesMobileSplit = "//*[@id='__bookmark_2']/tbody/tr[2]/th[6]/div";
	public static String resiPartner = "//*[@id='__TOC_0_0_0_0_0_1']/td[3]/div";
	public static String mobileSplitdateFrom = "//*[@id='paraDateFrom']";
	public static String mobileSplitdateTo = "//*[@id='paraDateTo']";
	
	//Signup
	public static String btnSignup = "//*[@class='sign-up']";
	public static String SignupPage = "//h1[contains(.,'Sign up')]";
	public static String firstNameBox = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/input";
	public static String lastNameBox = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[1]/div[2]/div[1]/input";
	public static String addressBox = "//*[@id='suburbasgcsearch']";
	public static String emailBox = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/input";
	public static String confirmEmailBox = "//*[@id='confirmUserEmail']";
	public static String passwordBox = "//*[@id='userPass']";
	public static String confirmpasswordBox = "//*[@id='confirmUserPass']";
	public static String termsAndCondition = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/input";
	public static String captchaBox = "//*[@id='recaptcha_response_field']";
	public static String submitSignup = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/button";
	public static String signupSuccess = "//*[@id='signupSuccess']";
	
	public static String mapFilters = "//*[@id='filters-pane']";
	public static String mapContainer = "//*[@class='map-container']";
	
	
	//login suburb search
	public static String suburbPins = "//*[@id='googleMap']/div/div[1]/div[3]/div[3]/div[19]";
	public static String propertyPins = "//*[@id='googleMap']/div/div[1]/div[3]/div[3]/div[5]";
	public static String propertyData = "//*[@id='property-result-list']/div[1]";
	public static String selectSuggestion = "(//*[@class='jquery-autocomplete-selected-item acSelect'])";
	public static String suburbSearchPin = "//*[@class='map-pin-suburb-fill']";
	public static String unitPropertyPin = "//*[@class='marker_3988092 marker_3988003 map-pin pin-sale-fill']";
	public static String housePropertyPin = "//*[@class='marker_3971028 map-pin pin-sale-fill']";
	public static String neighbourhoodFairlight = "//*[@style='position: absolute; overflow: hidden; opacity: 0.01; margin-left: -43px; margin-top: -20px; left: 425px; top: 273px; z-index: 1000002; display: block; cursor: pointer;']";
	public static String neighbourhoodManlyVale = "//*[@style='position: absolute; overflow: hidden; opacity: 0.01; margin-left: -43px; margin-top: -20px; left: 240px; top: -32px; z-index: 1000002; display: block; cursor: pointer;']";
	public static String neightbourhoodSuburb = "//*[@class='map-pin-suburb-fill white-space-nowrap']";
	public static String viewSuburbButton = "//*[@class='default-btn blue-btn hidden-xs hidden-sm']";
	public static String mapPropertyList = "//*[@class='prop-results']";
	
	//Signup with FB
	public static String clickSignupFB = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[5]/div/div[1]/a";
	public static String signupFB = "//*[@id='facebook']";	
		
	//PropertyProfileReport
	public static String BuyPropertyReport = "(//*[@id='property-insights']/div[1]/table/tbody/tr[1]/td/div[1]/ul[1]/li[2]/a)";
	public static String ProfileReportPage = "//*[@class='report']";	
	public static String btnGetThisReport = "//a[contains(.,'Get this report for ')]";
	public static String btnGetThisReportProperty = "//a[contains(.,'Get this Report for ')]";
	public static String ProfileReportPageHeader = "//h1[contains(.,'Property Profile Report')]";	
	
	//Suburb Profile
	public static String checkAddress = "//*[@id='paddress']";
	public static String checkSuburbInsights = "//*[@class='si']";
	public static String propertyPricesForSale = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div/div[1]/div";
	public static String propertyPricesRecentlySold = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div/div[2]/div";
	public static String propertyPricesForRent = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div/div[3]/div";
	public static String suburbAuction = "//*/div[4]/div/div[2]/div[12]";
	public static String suburbStatistics = "//*/div[4]/div/div[2]/div[14]/div/div[1]";
	public static String suburbTrends = "//*/div[4]/div/div[2]/div[16]/div";
	public static String localExperts = "//*/div[4]/div/div[2]/div[17]/table/tbody/tr[2]/td/div/div";
	
	//LEFT margin XPATH
	public static String about="//*[@id='freemium-floating-menu-about']";
	public static String comparable = "//*[@id='freemium-floating-menu-comparables']";
	public static String insights = "//a[contains(.,'Insights')]";
	public static String propertyprices = "//*[@id='freemium-floating-menu-property-prices']";
	public static String AuctionResults = "//*[@id='freemium-floating-menu-auction-results']";
	public static String neighbourhood = "//*[@id='freemium-floating-menu-neighbourhood']";
	public static String markettrends = "//*[@id='freemium-floating-menu-market-trends']";
	public static String localexperts = "//*[@id='freemium-floating-menu-local-experts']";
	public static String otherStreet = "//*[@id='freemium-floating-menu-streets']";
	public static String streetSection = "//*[@id='freemium-floating-menu-other-streets']";
	
	//Payment Summary 
	public static String PaymentSummaryScreen = "//*[@id='payment_panel']/h2";
	public static String PaymentSummaryUserEmail = "//*[@id='userEmail']";
	public static String btnBuyNow = "//*[@id='order_now_btn']";
	public static String btnPayNow = "//*[@id='getApproval']";
	public static String premiumBuyNow = "//*[@id='optionList']/div[1]/div/div/div[2]/a";
	public static String purchasePremium = "//*[@id='purchaseSubscription']/a";
	public static String promoCode = "//*[@id='promocode']";
	public static String btnContinue = "//*[@id='continue_btn']";
	public static String applyCode = "//*[@id='promocode_panel']/div/div[2]/button";
	public static String circleLogo = "//*[@class='circle-logo']//a";
	public static String propertyPricesSection = "//*[@class='comparable-properties-section']";
	public static String suburbSaleProperty = "//*[@class='title forsale']";
	public static String suburbSoldProperty = "//*[@class='title sold']";
	public static String suburbRentProperty = "//*[@class='title rent']";
	public static String suburbInfoHeader ="//h2[contains(.,'Suburb Information')]";
	public static String suburbINfoSection ="//*[@class='neighbourhood-info  suburbInfo_d']";
	public static String trendsHeader = "//h2[contains(.,'Market Trends for ')]";
	public static String trendsMetric = "//*[@id='market-trends-metric-box-values']";
	public static String trendsGraph = "//*[@class='graph-big']";
	public static String localExpertsSection = "//h2[contains(.,'Local Experts')]";
	public static String otherStreetsHeader = "//h2[contains(.,'Streets in Manly')]";
	public static String otherStreetsSection = "//*[@id='streets-insights-main-container']";
	
		
	//Payment Checkout
	public static String PaymentCheckout = "//*[@id='PxPayAuthMain']/div/h2";
	public static String cardNumber = "//*[@id='12939']";
	public static String cardHolderName = "//*[@id='12940']";
	public static String dateExpiry1 = "//*[@id='DateExpiry_1']";
	public static String dateExpiry2 = "//*[@id='DateExpiry_2']";
	public static String cardSecurityCode = "//*[@id='12944']";
	public static String btnSubmit = "//*[@id='12973']";
	public static String paymentSuccess = "//h2[contains(.,'Your payment has been successful!')]";
	public static String checkEmail = "//*[@id='Email']";
	public static String gmailPasswd = "//*[@id='Passwd']";
	public static String checkGmail = "//*[@id=':2']/div/div";
	public static String btnNext = "//*[@id='next']";
	public static String btnSignin = "//*[@id='signIn']";
	public static String clickCancel = "//*[@id='clickedCancel']";
	public static String paymentMsg = "//*[@class='wrap']/h2";
	public static String paymentBodyTxt = "//*[@class='wrap']/h1";
	
	//PostCodeDetails
	public static String postcodeAddress = "//h1[contains(.,'Suburbs in Postcode')]";
	public static String suburbLinks = "//*[@class='rowlist']";
	public static String clickSuburb = "//*/div[2]/div/div[2]/div[3]/div/div[1]/div[1]/b/a";
	public static String suburbMaps = "//*[@id='googleMap']/div/div[1]/div[2]";
	public static String reportAddress="//*[@id='reportAddress']";
	public static String price = "//*[@class='original-price']";
	public static String paymentSuccessHeader = "//h2[contains(.,'Your payment has been successful!')]";
	public static String getPostcodeReport = "//a[contains(.,'Get this report for $59.95')]";
		
	//SEARCH
	//SuburbSearchResult
	public static String btnForSale = "//*[@id='filters-pane']/div[2]/label[1]";
	public static String navigatePropertyPage = "//*[@class='col-sm-12 col-md-10']";
	
	//MultipleSearchResult
	public static String navigateMultipleSearchResult = "//*[@class='explore strategy']";
	public static String selectProperty = "//*[@id='populateData']/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/a";
	
	//PostcodeActivityReport
	public static String btnViewProfile = "//*[@id='viewProfileSuburbMobile']/a[1]";
	public static String BuyPostcodeReport = "//a[contains(.,'Buy Postcode Report')]";
	public static String rememberCard = "//*[@id='rememberCard']";
	public static String waitCreditCardPayment = "//*[@id='TxnAuthCreditCard']";
	public static String backtoHomepage = "//*[@class='home-link-success']";
	public static String postcodeActivityReportHeader = "//h1[contains(.,'Postcode Activity Report')]";
	public static String postcodeReportSection = "//*[@class='premium-features']";
	
	//PropertyDetails
	public static String propertyDetailsHeader = "//*[@class='ie']";
	public static String checkPropertyInsights = "//*[@id='property-insights']";
	public static String propertyInsightsData = "//h4[contains(.,'-')]";
	public static String propertyGallery = "//*[@id='property-insights']/div[2]/div[1]/div[1]";
	public static String auctionResults = "//*[@class='spacer toh2 sectionAnchor']";
	public static String marketTrends = "//*[@id='upgrade-premium-btn']/div/a";
	public static String aboutPropertyHeader = "//h2[contains(.,'About this Property')]";
	public static String aboutProperty = "//*[@class='property-table']";
	public static String comparableSection ="//*[@class='comparable-properties-section']";
	public static String comparableProperties = "//*[@id='comparable_main_wrap']";
	public static String marketTrendsHeader = "//*[@class='row sectionAnchor']";
	public static String marketTrendsMetric = "//*[@id='market-trends-metric-box-values']";
	public static String marketTrendsGraph = "//*[@class='graph-big']";
	
	public static String suburbinfoHeader = "//h2[contains(.,'Neighbourhood')]";
	public static String suburbInfo = "//*[@class='neighbourhood-info hidden-xs suburbInfo_d']";
	public static String suburbStats = "//*[@class='DivWidget neighbourhood-graph']";
	
	//Portfolio Summary
	public static String portfolioSnapshot = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]";
	public static String portfolioValues = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]/div[1]";
	public static String calculateEquity = "//*[@id='equity-not-select']/a";
	public static String calculateModal = "//*[@id='calculateModal']/div/div/div[2]";
	public static String addPortfolio = "//*[@id='addPropertyModal']/div/div/div[2]/div[1]/h3";
	public static String clickAddPropertyPortfolio = "//a[contains(.,' Add Property')]";//"//*[@id='portfolioListSection']/h4/a";
	public static String addPropertyModal = "//*[@id='addPropertyModal']/div/div";//"//*[@id='addPropertyModal']/div/div/div[2]";
	public static String addPropertyModalHeader = "//h3[contains(.,'Add a property to your porftolio')]";
	public static String addPortfolioButton = "//*[@class='portfolioGroupbutton']/a";//"//*[@class='portfolioGroupbutton']";
	public static String modalPropertyItem = "//*[@class='autocomplete-result-item']";
	public static String dataCrunchModal = "//*[@id='dataCruchModal']/div/div[1]/div[2]";
	public static String dataCrunchHeader = "//h3[contains(.,'Data crunching in progress ...')]";
	public static String portfolioSLAS ="//*[@id='search-portfolio']";
	public static String portfolioSection = "//*[@class='portfolio-section']";
	
	//StreetDetails
	public static String togglePropertyType = "//*[@id='propertyTypeToggle_units']";
	public static String clickHouse = "//*[@id='propertyTypeToggle_houses']";
	public static String checkStreetInsights = "//*[@class='sti']";
	public static String propertyPrices = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div";
	public static String streetAuction = "//h3[contains(.,' Auction ')]";
	public static String streetSuburbInfo = "//*[@class='spacer sectionAnchor']";
	public static String streetSuburbStat = "//*[@class='col-sm-12 col-md-12 hidden-xs nhGraph']";
	public static String otherStreets = "//*[@id='streets-insights-main-container']";	
	public static String unitLabel = "//span[contains(.,' Units in last 12 months')]";
	public static String streetSuburbInfoHeader = "//h2[contains(.,'Suburb Information')]";
	
	//StreetDetails
	public static String streetPageHeader = "//*[@class='ie']";
	public static String streetAddress = "//*[@id='paddress']";
		
		
		
	//SUBSCRIBED USERS
	//Subscription Details
	public static String subscriptionType = "//*[@class='col-md-8']";
	
	//Premium suburb map result
	public static String clickadvanceFilter = "//*[@id='filters-pane']/div[6]/div[2]/div[2]/a/i";
	public static String advanceFilter = "//*[@id='advFilters']";
	public static String toggleInsights = "//*[@id='mapSearch_form']/div[2]/div[6]/div[3]/div/button";
	public static String checkDropdownInsights = "//*[@id='SIlist']";
	public static String clickList = "//*[@id='SIlist']/li[5]";
	public static String clickRecentlySold = "//*[@id='filters-pane']/div[2]/label[2]";
	public static String clickSearch = "//*[@id='filters-pane']/div[8]/div";
	public static String moreResults = "//*[@id='left-container']";
	public static String actualPrice = "//*[@id='property-result-list']/div[1]/div[2]/div[2]/span[2]";
	
	//Download Report
	public static String propertyDownload = "//a[contains(.,' Download Property Report ')]";
	public static String postcodeDownload = "//*[@id='property-insights']/div[1]/table/tbody/tr[1]/td/div[1]/ul[1]/li[2]";
	public static String successReport = "//*[@id='sendReportModal']/div/div/div";
	public static String closebtn = "//*[@id='sendReportModal']/div/div/div/div[1]/button/span";
	
	//Portfolio
	public static String btnAddProperty = "//*[@id='portfolioListSection']/h4/a";
	public static String addProperty = "//*[@id='addPropertyModal']/div/div/div[2]/div[1]/h3";
	public static String btnClose = "//*[@id='addPropertyModal']/div/div/div[1]/button/span";
	public static String estimateGrossYield = "//*[@id='upgrade-premium-overlay-div']";
	public static String portfolioValueGraph = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]";
	public static String progressBar = "//*[@id='portfolio-results-table']/tbody/tr[1]/td[4]/div/div[2]/div";
	
	//watchlist
	public static String ownedRented = "//*[@class='street-percent']";
	public static String estimatedValue = "//*[@id='watched-pty-127']/td[2]";
	public static String clickWatchlist = "//*[@class='nav menu-tab-active']";
	
	//compare
	public static String compareBoxA ="//*[@id='compare-inputA']/input";
	public static String compareBoxB ="//*[@id='compare-inputB']/input";
	public static String Comparison = "//*[@class='heading']";
	
	//strategies
	public static String investmentStrategy = "//*[@id='cashflowContent']/div/div[2]";
	public static String clickStrategy = "//a[contains(.,'Strategies')]";
	public static String checkExplorePane = "//*[@id='explore_activity_pane']";
	public static String clickOrder = "//*[@id='explore_metric_div']/a";
	public static String selectOrder = "//*[@id='explore_metric_div']/div/ul/li[2]/a";
	public static String clickSort = "//*[@id='explore_form']/div/div/div[4]/table/thead/tr/th[1]";
	public static String checkSortText = "//*[@id='explore_form']/div[1]/div/div[4]/table/tbody/tr[1]/td[1]";
	public static String viewValue = "//*[@id='explore_form']/div/div/div[4]/table/tbody/tr[1]/td[4]/div/div[2]/div";
	
	//PropertyDetails  premium
	public static String checkExactValue = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/div[1]/h4";
	public static String checkEstimatedValue = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/div[1]/span[3]";
	public static String estimatedRent = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[2]/div";
	public static String estimatedYield = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div";
	public static String grossCashflow = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[4]/td[2]/div";
	public static String checkPros = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[3]/div/h5[1]";
	public static String checkCons = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[3]/div/h5[2]";
	public static String investmentStrategyScore = "//*[@id='strategy-scores']";
	public static String propertyTimeline = "//*[@id='propertyTimeline']/div/div[1]/div[2]";
	public static String unliComparableProperties = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[3]/h5/span/span";
	
	//street details premium
	public static String checkBreakdown = "//*[@class='street']";

	//SuburbProfilepage premium
	public static String verifyBedroomSplit = "//*[@class='glance-details glance-grid-5 si-active-desktop']";
	public static String checkScore = "//*[@id='investment-score-upgrade-content-desktop']";
	public static String checkPropertyPrices = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[3]/div[2]/a[2]";
	
	//SUBSCRIPTION CHANNEL MYRP
	//Signup
	public static String clickSignup = "//a[contains(.,'SIGN UP')]";
	public static String firstName = "//*[@id='firstName']";
	public static String lastName = "//*[@id='lastName']"; 
	public static String userEmail = "//*[@id='userEmail']";
	public static String confirmEmail = "//*[@id='confirmUserEmail']";
	public static String userPass = "//*[@id='userPass']";
	public static String confirmPass = "//*[@id='confirmUserPass']";
	public static String termsConditions = "//*[@id='termsConditions']";
	public static String captchaField = "//*[@id='recaptcha_response_field']";
	public static String clickDone = "//*[@id='subRegInd']";
	public static String successSignup = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/span";
	
	//Estimated Value Report
	public static String logIn = "//*[@class='buttonLogin']";
	public static String logOut = "//a[contains(.,'LOGOUT')]";
	public static String btnLogIn = "//*[@name='loginButton']";
	public static String slasBoxSC = "//*[@id='singleLineSearch']";
	public static String addToCart = "//*[@id='estimatedValueButton']/div/*[@id='purchaseButton']";
	public static String goToCart = "//*[@id='goToCart']";
	public static String promoCodeSC = "//*[@id='promotionCode']";
	public static String btnContinueSC = "//*[@id='checkOutButton']";
	public static String paymentSuccessSC = "//*[@id='purchaseDoneForm']/ul/li[1]/label";
	
	//Investors Postcode Report
	public static String investorsTab = "//a[contains(.,'Investors')]";
	public static String investorAddToCart = "(//*[@class='purchaseButtonContainer'])[1]/div/*[@id='purchaseButton']";
	public static String guestEmail = "//*[@id='customerEmail']";
	
	//Sales History report
	public static String clickProperty = "//*[@id='multipleSearchResults']/div[1]/table/tbody/tr[1]/td/a/h2";
	public static String salesAddToCart = "(//*[@class='purchaseButtonContainer'])[2]/div/*[@id='purchaseButton']";
	
	//Detailed Property Report
	public static String detailedAddToCart = "//*[@class='detailed-report']";
	
	//Street Sales History Report
	public static String streetAddToCart = "(//*[@class='purchaseButtonContainer'])[1]/div/*[@id='purchaseButton']";
	
	//Suburb Sales History Report
	public static String suburbAddToCart = "(//*[@class='purchaseButtonContainer'])[1]/div/*[@id='purchaseButton']";
	
	//Free Suburb Profile Report
	public static String btnFreeReport = "(//*[@class='purchaseButtonContainer'])[6]/div/*[@id='purchaseButton']";
	public static String getFreeReportEmail = "//*[@id='freePackageEmail']";
	public static String freeReportSent = "//*[@id='cboxLoadedContent']/div/div/label";
	public static String clickSubmit = "//*[@id='freePackageSubmit']";
	
	//Maps Tab
	public static String mapTab = "//a[contains(.,'Suburb map')]";
	public static String mapCentered = "//*[@id='map']/div/div[1]/div[2]";
	
	//Forgotten Password
	public static String clickForgot = "//a[contains(.,'Forgotten password?')]";
	public static String navForgotPasswordScreen = "//*[@class='sectionHeadingBlack']";
	public static String forgotPasswordEmail = "//*[@id='forgot_password_email']";
	public static String resetPassword = "//*[@id='label_container_success']/div";
	public static String submitForgot = "//*[@id='label_container_success']/div/table/tbody/tr[3]/td[2]/span/a";
	
	//MY REPORT
	public static String clickMyAccount = "//a[contains(.,'MY ACCOUNT')]";
	public static String tblPurchased = "(//*[@class='roundedWhiteBg'])[1]";
	public static String tblValuations = "(//*[@class='roundedWhiteBg'])[2]";
	
	//iFrame
	public static String iframe = "//iframe";
	public static String iframe2 = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div[4]/iframe";
	

	//----------------------------------------------Regression TEST---------------------------------------------------
	
	//Homepage
	public static String watchVideo = "//*[@class='watch-link']";
	public static String videoPlay = "//*[@id='watchvideo']/div[2]";
	public static String frameVideo = "//*[@id='watchvideo']/div[2]/iframe";
	public static String videoClose = "//*[@id='watchvideo']/div[2]/div";
	public static String ASXTicker = "//*[@id='data-rismark']";
	public static String ASXContent = "//*[@id='data-rismark']/div";
	public static String corelogicIndex = "//*[@class='span4 pull-left mt0']";
	public static String btnExplore = "//*[@id='explore_button']";
	public static String btnStrategies = "//a[contains(@class, 'orange-small-btn') and text() = 'Strategies']";
	public static String btnLearnMore = "//a[contains(@class, 'orange-small-btn') and text() = 'Learn more']";
	public static String btnMedianPriceChange = "//*[@id='fourth']";
	public static String displayUpdates = "//*[@class=' highcharts-yaxis-title']";
	public static String btnUnits = "//*/div/a[contains(.,'Units')]";
	public static String btnCapitalGrowth = "(//*[@class='blue-icon'])[1]";
	public static String btnCashFlow = "(//*[@class='blue-icon'])[2]";
	public static String btnLowerRisk = "(//*[@class='blue-icon'])[3]";
	
	//Signup
	public static String emptyFirstName = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]";
	public static String emptyEmailAdd = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]";
	public static String emptyPassword = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[2]/div[4]/div[3]";
	public static String emptyCaptcha = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[4]/div[2]";
	
	//Suburb Profile Links
	public static String clickBreadcrumbsManly = "//*[@class='breadcrumbs']/li/div/a[contains(.,'Manly')]";
	public static String clickPremium = "//*[@class='get-premium-action']/a[contains(.,'Upgrade to Premium')]";
	public static String getPremiumModal = "//*[@id='getPremium']/div/div";
	public static String premiumClose = "//*[@id='getPremium']/div/div/div[1]/button";
	public static String clickbuyPostcodeReport = "//*[@class='report-action col-xs-6'][2]/a[contains(.,' Buy Postcode Report ')]";
	public static String btnWatchlist = "//*[@id='watch_button']/i[(@data-n='1')]";
	public static String btnShare = "//*[@class='social-action col-xs-6']/a";
	public static String socialFB = "//*[@id='a2apage_mini_services']/a[1]";
	public static String rankingSuburb = "(//*[@class='stats'])[1]";
	public static String premiumInvestment = "//*[@id='investment-score-upgrade-content-desktop']";
	public static String frameAds = "(//iframe)[3]";
	public static String clickFrame = "(//iframe['/html/body/a'])[3]";
	public static String switchRecentSold = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div/div[2]/div";
	public static String switchForRent = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div/div[3]/div";
	public static String textRecentSold = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[3]/h5/span";
	public static String textForRent = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[3]/h5/span";
	public static String clickPropertyList = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/a";
	public static String getPremiumOtherSection = "(//*[@class='result-list']/a[contains(@class,'viewmore free-version-block')])[2]";
	public static String councilName = "//*[@class='subtitle suburbInfo_council']/a";
	public static String checkToggleCityCouncilM = "(//*[@class='highcharts-series highcharts-tracker'])[2]";
	public static String toggleCityCouncilM = "(//*[@class='highcharts-legend-item'])[2]";
	public static String checkToggleCityCouncil = "(//*[@class='highcharts-series highcharts-tracker'])[6]";
	public static String toggleCityCouncil = "(//*[@class='highcharts-legend-item'])[6]";
	public static String toggleCouples = "(//*[@class='highcharts-legend-item'])[8]";
	public static String toggleOutright = "(//*[@class='highcharts-legend-item'])[14]";
	public static String togglePropertySold = "//*[@id='market-trends-metric-box-values']/ul/li[2]/a";
	public static String toggleMedianRent = "//*[@id='market-trends-metric-box-values']/ul/li[3]/a";
	public static String toggleMedianGross = "//*[@id='market-trends-metric-box-values']/ul/li[4]/a";
	public static String checkMetricUpdate = "(//*[@class=' highcharts-yaxis-title'])[3]";
	public static String frameExperts = "(//iframe)[5]";
	public static String viewAll = "//*[@id='main-btn-link']";
	public static String selectStreet = "//*[@id='streets-insights']/div[2]/div/div/div[1]/div/ul/li[1]/a";
	public static String SuburbDetailsHeader = "//*[@class='ie']";
	
	//Suburb Profile
		//Suburb Profile page
	public static String checkSuburbAddress = "//*[@id='paddress']";
	public static String checkStateAddress = "//*[@id='paddress2']";
	
	
	
	//Street Details Links
	public static String clickBreadcrumbsStreet = "//*[@class='breadcrumbs']/li/div/a[contains(.,'Ballarat East 3350')]";
	public static String propertyPricesNav = "//*[@id='freemium-floating-menu-property-prices']";
	public static String propertyPricesNav1 = "//*[@class='fixed-aux-nav']/ul/li/a[contains(.,'Property Prices')]";
	public static String insightsNav = "//*[@id='freemium-floating-menu-insights']/a";
	public static String viewTooltip = "//*[@class='growth']/a/i";
	public static String checkTooltip = "//*[@class='tooltip fade top in']";
	public static String learnMore = "//*[@class='street-composition-free-div']/a[contains(.,'Learn more')]";
	public static String modalLearnMore = "//*[@id='streetLearnMoreModal']";
	public static String closeLearnMore = "//*[@id='streetLearnMore']/div/div/div[1]/button/span";
	public static String suburbClick = "//*[@class='hidden-xs']/a[contains(.,'Suburb Profile')]";
	public static String clickHeart = "//*[@class='watch-action col-xs-6']/a";
	
	//Property Details Links
	
	public static String clickBreadcrumbsProperty = "//*[@class='breadcrumbs']/li/div/a[contains(.,'Darlington Drive')]";
	public static String clickBuyPropertyReport = "//*[@class='report-action col-xs-6']/a[contains(.,' Buy Property Report ')]";
	public static String clickBuyTitleDocuments = "//*[@class='report-action col-xs-6']/a[contains(.,' Buy Title Documents ')]";
	public static String aboutNav1 = "//*[@class='fixed-aux-nav']/ul/li/a[contains(.,'About')]";
	public static String aboutNav = "//*[@id='freemium-floating-menu-about']";
	public static String viewPropertyTooltip = "//*[@id='property-insights']/div[2]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[1]/span[1]/i";
	public static String swipeImage = "//*[@id='photoGallerySide']/table/tbody/tr/td/div/div[2]/div[2]/div/img";
	public static String imgElement = "//*[@id='photoGallerySide']/table/tbody/tr/td/div/div[2]/div[2]/div";
	public static String propertyCouncil = "//*[@id='property-insights']/div[3]/div[7]/div/div[2]/div[1]/span[1]/a";
	
	//Watchlist Links
	public static String countWatchlist = "//*[@id='watchlist-results-table']";
	public static String propertyShowMore = "//*[@id='watchlist-results-table-more']";
	public static String streetShowMore = "//*[@id='street-results-table-more']";
	public static String suburbShowMore = "//*[@id='suburb-results-table-more']";
	public static String leftNavProperties = "//*[@wl-stat='wl-section-is-watched']";
	public static String leftNavPropertiesEle = "//*[@class='fixed-aux-nav']/ul/li/a[contains(.,'Properties')]";
	public static String myAccountLink = "//a[contains(.,'My Account')]";
	public static String checkAccount = "(//*[@class='row']/div[1])/h2[contains(.,'User Profile')]";
	
	//Portfolio Calculate
	public static String addedPortfolio = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]/h3";
	public static String clickAddEquity = "//*[@id='equity-not-select']/a";
	public static String calculateModalRT = "//*[@id='calculateModal']/div/div/div[2]/div";
	public static String updateNow = "//*[@id='update-now-button']";
	public static String currentLoan = "//*[@id='currentLoan']";
	public static String btnSave = "//*[@id='calculateModal']/div/div/div[2]/div/div[2]/a";
	public static String checkBox4 = "//*[@id='equity-select']";
	
	//Suburb Insights
	public static String stockMarket = "(//a[contains(.,'for sale')])[1]";
	public static String selectedPropertyType = "//*[@class='trigger'][contains(.,'House')]";
	public static String countResult = "//*[@class='result-list']";
	
	//RT My Account
	public static String editProfile = "//*[@class='col-md-8']/a[contains(.,'Edit Profile')]";
	public static String editProfilePage = "//*[@id='freemiumEditProfileForm']/div/div/h1";
	public static String changePassword = "//*[@class='user-left']/a[contains(.,'Change Password')]";
	public static String changePasswordPage = "//*[@class='form']/h1";
	public static String changeEmailOptions = "//*[@class='user-left']/a[contains(.,'Change Email Options')]";
	public static String changeEmailOptionsPage = "//*[@id='editEmailNotifications']/h4";
	
	//RT Explore
	public static String viewPropertiesForSale = "(//a[contains(.,'Properties for sale')])[1]";
	public static String clickSortOrder = "//*[@id='explore_metric_div']/a";
	public static String selectSortOrder = "//*[@id='explore_metric_div']/div/ul/li[2]/a";
	public static String verifySortOrder = "//*[@class='desc']";
	public static String selectSortOrder2 = "//*[@id='explore_metric_div']/div/ul/li[3]/a";
	
	//User Search
	public static String userSearch = "//*[@id='userSearch']";
	public static String customerDetails = "//*[@class='input-group']/h2";
	public static String accessLevel = "//*[@class='nav ']/a[contains(.,'Access Level')]";
	public static String updateSave = "//*[@id='btnSubmit']";
	public static String updateSuccess = "//*[@class='modal-title']";
	public static String modalOK = "//*[@class='modal-button-wrap']/input";
	public static String loginAsUser = "//*[@id='switchUser']";
	public static String btnReportsRT = "//*[@class='nav ']/a[contains(.,'Reports')]";
	public static String verifyReport = "//*[@class='oddnohover']";
	public static String btnSubscriptions = "//*[@class='nav ']/a[contains(.,'Subscription')]";
	public static String verifySubscriptions = "//*[@class='modal-box']";
	public static String btnExtend = "//*[@class='btn-line orange-btn-line manageSubscription']";
	public static String btnSaveRT = "//*[@class='btn-line orange-btn-line']";
	public static String btnSaveConfig = "//*[@class='btn lead-btn']";
	public static String successConfig = "//*[@class='alert alert-success']";
			
	//RT CMS
	public static String clickInfographic = "(//*[@class='col-xs-12 col-sm-2 col-md-2 col-lg-2 hidden-xs'])/ul/li/a[contains(.,'Infographic')]";
	public static String clickAboutUs = "(//*[@class='col-xs-12 col-sm-2 col-md-2 col-lg-2 hidden-xs'])/ul/li/a[contains(.,'About Us')]";
	public static String clickContactUs = "(//*[@class='col-xs-12 col-sm-2 col-md-2 col-lg-2 hidden-xs'])/ul/li/a[contains(.,'Contact Us')]";
	public static String clickFeatures = "(//*[@class='col-xs-12 col-sm-2 col-md-2 col-lg-2 hidden-xs'])/ul/li/a[contains(.,'Features')]";
	public static String clickPremiumCMS = "(//*[@class='col-xs-12 col-sm-3 col-md-3 col-lg-2 col-md-offset-1 hidden-xs'])/ul/li/a[contains(.,'Premium')]";
	public static String clickHelpFaq = "(//*[@class='col-xs-12 col-sm-2 col-md-2 col-lg-2 hidden-xs'])/ul/li/a[contains(.,'Help / FAQ')]";
}