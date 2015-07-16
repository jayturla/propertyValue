package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class PremiumPropertyDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PremiumPropertyDetailsUtil(String[] i) {
			input = i;
	}
	
	//check exact and estimated value if shown
	public boolean checkValue(int steps, int inputVal, int expected, int actual,int userName,int password, int property, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkExactValue));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkEstimatedValue));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.checkExactValue)) && isElementVisible(xpath(PVObjectReferenceSmoketest.checkEstimatedValue))){
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
			pass("Exact Value and Range of Estimated Property Value are shown.");
		}else {
			fail("Exact Value and Range of Estimated Property Value are not shown.");
		}
		return available;
	}	
	
	//check estimated rent if shown
	public boolean checkEstimatedRent(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.estimatedRent));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.estimatedRent)));
		String text = getText(xpath(PVObjectReferenceSmoketest.estimatedRent));
		if (text.contains(" pw")) {
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
			pass("Estimated Property Rent is shown.");
		}else {
			fail("Estimated Property Rent is not shown.");
		}
		return available;
	}
	
	//check estimated yield if shown
	public boolean checkEstimatedYield(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
			
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.estimatedYield));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.estimatedYield)));
		String text = getText(xpath(PVObjectReferenceSmoketest.estimatedYield));
		if (text.contains(" %")) {
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
			pass("Estimated Property Yield is shown.");
		}else {
			fail("Estimated Property Yield is not shown.");
		}
		return available;
	}
	
	//check estimated cashflow if shown
	public boolean checkEstimatedCashflow(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
	boolean available = false;
					
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.grossCashflow));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.grossCashflow)));
		String text = getText(xpath(PVObjectReferenceSmoketest.grossCashflow));
		if (text.contains(" pw")) {
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
			pass("Estimated Property Cashflow is shown.");
		}else {
			fail("Estimated Property Cashflow is not shown.");
		}
		return available;
	}
	
	//check if property pros and cons are shown
	public boolean checkProsCons(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkPros));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkCons));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkPros));
		String text1 = getText(xpath(PVObjectReferenceSmoketest.checkCons));
		if (text.contains("Things to like") && text1.contains("Things to look out for")) {
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
			pass("Property Pros and Cons are shown.");
		}else {
			fail("Property Pros and Cons are not shown.");
		}
		return available;
	}	
	
	//check property investment strategy score if shown
	public boolean checkInvestmentStratetyScore(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategyScore));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategyScore)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.investmentStrategyScore));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Property Investment Strategy Score is shown.");
		}else {
			fail("Property Investment Strategy Score is not shown.");
		}
		return available;
	}
	
	//check property history timeline if shown
	public boolean checkPropertyHistory(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyTimeline));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyTimeline)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.propertyTimeline));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Property History from timeline section is available.");
		}else {
			fail("Property History from timeline section is not available.");
		}
		return available;
	}	
	
	//check if unlimited comparable properties are shown in the map and list section
	public boolean checkUnliComparableProperties(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
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
			pass("Unlimited comparable properties from the map and list section for each status are shown.");
		}else {
			fail("Unlimited comparable properties from the map and list section for each status are not shown.");
		}
		return available;
	}	
	
	public boolean checkMarketTrends(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrends))){
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
			pass("Unlimited access to market trends metrics.");
		}else {
			fail("Limited access to market trends metics");
		}
		return available;
	}	
}

