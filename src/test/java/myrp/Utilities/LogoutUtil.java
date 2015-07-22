
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import pv.atu_utilities.copy.ATUUtil;
import myrp.library.FunctionReference;
import myrp.library.SC_PVObjectReferenceSmoketest;

public class LogoutUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public LogoutUtil(String[] i) {
		input = i;
	
	}
	
	//verify if user can logout
	public boolean logout(int steps, int inputVal, int expected, int actualPass, int actualFail, int uName, int pWord, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(SC_PVObjectReferenceSmoketest.logIn));
		type(xpath(SC_PVObjectReferenceSmoketest.userName), input[uName]);
		type(xpath(SC_PVObjectReferenceSmoketest.passWord), input[pWord]);
		click(xpath(SC_PVObjectReferenceSmoketest.btnLogIn));
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.logOut));
		click(xpath(SC_PVObjectReferenceSmoketest.logOut));
		
		waitForElementPresent(xpath(SC_PVObjectReferenceSmoketest.logIn));
		String text = getText(xpath(SC_PVObjectReferenceSmoketest.logIn));
		if(text.contains("LOGIN")){
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
			pass("User can log out from account.");
		}else {
			fail("User can not log out from account.");
		}
		
		return passed;
	}
} 

