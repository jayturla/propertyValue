package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.HeaderZoneUtil;

public class RT_WatchlistLinksUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_WatchlistLinksUtil(String[] i) {
			input = i;
	}
	
	//Check if watchlist have more than 6 property, suburb, street
	public boolean countWatchlist(int steps, int inputVal, int expected, int actualPass, int actualFail, int userName, int password, boolean withATU) throws Exception {
		boolean passed = false;
		
		pv.utilities.HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);		
		login.loginSite();
		
		clickMenu(0, 0, 0, 0, false);
		clickWatchlist(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.countWatchlist));
		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.countWatchlist));
		if(element.getAttribute("data-nvisible").equals("6")) {
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
			pass("Added Watchlists are more than 6.");
		}else {
			fail("Added Watchlists are less than 6.");
		}
		return passed;
	}
	
	//check if show more button will show the entire list
	public boolean showMore(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickpropertyShowMore(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.propertyShowMore));
		
		clickStreetShowMore(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text1 = getText(xpath(PVObjectReferenceSmoketest.streetShowMore));
		
		clickSuburbShowMore(0, 0, 0, 0, false);
		Thread.sleep(2000);
		String text2 = getText(xpath(PVObjectReferenceSmoketest.suburbShowMore));
		if(text.contains("Show Less") && text1.contains("Show Less") && text2.contains("Show Less")) {
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
			pass("Show All button are clickable and the entire list are shown.");
		}else {
			fail("Show All button are not clickable.");
		}
		return passed;
	}
	
	//check if left nav bar is clickable and will anchor to selected section
	public boolean leftNavBar(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickLeftProperty(0, 0, 0, 0, false);

		WebElement element = driver.findElement(xpath(PVObjectReferenceSmoketest.leftNavProperties));
		if(element.getAttribute("class").equals("active")) {
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
			pass("Left Navigation Bar is clickable and will anchor to the selected watchlist/portfolio section.");
		}else {
			fail("Left Navigation Bar is not clickable.");
		}
		return passed;
	}
	
	//check if Account link is available
	public boolean checkMyAccount (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.myAccountLink)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.myAccountLink));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		
		if(passed){
			pass("Account Link is available.");
		}else {
			fail("Account Link is not available.");
		}
		return passed;
	}
	
	//click myAccount if will navigate to account summary screen
	public boolean myAccount (int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		clickAccount(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkAccount));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkAccount));
		if(text.contains("User Profile")) {
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
			pass("Account Link will navigate to Account Summary Screen.");
		}else {
			fail("Account Link will not navigate to Account Summary Screen.");
		}
		return passed;
	}
		
	//Click Methods
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
	
	public boolean clickWatchlist(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMenuWatchlist));
			click(xpath(PVObjectReferenceSmoketest.clickMenuWatchlist));
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
	
	public boolean clickpropertyShowMore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyShowMore));
			click(xpath(PVObjectReferenceSmoketest.propertyShowMore));
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
	
	public boolean clickStreetShowMore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.streetShowMore));
			click(xpath(PVObjectReferenceSmoketest.streetShowMore));
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
	
	public boolean clickSuburbShowMore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.suburbShowMore));
			click(xpath(PVObjectReferenceSmoketest.suburbShowMore));
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
	
	public boolean clickLeftProperty(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.leftNavPropertiesEle));
			click(xpath(PVObjectReferenceSmoketest.leftNavPropertiesEle));
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
	
	public boolean clickAccount(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.myAccountLink));
			click(xpath(PVObjectReferenceSmoketest.myAccountLink));
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

