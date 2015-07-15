package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class ReportsPortfolioAndWatchlistUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public ReportsPortfolioAndWatchlistUtil(String[] i) {
			input = i;
	}
	
	//check if can download unlimited property and postcode rreports
	public boolean downloadReports(int steps, int inputVal, int expected, int actual, int userName, int password, int property, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		type(xpath(PVObjectReferenceSmoketest.slasBox), input[property]);
		driver.findElement(xpath(PVObjectReferenceSmoketest.slasBox)).sendKeys(Keys.RETURN);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.propertyDownload));
		
		click(xpath(PVObjectReferenceSmoketest.propertyDownload));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.successReport));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Can download unlimited Property and Postcode Reports.");
		}else {
			fail("Cannot download unlimited Property and Postcode Reports.");
		}
		click(xpath(PVObjectReferenceSmoketest.closebtn));
		return available;
	}
	
	//verify if able to add unlimited portfolio and properties
	public boolean subscribedPortfolio(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		click(xpath(PVObjectReferenceSmoketest.clickMenu));
		click(xpath(PVObjectReferenceSmoketest.clickPortfolio));
		click(xpath(PVObjectReferenceSmoketest.btnAddProperty));
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addProperty));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.addProperty)));
		String text = getText(xpath(PVObjectReferenceSmoketest.addProperty));
		
		if (text.contains("Add a property to your porftolio")) {
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
			pass("Able to add unlimited portfolio and properties.");
		}else {
			fail("Unable to add unlimited portfolio and properties.");
		}
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addProperty));
		click(xpath(PVObjectReferenceSmoketest.btnClose));
		return available;
	}
	
	//check if estimated gross yield is calculated
	public boolean checkEstimatedGrossYield(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.estimateGrossYield));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.estimateGrossYield)));
		String text = getText(xpath(PVObjectReferenceSmoketest.estimateGrossYield));
		
		if (text.contains("%")) {
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
			pass("Estimated Gross Yield is calculated.");
		}else {
			fail("Estimated Gross Yield is not calculated.");
		}
		return available;
	}
	
	//view total and individual properties
	public boolean portfolioValueGraph(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
			boolean available = false;
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.portfolioValueGraph));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.portfolioValueGraph)));
			available = isElementVisible(xpath(PVObjectReferenceSmoketest.portfolioValueGraph));
			
			if(withATU) {
				if(available){
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
				}else {
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
			}
			
			if(available){
				pass("Total and Individual properties are shown.");
			}else {
				fail("Total and Individual properties are not shown.");
			}
			return available;
	}
		
	//check if investor score are shown in premium user
	public boolean porfolioInvestorScore(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
			boolean available = false;
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.progressBar));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.progressBar)));
			available = isElementVisible(xpath(PVObjectReferenceSmoketest.progressBar));
			
			if(withATU) {
				if(available){
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
				}else {
					atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
				}
			}
			
			if(available){
				pass("Property Investor Score are shown in the Portfolio Property List.");
			}else {
				fail("Property Investor Score are not shown in the Portfolio Property List.");
			}
			return available;
	}
		
	//check if exact estimated value were added to property watchlist
	public boolean checkWatchlist(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
					boolean available = false;
					
					driver.navigate().to("http://dev.propertyvalue.com.au/watchlist");
					waitForElementPresent(xpath(PVObjectReferenceSmoketest.estimatedValue));
					Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.estimatedValue)));
					String text = getText(xpath(PVObjectReferenceSmoketest.estimatedValue));
					
					if(text.contains("$")){
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
						pass("Exact Estimated Value are shown in the property watchlist.");
					}else {
						fail("Exact Estimated Value are not shown in the property watchlist.");
					}
					return available;
	}
		
	//check owned/rented if available in premium users
	public boolean checkOwnedRented(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
			boolean available = false;
		
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.ownedRented));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.ownedRented)));
			String text = getText(xpath(PVObjectReferenceSmoketest.ownedRented));
			
			if(text.contains("%")){
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
				pass("Owned/Rented is shown on street for premium users.");
			}else {
				fail("Owned/Rented is not shown on street for premium users.");
			}
			return available;
	}
}

