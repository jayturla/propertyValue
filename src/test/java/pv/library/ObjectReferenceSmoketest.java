package pv.library;

public class ObjectReferenceSmoketest {

	// MYRP Sign Up
	public static String signUp = "/html/body/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/div/ul/li[2]/div/a";
	public static String firstName = "//*[@id='firstName']";
	public static String lastName = "//*[@id='lastName']";
	public static String email = "//*[@id='userEmail']";
	public static String confirmMail = "//*[@id='confirmUserEmail']";
	public static String password = "//*[@id='userPass']";
	public static String confirmPassword = "//*[@id='confirmUserPass']";
	public static String securityQuestion = "//*[@id='securityQuestion']";
	public static String confirmSecuritQuestion = "//*[@id='securityAnswer']";
	public static String acceptTerms = "//*[@id='termsConditions']";
	public static String done = "//*[@id='subRegInd']";
	
	
	// Login 
	public static String loginButton = "//*[@class='buttonLogin']";
	public static String usernameLogin = "//*[@id='userName']";
	public static String passwordLogin = "//*[@id='password']";
	public static String LoginRedbutton = "(//*[@name='loginButton'])";
	public static String forgottenPassword = "//a[@href='/n/fp/myrp-319']";
	public static String forgottenPasswordEmail = "//*[@id='forgot_password_email']";
	public static String submitButtonForgottenPassword = "//*[@class='button plainRed askSecQuestButton']//a";
	
	
	//Search via CFA
	public static String cfaButton = "//*[@id='cantFindAddressIcon']";
	public static String unitNumber = "//*[@id='cantFindAddress_unitNumber']";	
	public static String streetName = "//*[@id='cantFindAddress_streetName']";
	public static String ajaxCFA = "//*[@class='searchResults cantFindAddListContainer']//li";
	public static String addressAjax = "//*[@class='searchResults cantFindAddListContainer']//li)[1]";
			
	
	//add to Cart Button 
	public static String addEstimatedvalueSubsciption = "(//*[@class='button plainRed'])[3]"; 
	public static String iAgree = "//*[@id='saModalPopup_okButton']";
	public static String verifyIAgree = "//*[@class='fontStyle16']";
	
	//Main Buttons 
	public static String gotoMyCart = "//*[@id='cartCount']";
	public static String logOutButton = "//a[contains(.,'LOGOUT')]";
	public static String userNameDisplay = "//*[@class='customerName']";
	
	//cart User Fields 
	public static String cartUserName = "//*[@id='cartUserName']";
	public static String cartPassword = "//*[@id='cartPasswordDefault']";
	public static String cartLogin = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/div[2]/ul/li[2]/ul/li/div/table/tbody/tr/td[2]/ul/li[6]/div/input";
	
	
	//Merchant
	public static String merchantName = "//*[@id='cardName']";
	public static String merchantCard = "//*[@id='cardNumber']";
	public static String merchantCode = "//*[@id='securityCode']";
	public static String merchantPaynow = "//*[@id='checkOutButton']";

	//Purchase Success 
	public static String purchaseSuccess = "//*[@class='wbdRichText'][contains(.,'Purchase successful')]";
		
	//Tabs 
	public static String adminButton = "(//*[@class='button redTheme'])[1]//a";
			
	//Admin Links 
	public static String healthCheck =	"//a[contains(.,'Health Check')]";
	public static String checkAllConnections = "//a[contains(.,'Check All Connections.')]";
	public static String healthCheckResults = "//*[@id='checkResult']"; 
		
	//Main Buttons 
	public static String suburbReportsButton = "//a[@href='/n/Free-Suburb-Profile/myrp-545']";
	public static String suburbReportsLabel = "//h1[contains(.,'Suburb Reports')]";
	public static String suburbSalesMapSubscription = "//a[@href='/n/Suburb-Sales-Map-Subscription/myrp-547']";
	public static String austinCrescent = "//a[@href='/property/13_austin_crescent_lane_cove_nsw_2066/3593065']";
	public static String infographicTab = "//a[@href='/n/Infographic-Home/myrp-1003']";
										
	//SLAS
	public static String slasField = "//*[@id='singleLineSearch']";
	public static String selectajax = "(//*[@class='acResults']//ul//li)[1]";
												
	//CPS 
	public static String orderNowCPS = "//*[@class='cpsPaymentContainer'][contains(.,'Order Now')]";
	public static String payNowCPS = "(//*[@id='getApproval'])";
	public static String paymentCheckout ="//*[@class='wrapper']//div[2]//div[1]//h2[1]";
	
	//CheckOUT 
	public static String cardNumber = "//*[@id='CardNumber']";
	public static String cardHolder = "//*[@id='CardHolderName']";
	public static String monthDate = "//*[@id='DateExpiry_1']";
	public static String yearDate = "//*[@id='DateExpiry_2']";
	public static String cardSecurutyCode = "//*[@id='Cvc2']";
	public static String submitButtonCheckout = "//*[@id='Add']";
	public static String guestEmail = "//*[@id='customerEmail']";
	
	//Tabs
	public static String investorTab = "//*[@class='tab infotab_label'][contains(.,'Investors')]//a[1]";
	public static String keyStats = "//a[@href='/stats/sa/magill/5072']";
	public static String homeLoansTab = "//*[@class='tab infotab_label'][contains(.,'Home loans')]//a";
	public static String investorsTab = "//*[@class='navtab']//li[5]//div//a";      
	public static String localExperts = "//a[@href='/local-experts/nsw/manly/2095']";
										
	//Verify Fields 
	public static String investorPostCodeField = "//*[@class='purchaseButtonLabel']";
	public static String areaStatisticsKeyStats = "//*[@class='fontStyle17']";
	public static String infographicIntro = "//*[@class='infograph_intro']//span//p[1]";
	public static String findHomeLoan = "//*[@class='left']//h1";
	public static String homeLoanLetUs = "//*[@class='left']//p";	
	public static String ReportVerified = "//*[@class='labelText']";
	public static String verifyFPEmailSubmit = "(//*[@class='fp-success-wrap'][contains(.,'An email')])";
	public static String verifyinvestorInsighTool = "//*[@class='fontStyle1 header1']";
	public static String verifyLocalExperts = "//*[@class='main']";
	
	//Get Report
	public static String investorsGetReport = "//*[@class='roundedRedBg']//a";
	
} 