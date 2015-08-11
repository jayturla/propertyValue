package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class PostcodeDetailsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PostcodeDetailsUtil(String[] i) {
			input = i;
	}
	
	//Checking SLAS Box if available in the page
	public boolean checkSLAS(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.slasBox));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("SLAS is available in the page.");
		}else {
			fail("SLAS is NOT AVAILABLE in the page.");
		}
		return available;	
	}
		
	//check if SLAS will navigate to postcode page when entered <postcode address>
	public boolean navigatePostcodeAdd(int steps, int inputVal, int expected, int actual,int postcode,boolean withATU) throws Exception {
		boolean details = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[postcode]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.postcodeAddress));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.postcodeAddress)));
		String text = getText(xpath(PVObjectReferenceSmoketest.postcodeAddress));
		
		if (text.contains("Suburbs in Postcode")) {
			details = true;
			
		}
		
		if(withATU) {
			if(details){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(details){
			pass("SLAS Box search can navigate to Postcode Page.");
		}else {
			fail("SLAS Box search cannot navigate to Postcode Page.");
		}
		return details;
	}
	
	//check if Suburbs under the target postcode will be listed as link and suburb klms on map
	public boolean suburbsList(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbLinks));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbLinks)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.suburbLinks));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		
		if(available){
			pass("Suburbs under target Postcode are listed as links And Suburb KMLS is shown on the map.");
		}else {
			fail("Suburbs under target Postcode are not listed as links And Suburb KMLS isn't shown on the map.");
		}
		return available;
	}
	
	//verify if suburbs under target postcode links are working
	public boolean navigateSuburbs(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickSuburb));
		clickSuburb(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbMaps));
		available = isElementPresent(xpath(PVObjectReferenceSmoketest.suburbMaps));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		
		if(available){
			pass("Suburb Links can navigate to Suburb Map Results of the selected suburb.");
		}else {
			fail("Suburb Links cannot navigate to Suburb Map Results of the selected suburb.");
		}
		return available;
	}
	
	public boolean clickSuburb(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickSuburb));
			click(xpath(PVObjectReferenceSmoketest.clickSuburb));
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

