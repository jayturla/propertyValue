package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class ExploreUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public ExploreUtil(String[] i) {
			input = i;
	}
	
	//Verify if Explore button will navigate to explore page
	public boolean checkExplore(int steps, int inputVal, int expected, int actual,int userName,int password,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		clickExplore(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.explorePaeHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.explorePaeHeader)));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.explorePage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.explorePage)));
		
		if (isElementVisible(xpath(PVObjectReferenceSmoketest.explorePaeHeader)) ==true &&
				isElementVisible(xpath(PVObjectReferenceSmoketest.explorePage)) == true)
		{
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Explore Button can navigate in the Explore page.");
		}else {
			fail("Explore Button CANNOT navigate in the Explore page.");
		}
		return available;
	}
	
	//check if url is /explore
	public boolean checkURL(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		String url = driver.getCurrentUrl();
		if(url.contains("/explore")){
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Destination URL is correct /explore.");
		}else {
			fail("Destination URL isn't /explore.");
		}
		return available;
	}
	
	//check if state region filter are available
	public boolean checkStateRegionFilter(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.toggleButton));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.toggleButton)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.stateFilter));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stateFilter)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter)));
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.toggleButton)) == true &&
				isElementPresent(xpath(PVObjectReferenceSmoketest.stateFilter)) == true &&
						isElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter)) == true)
		{
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("State and Region Filters are available.");
		}else {
			fail("State and Region Filters are NOT available.");
		}
		return available;
	}
	//check if stafe region filter are functional
	public boolean functionStateRegionFilter(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		//waitForElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter));
		//Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter)));
		clickfunctionState(0,0,0,0,false);
		clickselectState(0,0,0,0,false);
		
		//waitForElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter));
		//Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter)));
		
		clickfunctionRegion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectRegion));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectRegion)));
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.selectRegion)) ==true)
		{
			click(xpath(PVObjectReferenceSmoketest.selectRegion));
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("State and Region Filters are functioning.");
		}else {
			fail("State and Region Filters are NOT functioning.");
		}
		return available;
	}
	
	//check if metric sorting are available
	public boolean metricSorting(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.marketActPane));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.marketActPane)));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.metricSorting));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.metricSorting)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.marketActPane)) == true && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.metricSorting)) == true)
		{
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Market Activity and Metric Sorting is available in Explore page.");
		}else {
			fail("Market Activity and Metric Sorting is NOT available in Explore page.");
		}
		return available;
	}
	
	//check if selected top suburbs can navigate to suburb page
	public boolean selectTopSuburb(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		clickselectTopSuburb(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbList));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbList)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbList)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.suburbList));
			Thread.sleep(1000);
			
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbPage));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbPage)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbPage)) == true)
			{
				available = true;
			}	
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Selected Top Suburb can navigate to Suburb Profile Page.");
		}else {
			fail("Selected Top Suburb CANNOT navigate to Suburb Profile Page.");
		}
		return available;
	}
	
	public boolean clickExplore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore)));
			if(isElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore))==true)
			{
				click(xpath(PVObjectReferenceSmoketest.clickExplore));
				click = true;
			}
			
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
	public boolean clickfunctionState(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.stateFilter));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stateFilter)));
			Thread.sleep(1000);
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.stateFilter)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.stateFilter));
				click = true;
			}
			
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(click){
			pass("Can click state");
		}else {
			fail("Can't click state");
		}
		
		return click;
	}
	public boolean clickselectState(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectState));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectState)));
			Thread.sleep(1000);
			click(xpath(PVObjectReferenceSmoketest.selectState));
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
		if(click){
			pass("Can Filter state");
		}else {
			fail("Can't Filter state");
		}
		return click;
	}
	public boolean clickfunctionRegion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.regionFilter)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.regionFilter)) == true)
			{
				click(xpath(PVObjectReferenceSmoketest.regionFilter));
				click = true;
			}
			
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(click){
			pass("Can click region");
		}else {
			fail("Can't click region");
		}
		return click;
	}
	public boolean clickselectTopSuburb(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectTopSuburb));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectTopSuburb)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.selectTopSuburb)) == true)
			{
				click = true;
			}
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(click){
			pass("Top Suburbs is available in the Explore page.");
		}else {
			fail("Top Suburbs is NOT available in the Explore page.");
		}
		
		return click;
	}
}



