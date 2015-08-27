package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.HeaderZoneUtil;

public class RT_MyAccountUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_MyAccountUtil(String[] i) {
			input = i;
	}
	
	//Can edit profile
	public boolean EditProfile(int steps, int inputVal, int expected, int actualPass, int actualFail, int userName, int password, boolean withATU) throws Exception {
		boolean passed = false;
		
		pv.utilities.HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);		
		login.loginSite();
		
		clickMenu(0, 0, 0, 0, false);
		clickgotoMyAccount(0,0,0,0,false);
		clickEditProfile(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.editProfilePage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.editProfilePage)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.editProfilePage));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Can edit profile on my account page.");
		}else {
			fail("Cannot edit profile on my account page.");
		}
		driver.navigate().back();
		return passed;
	}
	
	//Can change password
	public boolean changePassword(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
	
		clickChangePassword(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.changePasswordPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.changePasswordPage)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.changePasswordPage));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Can change password on my account page.");
		}else {
			fail("Cannot change password on my account page.");
		}
		driver.navigate().back();
		return passed;
	}
	
	//can edit email notifications
	public boolean EmailOptions(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
	
		clickEmailOptions(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.changeEmailOptionsPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.changeEmailOptionsPage)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.changeEmailOptionsPage));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Can change email settings on my account page.");
		}else {
			fail("Cannot change email settings on my account page.");
		}
		return passed;
	}
	
	//CLICK
	public boolean clickMenu(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMenu));
			click(xpath(PVObjectReferenceSmoketest.clickMenu));
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
	
	public boolean clickgotoMyAccount(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.gotoMyAccount));
			click(xpath(PVObjectReferenceSmoketest.gotoMyAccount));
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
	
	public boolean clickEditProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.editProfile));
			click(xpath(PVObjectReferenceSmoketest.editProfile));
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
	
	public boolean clickChangePassword(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.changePassword));
			click(xpath(PVObjectReferenceSmoketest.changePassword));
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
	
	public boolean clickEmailOptions(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.changeEmailOptions));
			click(xpath(PVObjectReferenceSmoketest.changeEmailOptions));
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


