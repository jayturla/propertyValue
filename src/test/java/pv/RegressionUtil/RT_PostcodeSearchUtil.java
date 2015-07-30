package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.Keys;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_PostcodeSearchUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_PostcodeSearchUtil(String[] i) {
			input = i;
	}
	
	//check if navigated to Postcode Details page
	public boolean postcodeDetailsNav(int steps, int inputVal, int expected, int actualPass, int actualFail, int postcode, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[postcode]);
		clickselectSuggestion(0,0,0,0,false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/postcode/")){
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
			pass("Postcode address search will navigate to postcode details page.");
		}else {
			fail("Postcode address search will not navigate to postcode details page.");
		}
		return passed;
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

