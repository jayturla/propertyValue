
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class ForgottenPasswordUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public ForgottenPasswordUtil(String[] i) {
		input = i;
	
	}
	
	//Navigate to FOrgot password Screen
	public boolean forgotPasswordNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(PVObjectReferenceSmoketest.logIn));
		click(xpath(PVObjectReferenceSmoketest.clickForgot));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.navForgotPasswordScreen));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.navForgotPasswordScreen)));
		String text = getText(xpath(PVObjectReferenceSmoketest.navForgotPasswordScreen));
		if(text.contains("Forgotten Password")){
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
			pass("Forgot Password link will navigate to Forgotten password screen.");
		}else {
			fail("Forgot Password link will not navigate to Forgotten password screen.");
		}
		
		return passed;
	}
	
	//reset password
	public boolean resetPassword(int steps, int inputVal, int expected, int actualPass, int actualFail, int email, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.forgotPasswordEmail), input[email]);
		click(xpath(PVObjectReferenceSmoketest.submitForgot));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.resetPassword));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.resetPassword)));
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.resetPassword));
		if(text.contains("An email has been sent to ")){
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
			pass("Details for Resetting your Password has been sent to your email.");
		}else {
			fail("Details for Resetting your Password has not been sent to your email.");
		}
		
		return passed;
	}
} 

