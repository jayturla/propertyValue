package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

public class PostcodeActivityReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PostcodeActivityReportUtil(String[] i) {
			input = i;
	}
	
	//Check if $Buy Postcode Report Button is available in the page
	public boolean checkBuyPostcodeReport(int steps, int inputVal, int expected, int actual, int userName, int password, int suburb,int suburbPage, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		//type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		//clickselectSuggestion(0,0,0,0,false);
		//clickbtnViewProfile(0,0,0,0,false);
		driver.navigate().to(input[suburbPage]);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport)));
		String text = getText(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));

		if (text.contains("Buy Postcode Report")) {
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		if(available){
			pass("$Buy Postcode Report button is available in the page.");
		}else {
			fail("$Buy Postcode Report button is NOT AVAILABLE in the page.");
		}
		return available;
	}
	
	//Check if $Buy Postcode Report button can navigate to Postcode Activity Report Screen
	public boolean clickBuyPostcodeReport(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		
		clickbtnBuyPostcodeReport(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.postcodeActivityReportHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.postcodeActivityReportHeader)));
		String text = getText(xpath(PVObjectReferenceSmoketest.postcodeActivityReportHeader));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.postcodeReportSection));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.postcodeReportSection)));
		
		//waitForElementPresent(xpath(PVObjectReferenceSmoketest.getPostcodeReport));
		//Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.getPostcodeReport)));
		
		if(text.contains("Postcode Activity Report"))
		{
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.postcodeReportSection))==true)
			{
					navigate = true;
			}
		}
		
		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(navigate){
			pass("$Buy Postcode Report button can navigate to Property Profile Report Screen.");
		}else {
			fail("$Buy Postcode Report button cannot navigate to Property Profile Report Screen.");
		}
		return navigate;
	}
	
	//Check if Get This Report button can navigate to Payment Summary Screen
	public boolean clickGetThisReport(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		clickbtnGetThisReport(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentSummaryScreen));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.PaymentSummaryScreen)));
		String text = getText(xpath(PVObjectReferenceSmoketest.PaymentSummaryScreen));

		if (text.contains("Complete your payment to receive the report")) {
			navigate = true;
		}
		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(navigate){
			pass("Get This Report button can navigate to Payment Summary Screen.");
		}else {
			fail("Get This Report button cannot navigate to Payment Summary Screen.");
		}
		return navigate;
	}
	
	
	//check if paynow button will navigate to Payment Checkout
	public boolean clickPayNow(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.reportAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.reportAddress)));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.price));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.price)));
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.reportAddress))==true &&
				isElementPresent(xpath(PVObjectReferenceSmoketest.price)) == true)
		{
			clickrememberCard(0,0,0,0,false);
			clickbtnPayNow(0,0,0,0,false);
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.PaymentCheckout))==true )
					{
						navigate=true;
					}
		}
		
		
		
		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(navigate){
			pass("Pay Now Button can navigate to Payment Checkout Screen.");
		}else {
			fail("Pay Now Button cannot navigate to Payment Checkout Screen.");
		}
		return navigate;
	}
	
	//Submit valid credit card details - redirect to Payment Success page
	public boolean submitCreditCard(int steps, int inputVal, int expected, int actual, int chn, int de1,
			int de2, int cs, boolean withATU)  throws Exception {
		boolean details = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.waitCreditCardPayment));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.waitCreditCardPayment)));
		
		type(xpath(PVObjectReferenceSmoketest.cardNumber), "4111111111111111");
		type(xpath(PVObjectReferenceSmoketest.cardHolderName), input[chn]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry1), input[de1]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry2), input[de2]);
		type(xpath(PVObjectReferenceSmoketest.cardSecurityCode), input[cs]);
		
		clickbtnSubmit(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccessHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccessHeader)));
		
		String text = getText(xpath(PVObjectReferenceSmoketest.paymentSuccessHeader));
		
		if (text.contains("Your payment has been successful!")) {
			details = true;
		}
		if(withATU) {
			if(details){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(details){
			pass("Submit Credit card details Payment Success.");
		}else {
			fail("Submit Credit card details Payment Failed.");
		}
		return details;
	}
	
	//check if back to home page link is available and can navigate to homepage when clicked
	public boolean backHomepage(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.backtoHomepage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.backtoHomepage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.backtoHomepage));
		
		if (text.contains("Back to home page")) {
			available = true;
		}
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Back to home page link is available.");
		}else {
			fail("Back to home page link is not available.");
		}
		return available;
	}
	
	public boolean clickbackHomepage(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.backtoHomepage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.backtoHomepage)));
		clickbtnbacktoHomepage(0,0,0,0,false);
		String url = driver.getCurrentUrl();
		if(url.contains("propertyvalue.com.au")){
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Back to home page link can navigate to homepage.");
		}else {
			fail("Back to home page link cannot navigate to homepage.");
		}
		return available;
	}
	
	public boolean clickbtnViewProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbButton));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbButton)));
			if (isElementVisible(xpath(PVObjectReferenceSmoketest.viewSuburbButton)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.viewSuburbButton));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnBuyPostcodeReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport)));
			if (isElementVisible(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnGetThisReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.getPostcodeReport));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.getPostcodeReport)));
			if (isElementVisible(xpath(PVObjectReferenceSmoketest.getPostcodeReport)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.getPostcodeReport));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickrememberCard(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.rememberCard));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.rememberCard)));
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.rememberCard)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.rememberCard));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnPayNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow)));
			
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow))==true)
			{
				click(xpath(PVObjectReferenceSmoketest.btnPayNow));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnSubmit(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSubmit));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.btnSubmit)));
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.btnSubmit)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.btnSubmit));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnbacktoHomepage(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.backtoHomepage));
			click(xpath(PVObjectReferenceSmoketest.backtoHomepage));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	
	public boolean clickselectSuggestion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion)));
			
			if (isElementVisible(xpath(PVObjectReferenceSmoketest.selectSuggestion)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.selectSuggestion));
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
}




