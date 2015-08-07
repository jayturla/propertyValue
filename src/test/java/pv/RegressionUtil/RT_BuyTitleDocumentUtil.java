package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_BuyTitleDocumentUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_BuyTitleDocumentUtil(String[] i) {
			input = i;
	}
	
	//check if buy title document is available
	public boolean btnBuyTitleDocument(int steps, int inputVal, int expected, int actualPass, int actualFail, int property, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickBuyTitleDocuments));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickBuyTitleDocuments)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.clickBuyTitleDocuments));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Buy Title Document Button is available.");
		}else {
			fail("Buy Title Document Button is not available.");
		}
		return passed;
	}
	
	//check if title ordering site will open in new tab when buy title button is clicked
	public boolean titleDocumentsNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		clickbuyTitleDocuments(0, 0, 0, 0, false);
				
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Perform the actions on new window
		String url = driver.getCurrentUrl();
		if(url.contains("realtor.com.au/cgi-bin/vgmsg")) {
			passed = true;
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Title Ordering site is opened in new tab when buy title button is clicked.");
		}else {
			fail("Title Ordering site is not opened.");
		}
		return passed;
	}
	
	//Click Methods
	public boolean clickbuyTitleDocuments(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickBuyTitleDocuments));
			click(xpath(PVObjectReferenceSmoketest.clickBuyTitleDocuments));
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

