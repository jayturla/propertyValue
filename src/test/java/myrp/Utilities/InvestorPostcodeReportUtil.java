
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import myrp.library.FunctionReference;
import myrp.library.SC_PVObjectReferenceSmoketest;

public class InvestorPostcodeReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public InvestorPostcodeReportUtil(String[] i) {
		input = i;
	
	}
	
	//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
	public boolean shopCartScreen(int steps, int inputVal, int expected, int actualPass, int actualFail, int postcode, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(SC_PVObjectReferenceSmoketest.slasBox), input[postcode]);
		driver.findElement(xpath(SC_PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);
		click(xpath(SC_PVObjectReferenceSmoketest.investorsTab));
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.investorAddToCart));
		Assert.assertTrue(isElementPresent(xpath(SC_PVObjectReferenceSmoketest.investorAddToCart)));
		click(xpath(SC_PVObjectReferenceSmoketest.investorAddToCart));
		Thread.sleep(2000);
		click(xpath(SC_PVObjectReferenceSmoketest.goToCart));
		
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
			pass("Go to Card button will navigate to Shopping Card Screen.");
		}else {
			fail("Go to Card button will not navigate to Shopping Card Screen.");
		}
		
		return passed;
	}
	
	//payment success using promo code and guest email
	public boolean paymentSuccess(int steps, int inputVal, int expected, int actualPass, int actualFail, int promo, int guest, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(SC_PVObjectReferenceSmoketest.promoCode), input[promo]);
		driver.findElement(xpath(SC_PVObjectReferenceSmoketest.promoCode)).sendKeys(Keys.RETURN);
		
		type(xpath(SC_PVObjectReferenceSmoketest.guestEmail), input[guest]);
		click(xpath(SC_PVObjectReferenceSmoketest.btnContinue));
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.paymentSuccess));
		Assert.assertTrue(isElementPresent(xpath(SC_PVObjectReferenceSmoketest.paymentSuccess)));
		String text = getText(xpath(SC_PVObjectReferenceSmoketest.paymentSuccess));
		
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
} 

