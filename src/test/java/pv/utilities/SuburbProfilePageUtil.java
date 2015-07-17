package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class SuburbProfilePageUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SuburbProfilePageUtil(String[] i) {
			input = i;
	}
	
	//check Suburb median prices split by bedroom count should be available
	public boolean checkBedroomSplit(int steps, int inputVal, int expected, int actual, int userName, int password, int suburb, boolean withATU ) throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		driver.navigate().to(input[suburb]);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.verifyBedroomSplit));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyBedroomSplit)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.verifyBedroomSplit));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Suburb median prices split by bedroom count are available.");
		}else {
			fail("Suburb median prices split by bedroom count are not available");
		}
		return available;
	}
	
	//check if can access investment strategy score
	public boolean checkScore(int steps, int inputVal, int expected, int actual, boolean withATU ) throws Exception {
		boolean available = false;
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.checkScore))){
			available = false;
		}else{
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
			pass("Investment Strategy Score is accessible.");
		}else {
			fail("Investment Strategy Score is not accessible.");
		}
		return available;
	}
	
	//check if unlimited property prices are shown
	public boolean checkPropertyPrices(int steps, int inputVal, int expected, int actual, boolean withATU ) throws Exception {
		boolean available = false;
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.checkPropertyPrices))){
			available = false;
		}else{
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
			pass("Unlimited properties for each status from the Proprty Prices for Suburb map and list section are shown.");
		}else {
			fail("Unlimited properties for each status from the Proprty Prices for Suburb map and list section are not shown.");
		}
		return available;
	}
	
	//verify if unlimited market trends are accessible
	public boolean checkUnlimitedMarketTrends(int steps, int inputVal, int expected, int actual, boolean withATU ) throws Exception {
		boolean available = false;
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrends))){
			available = false;
		}else{
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
			pass("Unlimited Market trends metrics are accessible.");
		}else {
			fail("Unlimited Market trends metrics are not accessible.");
		}
		return available;
	}
}

