package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;


import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_SignupUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_SignupUtil(String[] i) {
			input = i;
	}
	
	//verify if signupbutton can navigate to signup page
	public boolean btnSignup(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean available = false;
		
		clickbtnSignup(0,0,0,0,false);
		String url = driver.getCurrentUrl();
		if(url.contains("/signup")){
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(available){
			pass("Signup Button is able to navigate to Signup Page.");
		}else {
			fail("Signup Button is unable to navigate to Signup Page.");
		}
		return available;
	}
	
	//check if mandatory fields are empty, clicked signup btn and validation message are available
	public boolean checkValidationMsg(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean available = false;
		
		clickbtnSubmitSignup(0, 0, 0, 0, false);
		String text = getText(xpath(PVObjectReferenceSmoketest.emptyFirstName));
		String text1 = getText(xpath(PVObjectReferenceSmoketest.emptyEmailAdd));
		String text2 = getText(xpath(PVObjectReferenceSmoketest.emptyPassword));
		String text3 = getText(xpath(PVObjectReferenceSmoketest.emptyCaptcha));
		
		if(text.contains("First name should not be empty.") && text1.contains("Email should not be empty.") 
				&& text2.contains("Password should not be empty.") && text3.contains("Validation code should not be empty.")) {
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(available){
			pass("Validation message for each mandatory fields are shown.");
		}else {
			fail("Validation message for each mandatory fields are not shown.");
		}
		return available;
	}
	
	
	public boolean clickbtnSignup(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSignup));
			click(xpath(PVObjectReferenceSmoketest.btnSignup));
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
	
	public boolean clickbtnSubmitSignup(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.submitSignup));
			click(xpath(PVObjectReferenceSmoketest.submitSignup));
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

