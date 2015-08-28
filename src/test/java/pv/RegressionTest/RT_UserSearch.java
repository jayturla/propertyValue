package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_UserSearchUtil;
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
public class RT_UserSearch extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression User Search";
		
	@Test(description="Regression User Search", dataProvider = "Data-Provider-Function")
	public void testRegressionUserSearch(Class clzz, String[] input) {
		RT_UserSearchUtil pvRegression = new RT_UserSearchUtil(input);
		
		try {
			//Check if can search a user
			pvRegression.searchUser(0, 1, 2, 3, 4, 5, 6, 7, true);
			//check access level update
			pvRegression.accessLevel(8, 1, 9, 10, 4, true);
			//check if login as user is functional
			pvRegression.loginAsUser(11, 1, 12, 13, 4, true);
		} catch (Exception e) {
		}
	}
	
	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTUserSearch.xls");
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
