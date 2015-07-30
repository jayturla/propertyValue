package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_HomepageUtil;
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
public class RT_Homepage extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression HomePage";
		
	@Test(description="Regression HomePage", dataProvider = "Data-Provider-Function")
	public void testRegressionHomePage(Class clzz, String[] input) {
		RT_HomepageUtil pvRegression = new RT_HomepageUtil(input);
		

		try {
			//verify if watch video link will load an embedded youtube video
			pvRegression.watchVideo(0, 1, 2, 3, 4, true);
			//check if asx ticker is available
			pvRegression.checkAsxTicker(5, 1, 6, 7, 4, true);
			//check if can navigate to corelogic daily index in new tab
			pvRegression.asxTickerNav(8, 1, 9, 10, 4, true);
			//verify if can navigate to explore page when explore button is clicked
			pvRegression.exploreNav(11, 1, 12, 13, 4, true);
			//verify if can navigate to Cash Flow Investment Strategy page when Strategies button is clicked
			pvRegression.strategiesNav(14, 1, 15, 16, 4, true);
			//check if can navigate to corelogic in new tab when learn more button is clicked
			pvRegression.learnMoreNav(17, 1, 18, 19, 4, true);
			//check if can switch displays on metrics and property type in state of the nation section
			pvRegression.switchDisplay(20, 1, 21, 22, 4, true);
			//check if can navigate to to their own landing page if investment strategy scores are clicked
			pvRegression.investmenStrategiesNav(23, 1, 24, 25, 4, true);
			
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTHomepage.xls");
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
