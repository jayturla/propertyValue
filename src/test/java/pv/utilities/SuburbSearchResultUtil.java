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
		clickbtnForSale(0,0,0,0,false);
		clickbtnViewProfile(0,0,0,0,false);
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
	
	public boolean clickbtnForSale(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnForSale));
			click(xpath(PVObjectReferenceSmoketest.btnForSale));
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
	
	public boolean clickbtnViewProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnViewProfile));
			click(xpath(PVObjectReferenceSmoketest.btnViewProfile));
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

