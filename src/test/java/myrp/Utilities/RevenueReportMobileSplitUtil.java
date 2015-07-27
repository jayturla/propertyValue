
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import pv.utilities.RevenueReportUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RevenueReportMobileSplitUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public RevenueReportMobileSplitUtil(String[] i) {
		input = i;
	}
	
	//Generate revenue report
	public boolean generateRevenueReportMobileSplit(int steps, int inputVal, int expected, int actual, int userName, int password,
			int dateFrom, int dateTo, boolean withATU)  throws Exception {
		boolean available = false;
		
		RevenueReportUtil report = new RevenueReportUtil(input);
		
		type(xpath(PVObjectReferenceSmoketest.userName), input[userName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[password]);
		report.clickAdminLogin(0, 0, 0, 0, false);
		
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
		
		clickRevenueReportMobileSplit(0, 0, 0, 0, false);
		
		try{
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath(PVObjectReferenceSmoketest.iframe2)));
		}catch(Throwable e){
		    System.err.println("Error while switching to the frame. "+e.getMessage());
		}

		type(xpath(PVObjectReferenceSmoketest.mobileSplitdateFrom), input[dateFrom]);
		type(xpath(PVObjectReferenceSmoketest.mobileSplitdateTo), input[dateTo]);
		
		report.clickParamOk(0, 0, 0, 0, false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.waitFrame));
		String text1 = getText(xpath(PVObjectReferenceSmoketest.volumeMobileSplit));
		String text2 = getText(xpath(PVObjectReferenceSmoketest.grossSalesMobileSplit));
		String text3 = getText(xpath(PVObjectReferenceSmoketest.resiPartner));
		if(text1.isEmpty() && text2.isEmpty() && text3.contains("Resi")){
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
			pass("All the purchased reports are reflected in the revenue report and report price breakdown is correct.");
		}else {
			fail("All the purchased reports are not reflected in the revenue report and report price breakdown is incorrect.");
		}
		driver.switchTo().defaultContent();
		return available;
	}
	
	public boolean clickRevenueReportMobileSplit(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMobileSplit));
			click(xpath(PVObjectReferenceSmoketest.clickMobileSplit));
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

