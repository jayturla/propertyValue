package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.ReportsPortfolioAndWatchlistUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class ReportsPortfolioAndWatchlist_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Reports, Portfolio and Watchlist";
		
	@Test(description="Premium Reports, Portfolio And Watchlist", dataProvider = "Data-Provider-Function")
	public void testReportsPortfolioAndWatchlist(Class clzz, String[] input) {
		ReportsPortfolioAndWatchlistUtil pvSmoke = new ReportsPortfolioAndWatchlistUtil(input);

		try {
			//check if can download unlimited property and postcode rreports
			pvSmoke.downloadReports(0,1,2,3,4,5,6,true);
			//verify if able to add unlimited portfolio and properties
			pvSmoke.subscribedPortfolio(7,8,9,10,true);
			//check estimated Gross Yield if calculated
			pvSmoke.checkEstimatedGrossYield(11,8,12,13,true);
			//view total and individual properties
			pvSmoke.portfolioValueGraph(14,8,15,16,true);
			//check if investor score are shown in premium user
			pvSmoke.porfolioInvestorScore(17,8,18,19,true);
			//check exact estimated value
			pvSmoke.checkWatchlist(20,21,22,23,true);
			//check owned/rented if available in premium users
			pvSmoke.checkOwnedRented(24,21,25,26,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/reportsPortfolioAndWatchlist.xls");
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
