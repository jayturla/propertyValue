package myrp.library;

public class MYRPObjectReference_RTC {

	// FSPR
	public static String searchbySLAS = "(//*[@id='singleLineSearch'])";
	public static String SearchAddressResults = "(//*[@class='acResults']//ul//li)[1]";
	public static String clickSearchAddress = "(//*[@id='searchButtonIcon'])";
	public static String clickAddedTocart = "(//*[@class='itemAdded'])";
	//public static String clickAddedTocart1 = "(//*[@class='itemAdded'])";
			
	public static String getFSPRbutton = "(//*[@value='Get free suburb profile report'])";

	public static String gettingEmailwindow = "(//*[@id='cboxLoadedContent'])";
	public static String emailaddressLabel = "(//*[@id='cboxLoadedContent']/div/div[1]/ul/li[2]/label)";
	public static String emailaddressField = "(//*[@id='freePackageEmail'])";
	public static String submitbuttonFSPR = "(//*[@id='freePackageSubmit'])";
	
	public static String thankyouWindow = "(//*[@id='cboxLoadedContent'])";
	public static String thankyouMessage = "(//*[@id='cboxLoadedContent']/div/div/label)";
	public static String FSPRthankyouImage = "(//*[@id='freePackageContainer']/center/a/img)";
	public static String FSPRcloseButton = "(//*[@id='cboxClose']/img)";
	
	// KEYS STATS
	public static String keyStatsTab = "(//a[contains(.,'Key stats')])";
	public static String SuburbProfileStats = "(//h1[contains(.,'Suburb Profile and Statistics')])";
	public static String SuburbProfileField = "(//*[@class='roundedGrayBg padding5'])[1]";
	public static String SuburbProfile = "(//h2[contains(.,'Profile')])";
	public static String yellowBG = "(//*[@class='roundedYellowBg'])";
	
	// KEYS STATS -- AREA STATS
	public static String AreaStatsField = "(//*[@class='full_base grey_fading_bg padding5'])";
	public static String AreaStatsLabel = "(//h2[contains(.,'Area Statistics')])";
	public static String AreaStatsYaxis = "(//*[@id='age-label'])";
	public static String AreaIncomeTab = "(//*[@id='area1li']/table/tbody/tr/td[2]/a)";
	public static String AreaIncomeTabYaxis = "(//*[@id='percentage-label'])";
	public static String AreaStructureTab = "(//*[@id='area2li']/table/tbody/tr/td[2]/a)";
	public static String AreaOccupancyTab = "(//*[@id='area3li']/table/tbody/tr/td[2]/a)";
	
	// KEY STATS -- PRICE GROWTH
	public static String PriceGrowthField = "(//*[@class='roundedGrayBg padding5'])[2]";
	public static String PriceGrowthDesc = "(//p[contains(.,'The following charts and tables compare one, three and ten year house and unit median values for Miami against the wider Miami LGA')])";
	public static String PriceGrowthDescLabel = "((//h2[contains(.,'Price Growth')])[1])";
	
	public static String PriceGrowthLabelChart = "((//h2[contains(.,'Price Growth')])[2])";
	public static String PriceGrowthChart = "(//*[@id='highcharts-0'])";
	public static String PriceGrowth12YearTab = "(//a[contains(.,'12 Months')])[1]";
	public static String PriceGrowth3YearTab = "(//a[contains(.,'3 Years')])[1]";
	public static String PriceGrowth10YearTab = "(//a[contains(.,'10 Years')])[1]";
	
	// KEY STATS -- AVERAGE TIME ON MARKET
	public static String AveTimeMarketField = "(//*[@class='roundedGrayBg padding5'])[4]";
	public static String AveTimeMarketDesc = "(//p[contains(.,'The following charts and tables compare one, three and ten year house and unit time on market durations for Miami against the wider Miami LGA')])";
	public static String AveTimeMarketDescLabel = "()";
	
	public static String AveTimeMarketYaxis = "()";
	public static String AveTimeMarket12YearTab = "(//a[contains(.,'12 Months')])[2]";
	public static String AveTimeMarket3YearTab = "(//a[contains(.,'3 Years')])[2]";
	public static String AveTimeMarket10YearTab = "(//a[contains(.,'10 Years')])[2]";
	
	// KEY STATS -- MEDIAN ASKING RENT
	public static String MedianAskingRentDesc = "()";
	public static String MedianAskingRentField = "()";
	public static String MedianAskingRentLabel = "()";
	public static String MedianAskingRentYaxis = "()";
	public static String MedianAskingRent12YearTab = "(//a[contains(.,'12 Months')])[3]";
	public static String MedianAskingRent3YearTab = "(//a[contains(.,'3 Years')])[3]";
	public static String MedianAskingRent10YearTab = "(//a[contains(.,'10 Years')])[3]";
			
