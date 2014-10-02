package myrp.test;

import java.io.IOException;

import myrp.library.ReadXlsData;
import myrp.library.TestInitReference;
import myrp.utilities.EvrProjectUtilAUS;

import org.testng.Assert;
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
public class AddressChange extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../evr-automation/conf/atu.properties");
	}
	
	String testCase = "T1535038";
		
	@Test(description="T1535038", dataProvider = "Data-Provider-Function")
	public void addressChange(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[2];
		try {
			EvrProjectUtilAUS au = new EvrProjectUtilAUS(input);
			au.valexAuOrder(input[1]);
		//	au.gotoSubmission();
			au.checkAddressMatchModal();
		//	au.gotoSalesEvidence();
		//	au.checkBackButtonAddressMatchModal();
		//	au.checkRemoveMatchModalFunctionaliyInAddressMatchModal();
		//	au.checkChangeAddressPage();
		//	au.performUsedTypeAddressDiscardPropertyData();//FOR DISCARD PROPERTY DATA USED TYPE ADDRESS
		//	au.performUsedTypeAddressKeepPropertyData();//FOR KEEP PROPERTY DATA USED TYPE ADDRESS
		//	au.performSearchinChangeAddress();
		//	au.performSearchAndLeavePageinChangeAddress();// Not Completed DUe to C440016 unable to perform test case
		//	au.performChangeAddressViaSelectingProperty();
			
		}catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}
	

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../evr-automation/test-data/changeAddress.xls");
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
        ATUReports.indexPageDescription = "EVR";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
