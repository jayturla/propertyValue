package pv.utilities;


import static org.openqa.selenium.By.xpath;


import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class PropertyDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PropertyDetailsUtil(String[] i) {
			input = i;
	}
	
	//Verify if Explore button will navigate to explore page checkProfilePage
	public boolean propertyHeader(int steps, int inputVal, int expected, int actual,int userName,int password, int property, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Page is not distorted and Header is in placed.");
		}else {
			fail("Page is distorted and Header is not in place.");
		}
		return available;
	}
	
	public boolean propertyAddress(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage)));
		available = isElementVisible((xpath(PVObjectReferenceSmoketest.checkProfilePage)));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Property Address is correct.");
		}else {
			fail("Property Address is not correct.");
		}
		return available;
	}
	
	public boolean checkPropertyInsights(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkPropertyInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkPropertyInsights)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkPropertyInsights));
		
		if (text.contains("Property Insights")) {
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
			pass("Property Insights Section are in placed.");
		}else {
			fail("Property Insights Section are not in place.");
		}
		return available;
	}
	
	public boolean propertyInsightsData(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyInsightsData));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyInsightsData)));
		String text = getText(xpath(PVObjectReferenceSmoketest.propertyInsightsData));
		
		if (text.contains(" - ")) {
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
			pass("Property Insights Data for Free Users are correct.");
		}else {
			fail("Property Insights Data for Free Users are not correct.");
		}
		return available;
	}
	
	public boolean propertyGallery(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyGallery));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyGallery)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.propertyGallery));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Property Galery, Map and Street view are availalbe.");
		}else {
			fail("Property Galery, Map and Street view are not availalbe.");
		}
		return available;
	}
	
	public boolean aboutProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.aboutProperty));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.aboutProperty)));
		String text = getText(xpath(PVObjectReferenceSmoketest.aboutProperty));
		
		if (text.contains("About this Property")) {
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
			pass("About this property data is availalbe.");
		}else {
			fail("About this property data is not availalbe.");
		}
		return available;
	}
	
	public boolean comparableProperties(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.comparableProperties));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.comparableProperties)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.comparableProperties));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Comparable properties for each status are in placed.");
		}else {
			fail("Comparable properties for each status are not in place.");
		}
		return available;
	}
	
	public boolean auctionResult(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.auctionResults));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.auctionResults)));
		String text = getText(xpath(PVObjectReferenceSmoketest.auctionResults));
		
		if (text.contains(" Auction ")) {
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
			pass("Auction Results data are available.");
		}else {
			fail("Auction Results data are not available.");
		}
		return available;
	}
	
	public boolean suburbInformation(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = true;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfo));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfo)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbInfo));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Suburb Information is available.");
		}else {
			fail("Suburb Information is not available.");
		}

		return available;
	}
	
	public boolean suburbStatistics(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = true;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbStats));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbStats)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbStats));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Suburb Statistics Charts are in placed.");
		}else {
			fail("Suburb Statistics Charts are not in place.");
		}

		return available;
	}
	
	public boolean checkMarketTrends(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.marketTrends));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrends)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.marketTrends));

		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		
		if(available){
			pass("Market Trends Data for Free users are correct.");
		}else {
			fail("Market Trends Data for Free Users are not correct.");
		}
		return available;
	}
	
	public boolean checkFooter(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.footer));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.footer)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.footer));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		if(available){
			pass("Footer is in placed.");
		}else {
			fail("Footer is not in place.");
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