	// KEY STATS -- RENTAL YIELD
	public static String RentalYieldDesc = "()";
	public static String RentalYieldField = "()";
	public static String RentalYieldLabel = "()";
	public static String RentalYieldYaxis = "()";
	public static String RentalYield12YearTab = "(//a[contains(.,'12 Months')])[4]";
	public static String RentalYield3YearTab = "(//a[contains(.,'3 Years')])[4]";
	public static String RentalYield10YearTab = "(//a[contains(.,'10 Years')])[4]";
	
	
	// PROPERTY REPORT // RT_07810 // multiple reports
	//estimated value report
	public static String EstimatedReportTab = "(//a[contains(.,'Property report')])";
	public static String EstimatedReportField = "(//div[contains(.,'Estimated value report')])[1]";
	public static String estimatedPurchaseButton = "(//*[@id='purchaseButton'])[3]";
	// detailed property report
	public static String DetailedReportTab = "(//a[contains(.,'Property report')])";
	public static String DetailedReportField = "(//div[contains(.,'Detailed property report')])[1]";
	public static String detailedPurchaseButton = "(//*[@id='purchaseButton'])[1]";
	// sales history report
	public static String SalesHistoryReportTab = "(//a[contains(.,'Property report')])";
	public static String SalesHistoryReportField = "(//div[contains(.,'Sales history report')])[1]";
	public static String SalesHistoryPurchaseButton = "(//*[@id='purchaseButton'])[2]";
	public static String SalesHistoryPopup = "(//*[@id='saModalPopup_popupTitle']/table/tbody/tr/td)";
	public static String SalesHistoryMsg = "(//*[@id='saModalPopup_popupBody']/div)";
	public static String SalesHistoryAgreeBtn = "(//*[@id='saModalPopup_okButton'])";
	//street sales report
	public static String StreetSalesReportTab = "(//a[contains(.,'Street report')])";
	public static String StreetSalesReportField = "(//div[contains(.,'Street sales history')])[1]";
	public static String StreetSalesPurchaseButton = "(//*[@id='purchaseButton'])[1]";
	// suburb sales history report
	public static String SuburbSalesReportTab = "(//a[contains(.,'Suburb report')])";
	public static String SuburbSalesReportField = "(//div[contains(.,'suburb sales history')])[1]";
	public static String SuburbSalesPurchaseButton = "(//*[@id='purchaseButton'])[1]";
	
	// investor postcode report
	public static String InvestorPostcodeReportTab = "(//a[contains(.,'Investors')])";
	public static String InvestorPostcodeReportField = "(//div[contains(.,'Investor postcode report')])[1]";
	public static String InvestorPostcodePurchaseButton = "(//*[@id='purchaseButton'])[1]";
	
	public static String MyCart = "(//*[@id='cartCount'])";
	///cart default
	public static String PurchaseContainer = "(//*[@id='shoppingCartForm']/ul/li[1]/div)";
	public static String GuestEmail = "(//*[@id='customerEmail'])";
	public static String merchantField = "(//*[@id='customerDetails'])";
	public static String cardNameLabel = "(//*[@id='cardNameContainer']/span)";
	public static String cardNameField = "(//*[@id='cardName'])";
	public static String cardNumberLabel = "(//*[@id='cardNumberContainer']/span)";
	public static String cardNumberField = "(//*[@id='cardNumber'])";
	public static String cardExpiryLabel = "(//*[@id='expirationDateContainer']/span)";
	public static String cardExpiryMonthField = "(//*[@id='expirationMonth'])";
	public static String cardExpiryYearField = "(//*[@id='expirationYear'])";
	public static String SecurityCodeLabel = "(//*[@id='securityCodeContainer']/span)";
	public static String SecurityCodeField = "(//*[@id='securityCode'])";
	
	public static String PaynowContainer = "(//*[@id='customerDetails']/div[2]/ul/li[2])";
	public static String PaynowButton = "(//*[@id='checkOutButton'])";
	
	public static String PaymentMsg = "(//span[contains(.,'Purchase successful')])";
	public static String PurchaseCompletedLabel = "(//*[@id='purchaseDoneForm']/ul/li[1])";
	public static String YoumightAlsoLikeFiels = "(//*[@id='upsellReports']/div)";
	public static String SuccessSignUpField = "(//*[@id='purchaseDoneForm']/ul/li[4]/table/tbody/tr/td[1]/table)";
	
	
	//SUBSCRIPTION
	public static String propertySevicesButton = "//a[@href='/n/Estimated-Value-Report/myrp-537']";
	public static String estimatedValueSubscriptionButton = "//a[@href='/n/Estimated-Value-Subscription/myrp-538']";
	public static String getThisreport = "(//a[contains(.,'Get this report')])";
	public static String realAddress = "//a[contains(.,'46 Cardwell Street Canley Vale NSW 2166')]";
	public static String searchReuslt = "(//*[@class='avmSalesHeading'])";	
	public static String estimatedsubsField = "(//div[contains(.,'Estimated value subscription (12 months)')])[1]";
	public static String estimatedsubsbtn = "(//*[@id='purchaseButton'])"; 
	
