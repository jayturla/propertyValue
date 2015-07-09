package pv.Smoketest;

import java.io.IOException;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pv.utilities.AddtoWatchListUtil;
import pv.utilities.HeaderZoneUtil;
import pv.utilities.MyAccountUtil;
import pv.utilities.PVSmoketestUtil;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class MyAccount extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "MyAccount";
		
	@Test(description="MyAccount", dataProvider = "Data-Provider-Function")
	public void MyAccount(Class clzz, String[] input) {
		MyAccountUtil pvMyAccount = new MyAccountUtil(input);
		HeaderZoneUtil headZone = new HeaderZoneUtil(input);
	
		try {
			//Login Existing User 
			headZone.LoginPV(0,1,2,3,4,5,6,true);
			//Click Menu 
			headZone.clickMenu();
			//Check if My Account is available and Go to Account
			 pvMyAccount.clickAccount(7,8,9,10,11,true);
			 //Verify My Account page
			 pvMyAccount.checkAccountPage(12,13,14,15,16,true);
			 
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvtest-data/myAccount.xls");
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
