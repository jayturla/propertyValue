package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;


import org.testng.Assert;

public class StrategiesAndExploreUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public StrategiesAndExploreUtil(String[] i) {
			input = i;
	}
	
	//Check InvestmentStrategy Score column if available
	public boolean checkInvestmentStrategyScore(int steps, int inputVal, int expected, int actual, int userName,int password, boolean withATU)  throws Exception {
		boolean available = false;
		HeaderZoneUtil login = new HeaderZoneUtil(input);
		login.clickLogin();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.loginSite();
		
		clickStrategy(0, 0, 0, 0, false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategy));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.investmentStrategy)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.investmentStrategy));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Investment Strategy Score are available.");
		}else {
			fail("Investment Strategy Score are not available.");
		}
		return available;
	}
	
	//check explore unlimited suburbs
	public boolean checkUnliSuburbs(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		clickExplore(0, 0, 0, 0, false);
		clickfunctionState(0, 0, 0, 0, false);
		clickSelectState(0, 0, 0, 0, false);
		clickfunctionRegion(0, 0, 0, 0, false);
		clickSelectRegion(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkExplorePane));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkExplorePane)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.checkExplorePane));
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Explore Unlimited Suburbs from any state and region is accessible.");
		}else {
			fail("Explore Unlimited Suburbs from any state and region is not accessible.");
		}
		return available;
	}
	
	//check if order of suburbs by Investment Strategy Scores changed.
	public boolean checkOrder(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		clickOrder(0,0,0,0,false);
		clickselectOrder(0, 0, 0, 0, false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickOrder));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickOrder)));
		String text = getText(xpath(PVObjectReferenceSmoketest.clickOrder));
		if(text.contains("Capital Growth")){
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
			pass("Can change the order of suburbs by Investment Strategy Scores.");
		}else {
			fail("Cannot change the order of suburbs by Investment Strategy Scores.");
		}
		return available;
	}
	
	//check if can sort the top suburb list by clicking the column headers
	public boolean checkSort(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
			
		clickSort(0, 0, 0, 0, false);
//		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkSortText));
//		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.checkSortText)));
		Thread.sleep(2000);
		String text = getText(xpath(PVObjectReferenceSmoketest.checkSortText));
		if(text.contains("Ainslie")){
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
			pass("Can sort the top suburb list by clicking the column headers.");
		}else {
			fail("Cannot sort the top suburb list by clicking the column headers.");
		}
		return available;
	}
	
	//check if can view value from the selected Investment strategy score column
	public boolean checkValues(int steps, int inputVal, int expected, int actual, boolean withATU)  throws Exception {
		boolean available = false;
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.viewValue));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.viewValue)));
		available = isElementVisible(xpath(PVObjectReferenceSmoketest.viewValue));
				
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Can view value from the selected Investment strategy score column.");
		}else {
			fail("Cannot view value from the selected Investment strategy score column.");
		}
		return available;
	}
	
	public boolean clickStrategy(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickStrategy));
			click(xpath(PVObjectReferenceSmoketest.clickStrategy));
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
	
	public boolean clickExplore(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickExplore));
			click(xpath(PVObjectReferenceSmoketest.clickExplore));
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
	
	public boolean clickfunctionState(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.functionState));
			click(xpath(PVObjectReferenceSmoketest.functionState));
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
	
	public boolean clickSelectState(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectState));
			click(xpath(PVObjectReferenceSmoketest.selectState));
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
	
	public boolean clickfunctionRegion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.functionRegion));
			click(xpath(PVObjectReferenceSmoketest.functionRegion));
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
	
	public boolean clickSelectRegion(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectRegion));
			click(xpath(PVObjectReferenceSmoketest.selectRegion));
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
	public boolean clickOrder(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickOrder));
			click(xpath(PVObjectReferenceSmoketest.clickOrder));
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
	public boolean clickselectOrder(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.selectOrder));
			click(xpath(PVObjectReferenceSmoketest.selectOrder));
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
	public boolean clickSort(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickSort));
			click(xpath(PVObjectReferenceSmoketest.clickSort));
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

