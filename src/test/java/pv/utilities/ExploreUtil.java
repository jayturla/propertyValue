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

	public void clickExplore() throws Exception {
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore)));
		click(xpath(PVObjectReferenceSmoketest.clickExplore));

	}
	
	//Verify if Explore button will navigate to explore page
	public boolean checkExplore(int steps, int inputVal, int expected, int actual,int userName,int password,boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		clickExplore();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.explorePage));

		if (text.contains("Explore every State in Australia by ordering suburbs based on your buying criteria.")) {
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
			pass("Explore Button can navigate in the page.");
		}else {
			fail("Explore Button cannot navigate in the page.");
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
			pass("Destination URL is /explore.");
		}else {
			fail("Destination URL isn't /explore.");
		}
		return available;
	}
	
	//check if state region filter are available
	public boolean checkStateRegionFilter(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.stateRegionFilter));
		
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
			fail("State and Region Filters are not available.");
		}
		return available;
	}
	//check if stafe region filter are functional
	public boolean functionStateRegionFilter(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.stateRegionFilter)));
		click(xpath(PVObjectReferenceSmoketest.functionState));
		click(xpath(PVObjectReferenceSmoketest.selectState));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.functionRegion));
		click(xpath(PVObjectReferenceSmoketest.functionRegion));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.selectRegion));
		
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
			fail("State and Region Filters are not functioning.");
		}
		return available;
	}
	
	//check if metric sorting are available
	public boolean metricSorting(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.metricSorting));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.metricSorting)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.metricSorting));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("Metric Sorting is available in page.");
		}else {
			fail("Metric Sorting is not available in page.");
		}
		return available;
	}
	
	//check if selected top suburbs can navigate to suburb page
	public boolean selectTopSuburb(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		click(xpath(PVObjectReferenceSmoketest.selectTopSuburb));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkProfilePage)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.checkProfilePage));
		
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
			fail("Selected Top Suburb can not navigate to Suburb Profile Page.");
		}
		return available;
	}
}

