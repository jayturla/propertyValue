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
	public boolean checkBuyPostcodeReport(int steps, int inputVal, int expected, int actual, int userName, int password, int suburb, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnViewProfile));
		click(xpath(PVObjectReferenceSmoketest.btnViewProfile));
		
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
		click(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.ProfileReportPage));

		if (text.contains("Postcode Activity Report")) {
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
			pass("$Buy Postcode Report button can navigate to Property Profile Report Screen.");
		}else {
			fail("$Buy Postcode Report button cannot navigate to Property Profile Report Screen.");
		}
		return navigate;
	}
	
	//Check if Get This Report button can navigate to Payment Summary Screen
	public boolean clickGetThisReport(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		click(xpath(PVObjectReferenceSmoketest.btnGetThisReport));
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
		click(xpath(PVObjectReferenceSmoketest.rememberCard));
		click(xpath(PVObjectReferenceSmoketest.btnPayNow));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout)));
		String text = getText(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		
		if (text.contains("Payment Checkout")) {
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
		type(xpath(PVObjectReferenceSmoketest.cardNumber), "4111111111111111");
		type(xpath(PVObjectReferenceSmoketest.cardHolderName), input[chn]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry1), input[de1]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry2), input[de2]);
		type(xpath(PVObjectReferenceSmoketest.cardSecurityCode), input[cs]);
		
		click(xpath(PVObjectReferenceSmoketest.btnSubmit));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccess));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccess)));
		String text = getText(xpath(PVObjectReferenceSmoketest.paymentSuccess));
		
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
		click(xpath(PVObjectReferenceSmoketest.backtoHomepage));
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
}
