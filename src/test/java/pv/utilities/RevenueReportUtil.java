
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RevenueReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RevenueReportUtil(String[] i) {
		input = i;
	}
	
	//Generate revenue report
	public boolean generateRevenueReport(int steps, int inputVal, int expected, int actual, int userName, int password, int url,
			int dateFrom, int dateTo, boolean withATU)  throws Exception {
		boolean available = false;
		
		driver.navigate().to(input[url]);
		type(xpath(PVObjectReferenceSmoketest.userName), input[userName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[password]);
		clickAdminLogin(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnReports));
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(xpath(PVObjectReferenceSmoketest.btnReports));
		action.moveToElement(we).moveToElement(driver.findElement(xpath(PVObjectReferenceSmoketest.adminReports))).click().build().perform();
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.iframe)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}
		
		clickRevenueReport(0, 0, 0, 0, false);
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.iframe2)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}

		type(xpath(PVObjectReferenceSmoketest.dateFrom), input[dateFrom]);
		type(xpath(PVObjectReferenceSmoketest.dateTo), input[dateTo]);

		selectOption(xpath(PVObjectReferenceSmoketest.product), "All");

		clickParamOk(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.waitFrame));
		String text1 = getText(xpath(PVObjectReferenceSmoketest.volume));
		String text2 = getText(xpath(PVObjectReferenceSmoketest.grossSales));
		String text3 = getText(xpath(PVObjectReferenceSmoketest.GTS));
		if(text1.isEmpty() && text2.isEmpty() && text3.isEmpty()){
			available = false;
		}else{
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
			pass("Can Generate Property Value Revenue Report.");
		}else {
			fail("Cannot Generate Property Value Revenue Report.");
		}
		driver.switchTo().defaultContent();
		driver.navigate().to("http://consumer:QWE!%40%23rty456@dev.propertyvalue.com.au/");
		return available;
	}
	
	//clickMethods
	public boolean clickAdminLogin(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.adminLogin));
			click(xpath(PVObjectReferenceSmoketest.adminLogin));
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
	
	public boolean clickRevenueReport(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickRevenueReport));
			click(xpath(PVObjectReferenceSmoketest.clickRevenueReport));
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
	
	public boolean clickParamOk(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.paramOk));
			click(xpath(PVObjectReferenceSmoketest.paramOk));
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

