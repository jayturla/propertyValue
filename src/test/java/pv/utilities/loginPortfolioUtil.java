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
		
		click(xpath(PVObjectReferenceSmoketest.clickMenu));
		click(xpath(PVObjectReferenceSmoketest.navWatchlist));
		click(xpath(PVObjectReferenceSmoketest.portfolioTab));
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
		
		click(xpath(PVObjectReferenceSmoketest.clickAddPropertyPortfolio));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addPropertyModal));
		
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
}

