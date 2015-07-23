
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class FreeSuburbProfileReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public FreeSuburbProfileReportUtil(String[] i) {
		input = i;
	
	}
	
	//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
	public boolean freeProfileReport(int steps, int inputVal, int expected, int actualPass, int actualFail, int suburb, int email, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBoxSC), input[suburb]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBoxSC)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnFreeReport));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.btnFreeReport)));
		click(xpath(PVObjectReferenceSmoketest.btnFreeReport));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.getFreeReportEmail));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.getFreeReportEmail)));
		type(xpath(PVObjectReferenceSmoketest.getFreeReportEmail), input[email]);
		click(xpath(PVObjectReferenceSmoketest.clickSubmit));
		
		String text = getText(xpath(PVObjectReferenceSmoketest.freeReportSent));
		if(text.contains("Thank you. Your Free suburb profile report has been emailed.")){
			passed = true;
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Free Suburb Profile Report for <Suburb Address> has been sent and attached to an email.");
		}else {
			fail("Free Suburb Profile Report for <Suburb Address> has not been sent and attached to an email.");
		}
		
		return passed;
	}
} 

