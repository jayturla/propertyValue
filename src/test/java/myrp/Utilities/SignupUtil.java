
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class SignupUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SignupUtil(String[] i) {
		input = i;
	
	}
	
	//Signup to subscriptions channel propertyvalue
	//Channge email every test
	public boolean signup(int steps, int inputVal, int expected, int actualPass, int actualFail, int firstName, int lastName, 
			int userEmail, int confirmEmail, int userPass, int confirmPass, boolean withATU) throws Exception {
		boolean passed = false;
		
		driver.navigate().to("http://consumer:QWE!%40%23rty456@dev-subscriptions.propertyvalue.com.au/");
		click(xpath(PVObjectReferenceSmoketest.clickSignup));
		type(xpath(PVObjectReferenceSmoketest.firstName), input[firstName]);
		type(xpath(PVObjectReferenceSmoketest.lastName), input[lastName]);
		type(xpath(PVObjectReferenceSmoketest.userEmail), input[userEmail]);
		type(xpath(PVObjectReferenceSmoketest.confirmEmail), input[confirmEmail]);
		type(xpath(PVObjectReferenceSmoketest.userPass), input[userPass]);
		type(xpath(PVObjectReferenceSmoketest.confirmPass), input[confirmPass]);
		click(xpath(PVObjectReferenceSmoketest.termsConditions));
		
		String captcha = null;
		
		System.out.print("Enter value for captcha: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		captcha = reader.readLine();
		type(xpath(PVObjectReferenceSmoketest.captchaField), captcha);
		
		click(xpath(PVObjectReferenceSmoketest.clickDone));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.successSignup));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.successSignup)));
		String text = getText(xpath(PVObjectReferenceSmoketest.successSignup));
		
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

