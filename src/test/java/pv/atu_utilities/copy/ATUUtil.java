package pv.atu_utilities.copy;

import pv.library.FunctionReference;



import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class ATUUtil extends FunctionReference {
	
	public void performATU(String steps, String inputVal, String expected, String actual, boolean screenShot, boolean status) {
		if(status) {
			ATUReports.add(steps,inputVal,expected,actual,screenShot);
		}else{
			ATUReports.add(actual, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
}

