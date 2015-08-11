package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.LoginSuburbProfileUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class LoginSuburbProfile_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Suburb Profile";
		
	@Test(description="Login User Suburb Profile", dataProvider = "Data-Provider-Function")
	public void testLoginSuburbProfile(Class clzz, String[] input) {
		LoginSuburbProfileUtil pvSmoke = new LoginSuburbProfileUtil(input);
		

		try {
			//check if view suburb profile btn will navigate to suburb profile page
			pvSmoke.clickSuburbProfile(0,1,2,3,4,5,6, true);
			//check header
			pvSmoke.checkHeader(7, 1, 8, 9, true);
			//check address
			pvSmoke.checkAddress(10, 1, 11, 12, true);
			//toggle property type button if page update
			pvSmoke.btnPropertyType(13, 1, 14, 15, true);
			//check suburb insights data if available
			pvSmoke.checkSuburbInsights(16, 1, 17, 18, true);
			//check property prices status if in place
			pvSmoke.propertyPricesStatus(19, 1, 20, 21, true);
			//check auction result data if available 
			pvSmoke.checkAuction(22, 1, 23, 24, true);
			//check suburb information if available
			pvSmoke.checkSuburbInfo(25, 1, 26, 27, true);
			//check suburb statistics and charts if available
			pvSmoke.checkSuburbStatistics(28, 1, 29, 30, true);
			//check market trends if available in the page
			pvSmoke.checkSuburbTrends(31, 1, 32, 33, true);
			//check if local experts section is shown
			pvSmoke.checkLocalExperts(34, 1, 35, 36, true);
			//check if street links are available
			pvSmoke.checkStreetLinks(37, 1, 38, 39, true);
			//Checking the Footer if in place
			pvSmoke.checkFooter(40, 1, 41, 42, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/loginSuburbProfile.xls");
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
