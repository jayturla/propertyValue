package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pv.utilities.PostcodeDetailsUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class PostcodeDetails_Test extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "PostcodeDetails";
		
	@Test(description="PostcodeDetails", dataProvider = "Data-Provider-Function")
	public void testPostcodeDetails(Class clzz, String[] input) {
		PostcodeDetailsUtil pvSmoke = new PostcodeDetailsUtil(input);
		

		try {
			//check for slas
			pvSmoke.checkSLAS(1,2,3,4,true);
			//navigate through SLAS
			pvSmoke.navigatePostcodeAdd(5,2,6,7,14,true);
			//check if suburbs under target postcode are listed in links and KMLs are shown on MAP
			pvSmoke.suburbsList(8,2,9,10,true);
			//verify if can navigate to suburb maps result of the selected suburb
			pvSmoke.navigateSuburbs(11,2,12,13,true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/postcodeDetails.xls");
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
