package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.LoginSuburbSearchResultUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class LoginSuburbSearchResult_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Suburb Search Result";
		
	@Test(description="Login User Suburb Search Result", dataProvider = "Data-Provider-Function")
	public void testLoginSuburbSearchResult(Class clzz, String[] input) {
		LoginSuburbSearchResultUtil pvSmoke = new LoginSuburbSearchResultUtil(input);
		

		try {
			//Map Search Result Suburb section
			pvSmoke.suburbMapSearch(0,1,2,3,4,5,6,true);
			//check if neighbouring suburb pins are plotted
			pvSmoke.suburbPins(7, 1, 8, 9, true);
			//check if properties in the suburb are plotted in the map
			//pvSmoke.suburbProperties(10, 1, 11, 12, true);
			pvSmoke.suburbPropertyList(10, 1, 11, 12, true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/loginSuburbSearchResult.xls");
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
