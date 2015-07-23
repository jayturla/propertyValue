
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

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
		
		click(xpath(PVObjectReferenceSmoketest.logIn));
		type(xpath(PVObjectReferenceSmoketest.userName), input[uName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[pWord]);
		click(xpath(PVObjectReferenceSmoketest.btnLogIn));
		
		type(xpath(PVObjectReferenceSmoketest.slasBoxSC), input[property]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBoxSC)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addToCart));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.addToCart)));
		click(xpath(PVObjectReferenceSmoketest.addToCart));
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
	
	//payment success using promo code
	public boolean paymentSuccess(int steps, int inputVal, int expected, int actualPass, int actualFail, int promo, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.promoCodeSC), input[promo]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.promoCodeSC)).sendKeys(Keys.RETURN);
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
			pass("Payment using promo code will navigate to Payment Success Screen.");
		}else {
			fail("Payment using promo code will not navigate to Payment Success Screen.");
		}
		
		return passed;
	}
} 

