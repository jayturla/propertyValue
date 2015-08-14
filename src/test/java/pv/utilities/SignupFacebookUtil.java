package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class SignupFacebookUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SignupFacebookUtil(String[] i) {
			input = i;
	}
	
	//Verify if Signup with facebook is working
	public boolean signupFacebook(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		clickbtnSignup(0,0,0,0,false);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		clickSignupFB(0,0,0,0,false);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.signupFB));
		String text = getText(xpath(PVObjectReferenceSmoketest.signupFB));

		if (text.contains("Facebook")) {
				available = true;
				driver.close();
				driver.switchTo().window(winHandleBefore);
				
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
	
	public boolean clickSignupFB(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickSignupFB));
			click(xpath(PVObjectReferenceSmoketest.clickSignupFB));
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

