package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class HomepageUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public HomepageUtil(String[] i) {
			input = i;
	}
	
	//Checking Header if available in the homepage
	public boolean checkHeader(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception {
		boolean available = false;
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.headerNav)));
		String text = getText(xpath(PVObjectReferenceSmoketest.headerNav));

		if (text.contains("Explore Compare Strategies Get Premium Features")) {
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
			pass("Header is available in the page.");
		}else {
			fail("Header is NOT AVAILABLE in the page.");
		}
		return available;
	}
	
	//Checking SLAS Box if available in the homepage
	public boolean checkSLAS(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.slasBox));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		if(available){
			pass("SLAS is available in the page.");
		}else {
			fail("SLAS is NOT AVAILABLE in the page.");
		}
		return available;	
	}
	
	//Checking State of the Nation if available in the homepage
	public boolean checkstateNation(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.statNat));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.statNat)));
		String text = getText(xpath(PVObjectReferenceSmoketest.statNat));

		if (text.contains("State of the Nation")) {
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
			pass("State of the Nation is available in the page.");
		}else {
			fail("State of the Nation is NOT AVAILABLE in the page.");
		}
		return available;
	}
	
	//Checking Top Suburbs if available in the homepage
	public boolean checkTopSuburbs(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
			boolean available = false;
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.topSuburbs));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.topSuburbs)));
			String text = getText(xpath(PVObjectReferenceSmoketest.topSuburbs));

			if (text.contains("Top Suburbs")) {
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
				pass("Top Suburbs is available in the page.");
			}else {
				fail("Top Suburbs is NOT AVAILABLE in the page.");
			}
			return available;
	}
	
//	public boolean checkMedianPriceAndGrossYield(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
//		boolean exist = false;
//		if(checkMedianPriceChange(steps,inputVal,expected,actual,withATU) && checkMedianGrossYield(steps,inputVal,expected,actual,withATU)){
//			exist = true;
//		}
//		return exist;
//	}
	//Checking Top Suburbs by Median Price change (1yr) and Median Gross Yield if available in the homepage.
	public boolean checkMedianPriceChange(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.medianPriceChange));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.medianPriceChange)));
		String text = getText(xpath(PVObjectReferenceSmoketest.medianPriceChange));

		if (text.contains("Median Price Change (1 yr)")) {
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
			pass("Top Suburbs by Median Price Change (1 yr) is available in the page.");
		}else {
			fail("Top Suburbs by Median Price Change (1 yr) is NOT AVAILABLE in the page.");
		}
		return available;
	}
	
	public boolean checkMedianGrossYield(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.medianGrossYield));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.medianGrossYield)));
		String text = getText(xpath(PVObjectReferenceSmoketest.medianGrossYield));

		if (text.contains("Median Gross Yield")) {
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
			pass("Top Suburbs by Median Gross Yield is available in the page.");
		}else {
			fail("Top Suburbs by Median Gross Yield is NOT AVAILABLE in the page.");
		}
		return available;
	}

	//Checking the Footer if available in the homepage
	public boolean checkFooter(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.footer));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.footer)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.footer));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		if(available){
			pass("Footer is available in the page.");
		}else {
			fail("Footer is NOT AVAILABLE in the page.");
		}
		
		return available;
	}	
}

