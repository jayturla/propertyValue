
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class LogoutUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public LogoutUtil(String[] i) {
		input = i;
	
	}
	
	//verify if user can logout
	public boolean logout(int steps, int inputVal, int expected, int actualPass, int actualFail, int uName, int pWord, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(PVObjectReferenceSmoketest.logIn));
		type(xpath(PVObjectReferenceSmoketest.userName), input[uName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[pWord]);
		click(xpath(PVObjectReferenceSmoketest.btnLogIn));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.logOut));
		click(xpath(PVObjectReferenceSmoketest.logOut));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.logIn));
		String text = getText(xpath(PVObjectReferenceSmoketest.logIn));
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

