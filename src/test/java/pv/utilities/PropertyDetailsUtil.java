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
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.slasBox));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader)) == true)
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
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.checkProfilePage)) == true)
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
			pass("Property Address is correct.");
		}else {
			fail("Property Address is not correct.");
		}
		return available;
	}
	
	public boolean checkPropertyInsights(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.insights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.insights)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.insights)) == true)
		{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkPropertyInsights));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkPropertyInsights)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.checkPropertyInsights)) == true)
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
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyInsightsData)) == true)
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
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyGallery)) == true)
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
			pass("Property Gallery, Map and Street view are availalbe.");
		}else {
			fail("Property Gallery, Map and Street view are not availalbe.");
		}
		return available;
	}
	
	public boolean aboutProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.about));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.about)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.about)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.about));
			// section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.aboutPropertyHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.aboutPropertyHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.aboutProperty));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.aboutProperty)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.aboutPropertyHeader)) == true &&
					isElementPresent(xpath(PVObjectReferenceSmoketest.aboutProperty)) == true)
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
			pass("About this property data is availalbe.");
		}else {
			fail("About this property data is not availalbe.");
		}
		return available;
	}
	
	public boolean comparableProperties(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.comparable));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.comparable)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.comparable)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.comparable));
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.comparableSection));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.comparableSection)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.comparableSection)) == true)
			{
				available=true;
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
			pass("Comparable properties for each status are in placed.");
		}else {
			fail("Comparable properties for each status are not in place.");
		}
		return available;
	}
	
	public boolean auctionResult(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = false;
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.AuctionResults)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.AuctionResults));
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.auctionResults));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.auctionResults)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.auctionResults)) == true)
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
			pass("Auction Results data are available.");
		}else {
			fail("Auction Results data are not available.");
		}
		return available;
	}
	
	public boolean suburbInformation(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean available = true;
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.neighbourhood)))
		{
			click(xpath(PVObjectReferenceSmoketest.neighbourhood));
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbinfoHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbinfoHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfo));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfo)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbStats));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbStats)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbinfoHeader)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.suburbInfo)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.suburbStats)) == true)
			{
				available = true;
			}
		}
		
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
		//left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.markettrends));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.markettrends)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.markettrends)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.markettrends));
			//section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsMetric));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsMetric)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsGraph));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.marketTrendsGraph)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.marketTrendsHeader)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.marketTrendsMetric)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.marketTrendsGraph)) == true)
			{
				available=true;
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
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.footer)) == true)
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

