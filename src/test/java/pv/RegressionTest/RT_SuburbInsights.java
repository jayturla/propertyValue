package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_SuburbInsightsUtil;
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
public class RT_SuburbInsights extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression Suburb Insights";
		
	@Test(description="Regression Suburb Insights", dataProvider = "Data-Provider-Function")
	public void testRegressionSuburbInsights(Class clzz, String[] input) {
		RT_SuburbInsightsUtil pvRegression = new RT_SuburbInsightsUtil(input);
		

		try {
			//check stock on market if available and count of properties currently for sale is reflected in the value
			pvRegression.checkStockMarket(0, 1, 2, 3, 4, 5, true);
			//click value in link format
			pvRegression.clickValue(6, 1, 7, 8, 4, true);
			//check if For sale status is preselected and active property type is the same
			pvRegression.checkSelectedProperty(9, 1, 10, 11, 4, true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTSuburbInsights.xls");
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
