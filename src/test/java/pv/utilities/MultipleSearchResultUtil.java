package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class MultipleSearchResultUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public MultipleSearchResultUtil(String[] i) {
			input = i;
	}
	//Search for <parent unit> then navigated to Multiple Search result
	public boolean multipleSearchResult(int steps, int inputVal, int expected, int actual,int parent, boolean withATU)  throws Exception {
		boolean navigate = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[parent]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.navigateMultipleSearchResult));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.navigateMultipleSearchResult)));
		navigate = isElementVisible(xpath(PVObjectReferenceSmoketest.navigateMultipleSearchResult));

		if(withATU) {
			if(navigate){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
			
		if(navigate){
			pass("Parent Unit search will navigate to Multiple Search result.");
		}else {
			fail("Parent Unit search will not navigate to Multiple Search result.");
		}
		return navigate;
	}
	
		public boolean selectProperty(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
			boolean navigate = false;
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectProperty));
			clickbtnselectProperty(0,0,0,0,false);
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights)));
			navigate = isElementVisible(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights));

			if(withATU) {
				if(navigate){
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
				}else {
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
					}
			}
				
			if(navigate){
				pass("Selected property from the parent list will navigate to Multiple Search result.");
			}else {
				fail("Selected property from the parent list will not navigate to Multiple Search result.");
			}
		
		return navigate;
	}
	
	public boolean clickbtnselectProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectProperty));
			click(xpath(PVObjectReferenceSmoketest.selectProperty));
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

