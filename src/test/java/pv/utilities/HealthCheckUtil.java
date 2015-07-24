package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class HealthCheckUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public HealthCheckUtil(String[] i) {
			input = i;
	}
	
	public boolean healthCheck(int steps, int inputVal, int expected, int actualPass, int actualFail, int url, boolean withATU) throws Exception {
		boolean passed = false;
		
		driver.navigate().to(input[url]);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkResult));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkResult)));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkResult));
		if(text.contains("Database connection is OK.") && text.contains("BSG connection is OK.") && text.contains("BSG 3.0 connection is OK.")
				&& text.contains("S3 Bucket access is OK.") && text.contains("Manage Reports S3 Bucket access is OK.") && text.contains("Vision6 connection is OK.")
				&& text.contains("Access to RPConnect is OK.") && text.contains("Access to Cordell API is OK.") && text.contains("Statistics API Connection is OK.") 
				&& text.contains("CPS is OK.") && text.contains("Freemium CPS is OK.")){
			
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
			pass("Connection to <Integration Points> are 'OK'.");
		}else {
			fail("Connection to <Integration Points> Failed'.");
		}
		
		return passed;
	}
}

