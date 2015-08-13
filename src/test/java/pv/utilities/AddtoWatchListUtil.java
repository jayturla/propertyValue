
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class AddtoWatchListUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public AddtoWatchListUtil(String[] i) {
		input = i;
	}
	
	private HeaderZoneUtil head =  new HeaderZoneUtil(input);
	  
 	public boolean selectProperty(int property ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights)));
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyPropertyInsights));
		if (text.contains("Property Insights")) {
			available = true;	
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to search and select property");
		}else {
			fail("User was not able to search and select property");
		}

		return available;
	
 	}
	
	public boolean verifyIfPropertyisAddedtoWatchList(int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickAddtoWatchList();
		head.clickMenu();
		goToWatchList();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.checkWatchlist));
		if (text.contains("79 Darley Road")) {
			available = true;	
			clickWatchlistDropDown(0, 0, 0, 0, false);
			clickRemoveWatchlist(0, 0, 0, 0, false);
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Property was added to WatchList");
		}else {
			fail("Property was not added to WatchList");
		}
		

		return available;
	}
		
	
	
	
	public boolean selectStreet(int street ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickLogo();
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[street]);
		clickselectSuggestion(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.verifyStreetInsights));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyStreetInsights)));
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyStreetInsights));
		if (text.contains("Street Insights")) {
			available = true;	
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to search and select a Street");
		}else {
			fail("User was not able to search and select a Street");
		}
		

		return available;
	}
	
	public boolean verifyIfStreetisAddedtoWatchList(int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		clickAddtoWatchList();
		head.clickMenu();
		goToWatchList();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.checkWatchlist));
		if (text.contains("Maxwell Street")) {
			available = true;	
			clickWatchlistDropDown(0, 0, 0, 0, false);
			clickRemoveStreet(0, 0, 0, 0, false);
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Street was added to WatchList");
		}else {
			fail("Street was not added to WatchList");
		}
		

		return available;
	}
	
	public boolean selectSuburb(int suburb ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickLogo();
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[suburb]);
		clickselectSuggestion(0,0,0,0,false);
		clicViewSuburbProfile();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.verifySuburbInsights));
		if (text.contains("Suburb Insights")) {
			available = true;	
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("User was able to search and select a Suburb");
		}else {
			fail("User was not able to search and select a Suburb");
		}
		

		return available;
	}
	
	public boolean verifyIfSuburbisAddedtoWatchList(int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		clickAddtoWatchList();
		head.clickMenu();
		goToWatchList();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.checkWatchlist));
		if (text.contains("Manly, NSW 2095")) {
			available = true;	
			clickWatchlistDropDown(0, 0, 0, 0, false);
			clickRemoveSuburb(0, 0, 0, 0, false);
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Suburb was added to WatchList");
		}else {
			fail("Suburb was not added to WatchList");
		}
	
		return available;
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
	
	public boolean clickWatchlistDropDown(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.watchlistDropDown));
			click(xpath(PVObjectReferenceSmoketest.watchlistDropDown));
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
	
	public boolean clickRemoveWatchlist(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.removeWatchlist));
			click(xpath(PVObjectReferenceSmoketest.removeWatchlist));
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
	
	public boolean clickRemoveStreet(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.removeStreet));
			click(xpath(PVObjectReferenceSmoketest.removeStreet));
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
	
	public boolean clickRemoveSuburb(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.removeSuburb));
			click(xpath(PVObjectReferenceSmoketest.removeSuburb));
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
	
	
	public void searchAddress(int inputval) throws Exception{
	 	waitForElementPresent(xpath(PVObjectReferenceSmoketest.slasBox));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[inputval]);
	 
 	}
 
	public void selectAddress() throws Exception{
	
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectPropety));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectPropety)));
		click(xpath(PVObjectReferenceSmoketest.selectPropety));
 	}
	
	public void clickAddtoWatchList() throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList)));
		click(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList));
		
	}
 
	public void goToWatchList() throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.goToWatclist));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.goToWatclist)));
		click(xpath(PVObjectReferenceSmoketest.goToWatclist));
	}
	
	public void clickLogo() throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogo));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickLogo)));
		click(xpath(PVObjectReferenceSmoketest.clickLogo));
		
	}
	
	public void clicViewSuburbProfile() throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbProfile)));
		click(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
	
	}
} 

