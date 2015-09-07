package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class LoginSuburbSearchResultUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public LoginSuburbSearchResultUtil(String[] i) {
			input = i;
	}
	
	//Map Search Result Suburb section
	public boolean suburbMapSearch(int steps, int inputVal, int expected, int actual,int userName, int password, int suburb,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.slasBox));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		
		clickselectSuggestion(0,0,0,0,false);

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbSearchPin));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbSearchPin)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbSearchPin)) == true)
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
			pass("Search Suburb pin is plotted in the map result page.");
		}else {
			fail("Search Suburb pin is NOT plotted in the map result page.");
		}
		
		return available;
	}
	
	//check if neighbouring suburb are plotted in the map
	public boolean suburbPins(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhoodFairlight));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhoodFairlight)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhoodManlyVale));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.neighbourhoodManlyVale)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.neighbourhoodFairlight)) == true && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.neighbourhoodManlyVale)) == true)
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
			pass("Neighbouring Suburb Pins are plotted in the map.");
		}else {
			fail("Neighbouring Suburb Pins are NOT plotted in the map.");
		}
		
		return available;
	}
	
	//check if properties in the suburb are plotted in the map
	public boolean suburbProperties(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.unitPropertyPin));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.unitPropertyPin)));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.housePropertyPin));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.housePropertyPin)));
		
		if( isElementVisible(xpath(PVObjectReferenceSmoketest.unitPropertyPin)) == true && isElementVisible(xpath(PVObjectReferenceSmoketest.housePropertyPin)) == true){
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
			pass("Properties in the Suburb are plotted in the map and are shown in the property list where data is available.");
		}else {
			fail("Properties in the Suburb are not plotted in the map and not shown in the property list where data is available.");
		}
		
		return available;
	}
	
	public boolean clickselectSuggestion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion)));
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion))==true)
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
	
	public boolean suburbPropertyList(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.mapPropertyList));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.mapPropertyList)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.mapPropertyList)) == true)
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
			pass("Property Lists are available in the Suburb Map");
		}else {
			fail("Property Lists are NOT available in the Suburb Map");
		}
		
		return available;
	}
}

