package pv.atu_utilities.copy;

import pv.library.FunctionReference;



import atu.testng.reports.ATUReports;

public class ATUUtil extends FunctionReference {
	
	public void performATU(String steps, String inputVal, String expected, String actual, boolean screenShot, boolean status) {
		if(status){
			ATUReports.add(steps, inputVal, expected, actual, screenShot); //pass
		}else {
			ATUReports.add(steps, inputVal, expected, actual, screenShot); //fail
		}
	}
	
}

