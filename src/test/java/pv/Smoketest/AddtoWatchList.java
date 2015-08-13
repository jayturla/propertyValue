package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.AddtoWatchListUtil;
import pv.utilities.HeaderZoneUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class AddtoWatchList extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "HomePage";
		
	@Test(description="HomePage", dataProvider = "Data-Provider-Function")
	public void testHomePage(Class clzz, String[] input) {
		AddtoWatchListUtil pvAddtoWatchList = new AddtoWatchListUtil(input);
		HeaderZoneUtil headZone = new HeaderZoneUtil(input);
	
		try {
			//Login Existing User 
			headZone.LoginPV(0,1,2,3,4,5,6,true);
			//Search and Select for Property
			pvAddtoWatchList.selectProperty(7,8,9,10,11,12,true);
		   //Verify if Property is added and displaying in WatchList
			pvAddtoWatchList.verifyIfPropertyisAddedtoWatchList(13, 14, 15, 16, 17, true);
			//Search and Select for Street
			pvAddtoWatchList.selectStreet(18, 19, 20, 21, 22, 23, true);
			//Verify if Street is added and displaying in WatchList
			pvAddtoWatchList.verifyIfStreetisAddedtoWatchList(24, 25, 26, 27, 28, true);
			//Search and Select for Suburb
			pvAddtoWatchList.selectSuburb(29, 30, 31, 32, 33, 34, true);
			//Verify if Suburb is added and displaying in WatchList
			pvAddtoWatchList.verifyIfSuburbisAddedtoWatchList(35, 36, 37, 38, 39, true);
		
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/addtoWatchlist.xls");
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
