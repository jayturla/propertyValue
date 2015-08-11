package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class StreetDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public StreetDetailsUtil(String[] i) {
			input = i;
	}
	
	//check if street address search can navigate to street details page
	public boolean streetAddressNav(int steps, int inputVal, int expected, int actual,int userName,int password, int street, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[street]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage));
		String url = driver.getCurrentUrl();
		if(url.contains("/street/")){
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
			pass("Navigated to Street Details Page And URL is correct.");
		}else {
			fail("Didn't Navigated to Street Details Page And URL is incorrect.");
		}
		return available;
	}
	
	public boolean streetHeader(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
	
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
	//check if street address is correct
	public boolean checkstreetAddress(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
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
			pass("Street Address is correct.");
		}else {
			fail("Street Address is not correct.");
		}
		return available;
	}
	//check if updates as Property Type btn is toggled
	public boolean btnPropertyType(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		clicktogglePropertyType(0, 0, 0, 0, false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("#Unit")){
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
			pass("Data on the page updates as Property Type Button is toggled.");
		}else {
			fail("Data on the page doesn't updates as Property Type Button is toggled.");
		}
		clickHouse(0, 0, 0, 0, false);
		return available;
	}
	
	//check street insights data if available on page
	public boolean checkStreetInsights(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkStreetInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkStreetInsights)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkStreetInsights));
		
		if (text.contains("Street Insights")) {
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
			pass("Street Insights Data are available.");
		}else {
			fail("Street Insights Data are not available.");
		}
		return available;
	}
	//check property prices section if in place.
	public boolean checkPropertyPrices(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyPrices));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyPrices)));
		available = isElementVisible((xpath(PVObjectReferenceSmoketest.propertyPrices)));

		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		} 
		if(available){
			pass("Property Prices for each status are in placed.");
		}else {
			fail("Property Prices for each status are not in place.");
		}
		return available;
	}
	//check street auction if available
	public boolean streetAuctionResult(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAuction));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAuction)));
		String text = getText(xpath(PVObjectReferenceSmoketest.streetAuction));
		
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
	//check street suburb information if available
	public boolean streetSuburbInformation(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = true;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		
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
	//check street suburb statistics if available
	public boolean streetSuburbStatistics(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = true;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		
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
	//check otherStreet section if available
	public boolean checkOtherStreets(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		 
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets)));
		String text = getText(xpath(PVObjectReferenceSmoketest.otherStreets));
		
		if (text.contains("Other Streets")) {
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
			pass("Other Streets in Suburb is available.");
		}else {
			fail("Other Streets in Suburb is not available.");
		}
		return available;
	}
	//check footer
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
	
	public boolean clicktogglePropertyType(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertyType));
			click(xpath(PVObjectReferenceSmoketest.togglePropertyType));
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
	
	public boolean clickHouse(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickHouse));
			click(xpath(PVObjectReferenceSmoketest.clickHouse));
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

