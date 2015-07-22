package myrp.Smoketest;

import java.io.IOException;

import myrp.library.ReadXlsData;
import myrp.library.TestInitReference;
import myrp.Utilities.EstimatedValueReportUtil;

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
public class EstimatedValueReport_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Subscriptions Channel Estimated Value Report";
		
	@Test(description="Subscriptions Channel Estimated Value Report", dataProvider = "Data-Provider-Function")
	public void testSubscriptionsChannelEstimatedValueReport(Class clzz, String[] input) {
		EstimatedValueReportUtil scSmoke = new EstimatedValueReportUtil(input);

		try {
			//check if can navigate to shopping cart screen when go to cart button is clicked after adding to cart
			scSmoke.shopCartScreen(0, 1, 2, 3, 4, 5, 6, 7, true);
			//payment success using promo code
			//change user login if payment success test repeated
			scSmoke.paymentSuccess(8, 1, 9, 10, 4, 11, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/myrptest-data/EstimatedValueReport.xls");
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
