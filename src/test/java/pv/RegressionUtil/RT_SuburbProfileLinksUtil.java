package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.HeaderZoneUtil;

public class RT_SuburbProfileLinksUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_SuburbProfileLinksUtil(String[] i) {
			input = i;
	}
	
	//verify if breadcrumbs are clickable and will navigate to relevant page
	public boolean breadcrumbsNav(int steps, int inputVal, int expected, int actualPass, int actualFail, int urlnav, boolean withATU) throws Exception {
		boolean passed = false;
		
		driver.navigate().to(input[urlnav]);
		clickBreadcrumbs(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		if(url.contains("/explore/manly-nsw")) {
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
	
	//switch between property types
	public boolean switchPropertyType(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickPropertyType(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		if(url.contains("#Unit")) {
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
			pass("Able to switch between property types.");
		}else {
			fail("Unable to switch between property types.");
		}
		return passed;
	}
	
	//check if upgrade to premium is clickable
	public boolean upgradePremiumNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPremium));
		clickGetPremium(0, 0, 0, 0, false);
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
		clickCloseModal(0, 0, 0, 0, false);
		return passed;
	}
	
	//check if can buy postcode report when available
	public boolean postcodeReportNav(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickbuyPostcode(0, 0, 0, 0, false);
		
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
	
	//check if can add to watchlist
	public boolean btnAddToWatchlist(int steps, int inputVal, int expected, int actualPass, int actualFail, int userName, int password, boolean withATU) throws Exception {
		boolean passed = false;
		
		pv.utilities.HeaderZoneUtil login = new HeaderZoneUtil(input);
		
		clickbtnWatchlist(0, 0, 0, 0, false);
		
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.btnWatchlist));
		if(element.getAttribute("class").equals("fa fa-heart wl-watched")){
			passed = true;
			clickMenu(0, 0, 0, 0, false);
			clickLogout(0, 0, 0, 0, false);
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
			pass("Able to add the suburb to Watchlist.");
		}else {
			fail("Unable to add the suburb to Watchlist.");
		}
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
	
	//check if ranking on suburb insights are clickable
	public boolean rankingSuburb(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickRanking(0, 0, 0, 0, false);
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
			pass("Ranking on Suburb Insights Metrics are clickable.");
		}else {
			fail("Ranking on Suburb Insights Metrics are not clickable.");
		}
		return passed;
	}
	
	//verify if upgrade to premium on investment score section is clickable
	public boolean getPremiumInvestmentScore(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		getPremiumInvestment(0, 0, 0, 0, false);
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
			pass("Upgrade to Premium overlayed on Investment Strategy Score is clickable.");
		}else {
			fail("Upgrade to Premium overlayed on Investment Strategy Score is not clickable.");
		}
		clickCloseModal(0, 0, 0, 0, false);
		return passed;
	}
	
	//check if leaderboard banner ad is shown and clickable
	public boolean leaderboardBannerAds(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.frameAds)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}
		
		clickLeaderboardAds(0, 0, 0, 0, false);
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Upgrade to Premium overlayed on Investment Strategy Score is clickable.");
		}else {
			fail("Upgrade to Premium overlayed on Investment Strategy Score is not clickable.");
		}
		return passed;
	}
	
	//verify if can switch between for sale, recently sold and for rent on suburb property prices section
	public boolean switchSuburbPropertyPrices(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
	
		clickRecentSold(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.textRecentSold));
		clickForRent(0, 0, 0, 0, false);
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
		
		clickPropertyList(0, 0, 0, 0, false);
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		
		clickRecentSold(0, 0, 0, 0, false);
		clickPropertyList(0, 0, 0, 0, false);
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
		clickPremiumOtherSection(0, 0, 0, 0, false);
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
		clickCloseModal(0, 0, 0, 0, false);
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
	
	//check if can toggle the legend of each statistics chart
	public boolean toggleLegend(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickCityCouncilM(0, 0, 0, 0, false);
		WebElement element0 = driver.findElement(xpath(PVObjectReferenceSmoketest.checkToggleCityCouncilM));
		
		clickCityCouncil(0, 0, 0, 0, false);
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
		
		clickPropertySold(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.checkMetricUpdate));
		
		clickMedianRent(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text1 = getText(xpath(PVObjectReferenceSmoketest.checkMetricUpdate));
		
		clickMedianGross(0, 0, 0, 0, false);
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
	
	//verify if can view all experts
	public boolean viewAllExperts(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.frameExperts)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}
		
		clickViewAll(0, 0, 0, 0, false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/local-experts/")) {
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
			pass("View all Local Experts is available.");
		}else {
			fail("View all Local Experts is not available.");
		}
		driver.switchTo().defaultContent();
		return passed;
	}
	
	//check if can select from list of streets and navigate to street details page
	public boolean selectListStreet(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickStreetList(0, 0, 0, 0, false);
		
		String url = driver.getCurrentUrl();
		if(url.contains("/street/")) {
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
			pass("Select List of Street will navigate to street details page.");
		}else {
			fail("Select List of Street will not navigate to street details page.");
		}
		return passed;
	}
	
	//Click Methods
	public boolean clickBreadcrumbs(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickBreadcrumbsManly));
			click(xpath(PVObjectReferenceSmoketest.clickBreadcrumbsManly));
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
	
	public boolean clickPropertyType(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertyType));
			click(xpath(PVObjectReferenceSmoketest.togglePropertyType));
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
	
	public boolean clickGetPremium(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPremium));
			click(xpath(PVObjectReferenceSmoketest.clickPremium));
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
	
	public boolean clickCloseModal(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.premiumClose));
			click(xpath(PVObjectReferenceSmoketest.premiumClose));
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
	
	public boolean clickbuyPostcode(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickbuyPostcodeReport));
			click(xpath(PVObjectReferenceSmoketest.clickbuyPostcodeReport));
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
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnWatchlist));
			click(xpath(PVObjectReferenceSmoketest.btnWatchlist));
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
	
	public boolean clickMenu(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMenu));
			click(xpath(PVObjectReferenceSmoketest.clickMenu));
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
	
	public boolean clickLogout(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogOut));
			click(xpath(PVObjectReferenceSmoketest.clickLogOut));
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
	
	public boolean clickRanking(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.rankingSuburb));
			click(xpath(PVObjectReferenceSmoketest.rankingSuburb));
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
	
	public boolean getPremiumInvestment(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.premiumInvestment));
			click(xpath(PVObjectReferenceSmoketest.premiumInvestment));
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
	
	public boolean clickLeaderboardAds(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickFrame));
			click(xpath(PVObjectReferenceSmoketest.clickFrame));
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
	
	public boolean clickRecentSold(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.switchRecentSold));
			click(xpath(PVObjectReferenceSmoketest.switchRecentSold));
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
	
	public boolean clickForRent(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.switchForRent));
			click(xpath(PVObjectReferenceSmoketest.switchForRent));
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
	
	public boolean clickPropertyList(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickPropertyList));
			click(xpath(PVObjectReferenceSmoketest.clickPropertyList));
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
	
	public boolean clickPremiumOtherSection(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.getPremiumOtherSection));
			click(xpath(PVObjectReferenceSmoketest.getPremiumOtherSection));
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
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.councilName));
			click(xpath(PVObjectReferenceSmoketest.councilName));
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
	
	public boolean clickCityCouncilM(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleCityCouncilM));
			click(xpath(PVObjectReferenceSmoketest.toggleCityCouncilM));
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
	
	public boolean clickCityCouncil(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleCityCouncil));
			click(xpath(PVObjectReferenceSmoketest.toggleCityCouncil));
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
	
	public boolean clickCouples(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleCouples));
			click(xpath(PVObjectReferenceSmoketest.toggleCouples));
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
	
	public boolean clickOutright(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleOutright));
			click(xpath(PVObjectReferenceSmoketest.toggleOutright));
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
	
	public boolean clickPropertySold(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.togglePropertySold));
			click(xpath(PVObjectReferenceSmoketest.togglePropertySold));
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
	
	public boolean clickMedianRent(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleMedianRent));
			click(xpath(PVObjectReferenceSmoketest.toggleMedianRent));
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
	
	public boolean clickMedianGross(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleMedianGross));
			click(xpath(PVObjectReferenceSmoketest.toggleMedianGross));
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
	
	public boolean clickViewAll(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewAll));
			click(xpath(PVObjectReferenceSmoketest.viewAll));
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
	
	public boolean clickStreetList(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectStreet));
			click(xpath(PVObjectReferenceSmoketest.selectStreet));
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

