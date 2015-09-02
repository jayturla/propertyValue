package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_ExploreUtil;
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
public class RT_Explore extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression Explore";
		
	@Test(description="Regression Explore", dataProvider = "Data-Provider-Function")
	public void testRegressionExplore(Class clzz, String[] input) {
		RT_ExploreUtil pvRegression = new RT_ExploreUtil(input);
		

		try {
			//check if view count properties for sale in link text and can navigate to suburb map result
			pvRegression.viewPropertiesForSale(0, 1, 2, 3, 4, true);
			//check if can find top suburbs in state based on the selected sort order
			pvRegression.chooseSortOrderState(5, 6, 7, 8, 4, true);
			//check if can find top suburbs in region based on the selected sort order
			pvRegression.chooseSortOrderRegion(9, 10, 11, 12, 4, 13, 14, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTExplore.xls");
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
