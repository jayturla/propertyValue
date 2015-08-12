package pv.RegressionUtil;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.HeaderZoneUtil;

public class RT_CalculatePortfolioUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RT_CalculatePortfolioUtil(String[] i) {
			input = i;
	}
	
	//Check if portfolio summary is available
	public boolean portfolioSummary(int steps, int inputVal, int expected, int actualPass, int actualFail, int userName, int password, int url, boolean withATU) throws Exception {
		boolean passed = false;
		
		pv.utilities.HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);		
		login.loginSite();
		
		driver.navigate().to(input[url]);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.addedPortfolio));
		String text = getText(xpath(PVObjectReferenceSmoketest.addedPortfolio));
		if(text.contains("Portfolio Snapshot")){
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
			pass("Portfolio Summary is available.");
		}else {
			fail("Portfolio Summary is not available.");
		}
		
		return passed;
	}
	
	//check if calcualte equity modal is presented and allowed to enter current loan balance
	public boolean CalculateModal(int steps, int inputVal, int expected, int actualPass, int actualFail, boolean withATU) throws Exception {
		boolean passed = false;
		
		if(isElementPresent(xpath(PVObjectReferenceSmoketest.clickAddEquity))){
			clickAddEquity(0, 0, 0, 0, false);
		}else{
			clickUpdateNow(0, 0, 0, 0, false);
		}
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.calculateModal));
		Assert.assertTrue(isElementVisible(xpath(PVObjectReferenceSmoketest.calculateModal)));
		passed = isElementVisible(xpath(PVObjectReferenceSmoketest.calculateModal));
		
		if(withATU) {
			if(passed){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
				}
		}
			
		if(passed){
			pass("Calculate equity Modal is shown.");
		}else {
			fail("Calculate equity Modal is not shown.");
		}
		
		return passed;
	}
	
	//check if total equity will be calculated
	public boolean enterLoan(int steps, int inputVal, int expected, int actualPass, int actualFail, int Loan, boolean withATU) throws Exception {
		boolean passed = false;
		
		type(xpath(PVObjectReferenceSmoketest.currentLoan), input[Loan]);
		clickbtnSave(0, 0, 0, 0, false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkBox4));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkBox4));
		if(text.contains("Estimated Equity")){
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
			pass("Total equity are calculated And shown on box 4 for portfolio summary.");
		}else {
			fail("Total equity are not calculated.");
		}
		
		return passed;
	}
	
	//clickmethods
	public boolean clickAddEquity(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickAddEquity));
			click(xpath(PVObjectReferenceSmoketest.clickAddEquity));
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
	
	public boolean clickUpdateNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.updateNow));
			click(xpath(PVObjectReferenceSmoketest.updateNow));
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
	
	public boolean clickbtnSave(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSave));
			click(xpath(PVObjectReferenceSmoketest.btnSave));
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

