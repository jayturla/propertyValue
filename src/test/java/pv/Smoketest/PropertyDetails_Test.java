package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.PropertyDetailsUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PropertyDetails_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Property Details";
		
	@Test(description="Property Details", dataProvider = "Data-Provider-Function")
	public void testPropertyDetails(Class clzz, String[] input) {
		PropertyDetailsUtil pvSmoke = new PropertyDetailsUtil(input);

		try {
			//if page is distorted and header in placed
			pvSmoke.propertyHeader(0,1,2,3,4,5,6,true);
			//check if address is correct
			pvSmoke.propertyAddress(7,1,8,9,true);
			//verify if properety insights are in place
			pvSmoke.checkPropertyInsights(10,1,11,12,true);
			//verify if property insights data are correct
			pvSmoke.propertyInsightsData(13,1,14,15,true);
			//check if property gallery is available in page
			pvSmoke.propertyGallery(16,1,17,18,true);
			//check if about property data is available in page
			pvSmoke.aboutProperty(19,1,20,21,true);
			//check if comparable properties are in place
			pvSmoke.comparableProperties(22,1,23,24,true);
			//checkAuction Results data if available
			pvSmoke.auctionResult(25,1,26,27,true);
			//check if suburb information is available in page
			pvSmoke.suburbInformation(28,1,29,30,true);
			//check if suburb statistis are in placed
			pvSmoke.suburbStatistics(31,1,32,33,true);
			//verify if market trends data are correct
			pvSmoke.checkMarketTrends(34,1,35,36,true);
			//check footer if available
			pvSmoke.checkFooter(37,1,38,39,true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/propertyDetails.xls");
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
