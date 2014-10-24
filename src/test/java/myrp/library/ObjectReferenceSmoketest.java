package myrp.library;

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


	//Search via CFA
	public static String cfaButton = "//*[@id='cantFindAddressIcon']";
	public static String unitNumber = "//*[@id='cantFindAddress_unitNumber']";	
	public static String streetName = "//*[@id='cantFindAddress_streetName']";
	public static String ajaxCFA = "//*[@class='searchResults cantFindAddListContainer']//li";
	public static String addressAjax = "//*[@class='searchResults cantFindAddListContainer']//li)[1]";
			
	
	//add to Cart Button 
	public static String addEstimatedvalueSubsciption = "(//*[@class='button plainRed'])[3]"; 

	
	//Main Buttons 
	public static String gotoMyCart = "//*[@id='cartCount']";
	
	
	//cart User Fields 
	public static String cartUserName = "//*[@id='cartUserName']";
	public static String cartPassword = "//*[@id='cartPasswordDefault']";
	public static String cartLogin = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/div[2]/ul/li[2]/ul/li/div/table/tbody/tr/td[2]/ul/li[6]/div/input";
	
	
	//Merchant
	public static String merchantName = "//*[@id='cardName']";
	public static String merchantCard = "//*[@id='cardNumber']";
	public static String merchantCode = "//*[@id='securityCode']";
	public static String merchantPaynow = "//*[@id='checkOutButton']";
		
} 