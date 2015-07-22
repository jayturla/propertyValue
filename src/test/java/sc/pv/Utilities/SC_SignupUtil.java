
package sc.pv.Utilities;


import static org.openqa.selenium.By.xpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.SC_PVObjectReferenceSmoketest;

public class SC_SignupUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SC_SignupUtil(String[] i) {
		input = i;
	
	}
	
	//Signup to subscriptions channel propertyvalue
	//Channge email every test
	public boolean signup(int steps, int inputVal, int expected, int actualPass, int actualFail, int firstName, int lastName, 
			int userEmail, int confirmEmail, int userPass, int confirmPass, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(SC_PVObjectReferenceSmoketest.clickSignup));
		type(xpath(SC_PVObjectReferenceSmoketest.firstName), input[firstName]);
		type(xpath(SC_PVObjectReferenceSmoketest.lastName), input[lastName]);
		type(xpath(SC_PVObjectReferenceSmoketest.userEmail), input[userEmail]);
		type(xpath(SC_PVObjectReferenceSmoketest.confirmEmail), input[confirmEmail]);
		type(xpath(SC_PVObjectReferenceSmoketest.userPass), input[userPass]);
		type(xpath(SC_PVObjectReferenceSmoketest.confirmPass), input[confirmPass]);
		click(xpath(SC_PVObjectReferenceSmoketest.termsConditions));
		
		String captcha = null;
		
		System.out.print("Enter value for captcha: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		captcha = reader.readLine();
		type(xpath(SC_PVObjectReferenceSmoketest.captchaField), captcha);
		
		click(xpath(SC_PVObjectReferenceSmoketest.clickDone));
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.successSignup));
		Assert.assertTrue(isElementPresent(xpath(SC_PVObjectReferenceSmoketest.successSignup)));
		String text = getText(xpath(SC_PVObjectReferenceSmoketest.successSignup));
		
		if(text.contains("You have successfully signed in to myRPData and you are now logged in.")){
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
			pass("Can signup into subscriptions channel.");
		}else {
			fail("Cannot signup into subscriptions channel.");
		}
		
		return passed;
	}
} 

