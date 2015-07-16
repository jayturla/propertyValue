package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class StrategiesAndExploreUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public StrategiesAndExploreUtil(String[] i) {
			input = i;
	}
	
	//Check InvestmentStrategy Score column if available
	public boolean checkInvestmentStrategyScore(int steps, int inputVal, int expected, int actual, int userName,int password, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		click(xpath(PVObjectReferenceSmoketest.clickStrategy));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategy));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategy)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.investmentStrategy));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Investment Strategy Score are available.");
		}else {
			fail("Investment Strategy Score are not available.");
		}
		return available;
	}
	
	//check explore unlimited suburbs
	public boolean checkUnliSuburbs(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		click(xpath(PVObjectReferenceSmoketest.clickExplore));
		click(xpath(PVObjectReferenceSmoketest.functionState));
		click(xpath(PVObjectReferenceSmoketest.selectState));
		click(xpath(PVObjectReferenceSmoketest.functionRegion));
		click(xpath(PVObjectReferenceSmoketest.selectRegion));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkExplorePane));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkExplorePane)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.checkExplorePane));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Explore Unlimited Suburbs from any state and region is accessible.");
		}else {
			fail("Explore Unlimited Suburbs from any state and region is not accessible.");
		}
		return available;
	}
	
	//check if order of suburbs by Investment Strategy Scores changed.
	public boolean checkOrder(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		click(xpath(PVObjectReferenceSmoketest.clickOrder));
		click(xpath(PVObjectReferenceSmoketest.selectOrder));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickOrder));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickOrder)));
		String text = getText(xpath(PVObjectReferenceSmoketest.clickOrder));
		if(text.contains("Capital Growth")){
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
			pass("Can change the order of suburbs by Investment Strategy Scores.");
		}else {
			fail("Cannot change the order of suburbs by Investment Strategy Scores.");
		}
		return available;
	}
	
	//check if can sort the top suburb list by clicking the column headers
	public boolean checkSort(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
			
		click(xpath(PVObjectReferenceSmoketest.clickSort));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkSortText));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkSortText)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkSortText));
		if(text.contains("Ainslie")){
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
			pass("Can sort the top suburb list by clicking the column headers.");
		}else {
			fail("Cannot sort the top suburb list by clicking the column headers.");
		}
		return available;
	}
	
	//check if can view value from the selected Investment strategy score column
	public boolean checkValues(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewValue));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewValue)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.viewValue));
				
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Can view value from the selected Investment strategy score column.");
		}else {
			fail("Cannot view value from the selected Investment strategy score column.");
		}
		return available;
	}
}

