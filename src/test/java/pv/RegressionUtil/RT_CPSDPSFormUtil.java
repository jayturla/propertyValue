package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import javax.lang.model.element.ElementVisitor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_CPSDPSFormUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_CPSDPSFormUtil(String[] i) {
			input = i;
	}
	
	//check if can navigate to Postcode Activity Report screen when buypostcodereport button is clicked
	public boolean BuyPostcodeReport(int steps, int inputVal, int expected, int actualPass, int actualFail, int urlnav, boolean withATU)  throws Exception {
		boolean navigate = false;
		
		driver.navigate().to(input[urlnav]);
		clickbtnBuyPostcodeReport(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.ProfileReportPage)));
		
		String text = getText(xpath(PVObjectReferenceSmoketest.ProfileReportPage));
		if (text.contains("Postcode Activity Report")) {
			navigate = true;
		}
		
		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
				}
		}
			
		if(navigate){
			pass("$Buy Postcode Report button can navigate to Postcode Activity Report Screen.");
		}else {
			fail("$Buy Postcode Report button cannot navigate to Postcode Activity Report Screen.");
		}
		return navigate;
	}
	
	//Check if Get This Report button can navigate to Payment Summary Screen
	public boolean GetThisReport(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception {
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
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
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
	public boolean PayNow(int steps, int inputVal, int expected, int actualPass, int actualFail, int email, boolean withATU)  throws Exception {
		boolean navigate = false;
		
		type(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail), input[email]);
		clickbtnBuyNow(0, 0, 0, 0, false);
		clickbtnPayNow(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout)));
		String text = getText(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		
		if (text.contains("Payment Checkout")) {
			navigate = true;
		}

		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
				}
		}
			
		if(navigate){
			pass("Pay Now Button can navigate to Payment Checkout Screen.");
		}else {
			fail("Pay Now Button cannot navigate to Payment Checkout Screen.");
		}
		return navigate;
	}
	
	//check if cancel payment will navigate to payment cancel screen and messages are correct
	public boolean cancelPayment(int steps, int inputVal, int expected, int actualPass, int actualFail, int body, boolean withATU)  throws Exception {
		boolean navigate = false;
		
		clickbtnCancel(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentMsg));
		String msg = getText(xpath(PVObjectReferenceSmoketest.paymentMsg));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentBodyTxt));
		String bodyTxt = getText(xpath(PVObjectReferenceSmoketest.paymentBodyTxt));
		String url = driver.getCurrentUrl();
		
		if (url.contains("/payment-cancel") && msg.contains("Payment failed")  && bodyTxt.contains(input[body])) {
			navigate = true;
		}

		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
				}
		}
			
		if(navigate){
			pass("Cancel button navigated to Payment cancel screen and Message and Body Text is correct.");
		}else {
			fail("Cancel button failed to navigate to Payment cancel screen.");
		}
		return navigate;
	}

	//click methods
	public boolean clickbtnBuyPostcodeReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
			click(xpath(PVObjectReferenceSmoketest.BuyPostcodeReport));
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
	
	public boolean clickbtnGetThisReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnGetThisReport));
			click(xpath(PVObjectReferenceSmoketest.btnGetThisReport));
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
	
	public boolean clickbtnCancel(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickCancel));
			click(xpath(PVObjectReferenceSmoketest.clickCancel));
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

