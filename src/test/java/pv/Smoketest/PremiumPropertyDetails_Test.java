package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.PremiumPropertyDetailsUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PremiumPropertyDetails_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Premium Property Details";
		
	@Test(description="Premium Property Details", dataProvider = "Data-Provider-Function")
	public void testPremiumPropertyDetails(Class clzz, String[] input) {
		PremiumPropertyDetailsUtil pvSmoke = new PremiumPropertyDetailsUtil(input);

		try {
			//check exact and estimated value if shown
			pvSmoke.checkValue(0,1,2,3,4,5,6,true);
			//check estimated rent if shown
			pvSmoke.checkEstimatedRent(7,1,8,9,true);
			//check estimated yield if shown
			pvSmoke.checkEstimatedYield(10,1,11,12,true);
			//check estimated cashflow if shown
			pvSmoke.checkEstimatedCashflow(13,1,14,15,true);
			//check if property pros and cons are shown
			pvSmoke.checkProsCons(16,1,17,18,true);
			//check property investment strategy score if shown
			pvSmoke.checkInvestmentStratetyScore(19,1,20,21,true);
			//check property history timeline if shown
			pvSmoke.checkPropertyHistory(22,1,23,24,true);
			//check if unlimited comparable properties are shown in the map and list section
			pvSmoke.checkUnliComparableProperties(25,1,26,27,true);
			//check if market trends metrics are in unlimited access
			pvSmoke.checkMarketTrends(28,1,29,30,true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/premiumPropertyDetails.xls");
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
