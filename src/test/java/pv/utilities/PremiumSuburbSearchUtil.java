package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class PremiumSuburbSearchUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PremiumSuburbSearchUtil(String[] i) {
			input = i;
	}
	
	//verify if advance filter is usable
	public boolean checkAdvanceFilters(int steps, int inputVal, int expected, int actual,int userName,int password,int suburb,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		clickselectSuggestion(0,0,0,0,false);
		
		clickbtnadvanceFilter(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.advanceFilter));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceFilter)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.advanceFilter));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Advanced Filter from suburb map result are usable.");
		}else {
			fail("Advanced Filter from suburb map result are not usable.");
		}
		return available;
	}
	
	//check if investment strategies metrics are workinng
	public boolean suburbHeatMap(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		clicktoggleInsights(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkDropdownInsights));;
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.clickList));
		clickList(0,0,0,0,false);
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Investment Strategy Metrics are selectable in Suburb Heat Maps.");
		}else {
			fail("Investment Strategy Metrics are not selectable in Suburb Heat Maps.");
		}
		return available;
	}
	
	//check if have unlimited access to recently sold results
	public boolean recentlySold(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		clickRecentlySold(0,0,0,0,false);
		clickSearch(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.moreResults));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.moreResults));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Premium Users have unlimited access to Recently Sold Properties.");
		}else {
			fail("Premium Users don't have unlimited access to Recently Sold Properties.");
		}
		return available;
	}
	
	//verify if actual price is shown 
	public boolean actualPrice(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actualPrice));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actualPrice)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.actualPrice));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Actual Sale Price is shown.");
		}else {
			fail("Actual Sale Price is not shown.");
		}
		return available;
	}
	
	public boolean clickbtnadvanceFilter(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickadvanceFilter));
			click(xpath(PVObjectReferenceSmoketest.clickadvanceFilter));
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
	public boolean clicktoggleInsights(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleInsights));
			click(xpath(PVObjectReferenceSmoketest.toggleInsights));
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
	public boolean clickList(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickList));
			click(xpath(PVObjectReferenceSmoketest.clickList));
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
	public boolean clickRecentlySold(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickRecentlySold));
			click(xpath(PVObjectReferenceSmoketest.clickRecentlySold));
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
	public boolean clickSearch(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickSearch));
			click(xpath(PVObjectReferenceSmoketest.clickSearch));
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
}



