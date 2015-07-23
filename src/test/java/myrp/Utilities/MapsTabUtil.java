
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class MapsTabUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public MapsTabUtil(String[] i) {
		input = i;
	
	}
	
	//check map for suburb address if centered in the map
	public boolean checkMap(int steps, int inputVal, int expected, int actualPass, int actualFail, int suburb, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBoxSC), input[suburb]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBoxSC)).sendKeys(Keys.RETURN);
		
		click(xpath(PVObjectReferenceSmoketest.mapTab));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.mapCentered));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.mapCentered)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.mapCentered));
		
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Map for Suburb are centered.");
		}else {
			fail("Map for Suburb are not centered.");
		}
		
		return passed;
	}
} 

