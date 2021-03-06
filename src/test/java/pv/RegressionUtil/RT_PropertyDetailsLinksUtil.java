package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.HeaderZoneUtil;

public class RT_PropertyDetailsLinksUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_PropertyDetailsLinksUtil(String[] i) {
			input = i;
	}
	
	private RT_SuburbProfileLinksUtil click = new RT_SuburbProfileLinksUtil(input);
	
	
	//verify if breadcrumbs are clickable and will navigate to relevant page
	public boolean breadcrumbsNav(int steps, int inputVal, int expected, int actualPass, int actualFail, int urlnav, int userName, int password, boolean withATU) throws Exception {
		boolean passed = false;
		
		pv.utilities.HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);		
		login.loginSite();
		
		driver.navigate().to(input[urlnav]);
		clickBreadcrumbs(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		if(url.contains("/street/nsw/banora%20point/2486/darlington%20drive")) {
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
			pass("Breadcrumbs are clickable.");
		}else {
			fail("Breadcrumbs are not clickable.");
		}
		return passed;
	}
	
	//check if upgrade to premium is clickable
	public boolean upgradePremiumNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPremium));
		click.clickGetPremium(0, 0, 0, 0, false);
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.getPremiumModal)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.getPremiumModal));
		
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Upgrade to Premium button is clickable.");
		}else {
			fail("Upgrade to Premium button is not clickable.");
		}
		click.clickCloseModal(0, 0, 0, 0, false);
		return passed;
	}
	
	//check if can buy property report when available
		public boolean propertyReportNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
			boolean passed = false;
			
			clickbuyProperty(0, 0, 0, 0, false);
			
			String url = driver.getCurrentUrl();
			if(url.contains("/property-report/")) {
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
				pass("Able to Buy Property Report when available.");
			}else {
				fail("Unable to Buy Property Report.");
			}
			return passed;
		}
	
	//check if can buy postcode report when available
	public boolean postcodeReportNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		click.clickbuyPostcode(0, 0, 0, 0, false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/postcode-report/")) {
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
			pass("Able to Buy Postcode Report when available.");
		}else {
			fail("Unable to Buy Postcode Report.");
		}
		return passed;
	}
	
	//check if can buy Title documents when available
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
			if(url.contains("realtor.com.au/cgi-bin/vgmsg/lto")) {
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
				pass("Able to Buy Title Documents when available.");
			}else {
				fail("Unable to Buy Title Documents.");
			}
			return passed;
		}
	
	//check if can add to watchlist
	public boolean btnAddToWatchlist(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbtnWatchlist(0, 0, 0, 0, false);
		Thread.sleep(2000);
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.btnWatchlist));
		if(element.getAttribute("class").equals("fa fa-heart wl-watched")){
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
			pass("Able to add the suburb to Watchlist.");
		}else {
			fail("Unable to add the suburb to Watchlist.");
		}
		clickbtnWatchlist(0, 0, 0, 0, false);
		return passed;
	}
	
	
	//check if can share the suburb profile to social 
	public boolean btnShare(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Perform the click operation that opens new window
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(xpath(PVObjectReferenceSmoketest.btnShare));
		action.moveToElement(we).moveToElement(driver.findElement(xpath(PVObjectReferenceSmoketest.socialFB))).click().build().perform();
				
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Perform the actions on new window
		String url = driver.getCurrentUrl();
		if(url.contains("facebook.com")){
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
			pass("Able to share the suburb profile page.");
		}else {
			fail("Unable to share the suburb profile page.");
		}
		return passed;
	}
	
	//check if can click links on left nav bar to anchor specifit page
	public boolean leftNavBar (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickAbout(0,0,0,0,false);
		Thread.sleep(2000);
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.aboutNav));
		
		if(element.getAttribute("class").equals("active")){
			passed = true;
			clickInsights(0, 0, 0, 0, false);
		}	
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Links on Left Nav Bar will anchor to their specific page.");
		}else {
			fail("Links on Left Nav Bar will not anchor to their specific page.");
		}
		return passed;
		
	}	
	
	//check if can view all image at gallery
	public boolean viewImage (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickSwipeImg(0, 0, 0, 0, false);
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.imgElement));
		if(element.getAttribute("class").equals("title active-selected")){
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
			pass("Image on gallery are shown.");
		}else {
			fail("Image on gallery are missing.");
		}
		return passed;
		
	}	
	
	//view toolip details
	public boolean tooltipView (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(xpath(PVObjectReferenceSmoketest.viewPropertyTooltip));
		action.moveToElement(we).moveToElement(driver.findElement(xpath(PVObjectReferenceSmoketest.viewPropertyTooltip))).build().perform();
		
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.checkTooltip));
		if(element.isDisplayed()){
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
			pass("Tooltip Details are shown when mouse hover.");
		}else {
			fail("Tooltip Details are not shown when mouse hover.");
		}
		return passed;
	}	
	
	//verify if can switch between for sale, recently sold and for rent on suburb property prices section
	public boolean switchSuburbPropertyPrices(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		click.clickRecentSold(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.textRecentSold));
		click.clickForRent(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text1 = getText(xpath(PVObjectReferenceSmoketest.textForRent));
	
		
		if(text.contains("recently sold") && text1.contains("for rent")) {
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
			pass("Able to switch between For Sale, Recently Sold, For Rent buttons on Suburb Property Prices.");
		}else {
			fail("Unable to switch between For Sale, Recently Sold, For Rent buttons on Suburb Property Prices.");
		}
		return passed;
	}
	
	//verify if Properties on either map or list are clickable
	public boolean clickProperties(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		click.clickPropertyList(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		
		click.clickRecentSold(0, 0, 0, 0, false);
		click.clickPropertyList(0, 0, 0, 0, false);
		String url1 = driver.getCurrentUrl();
		
		if(url.contains("/property/") && url1.contains("/property/")){
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
			pass("Able to click the Properties from either map or list on each status.");
		}else {
			fail("Unable to click the Properties from either map or list on each status.");
		}
		return passed;
	}
	
	//check if upgrade to premium on other section if clickable
	public boolean getPremiumOtherSection(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPremium));
		click.clickPremiumOtherSection(0, 0, 0, 0, false);
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.getPremiumModal)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.getPremiumModal));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Able to click Upgrade to premium on other section.");
		}else {
			fail("Unable to click Upgrade to premium on other section.");
		}
		click.clickCloseModal(0, 0, 0, 0, false);
		return passed;
	}
	
	//check it the council name from suburb information is clickable and navigate to explore region page
	public boolean councilNameNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickCouncilName(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		if(url.contains("/explore/")) {
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
			pass("Able to click Council name and navigate to Explore Region Page.");
		}else {
			fail("Unable to click Council name.");
		}
		return passed;
	}
	
	//check if view suburb profile from suburb information section is clickable and navigate to suburb profile
	public boolean viewSuburbProfile(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickSuburbProfile(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		if(url.contains("/suburb/")) {
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
			pass("View Suburb Profile link is clickable and navigated to Suburb profile page.");
		}else {
			fail("View Suburb Profile link is not clickable.");
		}
		return passed;
	}
	
	//check if can toggle the legend of each statistics chart
	public boolean toggleLegend(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		click.clickCityCouncilM(0, 0, 0, 0, false);
		WebElement element0 = driver.findElement(xpath(PVObjectReferenceSmoketest.checkToggleCityCouncilM));
		
		click.clickCityCouncil(0, 0, 0, 0, false);
		WebElement element1 = driver.findElement(xpath(PVObjectReferenceSmoketest.checkToggleCityCouncil));
		
		if(element0.getAttribute("visibility").equals("hidden") && element1.getAttribute("visibility").equals("hidden")){
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
			pass("Able to toggle the legend of each statistics chart.");
		}else {
			fail("Unable to toggle Legend.");
		}
		return passed;
	}
	
	//check if can toggle display between metrics in market trends section
		public boolean toggleMetric(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
			boolean passed = false;
			
			click.clickPropertySold(0, 0, 0, 0, false);
			Thread.sleep(2000);
			String text = getText(xpath(PVObjectReferenceSmoketest.checkMetricUpdate));
			
			click.clickMedianRent(0, 0, 0, 0, false);
			Thread.sleep(2000);
			String text1 = getText(xpath(PVObjectReferenceSmoketest.checkMetricUpdate));
			
			click.clickMedianGross(0, 0, 0, 0, false);
			Thread.sleep(2000);
			String text2 = getText(xpath(PVObjectReferenceSmoketest.checkMetricUpdate));
			
			if(text.contains("Properties Sold") && text1.contains("Median Rent") && text2.contains("Median Gross Yield")) {
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
				pass("Able to toggle the display between each metric in Market Trends section.");
			}else {
				fail("Unable to toggle Metrics.");
			}
			return passed;
		}
	
	public boolean clickBreadcrumbs(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickBreadcrumbsProperty));
			click(xpath(PVObjectReferenceSmoketest.clickBreadcrumbsProperty));
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
	
	public boolean clickAbout(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.aboutNav1));
			click(xpath(PVObjectReferenceSmoketest.aboutNav1));
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
	
	public boolean clickSuburbProfile(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbClick));
			click(xpath(PVObjectReferenceSmoketest.suburbClick));
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
	
	public boolean clickInsights(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.insightsNav));
			click(xpath(PVObjectReferenceSmoketest.insightsNav));
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
	
	public boolean clickbtnWatchlist(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickHeart));
			click(xpath(PVObjectReferenceSmoketest.clickHeart));
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
	
	public boolean clickbuyProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickBuyPropertyReport));
			click(xpath(PVObjectReferenceSmoketest.clickBuyPropertyReport));
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
	
	public boolean clickSwipeImg(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.swipeImage));
			click(xpath(PVObjectReferenceSmoketest.swipeImage));
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
	
	public boolean clickCouncilName(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyCouncil));
			click(xpath(PVObjectReferenceSmoketest.propertyCouncil));
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

