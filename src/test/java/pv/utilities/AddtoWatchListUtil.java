
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

 public void searchAddress(int inputval) throws Exception{
	 	waitForElementPresent(xpath(PVObjectReferenceSmoketest.slasBox));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.slasBox)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.slasBox)))
		{
			type(xpath(PVObjectReferenceSmoketest.slasBox), input[inputval]);
		}
 	}
 
 
 public void selectAddress() throws Exception{
	waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectPropety));
	Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectPropety)));
	if(isElementPresent(xpath(PVObjectReferenceSmoketest.selectPropety))==true)
	{
		click(xpath(PVObjectReferenceSmoketest.selectPropety));
	}
 	}
	  
 	public boolean selectProperty(int property ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		searchAddress(property);
		selectAddress();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actionBar));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actionBar)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.actionBar)) == true)
		{
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
	
	public void clickAddtoWatchList() throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.clickAddtoWatchList));
		}	
	}
 
	public void goToWatchList() throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.goToWatclist));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.goToWatclist)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.goToWatclist)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.goToWatclist));
		}
	}
	
	public boolean verifyIfPropertyisAddedtoWatchList(int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		clickAddtoWatchList();
		head.clickMenu();
		goToWatchList();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyWatchlistHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyWatchlistHeader)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyWatchlistTable));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.propertyWatchlistTable)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.propertyWatchlistHeader)) == true && 
				isElementPresent(xpath(PVObjectReferenceSmoketest.propertyWatchlistTable)) == true)
		{
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
			pass("Property address has been added to Property WatchList Table");
		}else {
			fail("Property was not added to Property WatchList Table");
		}
		

		return available;
	}
		
	/*public void clickLogo() throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogo));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickLogo)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.clickLogo)))
		{
			click(xpath(PVObjectReferenceSmoketest.clickLogo));
		}
	}*/
	
	public void clicViewSuburbProfile() throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewSuburbProfile)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.viewSuburbProfile)) == true)
		{
			click(xpath(PVObjectReferenceSmoketest.viewSuburbProfile));
		}
	}
	
	
	public boolean selectStreet(int street ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		//clickLogo();
		searchAddress(street);
		selectAddress();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actionBar));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actionBar)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.actionBar)) == true)
		{
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
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetWatchlistHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetWatchlistHeader)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetWatchlistTable));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.streetWatchlistTable)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.streetWatchlistHeader)) == true && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.streetWatchlistTable)) == true)
		{
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
			pass("Street Addess was added to Street WatchList Table");
		}else {
			fail("Street Addess was NOT added to Street WatchList Table");
		}
		return available;
	}
	
	public boolean selectSuburb(int suburb ,int steps, int inputVal, int expected, int actualPass,int actualFail ,boolean withATU)  throws Exception{
		boolean available = false;
		
		//clickLogo();
		searchAddress(suburb);
		selectAddress();
		clicViewSuburbProfile();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actionBar));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actionBar)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.actionBar)) == true)
		{
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
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbWatchlistHeader));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbWatchlistHeader)));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbWatchlistTable));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.suburbWatchlistTable)));
		
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.suburbWatchlistHeader)) == true && 
				isElementVisible(xpath(PVObjectReferenceSmoketest.suburbWatchlistTable)) == true)
		{
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
			pass("Suburb Address was added to Suburb WatchList Table");
		}else {
			fail("Suburb Address was not added to Suburb WatchList Table");
		}
		return available;
	}
	public boolean selectStreet(int street ,int steps, int inputVal, int expected, int actualPass,int actualFail ,int a,boolean withATU)  throws Exception{
		boolean available = false;
		
		//clickLogo();
		searchAddress(street);
		selectAddress();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actionBar));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actionBar)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.actionBar)) == true)
		{
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
	public boolean selectSuburb(int suburb ,int steps, int inputVal, int expected, int actualPass,int actualFail ,int a,boolean withATU)  throws Exception{
		boolean available = false;
		
		//clickLogo();
		searchAddress(suburb);
		selectAddress();
		clicViewSuburbProfile();
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.actionBar));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.actionBar)));
		if(isElementVisible(xpath(PVObjectReferenceSmoketest.actionBar)) == true)
		{
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
} 

