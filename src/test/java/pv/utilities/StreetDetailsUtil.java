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
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.slasBox));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.slasBox)) == true)
		{
			type(xpath(PVObjectReferenceSmoketest.slasBox), input[street]);
			clickselectSuggestion(0,0,0,0,false);
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAddress));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAddress)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetAddress)) == true)
			{
				String url = driver.getCurrentUrl();
				
				if(url.contains("/street/")){
					available = true;
				}
			}
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
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetPageHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetPageHeader)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetPageHeader)) == true)
		{
			available =true;
		}
		
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
			fail("Page is distorted and Header is NOT in place.");
		}
		return available;
	}
	//check if street address is correct
	public boolean checkstreetAddress(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAddress)));
		if(isElementVisible((xpath(PVObjectReferenceSmoketest.streetAddress))) == true)
		{
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
			pass("Street Address is displayed.");
		}else {
			fail("Street Address is not displayed.");
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
		 
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.insights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.insights)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.insights)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.insights)); 
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkStreetInsights));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkStreetInsights)));
			String text = getText(xpath(PVObjectReferenceSmoketest.checkStreetInsights));
			if (text.contains("Street Insights")) {
				available = true;
			}
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
			fail("Street Insights Data are NOT available.");
		}
		return available;
	}
	//check property prices section if in place.
	public boolean checkPropertyPrices(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyprices));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyprices)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyprices)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.propertyprices)); 
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyPrices));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyPrices)));
			if(isElementVisible((xpath(PVObjectReferenceSmoketest.propertyPrices))) == true)
			{
				available = true;
			}
		}
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
		
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.AuctionResults)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.AuctionResults)); 
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAuction));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAuction)));
			String text = getText(xpath(PVObjectReferenceSmoketest.streetAuction));
			if (text.contains(" Auction ")) {
				available = true;
			}
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
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.neighbourhood)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.neighbourhood)); 
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfoHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfoHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetSuburbInfo)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.streetSuburbInfoHeader)) == true)
			{
				available = true;
			}	
		}
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
			fail("Suburb Information is NOT available.");
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
		
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSection));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetSection)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetSection)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.streetSection)); 
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets)));
			String text = getText(xpath(PVObjectReferenceSmoketest.otherStreets));
			if (text.contains("Other Streets")) 
			{
				available = true;
			}
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
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.footer)) == true)
		{
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
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertyType)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.togglePropertyType)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.togglePropertyType));
				click = true;
			}
			
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
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickHouse)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.clickHouse)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.clickHouse));
				String url = driver.getCurrentUrl();
				if(url.contains("#House")){
					click = true;
				}
			}
			
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
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.selectSuggestion)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.selectSuggestion));
				click = true;
			}
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

