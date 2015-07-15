package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class CompareUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public CompareUtil(String[] i) {
			input = i;
	}
	
	//PUrchase any product using promo code
	public boolean verifyCompare(int steps, int inputVal, int expected, int actual, int userName,int password, int url, int compareA, int compareB, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		driver.navigate().to(input[url]);

		type(xpath(PVObjectReferenceSmoketest.compareBoxA), input[compareA]);
		type(xpath(PVObjectReferenceSmoketest.compareBoxB), input[compareB]);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.Comparison));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.Comparison));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Able to search and compare 2 suburbs.");
		}else {
			fail("Unable to search and compare 2 suburbs.");
		}
		return available;
		
	}
}

