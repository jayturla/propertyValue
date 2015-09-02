package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_CMSUtil;
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
public class RT_CMS extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression CMS";
		
	@Test(description="Regression CMS", dataProvider = "Data-Provider-Function")
	public void testRegressionCMS(Class clzz, String[] input) {
		RT_CMSUtil pvRegression = new RT_CMSUtil(input);
		
		try {
			//check if Infographic page is available and screen layout is correct
			pvRegression.Infographic(0, 1, 2, 3, 4, true);
			//check if About us Page is accessible and screen layout is not distorted
			pvRegression.AboutUs(5, 6, 7, 8, 4, true);
			//check if Contact us Page is accessible and screen layout is not distorted
			pvRegression.ContactUs(9, 10, 11, 12, 4, true);
			//check if Features Page is accessible and screen layout is not distorted
			pvRegression.Features(13, 14, 15, 16, 4, true);
			//check if Get Premium Pricing Page is accessible and screen layout is not distorted
			pvRegression.getPremium(17, 18, 19, 20, 4, true);
			//check if Help/FAQ Page is accessible and screen layout is not distorted
			pvRegression.HelpFaq(21, 22, 23, 24, 4, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTCMS.xls");
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
