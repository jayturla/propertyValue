
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
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch)));
		String text = getText(xpath(PVObjectReferenceSmoketest.advanceSearch));
		if (text.contains("Advanced Search")) {
			available = true;
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearch)));
			click(xpath(PVObjectReferenceSmoketest.advanceSearch));
			
			
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Advance search is available in the homepage");
		}else {
			fail("Advance search is Not available in the homepage");
		}
	
		return available;
	}

	public boolean enterUnit(int steps,int inputVal, int expected, int actualPass, int actualFail, int unit,boolean withATU) throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearchPage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.advanceSearchPage));
		if (text.contains("Unit No.")) {
			available = true;
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch)));
			type(xpath(PVObjectReferenceSmoketest.unitAdvanceSearch), input[unit]);
		
	}
	
	
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to enter unit in Advance Search");
		}else {
			fail("User was not able to enter unit in Advance Search");
		}
		return available;
	
	}

	public boolean enterStreetName(int steps,int inputVal, int expected, int actualPass, int actualFail, int street,boolean withATU) throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearchPage)));
		String text = getText(xpath(PVObjectReferenceSmoketest.advanceSearchPage));
		if (text.contains("Street Name")) {
			available = true;
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch)));
			type(xpath(PVObjectReferenceSmoketest.streetAdvanceSearch), input[street]);
			
			Thread.sleep(3000);
		}
	
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

	public boolean searchInAdvanceSearch(int steps,int inputVal, int expected, int actualPass, int actualFail, int unit, int street,boolean withATU) throws Exception{
		boolean available = false;
		
			enterUnit(0, 0, 0, 0, 0, unit, false);
			enterStreetName(0, 0, 0, 0, 0, street, false);
		
			Thread.sleep(3000);
			
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.advanceSearchPage)));
			String text = getText(xpath(PVObjectReferenceSmoketest.advanceSearchPage));
			if (text.contains("5 matches found.")) {
				available = true;
			
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
			
}
	
	

