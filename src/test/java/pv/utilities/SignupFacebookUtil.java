package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class SignupFacebookUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SignupFacebookUtil(String[] i) {
			input = i;
	}
	
	//Verify if Signup with facebook is working
	public boolean signupFacebook(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		click(xpath(PVObjectReferenceSmoketest.btnSignup));
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		click(xpath(PVObjectReferenceSmoketest.clickSignupFB));
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.signupFB));
		String text = getText(xpath(PVObjectReferenceSmoketest.signupFB));

		if (text.contains("Facebook")) {
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
			pass("Can sign up with Facebook.");
		}else {
			fail("Cannot sign up with Facebook");
		}
		return available;
	}
}

