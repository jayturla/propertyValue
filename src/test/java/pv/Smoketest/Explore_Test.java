package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.ExploreUtil;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class Explore_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Explore";
		
	@Test(description="Explore", dataProvider = "Data-Provider-Function")
	public void testExplore(Class clzz, String[] input) {
		ExploreUtil pvSmoke = new ExploreUtil(input);

		try {
			//click and navigate to explore page
			pvSmoke.checkExplore(1,2,3,4,5,6,true);
			//check if url is /explore
			pvSmoke.checkURL(7,2,8,9,true);
			//check if state region filter are available
			pvSmoke.checkStateRegionFilter(10,2,11,12,true);
			//check if state region filter are functional
			pvSmoke.functionStateRegionFilter(19,2,20,21,true);
			//check if metric sorting are available
			pvSmoke.metricSorting(13,2,14,15,true);
			//check if selected top suburbs can navigate to suburb page
			pvSmoke.selectTopSuburb(16,2,17,18,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/explore.xls");
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
