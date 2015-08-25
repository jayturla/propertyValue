
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class MyAccountUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	public MyAccountUtil(String[] i) {
			input = i;
	}
	
	//My account
	
	public boolean clickAccount(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.gotoMyAccount)));
		String text = getText(xpath(PVObjectReferenceSmoketest.gotoMyAccount));
		if (text.contains("Account")) {
			available = true;
			
			clickgotoMyAccount(0,0,0,0,false);
			
			
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("My Account is Available and clickable");
		}else {
			fail("My Account is Not Available and clickable");
		}
	
		return available;
	}

			
	public boolean checkAccountPage(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyAccountPage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyAccountPage));
		if (text.contains("User Profile") && text.contains("My Receipts")) {
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
			pass("My Account button will navigate to Account Page");
		}else {
			fail("My Account button will not navigate to Account Page");
		}
	
		return available;
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
	
}
	
	

