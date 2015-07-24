
package myrp.Utilities;


import static org.openqa.selenium.By.xpath;

import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

public class MyReportUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public MyReportUtil(String[] i) {
		input = i;
	
	}
	
	//check if all purchased reports are in myreport section
	public boolean myReportSection(int steps, int inputVal, int expected, int actualPass, int actualFail, int uName, int pWord, boolean withATU) throws Exception {
		boolean passed = false;
		
		click(xpath(PVObjectReferenceSmoketest.logIn));
		type(xpath(PVObjectReferenceSmoketest.userName), input[uName]);
		type(xpath(PVObjectReferenceSmoketest.password), input[pWord]);
		click(xpath(PVObjectReferenceSmoketest.btnLogIn));
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickMyAccount));
		click(xpath(PVObjectReferenceSmoketest.clickMyAccount));
		
		String text,text1,text2,text3,text4 = text = text1 = text2 = text3 = getText(xpath(PVObjectReferenceSmoketest.tblPurchased));
		String text5 = getText(xpath(PVObjectReferenceSmoketest.tblValuations));
		
		if(text.contains("Magill SA 5072 - Suburb Sales Report") && text1.contains("Esplanade North George Town TAS 7253 - Street Sales Report") && text2.contains("10/287-293 Exhibition Street Melbourne VIC 3000 - Detailed Property Report")
				&& text3.contains("13 Austin Crescent Lane Cove NSW 2066 - Sales History Report") && text4.contains("6066 WA - Investor Postcode Report") && text5.contains("14N/143 Lowanna Drive Buddina QLD 4575 - Estimated Value Report")) {
			
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
			pass("All purchased reports are available in My Reports Section.");
		}else {
			fail("All purchased reports are not available in My Reports Section.");
		}
		
		return passed;
	}
} 

