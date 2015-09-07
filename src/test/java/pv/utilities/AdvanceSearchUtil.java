
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class AdvanceSearchUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	public AdvanceSearchUtil(String[] i) {
			input = i;
	}
	
	//Advance search
	
	public boolean clickAdvanceSearch(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU)  throws Exception{
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch)));
		String text = getText(xpath(PVObjectReferenceSmoketest.advanceSearch));
		if (text.contains("Advanced Search")) {
			available = true;
			clickbtnadvanceSearch(0,0,0,0,false);
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Advance Search button is functional");
		}else {
			fail("Advance Search button is functional");
		}
	
		return available;
	}

	public boolean enterUnit(int steps,int inputVal, int expected, int actualPass, int actualFail, int unit,boolean withATU) throws Exception{
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearchPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearchPage)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.advanceSearchPage)) == true)
		{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch)) ==true)
			{
				type(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch), input[unit]);
				available = true;
			}
		}
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to enter unit number in Advance Search");
		}else {
			fail("User was not able to enter unit number in Advance Search");
		}
		return available;
	
	}

	public boolean enterStreetName(int steps,int inputVal, int expected, int actualPass, int actualFail, int street,boolean withATU) throws Exception{
		boolean available = false;
		
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch)) == true)
			{
				type(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch), input[street]);
				available = true;
			}
			Thread.sleep(3000);
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to enter Street in Advance Search");
		}else {
			fail("User was not able to enter Street in Advance Search");
		}
		return available;
	
	}

	public boolean searchInAdvanceSearch(int steps,int inputVal, int expected, int actualPass, int actualFail, int unit, int street, boolean withATU) throws Exception{
		boolean available = false;
		
			enterUnit(0, 0, 0, 0, 0, unit, false);
			enterStreetName(0, 0, 0, 0, 0, street, false);
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.advSearchSuggest));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advSearchSuggest)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.advSearchSuggest)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.advSearchSuggest));
				
				//advance search result
				waitForElementPresent(xpath(PVObjectReferenceSmoketest.advSearchResults));
				Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advSearchResults)));
				if(isElementVisible(xpath(PVObjectReferenceSmoketest.advSearchResults)) == true)
				{
					available =true;
				}
			}
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to search in Advance Search");
		}else {
			fail("User was not able to search in Advance Search");
		}
		return available;
	}
	
	public boolean clickbtnadvanceSearch(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.advanceSearch)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.advanceSearch));
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
		if(click){
			pass("Advance search is available in the homepage");
		}else {
			fail("Advance search is available in the homepage");
		}
		
		return click;
	}
			
}
	
	

