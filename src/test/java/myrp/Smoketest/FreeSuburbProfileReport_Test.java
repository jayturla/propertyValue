package myrp.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;
import myrp.Utilities.FreeSuburbProfileReportUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class FreeSuburbProfileReport_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Subscriptions Channel Free Suburb Profile Report";
		
	@Test(description="Subscriptions Channel Free Suburb Profile Report", dataProvider = "Data-Provider-Function")
	public void testSubscriptionsChannelFreeSuburbProfileReport(Class clzz, String[] input) {
		FreeSuburbProfileReportUtil scSmoke = new FreeSuburbProfileReportUtil(input);

		try {
			//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
			scSmoke.freeProfileReport(0, 1, 2, 3, 4, 5, 6, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/myrptest-data/FreeSuburbProfileReport.xls");
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
