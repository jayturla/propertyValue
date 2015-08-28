
package pv.RegressionUtil;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RT_UserSearchUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_UserSearchUtil(String[] i) {
		input = i;
	}
	
	//Check if can search a user
	public boolean searchUser(int steps, int inputVal, int expected, int actualPass, int actualFail, int userName, int password, int user, boolean withATU)  throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.userName), input[userName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[password]);
		clickAdminLogin(0, 0, 0, 0, false);
		
		type(xpath(PVObjectReferenceSmoketest.userSearch), input[user]);
		clickselectSuggestion(0,0,0,0,false);
		
		String text = getText(xpath(PVObjectReferenceSmoketest.customerDetails));
		if(text.contains("Customer Details")){
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
			pass("Able to search a Freemium User and Details are shown.");
		}else {
			fail("Unable to search a Freemium User.");
		}
		return passed;
	}
	
	//check access level update
	public boolean accessLevel(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception {
		boolean passed = false;
		
		clickaccessLevel(0, 0, 0, 0, false);
		clickbtnSave(0, 0, 0, 0, false);
		
		String text = getText(xpath(PVObjectReferenceSmoketest.updateSuccess));
		if(text.contains("Success")){
			passed = true;
			clickmodalOK(0, 0, 0, 0, false);
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(passed){
			pass("User Role Access Level can change.");
		}else {
			fail("User Role Access Level cannot change.");
		}
		return passed;
	}
	
	//check if login as user is functional
	public boolean loginAsUser(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception {
		boolean passed = false;

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
				
		// Perform the click operation that opens new window
		clickLoginAsUser(0, 0, 0, 0, false);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
				
		// Perform the actions on new window
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickMenu)));
		String text = getText(xpath(PVObjectReferenceSmoketest.clickMenu));
		if(text.contains("Freemium")){
			passed = true;
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(passed){
			pass("Login As User is functional.");
		}else {
			fail("Login As User is not functional.");
		}
		return passed;
	}
	
	//clickMethods
	public boolean clickAdminLogin(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.adminLogin));
			click(xpath(PVObjectReferenceSmoketest.adminLogin));
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
	
	public boolean clickselectSuggestion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion));
			click(xpath(PVObjectReferenceSmoketest.selectSuggestion));
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
	
	public boolean clickaccessLevel(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.accessLevel));
			click(xpath(PVObjectReferenceSmoketest.accessLevel));
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
	
	public boolean clickbtnSave(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.updateSave));
			click(xpath(PVObjectReferenceSmoketest.updateSave));
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
	
	public boolean clickmodalOK(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.modalOK));
			click(xpath(PVObjectReferenceSmoketest.modalOK));
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
	
	public boolean clickLoginAsUser(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.loginAsUser));
			click(xpath(PVObjectReferenceSmoketest.loginAsUser));
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

