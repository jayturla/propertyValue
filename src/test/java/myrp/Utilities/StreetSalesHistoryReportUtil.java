
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class StreetSalesHistoryReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public StreetSalesHistoryReportUtil(String[] i) {
		input = i;
	
	}
	
	//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
	public boolean shopCartScreen(int steps, int inputVal, int expected, int actualPass, int actualFail, int street, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBoxSC), input[street]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAddToCart));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAddToCart)));
		Thread.sleep(2000);
		click(xpath(PVObjectReferenceSmoketest.streetAddToCart));
		click(xpath(PVObjectReferenceSmoketest.goToCart));
		
		String url = driver.getCurrentUrl();
		if(url.contains("/Payment-Form")){
			passed = true;
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Go to Cart button will navigate to Shopping Card Screen.");
		}else {
			fail("Go to Cart button will not navigate to Shopping Card Screen.");
		}
		
		return passed;
	}
	
	//payment success using promo code and guest email
	public boolean paymentSuccess(int steps, int inputVal, int expected, int actualPass, int actualFail, int promo, int guest, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.promoCodeSC), input[promo]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.promoCodeSC)).sendKeys(Keys.RETURN);
		
		type(xpath(PVObjectReferenceSmoketest.guestEmail), input[guest]);
		click(xpath(PVObjectReferenceSmoketest.btnContinueSC));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccessSC));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccessSC)));
		String text = getText(xpath(PVObjectReferenceSmoketest.paymentSuccessSC));
		
		if(text.contains("Your order has been successfully completed.")) {
			passed = true;
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Payment using promo code with email will navigate to Payment Success Screen.");
		}else {
			fail("Payment using promo code with email will not navigate to Payment Success Screen.");
		}
		
		return passed;
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

