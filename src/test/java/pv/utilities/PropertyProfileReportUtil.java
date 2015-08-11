package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class PropertyProfileReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PropertyProfileReportUtil(String[] i) {
			input = i;
	}
	
	//Check if $Buy Property Report Button is available in the page
	public boolean checkBuyPropertyReport(int steps, int inputVal, int expected, int actual,int property,boolean withATU)  throws Exception {
		boolean available = false;
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.BuyPropertyReport));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.BuyPropertyReport)));
		String text = getText(xpath(PVObjectReferenceSmoketest.BuyPropertyReport));

		if (text.contains("Buy Property Report")) {
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
			pass("$Buy Property Report button is available in the page.");
		}else {
			fail("$Buy Property Report button is NOT AVAILABLE in the page.");
		}
		return available;
	}
	
	//Check if $Buy Property Report button can navigate to Property Profile Report Screen
	public boolean clickBuyPropertyReport(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		clickbtnBuyPropertyReport(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.ProfileReportPage));

		if (text.contains("Property Profile Report")) {
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
			pass("$Buy Property Report button can navigate to Property Profile Report Screen.");
		}else {
			fail("$Buy Property Report button cannot navigate to Property Profile Report Screen.");
		}
		return navigate;
	}
	
	//Check if Get This Report button can navigate to Payment Summary Screen
	public boolean clickGetThisReport(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		clickbtnGetThisReportProperty(0,0,0,0,false);
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
	
	//check if buynow button will update to paynow button
	public boolean clickBuyNow(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		WebElement email = driver.findElement(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail));
		email.sendKeys("qwerty@gmail.com");
		clickbtnBuyNow(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow)));
		String text = getText(xpath(PVObjectReferenceSmoketest.btnPayNow));
		
		if (text.contains("Pay Now")) {
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
			pass("Buy Now/Confirm Email button successfully updated to Pay Now button.");
		}else {
			fail("Buy Now/Confirm Email button failed to update into Pay Now button.");
		}
		
		return navigate;
	}
	//check if paynow button will navigate to Payment Checkout
	public boolean clickPayNow(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean navigate = false;
		clickbtnPayNow(0,0,0,0,false);
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
		
		type(xpath(PVObjectReferenceSmoketest.cardNumber), "4111111111111111");
		type(xpath(PVObjectReferenceSmoketest.cardHolderName), input[chn]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry1), input[de1]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry2), input[de2]);
		type(xpath(PVObjectReferenceSmoketest.cardSecurityCode), input[cs]);
		
		clickbtnSubmit(0,0,0,0,false);
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
	
	public boolean clickbtnBuyPropertyReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.BuyPropertyReport));
			click(xpath(PVObjectReferenceSmoketest.BuyPropertyReport));
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
	public boolean clickbtnGetThisReportProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnGetThisReportProperty));
			click(xpath(PVObjectReferenceSmoketest.btnGetThisReportProperty));
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
	public boolean clickbtnBuyNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnBuyNow));
			click(xpath(PVObjectReferenceSmoketest.btnBuyNow));
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
	public boolean clickbtnPayNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow));
			click(xpath(PVObjectReferenceSmoketest.btnPayNow));
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
	public boolean clickbtnSubmit(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSubmit));
			click(xpath(PVObjectReferenceSmoketest.btnSubmit));
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
			click(xpath(PVObjectReferenceSmoketest.selectSuggestion));
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
	
}




