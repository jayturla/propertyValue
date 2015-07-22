
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import myrp.library.FunctionReference;
import myrp.library.SC_PVObjectReferenceSmoketest;

public class EstimatedValueReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public EstimatedValueReportUtil(String[] i) {
		input = i;
	
	}
	
	//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
	public boolean shopCartScreen(int steps, int inputVal, int expected, int actualPass, int actualFail, int uName, int pWord, 
			int property, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(SC_PVObjectReferenceSmoketest.logIn));
		type(xpath(SC_PVObjectReferenceSmoketest.userName), input[uName]);
		type(xpath(SC_PVObjectReferenceSmoketest.passWord), input[pWord]);
		click(xpath(SC_PVObjectReferenceSmoketest.btnLogIn));
		
		type(xpath(SC_PVObjectReferenceSmoketest.slasBox), input[property]);
		driver.findElement(xpath(SC_PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.addToCart));
		Assert.assertTrue(isElementPresent(xpath(SC_PVObjectReferenceSmoketest.addToCart)));
		click(xpath(SC_PVObjectReferenceSmoketest.addToCart));
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
	
	//payment success using promo code
	public boolean paymentSuccess(int steps, int inputVal, int expected, int actualPass, int actualFail, int promo, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(SC_PVObjectReferenceSmoketest.promoCode), input[promo]);
		driver.findElement(xpath(SC_PVObjectReferenceSmoketest.promoCode)).sendKeys(Keys.RETURN);
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
			pass("Payment using promo code will navigate to Payment Success Screen.");
		}else {
			fail("Payment using promo code will not navigate to Payment Success Screen.");
		}
		
		return passed;
	}
} 

