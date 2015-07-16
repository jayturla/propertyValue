package pv.library;

public class PVObjectReferenceSmoketest {
	
	//HeaderZones
	public static String verifyLogin = "//*[@class='login']";
	public static String clickLogin = "//*[@class='logged-out'][1]";
	public static String verifyLoginPage = "//*[@class='form']";
	public static String userName ="//*[@id='userName']";
	public static String password = "//*[@id='password']";
	public static String loginSite = "//*[@class='form']//button";
	public static String verifyLoginName = "//*[@class='login']";
	public static String clickMenu = "(//*[@class='login']//a)[1]";
	public static String clickLogOut = "(//*[@class='login']//a)[5]";
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
	public static String advanceSearch = "(//*[@class='active']//button)[15]";
	public static String fpPage = "//*[@class='container'][1]";
	public static String unitAdvanceSearch = "//*[@id='adv_unitnumber']";
	public static String advanceSearchPage = "//*[@class='form']";
	public static String streetAdvanceSearch = "//*[@id='adv_streetname']";
	public static String searchResultsAdvanceSearch = "//*[@class='row sectionAnchor']";
	public static String gotoMyAccount = "(//*[@class='login']//a)[4]";
	public static String verifyAccountPage = "//*[@class='container'][1]";

		//HeaderZone jeck
		public static String clickExplore = "//a[contains(.,'Explore')]";
		public static String explorePage = "//*[@id='explore_form']/div/div/p[1]";
		public static String stateRegionFilter = "//*[@id='explore_form']/div/div/div[1]";
		public static String functionState = "//*[@id='explore_state_select']/a";
		public static String functionRegion = "//*[@id='explore_region_select']/a";
		public static String selectState = "//*[@id='explore_state_select']/div/ul/li[2]/a";
		public static String selectRegion ="//*[@id='explore_region_select']/div/ul";
		public static String metricSorting ="//*[@id='explore_metric_div']";
		public static String selectTopSuburb = "//*[@id='explore_form']/div/div/div[4]/table/tbody/tr[1]/td[1]/a";
		public static String checkProfilePage = "//*[@class='col-xs-12 col-sm-8 col-md-8 col-lg-8']";
		public static String clickPortfolio = "//a[contains(.,'Portfolio')]";
		public static String getPremium = "//a[contains(.,'Get Premium')]";
		
		
		//Homepage
		public static String headerNav = "//*[@class='main']";
		public static String slasBox = "id('propertysearch')";
		public static String statNat = "//*[@class='home-graph']";
		public static String topSuburbs = "//*[@class='top-suburbs']";
		public static String medianPriceChange = "//*[@id='topsuburblistpanel']/div[1]/div";
		public static String medianGrossYield = "//*[@id='topsuburblistpanel']/div[2]/div";
		public static String footer = "//footer";

		//Signup
		public static String btnSignup = "//*[@class='sign-up']";
		public static String SignupPage = "//h1[contains(.,'Sign up')]";
		//Signup with FB
		public static String clickSignupFB = "//*[@id='freemiumRegisForm']/div/div/div/div[1]/div[1]/div[5]/div/div[1]/a";
		public static String signupFB = "//*[@id='facebook']";	
		
		//PropertyProfileReport
		public static String BuyPropertyReport = "(//*[@id='property-insights']/div[1]/table/tbody/tr[1]/td/div[1]/ul[1]/li[2]/a)";
		public static String ProfileReportPage = "//*[@class='report']";	
		public static String btnGetThisReport = "//a[contains(.,'Get this report for ')]";
		public static String btnGetThisReportProperty = "//a[contains(.,'Get this Report for ')]";
		
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
		
		//Payment Checkout
		public static String PaymentCheckout = "//*[@id='PxPayAuthMain']/div/h2";
		public static String cardNumber = "//*[@id='CardNumber']";
		public static String cardHolderName = "//*[@id='CardHolderName']";
		public static String dateExpiry1 = "//*[@id='DateExpiry_1']";
		public static String dateExpiry2 = "//*[@id='DateExpiry_2']";
		public static String cardSecurityCode = "//*[@id='Cvc2']";
		public static String btnSubmit = "//*[@id='clickedAdd']";
		public static String paymentSuccess = "//h2[contains(.,'Your payment has been successful!')]";
		public static String checkEmail = "//*[@id='Email']";
		public static String gmailPasswd = "//*[@id='Passwd']";
		public static String checkGmail = "//*[@id=':2']/div/div";
		public static String btnNext = "//*[@id='next']";
		public static String btnSignin = "//*[@id='signIn']";
		
		//PostCodeDetails
		public static String postcodeAddress = "//h1[contains(.,'Suburbs in Postcode')]";
		public static String suburbLinks = "//*[@class='rowlist']";
		public static String clickSuburb = "//*/div[2]/div/div[2]/div[3]/div/div[1]/div[1]/b/a";
		public static String suburbMaps = "//*[@id='googleMap']/div/div[1]/div[2]";
		
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
		
		//PropertyDetails
		public static String propertyDetailsHeader = "//*[@class='ie']";
		public static String checkPropertyInsights = "//*[@id='property-insights']";
		public static String propertyInsightsData = "//h4[contains(.,'-')]";
		public static String propertyGallery = "//*[@id='property-insights']/div[2]/div[1]/div[1]";
		public static String aboutProperty = "//*[@id='property-insights']/div[3]";
		public static String comparableProperties = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div/div[2]/div[2]/div";
		public static String auctionResults = "//*[@id='property-insights']/div[3]/div[6]";
		public static String suburbInfo = "//*[@id='property-insights']/div[3]/div[7]/div";
		public static String suburbStats = "//*[@id='property-insights']/div[3]/div[8]/div/div[1]";
		public static String marketTrends = "//*[@id='upgrade-premium-btn']/div/a";
		
		//Portfolio Summary
		public static String portfolioSnapshot = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]";
		public static String portfolioValues = "//*[@id='portfolio-watchlist-div']/div/table/tbody/tr/td/div/div[1]/div[1]";
		public static String calculateEquity = "//*[@id='equity-not-select']/a";
		public static String calculateModal = "//*[@id='calculateModal']/div/div/div[2]";
		
		//StreetDetails
		public static String togglePropertyType = "//*[@id='propertyTypeToggle_units']";
		public static String clickHouse = "//*[@id='propertyTypeToggle_houses']";
		public static String checkStreetInsights = "//*[@class='sti']";
		public static String propertyPrices = "//*[@id='comparable_main_wrap']/table/tbody/tr/td/table/tbody/tr/td/div[2]/div";
		public static String streetAuction = "//h3[contains(.,' Auction ')]";
		public static String streetSuburbInfo = "//*[@class='spacer sectionAnchor']";
		public static String streetSuburbStat = "//*[@class='col-sm-12 col-md-12 hidden-xs nhGraph']";
		public static String otherStreets = "//*[@id='streets-insights-main-container']";	
		
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
		public static String checkSortText = "//a[contains(.,'Ainslie')]";
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
}