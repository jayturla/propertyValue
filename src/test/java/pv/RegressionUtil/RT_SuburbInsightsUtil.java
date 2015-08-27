package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_SuburbInsightsUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_SuburbInsightsUtil(String[] i) {
			input = i;
	}
	
	//check stock on market if available and count of properties currently for sale is reflected in the value
	public boolean checkStockMarket(int steps, int inputVal, int expected, int actualPass, int actualFail, int suburb, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		clickselectSuggestion(0,0,0,0,false);
		clickbtnViewProfile(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.stockMarket));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stockMarket)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.stockMarket))){
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
			pass("Value on Stock on market is available and count of current property are reflected.");
		}else {
			fail("Value on Stock on market is NOT available.");
		}
		return passed;
	}
	
	//click value in link format
	public boolean clickValue(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		btnValue(0, 0, 0, 0, false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/map")){
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
			pass("Value link will navigate to map search results.");
		}else {
			fail("Value link will NOT navigate to map search results.");
		}
		return passed;
	}
	
	//check if For sale status is preselected and active property type is the same
	public boolean checkSelectedProperty(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;

		String text = getText(xpath(PVObjectReferenceSmoketest.selectedPropertyType));
		if(text.contains("House") && isElementVisible(xpath(PVObjectReferenceSmoketest.countResult))){
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
			pass("Active Property type from previous suburb and count for properties for sale are the same.");
		}else {
			fail("Active Property type from previous suburb and count for properties for sale are NOT the same.");
		}
		return passed;
	}
	
	//CLICK
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
	
	public boolean btnValue(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.stockMarket));
			click(xpath(PVObjectReferenceSmoketest.stockMarket));
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

