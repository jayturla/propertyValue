package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;


public class RT_CMSUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_CMSUtil(String[] i) {
			input = i;
	}
	
	//check if Infographic page is available and screen layout is correct
	public boolean Infographic (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickInfographic(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/infographic")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Infographic page is available and screen layout is correct.");
		}else {
			fail("Infographic page is not available.");
		}
		return passed;
	}
	
	//check if About us Page is accessible and screen layout is not distorted
	public boolean AboutUs (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickAboutUs(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/about-us")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("About us Page is accessible and screen layout is not distorted.");
		}else {
			fail("About us Page is not accessible.");
		}
		return passed;
	}
	
	//check if Contact us Page is accessible and screen layout is not distorted
	public boolean ContactUs (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickContactUs(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/contact-us")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Contact us Page is accessible and screen layout is not distorted.");
		}else {
			fail("Contact us Page is not accessible.");
		}
		return passed;
	}
	
	//check if Features Page is accessible and screen layout is not distorted
	public boolean Features (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickFeatures(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/features")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Features Page is accessible and screen layout is not distorted.");
		}else {
			fail("Features Page is not accessible.");
		}
		return passed;
	}
	
	//check if Get Premium Pricing Page is accessible and screen layout is not distorted
	public boolean getPremium (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickPremiumCMS(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/upgrade")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Get Premium Pricing Page is accessible and screen layout is not distorted.");
		}else {
			fail("Get Premium Pricing Page is not accessible.");
		}
		return passed;
	}
	
	//check if Help/FAQ Page is accessible and screen layout is not distorted
	public boolean HelpFaq (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickHelpFaq(0, 0, 0, 0, false);
	
		String url = driver.getCurrentUrl();
		if(url.contains("/help")){
			passed = true;
			driver.navigate().back();
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Help/FAQ Page is accessible and screen layout is not distorted.");
		}else {
			fail("Help/FAQ Page is not accessible.");
		}
		return passed;
	}
	
	//click methods
	public boolean clickInfographic(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickInfographic));
			click(xpath(PVObjectReferenceSmoketest.clickInfographic));
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
	
	public boolean clickAboutUs(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickAboutUs));
			click(xpath(PVObjectReferenceSmoketest.clickAboutUs));
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
	
	public boolean clickContactUs(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickContactUs));
			click(xpath(PVObjectReferenceSmoketest.clickContactUs));
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
	
	public boolean clickFeatures(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickFeatures));
			click(xpath(PVObjectReferenceSmoketest.clickFeatures));
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
	
	public boolean clickPremiumCMS(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPremiumCMS));
			click(xpath(PVObjectReferenceSmoketest.clickPremiumCMS));
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
	
	public boolean clickHelpFaq(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickHelpFaq));
			click(xpath(PVObjectReferenceSmoketest.clickHelpFaq));
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

