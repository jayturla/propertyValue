package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import javax.lang.model.element.ElementVisitor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class RT_HomepageUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_HomepageUtil(String[] i) {
			input = i;
	}
	
	//verify if watch video link will load an embedded youtube video
	public boolean watchVideo (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickWatchVideo(0,0,0,0,false);
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.frameVideo)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}
		
		String url = driver.getCurrentUrl();
		if(url.contains("youtube.com")) {
			passed = true;
			driver.switchTo().defaultContent();
			clickVideoClose(0,0,0,0,false);
		}
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Embedded Video is loaded when Watch Video link or icon is clicked.");
		}else {
			fail("Embedded Video is not loaded when Watch Video link or icon is clicked.");
		}
		return passed;
	}
	
	//check if asx ticker is available
		public boolean checkAsxTicker (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
			boolean passed = false;
			
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.ASXTicker)));
			passed = isElementVisible(xpath(PVObjectReferenceSmoketest.ASXTicker));
			
			if(withATU) {
				if(passed){
					atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
				}else {
					atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
				}
			}
			
			if(passed){
				pass("ASX ticker below the home hero is available in the Homepage.");
			}else {
				fail("ASX ticker below the home hero is not available in the Homepage.");
			}
			return passed;
		}
	
	//check if can navigate to corelogic daily index ini new tab
	public boolean asxTickerNav (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		clickAsxContent(0,0,0,0,false);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Perform the actions on new window
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.corelogicIndex)));
		String text = getText(xpath(PVObjectReferenceSmoketest.corelogicIndex));
		if(text.contains("RP Data Daily Index")){
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
			pass("ASX ticker below the home hero will open the CoreLogic RP Data Daily Index in new tab.");
		}else {
			fail("ASX ticker below the home hero will not open the CoreLogic RP Data Daily Index in new tab.");
		}
		return passed;
	}
	
	//verify if can navigate to explore page when explore button is clicked
	public boolean exploreNav (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbtnExplore(0,0,0,0,false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/explore")){
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
			pass("Explore button will navigate to explore page.");
		}else {
			fail("Explore button will not navigate to explore page.");
		}
		
		return passed;
	}
	
	//verify if can navigate to Cash Flow Investment Strategy page when Strategies button is clicked
	public boolean strategiesNav (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbtnStrategies(0,0,0,0,false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/investment-strategies/cash-flow")){
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
			pass("Strategies button will navigate to Cash Flow Investment Strategy page.");
		}else {
			fail("Strategies button will not navigate to Cash Flow Investment Strategy page.");
		}
		return passed;
	}
	
	//check if can navigate to corelogic in new tab when learn more button is clicked
	public boolean learnMoreNav (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		clickbtnLearnMore(0,0,0,0,false);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Perform the actions on new window
		String url = driver.getCurrentUrl();
		if(url.contains("corelogic.com.au")){
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
			pass("Learn more button will open the Corelogic site in new tab.");
		}else {
			fail("Learn more button will not open the Corelogic site in new tab.");
		}
		return passed;
	}
	
	//check if can switch displays on metrics and property type in state of the nation section
	public boolean switchDisplay (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbtnMedianPriceChange(0,0,0,0,false);
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.displayUpdates)));
		String text = getText(xpath(PVObjectReferenceSmoketest.displayUpdates));
		
		clickbtnUnits(0,0,0,0,false);
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.btnUnits));
		
		if(text.contains("Median Price Change (1 yr)") && element.getAttribute("class").equals("active")){
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
			pass("Able to switch Displays between Metrics and Property Type in State of the nation section.");
		}else {
			fail("Unable to switch Displays between Metrics and Property Type in State of the nation section.");
		}
		return passed;
	}	
	
	//check if can navigate to to their own landing page if investment strategy scores are clicked
	public boolean investmenStrategiesNav (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbtnCapitalGrowth(0,0,0,0,false);
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		
		clickbtnCashFlow(0,0,0,0,false);
		String url2 = driver.getCurrentUrl();
		driver.navigate().back();
		
		clickbtnLowerRisk(0,0,0,0,false);
		String url3 = driver.getCurrentUrl();

		if(url.contains("/investment-strategies/capital-growth") && url2.contains("/investment-strategies/cash-flow") && url3.contains("/investment-strategies/lower-risk")){
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
			pass("Can click Investment strategy scores button to navigate me to their own landing page.");
		}else {
			fail("Cannot click Investment strategy scores button to navigate me to their own landing page.");
		}
		return passed;
	}
	
	//Click Methods
	public boolean clickWatchVideo(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.watchVideo));
			click(xpath(PVObjectReferenceSmoketest.watchVideo));
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
	
	public boolean clickVideoClose(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.videoClose));
			click(xpath(PVObjectReferenceSmoketest.videoClose));
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
	
	public boolean clickAsxContent(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.ASXContent));
			click(xpath(PVObjectReferenceSmoketest.ASXContent));
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
	
	public boolean clickbtnExplore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnExplore));
			click(xpath(PVObjectReferenceSmoketest.btnExplore));
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
	
	public boolean clickbtnStrategies(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnStrategies));
			click(xpath(PVObjectReferenceSmoketest.btnStrategies));
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
	
	public boolean clickbtnLearnMore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnLearnMore));
			click(xpath(PVObjectReferenceSmoketest.btnLearnMore));
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
	
	public boolean clickbtnMedianPriceChange(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnMedianPriceChange));
			click(xpath(PVObjectReferenceSmoketest.btnMedianPriceChange));
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
	
	public boolean clickbtnUnits(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnUnits));
			click(xpath(PVObjectReferenceSmoketest.btnUnits));
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
	
	public boolean clickbtnCapitalGrowth(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnCapitalGrowth));
			click(xpath(PVObjectReferenceSmoketest.btnCapitalGrowth));
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
	
	public boolean clickbtnCashFlow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnCashFlow));
			click(xpath(PVObjectReferenceSmoketest.btnCashFlow));
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
	
	public boolean clickbtnLowerRisk(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnLowerRisk));
			click(xpath(PVObjectReferenceSmoketest.btnLowerRisk));
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

