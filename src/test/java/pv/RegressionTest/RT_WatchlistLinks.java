package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_WatchlistLinksUtil;
import pv.library.ReadXlsData;
import pv.library.TestInitReference;

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
public class RT_WatchlistLinks extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression Watchlist Links";
		
	@Test(description="Regression Watchlist Links", dataProvider = "Data-Provider-Function")
	public void testRegressionWatchlistLinks(Class clzz, String[] input) {
		RT_WatchlistLinksUtil pvRegression = new RT_WatchlistLinksUtil(input);
		

		try {
			
			//Check if watchlist have more than 6 property, suburb, street
			pvRegression.countWatchlist(0, 1, 2, 3, 4, 5, 6, true);
			//check if show more button will show the entire list
			pvRegression.showMore(7, 1, 8, 9, 4, true);
			//check if left nav bar is clickable and will anchor to selected section
			pvRegression.leftNavBar(10, 1, 11, 12, 4, true);
			//check if Account link is available
			pvRegression.checkMyAccount(13, 1, 14, 15, 4, true);
			//click myAccount if will navigate to account summary screen
			pvRegression.myAccount(16, 1, 17, 18, 4, true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTWatchlistLinks.xls");
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
