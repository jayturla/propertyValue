package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pv.utilities.PostcodeActivityReportUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PostcodeActivityReport_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "PostcodeActivityReport";
		
	@Test(description="PostcodeActivityReport", dataProvider = "Data-Provider-Function")
	public void testPostcodeActivityReport(Class clzz, String[] input) {
		PostcodeActivityReportUtil pvSmoke = new PostcodeActivityReportUtil(input);
		

		try {
			//check for $ Buy Postcode report
			pvSmoke.checkBuyPostcodeReport(1,2,3,4,5,6,30,true);
			//click $ Buy Postcode report button to navigate to Postcode Activity Report screen
			pvSmoke.clickBuyPostcodeReport(7,2,8,9,true);
			//click Get This Report Button to navigate Payment Summary Screen
			pvSmoke.clickGetThisReport(10,2,11,12,true);
			//click pay now button to navigate to Payment Checkout
			pvSmoke.clickPayNow(13,2,14,15,true);
			//submit credit card details and navigate to payment success screen
			pvSmoke.submitCreditCard(16,2,17,18,19,20,21,22,true);
			//check if back to home page link is available and can navigate to homepage when clicked
			pvSmoke.backHomepage(23,24,25,26,true);
			pvSmoke.clickbackHomepage(27,24,28,29,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/postcodeActivityReport.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "PROPERTY VALUE";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}