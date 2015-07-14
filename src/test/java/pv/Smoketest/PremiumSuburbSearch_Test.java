package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.PremiumSuburbSearchUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PremiumSuburbSearch_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Premium Suburb Search Result";
		
	@Test(description="Premium Suburb Search Result", dataProvider = "Data-Provider-Function")
	public void testPremiumSuburbSearch(Class clzz, String[] input) {
		PremiumSuburbSearchUtil pvSmoke = new PremiumSuburbSearchUtil(input);

		try {
			//verify if advance filter is usable
			pvSmoke.checkAdvanceFilters(0,1,2,3,4,5,6,true);
			//check if investment strategies metrics are workinng
			pvSmoke.suburbHeatMap(7,1,8,9,true);
			//check if have unlimited access to recently sold results
			pvSmoke.recentlySold(10,1,11,12,true);
			//verify if actual price is shown 
			pvSmoke.actualPrice(13,1,14,15,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/premiumSuburbSearch.xls");
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
