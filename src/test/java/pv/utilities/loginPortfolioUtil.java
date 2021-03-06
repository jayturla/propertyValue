package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;


public class loginPortfolioUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public loginPortfolioUtil(String[] i) {
			input = i;
	}
	
	//verify if can navigate to portfolio screen
	public boolean navigatePortfolioScreen(int steps, int inputVal, int expected, int actual,int userName,int password, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		clickMenu(0,0,0,0,false);
		clicknavWatchlist(0,0,0,0,false);
		clickportfolioTab(0,0,0,0,false);
		String url = driver.getCurrentUrl();
		if(url.contains("/portfolio")){
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
			pass("Portfolio Screen is available.");
		}else {
			fail("Portfolio Screen is not available.");
		}
		return available;
	}
	
	//check if add property modal is promted and portfolio SLAS is available
	public boolean btnAddPropertyPortfolio(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		clickAddPropertyPortfolio(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addPropertyModal));
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.addPortfolio));
		
		if(text.contains("Add a property to your porftolio") && isElementPresent(xpath(PVObjectReferenceSmoketest.portfolioSLAS))){
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
			pass("Add Property Modal is prompted and Property SLAS is available.");
		}else {
			fail("Add Property Modal is not prompted and Property SLAS is not available.");
		}
		return available;
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
	public boolean clicknavWatchlist(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.navWatchlist));
			click(xpath(PVObjectReferenceSmoketest.navWatchlist));
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
	public boolean clickportfolioTab(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.portfolioTab));
			click(xpath(PVObjectReferenceSmoketest.portfolioTab));
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
	public boolean clickAddPropertyPortfolio(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickAddPropertyPortfolio));
			click(xpath(PVObjectReferenceSmoketest.clickAddPropertyPortfolio));
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
	
	public boolean AddPorpertytoPortfolio(int steps, int inputVal, int expected, int actual, int address, boolean withATU) throws Exception {
		boolean add = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.portfolioSLAS));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.portfolioSLAS)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.portfolioSLAS)) == true)
			{
				type(xpath(PVObjectReferenceSmoketest.portfolioSLAS), input[address]);
				clickselectSuggestion(0,0,0,0,false);
		
				waitForElementPresent(xpath(PVObjectReferenceSmoketest.modalPropertyItem));
				Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.modalPropertyItem)));
				if(isElementVisible(xpath(PVObjectReferenceSmoketest.modalPropertyItem)) == true)
				{
					waitForElementPresent(xpath(PVObjectReferenceSmoketest.addPortfolioButton));
					Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.addPortfolioButton)));
					if(isElementVisible(xpath(PVObjectReferenceSmoketest.addPortfolioButton)) == true)
					{
						click(xpath(PVObjectReferenceSmoketest.addPortfolioButton));
						//Thread.sleep(1000);
						waitForElementPresent(xpath(PVObjectReferenceSmoketest.dataCrunchHeader));
						Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.dataCrunchHeader)));
						if(isElementVisible(xpath(PVObjectReferenceSmoketest.dataCrunchHeader)) == true)
						{
							add = true;
						}	
					}
				}
			}
		if(withATU) {
			if(add){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(add){
			pass("User was able to Add Property to Portfolio Screen and data crunching modal appeared");
		}else {
			fail("User was not able to Add Property to Portfolio Screen and data crunching modal appeared");
		}		
		return add;
		// TODO Auto-generated method stub
		
	}
	
	public boolean clickselectSuggestion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion));
			Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.selectSuggestion)));
			if(isElementVisible(xpath(PVObjectReferenceSmoketest.selectSuggestion))==true)
			{
				click(xpath(PVObjectReferenceSmoketest.selectSuggestion));
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
}



