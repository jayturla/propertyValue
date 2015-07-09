package pv.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.List;

import pv.library.FunctionReference;
import pv.library.MYRPObjectReferenceRT_07810;
import pv.library.ObjectReference;
import pv.library.ObjectReferenceSmoketest;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class PVSmoketestUtil extends FunctionReference {
	
	private String[] input = null;
	
	public PVSmoketestUtil(String[] i) {
			input = i;
	}
	
	//Checking Header if available in the homepage
	public boolean checkHeader(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.headerNav)));
		String text = getText(xpath(PVObjectReferenceSmoketest.headerNav));

		if (text.contains("Explore Compare Strategies Get Premium Features")) {
			available = true;
		}
		
		if(withATU) {
			if(available){
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Header is available in the page");
		}else {
			fail("Header is NOT AVAILABLE in the page");
		}
		return available;
	}
	
	//Checking SLAS Box if available in the homepage
	public boolean checkSLAS(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception{
		boolean available = false;
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.slasBox));
		if(withATU) {
			if(available){
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("SLAS is available in the page");
		}else {
			fail("SLAS is NOT AVAILABLE in the page");
		}
		return available;	
	}
	
	//Checking State of the Nation if available in the homepage
	public boolean checkstateNation(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception{
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.statNat));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.statNat)));
		String text = getText(xpath(PVObjectReferenceSmoketest.statNat));

		if (text.contains("State of the Nation")) {
			available = true;
		}
		if(withATU) {
			if(available){
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
		}
		if(available){
			pass("State of the Nation is available in the page");
		}else {
			fail("State of the Nation is NOT AVAILABLE in the page");
		}
		return available;
	}
	
	//Checking Top Suburbs if available in the homepage
	public boolean checkTopSuburbs(int steps, int inputVal, int expected, int actual,boolean withATU) throws Exception{
			boolean available = false;
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.topSuburbs));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.topSuburbs)));
			String text = getText(xpath(PVObjectReferenceSmoketest.topSuburbs));

			if (text.contains("Top Suburbs")) {
				available = true;
			}
			if(withATU) {
				if(available){
					performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
				}else {
					performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
					}
			}
			if(available){
				pass("Top Suburbs is available in the page");
			}else {
				fail("Top Suburbs is NOT AVAILABLE in the page");
			}
			return available;
		}
	
	//ATU Report
	public void performATU(String steps, String inputVal, String expected, String actual, boolean screenShot, boolean status){
		if(status) {
			ATUReports.add(steps,inputVal,expected,actual,screenShot);
		}else{
			ATUReports.add(actual, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		
		
	}
	
}

