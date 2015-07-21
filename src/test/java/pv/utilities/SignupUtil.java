package pv.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;


public class SignupUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SignupUtil(String[] i) {
			input = i;
	}
	
	//verify if signupbutton can navigate to signup page
	public boolean btnSignup(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		
		click(xpath(PVObjectReferenceSmoketest.btnSignup));
		String url = driver.getCurrentUrl();
		if(url.contains("/signup")){
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
			pass("Signup Button is able to navigate to Signup Page.");
		}else {
			fail("Signup Button is unable to navigate to Signup Page.");
		}
		return available;
	}
	
	//fill all the mandatory fields and success signup
	public boolean signupSuccess(int steps, int inputVal, int expected, int actual, int fName, int lName, int adBox, int emBox, int conEmBox,
			int pWord, int conPWord, boolean withATU) throws Exception {
		boolean available = false;
		
		type(xpath(PVObjectReferenceSmoketest.firstNameBox), input[fName]);
		type(xpath(PVObjectReferenceSmoketest.lastNameBox), input[lName]);
		type(xpath(PVObjectReferenceSmoketest.addressBox), input[adBox]);
		type(xpath(PVObjectReferenceSmoketest.emailBox), input[emBox]);
		type(xpath(PVObjectReferenceSmoketest.confirmEmailBox), input[conEmBox]);
		type(xpath(PVObjectReferenceSmoketest.passwordBox), input[pWord]);
		type(xpath(PVObjectReferenceSmoketest.confirmpasswordBox), input[conPWord]);
		click(xpath(PVObjectReferenceSmoketest.termsAndCondition));
		
		String captcha = null;
		
		System.out.print("Enter value for captcha: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		captcha = reader.readLine();
		
		type(xpath(PVObjectReferenceSmoketest.captchaBox), captcha);
		
		click(xpath(PVObjectReferenceSmoketest.submitSignup));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.signupSuccess));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.signupSuccess)));
		
		String text = getText(xpath(PVObjectReferenceSmoketest.signupSuccess));
		if(text.contains("Your account has been created")){
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
			pass("Success signup modal is prompted and Navigatede to homepage.");
		}else {
			fail("Failed Signing Up.");
		}
		return available;
	}
}

