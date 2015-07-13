package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class PortfolioSummaryUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PortfolioSummaryUtil(String[] i) {
			input = i;
	}
	
	//check if portfolio snapshot is avaialable in portfolio summary page
	public boolean checkPortfolioSnapshot(int steps, int inputVal, int expected, int actual,int userName,int password, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		click(xpath(PVObjectReferenceSmoketest.clickMenu));
		click(xpath(PVObjectReferenceSmoketest.clickPortfolio));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.portfolioSnapshot));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.portfolioSnapshot));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Portfolio Snapshot Section is available.");
		}else {
			fail("Portfolio Snapshot Section is not available.");
		}
		return available;
	}
	
	//Verify if portfolio values are correct
	public boolean portfolioValues(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.portfolioValues));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.portfolioValues)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.portfolioValues));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Portfolio Values are correct.");
		}else {
			fail("Portfolio Values are not correct.");
		}
		return available;
	}
	
	//check if can calculate equity
	public boolean calculateEquity(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.calculateEquity));
		click(xpath(PVObjectReferenceSmoketest.calculateEquity));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.calculateModal));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.calculateModal)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.calculateModal));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Able to calculate total equity.");
		}else {
			fail("Unable to calculate total quity.");
		}
		return available;
	}
}

