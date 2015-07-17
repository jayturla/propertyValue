package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class SuburbSearchResultUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public SuburbSearchResultUtil(String[] i) {
			input = i;
	}
	//Map Search Result Suburb section
	public boolean btnPropertyProfile(int steps, int inputVal, int expected, int actual,int suburb,boolean withATU)  throws Exception {
		boolean navigate = false;
		
		driver.navigate().to(input[suburb]);
		
		click(xpath(PVObjectReferenceSmoketest.btnForSale));
		click(xpath(PVObjectReferenceSmoketest.btnViewProfile));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.navigatePropertyPage)));
		navigate = isElementVisible(xpath(PVObjectReferenceSmoketest.navigatePropertyPage));

		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(navigate){
			pass("View Property Button can navigate to Suburb Property Details.");
		}else {
			fail("View Property Button cannot navigate to Suburb Property Details.");
		}
		
		return navigate;
	}
}

