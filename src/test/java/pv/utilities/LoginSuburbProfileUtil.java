package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class LoginSuburbProfileUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public LoginSuburbProfileUtil(String[] i) {
			input = i;
	}
	
	//click view suburb profile then navigate to suburb profile page
	public boolean clickSuburbProfile(int steps, int inputVal, int expected, int actual,int userName, int password, int suburb,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		driver.navigate().to(input[suburb]);
		//clickviewSuburbProfile(0,0,0,0,false);
		available =true;
		
		/*waitForElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));*/

		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Viewing the Suburb Profile page");
		}else {
			fail("Cannot view Suburb Profile page");
		}
		
		return available;
	}
	
	//check the Suburb header
	public boolean checkHeader(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.SuburbDetailsHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.SuburbDetailsHeader)));
		
		if (isElementVisible(xpath(PVObjectReferenceSmoketest.SuburbDetailsHeader)) == true)
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
			pass("Header is available on the Suburb page");
		}else {
			fail("Header is NOT available on the Suburb page");
		}
		
		return available;
	}
	
	//check if the Suburb address displayed is correct
	public boolean checkAddress(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbAddress)));
		//String text = getText(xpath(PVObjectReferenceSmoketest.checkSuburbAddress));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkStateAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkStateAddress)));
		//String text1 = getText(xpath(PVObjectReferenceSmoketest.checkStateAddress));

		/*if (text.contains("Manly")) {
			if (text1.contains("NSW 2095"))
			{
				available = true;
			}
		}*/
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.checkSuburbAddress)) == true)
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
			pass("Suburb Address displayed is correct.");
		}else {
			fail("Suburb Address displayed is INCORRECT.");
		}
		
		return available;
	}
	
	//toggle property type button if page update
	public boolean btnPropertyType(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		clicktogglePropertyType(0,0,0,0,false);
		
		//URL Checking
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
			pass("#Unit is added upon changing property type");
		}else {
			fail("URL is incorrect");
		}
		
		return available;
	}
	
	//check suburb insights data if available
	public boolean checkSuburbInsights(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		//insight left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.insights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.insights)));
		
		//suburb insight section
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbInsights)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.insights)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.insights));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.checkSuburbInsights))==true)
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
			pass("Suburb Insights data is available.");
		}else {
			fail("Suburb Insights data is NOT available.");
		}
		
		return available;
	}
	
	//check property prices status if in place
	public boolean propertyPricesStatus(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		//property prices left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyprices));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyprices)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyprices))==true)
		{
			click(xpath(PVObjectReferenceSmoketest.propertyprices));
			
			//property prices section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyPricesSection));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyPricesSection)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyPricesSection))==true)
			{
				if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbSaleProperty))==true && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.suburbSoldProperty))==true &&
				isElementVisible(xpath(PVObjectReferenceSmoketest.suburbRentProperty))==true)
				{
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
			pass("Property Prices section for each status are in place.");
		}else {
			fail("Property Prices section for each status are not in place.");
		}
		
		return available;
	}
	
	//check auction result data if available 
	public boolean checkAuction(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		//Auction Results left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.AuctionResults)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbAuction))==true)
		{
			click(xpath(PVObjectReferenceSmoketest.AuctionResults));
			//Auction section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbAuction));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbAuction)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbAuction))==true)
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
			pass("Auction Results data are available.");
		}else {
			fail("Auction Results data are not available.");
		}
		
		return available;
	}
	
	//check suburb information if available
	public boolean checkSuburbInfo(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhood)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.neighbourhood))==true)
		{
			click(xpath(PVObjectReferenceSmoketest.neighbourhood));
			//Suburb Info section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbINfoSection));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbINfoSection)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfoHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfoHeader)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbINfoSection))==true && isElementPresent(xpath(PVObjectReferenceSmoketest.suburbInfoHeader)) ==true)
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
			pass("Suburb Information section is available.");
		}else {
			fail("Suburb Information section is available.");
		}
		return available;
	}
	
	//check suburb statistics and charts if available
	public boolean checkSuburbStatistics(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbStatistics));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbStatistics)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbStatistics)) == true)
		{
			available=true;
		}
		
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
			fail("Suburb Statistics Charts are not in placed.");
		}
		return available;
	}
	
	//check market trends if available in the page
	public boolean checkSuburbTrends(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		//check market trends left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.markettrends));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.markettrends)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.markettrends))==true)
		{
			click(xpath(PVObjectReferenceSmoketest.markettrends));
			
			//Market Trends
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.trendsHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.trendsHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.trendsMetric));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.trendsMetric)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.trendsGraph));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.trendsGraph)));
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.trendsHeader)) == true && 
					isElementVisible(xpath(PVObjectReferenceSmoketest.trendsMetric)) == true &&
					isElementVisible(xpath(PVObjectReferenceSmoketest.trendsGraph)) == true)
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
			pass("Market Trends section are available.");
		}else {
			fail("Market Trends section are not available.");
		}
		return available;
	}
	
	//check if local experts section is shown
	public boolean checkLocalExperts(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		//local experts left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.localexperts));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.localexperts)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.localexperts)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.localexperts));
			
			//local experts section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.localExpertsSection));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.localExpertsSection)));
			
			if (isElementVisible(xpath(PVObjectReferenceSmoketest.localExpertsSection)) == true)
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
			pass("Local Experts section are shown.");
		}else {
			fail("Local Experts section are not shown.");
		}
		return available;
	}
	
	//check if street links are available
	public boolean checkStreetLinks(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		//other street left margin
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreet));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreet)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.otherStreets))==true)
		{
			click(xpath(PVObjectReferenceSmoketest.otherStreets));
			
			//Other Street section
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreetsHeader));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreetsHeader)));
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreetsSection));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreetsSection)));
			//String text=getText(xpath(PVObjectReferenceSmoketest.otherStreetsHeader));
			
			
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.otherStreetsHeader))==true
					&& isElementVisible(xpath(PVObjectReferenceSmoketest.otherStreetsSection))==true)
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
			pass("Street Links are availble.");
		}else {
			fail("Street Links are not availble.");
		}
		return available;
	}
	
	//Checking the Footer if in place
	public boolean checkFooter(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.footer));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.footer)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.footer))==true)
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
			fail("Footer is not place.");
		}
		
		return available;
	}	
	
	//Clicking the View Suburb button in Map page to navigate to Suburb Page
	public boolean clickviewSuburbProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbButton));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbButton)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.viewSuburbButton))==true)
			{
				click(xpath(PVObjectReferenceSmoketest.viewSuburbButton));
				click =true;
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
		if(click){
			pass("View Suburb Profile Button can navigate to Suburb Profile page.");
		}else {
			fail("View Suburb Profile Button cannot navigate to Suburb Profile page.");
		}
		
		return click;
	}
	//Checking of the toggle button is functional and updates the data
	public boolean clicktogglePropertyType(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertyType));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertyType)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.togglePropertyType))==true)
			{
				click(xpath(PVObjectReferenceSmoketest.togglePropertyType));
				
				//CHECK FOR DATA updates
				waitForElementPresent(xpath(PVObjectReferenceSmoketest.unitLabel));
				Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.unitLabel)));
				
				String text = getText(xpath(PVObjectReferenceSmoketest.unitLabel));
				if (text.contains (" Units in last 12 months")) 
				{
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
		if(click){
			pass("Data on the page updates as property type button is toggled.");
		}else {
			fail("Data on the page DOES NOT updates as property type button is toggled.");
		}
		return click;
	}
}


