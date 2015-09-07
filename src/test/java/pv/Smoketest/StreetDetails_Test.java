package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.StreetDetailsUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class StreetDetails_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Street Details";
		
	@Test(description="Street Details", dataProvider = "Data-Provider-Function")
	public void testStreetDetails(Class clzz, String[] input) {
		StreetDetailsUtil pvSmoke = new StreetDetailsUtil(input);

		try {
			//check if street address search can navigate to street details page
			pvSmoke.streetAddressNav(0,1,2,3,4,5,6,true);
			//check header if in place
			pvSmoke.streetHeader(7, 1, 8, 9, true);
			//check if street address is correct
			pvSmoke.checkstreetAddress(10,1,11,12,true);
			//check if updates as Property Type btn is toggled
			pvSmoke.btnPropertyType(13,1,14,15,true);
			//check street insights data if available
			pvSmoke.checkStreetInsights(16,1,17,18,true);
			//check if property prices if in place
			pvSmoke.checkPropertyPrices(19, 1, 20, 21, true);
			//check if street auction result data if available
			pvSmoke.streetAuctionResult(22,1,23,24,true);
			//check if street suburb information if available 
			pvSmoke.streetSuburbInformation(25,1,26,27,true);
			//check if street suburb statistics if available
			//pvSmoke.streetSuburbStatistics(28,1,29,30,true);
			//check if other streets section is available
			pvSmoke.checkOtherStreets(31,1,32,33,true);
			//check footer
			pvSmoke.checkFooter(34,1,35,36,true);
			
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/streetDetails.xls");
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
