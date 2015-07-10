package pv.Smoketest;

import java.io.IOException;
import pv.library.ReadXlsData;
import pv.library.TestInitReference;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.HomepageUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class HomePage_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "HomePage";
		
	@Test(description="HomePage", dataProvider = "Data-Provider-Function")
	public void testHomePage(Class clzz, String[] input) {
		HomepageUtil pvSmoke = new HomepageUtil(input);
		

		try {
			//check for header
			pvSmoke.checkHeader(1,2,3,4,true);
			//check for slas
			pvSmoke.checkSLAS(5,2,6,7,true);
			//check state of the nation
			pvSmoke.checkstateNation(8,2,9,10,true);
			//check top suburbs
			pvSmoke.checkTopSuburbs(11,2,12,13,true);
			//check Median Price Change
			pvSmoke.checkMedianPriceChange(14,2,15,16,true);
			//check median gross yield
			pvSmoke.checkMedianGrossYield(14,2,20,21,true);
			//check footer
			pvSmoke.checkFooter(17,2,18,19,true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/homepage.xls");
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
