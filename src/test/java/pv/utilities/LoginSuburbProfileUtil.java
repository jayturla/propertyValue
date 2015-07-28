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
		clickviewSuburbProfile(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));

		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("View Suburb Profile Button can navigate to Suburb Profile page.");
		}else {
			fail("View Suburb Profile Button cannot navigate to Suburb Profile page");
		}
		
		return available;
	}
	
	//checkheader
	public boolean checkHeader(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyDetailsHeader)));
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
			fail("Page is distorted and Header is not in placed.");
		}
		
		return available;
	}
	
	//check address
	public boolean checkAddress(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkAddress)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkAddress));

		if (text.contains("Manly")) {
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
			pass("Address is correct.");
		}else {
			fail("Address is incorrect.");
		}
		
		return available;
	}
	
	//toggle property type button if page update
	public boolean btnPropertyType(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		clicktogglePropertyType(0,0,0,0,false);
		
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
			pass("Data on the page updates as property type button is toggled.");
		}else {
			fail("Data on the page didn't update as property type button is toggled.");
		}
		
		return available;
	}
	
	//check suburb insights data if available
	public boolean checkSuburbInsights(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkSuburbInsights)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.checkSuburbInsights));

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
			fail("Suburb Insights data is not available.");
		}
		
		return available;
	}
	
	//check property prices status if in place
	public boolean propertyPricesStatus(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyPricesForSale)) && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.propertyPricesRecentlySold))&&
					isElementVisible(xpath(PVObjectReferenceSmoketest.propertyPricesForRent))) {
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
			pass("Property Prices for each status are in place.");
		}else {
			fail("Property Prices for each status are not in place.");
		}
		
		return available;
	}
	
	//check auction result data if available 
	public boolean checkAuction(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbAuction));
		String text = getText(xpath(PVObjectReferenceSmoketest.suburbAuction));
		if (text.contains ("Auction")) {
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
	
	//check suburb information if available
	public boolean checkSuburbInfo(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		String text = getText(xpath(PVObjectReferenceSmoketest.streetSuburbInfo));
		if (text.contains ("Suburb Information")) {
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
			pass("Suburb Information is available.");
		}else {
			fail("Suburb Information is not available.");
		}
		return available;
	}
	
	//check suburb statistics and charts if available
	public boolean checkSuburbStatistics(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbStatistics));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbStatistics)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbStatistics));
		
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
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbTrends));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbTrends)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbTrends));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Market Trends are available.");
		}else {
			fail("Market Trends are not available.");
		}
		return available;
	}
	
	//check if local experts section is shown
	public boolean checkLocalExperts(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.localExperts));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.localExperts)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.localExperts));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Local Experts are shown.");
		}else {
			fail("Local Experts are not shown.");
		}
		return available;
	}
	
	//check if street links are available
	public boolean checkStreetLinks(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.otherStreets)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.otherStreets));
		
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
			fail("Footer is not place.");
		}
		
		return available;
	}	
	
	public boolean clickviewSuburbProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
			click(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
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
}


