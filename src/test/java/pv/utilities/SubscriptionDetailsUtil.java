package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class SubscriptionDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SubscriptionDetailsUtil(String[] i) {
			input = i;
	}
	//check if subscription type and expiry are shown
	public boolean checkSubscriptionDetails(int steps, int inputVal, int expected, int actual,int userName,int password,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		login.clickMenu();
		click(xpath(PVObjectReferenceSmoketest.gotoMyAccount));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.subscriptionType));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.subscriptionType)));
		String text = getText(xpath(PVObjectReferenceSmoketest.subscriptionType));

		if (text.contains(" Subscription") && text.contains("Expires on:")) {
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
			pass("Subscription Type and Expiry Date are Shown.");
		}else {
			fail("Subscription Type and Expiry Date are Missing.");
		}
		return available;
	}
}

