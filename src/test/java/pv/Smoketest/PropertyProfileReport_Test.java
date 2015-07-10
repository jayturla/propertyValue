package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.PropertyProfileReportUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PropertyProfileReport_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "PropertyProfileReport";
		
	@Test(description="PropertyProfileReport", dataProvider = "Data-Provider-Function")
	public void testPropertyProfileReport(Class clzz, String[] input) {
		PropertyProfileReportUtil pvSmoke = new PropertyProfileReportUtil(input);
		

		try {
			//check for $ Buy Property report
			pvSmoke.checkBuyPropertyReport(1,2,3,4,25,true);
			//click $ Buy Property report button to navigate to Property Profile Report screen
			pvSmoke.clickBuyPropertyReport(5,2,6,7,true);
			//click Get This Report Button to navigate Payment Summary Screen
			pvSmoke.clickGetThisReport(8,2,9,10,true);
			//click buy now button checked if updated to pay now button
			pvSmoke.clickBuyNow(11,2,12,13,true);
			//click pay now button to navigate to Payment Checkout
			pvSmoke.clickPayNow(14,2,15,16,true);
			//submit credit card details and navigate to payment success screen
			pvSmoke.submitCreditCard(17,2,18,19,21,22,23,24,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/propertyprofilereport.xls");
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
