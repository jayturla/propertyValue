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
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbMaps));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbMaps)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbMaps));

		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(available){
			pass("Suburb Search will navigate to Suburb Map Result showing the targetted Suburb.");
		}else {
			fail("Suburb Search will not navigate to Suburb Map Result showing the targetted Suburb.");
		}
		
		return available;
	}
	
	//check if neighbouring suburb are plotted in the map
	public boolean suburbPins(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbPins));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbPins)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbPins));

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
			fail("Neighbouring Suburb Pins are not plotted in the map.");
		}
		
		return available;
	}
	
	//check if properties in the suburb are plotted in the map
	public boolean suburbProperties(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyPins));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyData));
		if( isElementVisible(xpath(PVObjectReferenceSmoketest.propertyPins)) && isElementVisible(xpath(PVObjectReferenceSmoketest.propertyData))){
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
}

