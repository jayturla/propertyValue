package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class PremiumStreetDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PremiumStreetDetailsUtil(String[] i) {
			input = i;
	}
	
	//check if street composition breakdown is available
	public boolean checkBreakdown(int steps, int inputVal, int expected, int actual,int userName,int password, int street, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[street]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkBreakdown));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkBreakdown)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkBreakdown));
		if(text.contains("Properties on this Street")){
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
			pass("Street Composition breakdown is available.");
		}else {
			fail("Street Composition breakdown is not available.");
		}
		return available;
	}
	
	//check if can view unlimited properties for each status from the Proprty Prices for Street map and list section
	public boolean checkStreetUnliProperties(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.unliComparableProperties));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.unliComparableProperties)));
		String text = getText(xpath(PVObjectReferenceSmoketest.unliComparableProperties));
		if (text.contains(" of ")){
			available = false;
		}else {
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
			pass("Unlimited properties for each status from the Proprty Prices for Street map and list section are shown.");
		}else {
			fail("No Properties are for sale in this Street.");
		}
		return available;
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
}

