package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.StrategiesAndExploreUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class StrategiesAndExplore_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "StrategiesAndExplore";
		
	@Test(description="StrategiesAndExplore", dataProvider = "Data-Provider-Function")
	public void testStrategiesAndExplore(Class clzz, String[] input) {
		StrategiesAndExploreUtil pvSmoke = new StrategiesAndExploreUtil(input);

		try {
			//Check InvestmentStrategy Score column if available
			pvSmoke.checkInvestmentStrategyScore(0,1,2,3,4,5,true);
			//check explore unlimited suburbs
			pvSmoke.checkUnliSuburbs(6,7,8,9,true);
			//check if order of suburbs by Investment Strategy Scores changed.
			pvSmoke.checkOrder(10,7,11,12,true);
			//check if can sort the top suburb list by clicking the column headers
			pvSmoke.checkSort(13,7,14,15,true);
			//check if can view value from the selected Investment strategy score colum
			pvSmoke.checkValues(16,7,17,18,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/strategiesAndExplore.xls");
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
