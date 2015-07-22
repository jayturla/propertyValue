package myrp.library;

public class SC_PVObjectReferenceSmoketest {
	
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
	public static String userName = "//*[@id='userName']";
	public static String passWord = "//*[@id='password']";
	public static String slasBox = "//*[@id='singleLineSearch']";
	public static String addToCart = "//*[@id='estimatedValueButton']/div/*[@id='purchaseButton']";
	public static String goToCart = "//*[@id='goToCart']";
	public static String promoCode = "//*[@id='promotionCode']";
	public static String btnContinue = "//*[@id='checkOutButton']";
	public static String paymentSuccess = "//*[@id='purchaseDoneForm']/ul/li[1]/label";
	
	//Investors Postcode Report
	public static String investorsTab = "//a[contains(.,'Investors')]";
	public static String investorAddToCart = "(//*[@class='purchaseButtonContainer'])[1]/div/*[@id='purchaseButton']";
	public static String guestEmail = "//*[@id='customerEmail']";
	
	
	
}