	public static String searchAddressField = "(//*[@id='landingSearch'])";
	//public static String searchAddressResult = "(//*[@class='jquery-autocomplete-selected-item acSelect']//ul//li)[1]";
	public static String logo = "(//*[@alt='myrpdata site logo'])";
	
	public static String suburbreportsButton = "//a[@href='/n/Free-Suburb-Profile/myrp-545']";
	public static String suburbsalesmapButton = "//a[@href='/n/Suburb-Sales-Map-Subscription/myrp-547']";
	public static String suburbvaluwmapButton = "//a[@href='/n/Suburb-Value-Map-Subscription/myrp-548']";
	public static String suburbfield = "(//*[@class='purchaseButton'])";
	public static String suburbfieldbutton = "(//*[@id='purchaseButton'])[2]";
	//public static String popup = "()";
	
	//cartsignin
	public static String usernameCart = "(//*[@id='cartUserName'])";
	public static String passwordCart = "(//*[@id='cartPasswordDefault'])";
	public static String loginbtnCart = "(//*[@name='cartLoginButton'])";
	
	// 25offer
	public static String offerfield = "(//*[@id='singleLineSearch'])";
	public static String strikePrice = "(//*[@class='strikeThrough'])[3]";
	public static String discPrice = "(//*[@itemprop='price'])[3]";
	public static String offer25Btn = "(//*[@id='purchaseButton'])[3]";
	
	//all partner search address
	public static String partnerSearchAddressField = "(//*[@id='searchAddress'])";
	public static String partnerSearchAddressResults = "(//*[@class='acResults']//ul//li)[1]";
	
	public static String partnerStreetAddress = "(//*[@itemprop='streetAddress'])";
	public static String propertyreportDetails = "(//*[@class='details'])[1]";
	public static String suburbreportDetails = "(//*[@class='details'])[2]";
	public static String Map = "(//*[@id='map'])";
	public static String partnerNameLabel ="(//label[contains(.,'Your Name:')])";
	public static String partnerNameField = "(//*[@id='agentNameInp'])";
	public static String partnerCustomerLabel ="(//label[contains(.,'Custome')])";
	public static String partnerCustomerField = "(//*[@id='customersNameInp'])";
	
	
	public static String partnersPurchasebtn = "(//*[@id='purchaseButton'])[1]";
	public static String partnersMycart = "(//*[@id='cartCount'])";
	//NAB Partner
	public static String nablogo = "(//img[@src='/cropImage/myrp.images.nab_i_logo.png'])";
	
	//cart partner
	public static String nabListPurchasedReports = "(//*[@id='purchaseReports'])";
	public static String nabPromotionSection = "//*[@id='promotionDetails']";
	public static String nabPromotionCodeField = "(//*[@id='promotionCode'])";
	public static String nabPromotionCodeBtn = "(//*[@name='applyPromoCodeButton'])";
	
	
	
	//plan partner
	public static String planlogo = "(//img[@src='/cropImage/myrp.images.plan_i_logo_new.jpg'])";
	
	// fast partner
	public static String fastlogo = "(//img[@src='/cropImage/myrp.images.fast_i_logo.png'])";
		
	//choice partner
	public static String choicelogo = "(//img[@src='/cropImage/myrp.images.choice_i_logo.png'])";
	
	//advantedge partner
	public static String advantedgelogo = "(//img[@src='/cropImage/myrp.images.advantedge_i_logo.png'])";
	
	//peopleschoice partner
	public static String peopleschoicelogo = "(//img[@src='/cropImage/myrp.images.peoplesChoice_i_logo.png'])";
	
	
	// cart partner
	public static String PartnerEmailLabel = "(//label[contains(.,'* Email:')])";
	public static String partnerGuestEmail = "(//*[@id='customerEmail'])";
	public static String partnermerchantField = "(//*[@id='customerDetails'])";
	public static String partnercardNameLabel = "(//label[contains(.,'* Name on card:')])";
	public static String partnercardNameField = "(//*[@id='cardName'])";
	public static String partnercardNumberLabel = "(//label[contains(.,'* Card Number:')])";
	public static String partnercardNumberField = "(//*[@id='cardNumber'])";
	public static String partnercardExpiryLabel = "(//label[contains(.,'* Expiration Date: (MM/YYYY)')])";
	public static String partnercardExpiryMonthField = "(//*[@id='expirationMonth'])";
	public static String partnercardExpiryYearField = "(//*[@id='expirationYear'])";
	public static String partnerSecurityCodeLabel = "(//label[contains(.,'* Security Code:')])";
	public static String partnerSecurityCodeField = "(//*[@id='securityCode'])";
	public static String termCondition = "//b[contains(.,'Terms & Conditions')]";
	public static String termConditionCheckbox = "(//*[@id='iAgree'])";
	public static String ConfirmDetails = "(//*[@class='confirmDetails'])";
	public static String PaynowBtn = "(//*[@id='checkOutButton'])";
	public static String successPage = "(//span[contains(.,'Purchase successful')])";
	
}