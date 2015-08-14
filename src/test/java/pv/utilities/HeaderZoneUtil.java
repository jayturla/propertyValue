
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;


public class HeaderZoneUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	public HeaderZoneUtil(String[] i) {
			input = i;
	}
	
	//Checking Header if available in the homepage
	
	public boolean checkLogin(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyLogin)));
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyLogin));

		if (text.contains("Log in")) {
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
			pass("Login is available in the page");
		}else {
			fail("Login is NOT AVAILABLE in the page");
		}
		return available;
	
	}

	public void clickLogin()  throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogin));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickLogin)));
		click(xpath(PVObjectReferenceSmoketest.clickLogin));
		
	}

	public void enterUserName(int inputval) throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.userName));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.userName)));
		type(xpath(PVObjectReferenceSmoketest.userName), input[inputval]);
	}
	
	public void enterPassword(int inputval) throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.password));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.password)));
		type(xpath(PVObjectReferenceSmoketest.password), input[inputval]);
	}
	

	public void loginSite() throws Exception{

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.loginSite));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.loginSite)));
		click(xpath(PVObjectReferenceSmoketest.loginSite));
	
	}

	public void forgottenPassword() throws Exception{

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.forgottenPassword));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.forgottenPassword)));
		click(xpath(PVObjectReferenceSmoketest.forgottenPassword));
	}
	
	public boolean enterEmailFP(int steps, int inputVal, int expected, int actualPass, int actualFail, int email, boolean withATU) throws Exception{ 
		boolean available = false;
		
		String text = getText(xpath(PVObjectReferenceSmoketest.fpPage));
		if (text.contains("Forgotten Password")) {
			available = true;	
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.emailForgottenPassword));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.emailForgottenPassword)));
		type(xpath(PVObjectReferenceSmoketest.emailForgottenPassword), input[email]);
		
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Enter Email Address in Forgotten password is displaying!");
		}else {
			fail("Enter Email Address in Forgotten password is NOT displaying");
		}
		

		return available;
	
	}
	
	public boolean clickResetFP(int steps, int inputVal, int expected, int actualPass,int actualFail,boolean withATU) throws Exception{
		boolean available = false; 
		
		String text = getText(xpath(PVObjectReferenceSmoketest.resetFP));
		if (text.contains("Reset")) {
			available = true;	
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.resetFP));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.resetFP)));
		clickbtnresetFP(0,0,0,0,false);
		
	}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Reset buton is displayed!");
		}else {
			fail("Reset buton is not displayed!");
		}
		
		return available;
		
	}
	
	public boolean LoginPV(int steps, int inputVal, int expected, int actualPass,int actualFail,int userName,int password,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickLogin();
		enterUserName(userName);
		enterPassword(password);
		loginSite();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyLoginName));
		if (text.contains("tooltwist")) {
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
			pass("Existing User was able to Login!");
		}else {
			fail("Existing User was not able to Login!");
		}
		

		return available;
	}

	
	
	public void clickMenu() throws Exception{ 
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMenu));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickMenu)));
		click(xpath(PVObjectReferenceSmoketest.clickMenu));
	}
	
	
	public void clickLogOut() throws Exception{ 
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogOut));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickLogOut)));
		click(xpath(PVObjectReferenceSmoketest.clickLogOut));
		
	}
	
	
	public boolean logOutUser(int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		clickMenu();
		clickLogOut();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyLoginName));
		if (text.contains("Log in")) {
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
			pass("Existing User was able to Logout");
		}else {
			fail("Existing User was not able to Logout!");
		}
		

		return available;
	}
	

	public boolean resetPassword(int steps, int inputVal, int expected, int actualPass,int actualFail ,int email ,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickLogin();
		forgottenPassword();
		enterEmailFP(0, 0, 0, 0, 0, email, false);
		clickResetFP(0,0,0,0,0,false);
		 
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyResetPW));
		if (text.contains("Your password has been reset")) {
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
			pass("User was able to Reset Password");
		}else {
			fail("User was able to Reset Password");
		}
		

		return available;
	}
	
	public boolean clickbtnresetFP(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.resetFP));
			click(xpath(PVObjectReferenceSmoketest.resetFP));
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

